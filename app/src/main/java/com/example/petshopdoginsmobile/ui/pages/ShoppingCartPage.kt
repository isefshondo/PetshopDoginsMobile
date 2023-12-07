package com.example.petshopdoginsmobile.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petshopdoginsmobile.domain.ItemDomain
import com.example.petshopdoginsmobile.ui.components.buttons.CalculateShippingButton
import com.example.petshopdoginsmobile.ui.components.cards.CartBottomCard
import com.example.petshopdoginsmobile.ui.components.cards.CartProductCard
import com.example.petshopdoginsmobile.ui.components.cards.OrderSummaryCard
import com.example.petshopdoginsmobile.ui.components.cards.RenderApplyCouponSection
import com.example.petshopdoginsmobile.ui.components.header.PageHeader
import com.example.petshopdoginsmobile.ui.theme.BgGrey
import com.example.petshopdoginsmobile.ui.utils.productImageExample
import com.example.petshopdoginsmobile.ui.viewmodels.ItemViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartPage(navController: NavController) {
    val itemDomains = listOf(
        ItemDomain(
            id = "",
            image = productImageExample.data,
            title = "Fantasia para Gatos de Unicórnio e Leão Fantasia para Gatos de Unicórnio",
            quantity = MutableStateFlow(1),
            inStock = MutableStateFlow(6),
            discount = MutableStateFlow(20.0),
            price = MutableStateFlow(62.0),
            total = MutableStateFlow(0.0)
        ),
        ItemDomain(
            id = "",
            image = productImageExample.data,
            title = "Fantasia para Cachorros de Super-Heróis",
            quantity = MutableStateFlow(2),
            inStock = MutableStateFlow(10),
            discount = MutableStateFlow(0.0),
            price = MutableStateFlow(49.90),
            total = MutableStateFlow(0.0)
        )
    )
    // cria uma lista mutável de ViewModels para cada item
    val itemViewModels = remember {
        mutableStateListOf(*itemDomains.map {
            ItemViewModel(it)
        }.toTypedArray())
    }

    // cria um estado para armazenar o valor total do carrinho
    val totalValue = remember { mutableStateOf(0.0) }

    // cria um estado para armazenar o número total de itens
    val totalItems = remember { mutableStateOf(itemDomains.size) }

    // cria um coletor para cada ItemViewModel
    itemViewModels.forEach { itemViewModel ->
        LaunchedEffect(itemViewModel.total) {
            itemViewModel.total.collect { total ->
                // Atualizar o totalValue sempre que o total de qualquer ItemViewModel mudar
                totalValue.value = itemViewModels.sumOf { it.total.value }
                totalItems.value = itemViewModels.size
            }
        }
    }

    // cria um estado para armazenar os cupons aplicados
    val coupons = remember { mutableStateOf(mapOf<String?, Double>()) }
    // cria uma função para calcular o desconto dos cupons
    val couponDiscount: (String?, Double) -> Double = { _, _ -> 0.0 }

    Scaffold(
        containerColor = BgGrey,
        topBar = {
            PageHeader(
                isHomePage = false,
                headerTitle = "Carrinho de Compra",
                handleViewCartEvent = {},
                navController = navController
            )
        },
        bottomBar = {
            CartBottomCard(
                btnLabel = "Finalizar Compra",
                btnOnClick = { navController.navigate("purchase-confirm") },
                totalValue = totalValue
            )
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(itemViewModels.size) { index ->
                    val itemViewModel = itemViewModels[index]
                    CartProductCard(
                        image = itemViewModel.itemDomain.image,
                        title = itemViewModel.itemDomain.title,
                        _quantity = itemViewModel.itemDomain.quantity,
                        _inStock = itemViewModel.itemDomain.inStock,
                        _discount = itemViewModel.itemDomain.discount,
                        _price = itemViewModel.itemDomain.price,
                        _total = itemViewModel.total,
                        onQuantityChange = itemViewModel::updateQuantity,
                        onRemove = {
                            itemViewModels.remove(itemViewModel)
                            // Atualizar o totalValue e o totalItems quando um item é removido
                            totalValue.value = itemViewModels.sumOf { it.total.value }
                            totalItems.value = itemViewModels.size
                        }
                    )
                }

                item {
                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(0.9f)
                            .background(Color.White)
                    ){
                        CalculateShippingButton(onClick = {})
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(0.9f)
                            .background(Color.White)
                    ){
                        RenderApplyCouponSection()
                    }
                }
                item {
                    OrderSummaryCard(
                        totalItems = totalItems,
                        totalValue = totalValue,
                        shippingCost = 0.0,
                        coupons = coupons,
                        couponDiscount = couponDiscount
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }

    }
}


@Preview
@Composable
private fun ShoppingCartPagePreview(){
    ShoppingCartPage(navController = rememberNavController())
}