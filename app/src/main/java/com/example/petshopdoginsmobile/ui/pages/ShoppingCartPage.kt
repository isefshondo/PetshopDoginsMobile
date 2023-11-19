package com.example.petshopdoginsmobile.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.petshopdoginsmobile.R
import com.example.petshopdoginsmobile.domain.Item
import com.example.petshopdoginsmobile.ui.components.cards.CartProductCard
import com.example.petshopdoginsmobile.ui.components.cards.OrderSummaryCard
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.viewmodels.ItemViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.petshopdoginsmobile.ui.viewmodels.ItemViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartPage() {
    val items = listOf(
        Item(
            image = painterResource(id = R.drawable.img_cat),
            title = "Fantasia para Gatos de Unicórnio e Leão Fantasia para Gatos de Unicórnio",
            quantity = MutableStateFlow(1),
            inStock = MutableStateFlow(6),
            discount = MutableStateFlow(20.0),
            price = MutableStateFlow(62.0),
            total = MutableStateFlow(0.0)
        ),
        Item(
            image = painterResource(id = R.drawable.img_cat),
            title = "Fantasia para Cachorros de Super-Heróis",
            quantity = MutableStateFlow(2),
            inStock = MutableStateFlow(10),
            discount = MutableStateFlow(0.0),
            price = MutableStateFlow(49.90),
            total = MutableStateFlow(0.0)
        )
    )
    // criar uma lista mutável de ViewModels para cada item
    val itemViewModels = remember {
        mutableStateListOf(*items.map {
            ItemViewModel(it)
        }.toTypedArray())
    }

    // criar um estado para armazenar o valor total do carrinho
    val totalValue = remember { mutableStateOf(0.0) }

    // criar um estado para armazenar o número total de itens
    val totalItems = remember { mutableStateOf(items.size) }

    // criar um coletor para cada ItemViewModel
    itemViewModels.forEach { itemViewModel ->
        LaunchedEffect(itemViewModel.total) {
            itemViewModel.total.collect { total ->
                // Atualizar o totalValue sempre que o total de qualquer ItemViewModel mudar
                totalValue.value = itemViewModels.sumOf { it.total.value }
                totalItems.value = itemViewModels.size
            }
        }
    }

    // criar um estado para armazenar os cupons aplicados
    val coupons = remember { mutableStateOf(mapOf<String?, Double>()) }
    // criar uma função para calcular o desconto dos cupons
    val couponDiscount: (String?, Double) -> Double = { _, _ -> 0.0 }

    Scaffold(
        modifier = Modifier.background(Grey)
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .background(Grey)
                .padding(innerPadding)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(itemViewModels.size) { index ->
                    val itemViewModel = itemViewModels[index]
                    CartProductCard(
                        image = itemViewModel.item.image,
                        title = itemViewModel.item.title,
                        _quantity = itemViewModel.item.quantity,
                        _inStock = itemViewModel.item.inStock,
                        _discount = itemViewModel.item.discount,
                        _price = itemViewModel.item.price,
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
            }

            OrderSummaryCard(
                totalItems = totalItems,
                totalValue = totalValue,
                shippingCost = 0.0,
                coupons = coupons,
                couponDiscount = couponDiscount
            )
        }

    }
}


@Preview
@Composable
private fun ShoppingCartPagePreview(){
    ShoppingCartPage()
}