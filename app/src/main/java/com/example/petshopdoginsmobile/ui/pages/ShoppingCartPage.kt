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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petshopdoginsmobile.ui.components.buttons.BackToStart
import com.example.petshopdoginsmobile.ui.components.buttons.CalculateShippingButton
import com.example.petshopdoginsmobile.ui.components.cards.CartBottomCard
import com.example.petshopdoginsmobile.ui.components.cards.CartProductCard
import com.example.petshopdoginsmobile.ui.components.cards.OrderSummaryCard
import com.example.petshopdoginsmobile.ui.components.cards.RenderApplyCouponSection
import com.example.petshopdoginsmobile.ui.components.header.PageHeader
import com.example.petshopdoginsmobile.ui.theme.BgGrey
import com.example.petshopdoginsmobile.ui.theme.VibrantBlue
import com.example.petshopdoginsmobile.ui.theme.medium20
import com.example.petshopdoginsmobile.ui.viewmodels.ItemsViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartPage(navController: NavController) {
    val viewModel: ItemsViewModel = viewModel()
    val itemViewModels = viewModel.itemViewModels.collectAsState()
    val itemViewModelsState = viewModel.itemViewModels.collectAsState()
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(viewModel.errorMessage) {
        viewModel.errorMessage.collect { message ->
            message?.let {
                scope.launch {
                    snackbarHostState.showSnackbar(message)
                }
            }
        }
    }

    val totalValue = viewModel.totalValue.collectAsState()
    val totalItems = viewModel.totalItems.collectAsState()

    // cria um coletor para cada ItemViewModel
    itemViewModels.value.forEach { itemViewModel ->
        LaunchedEffect(itemViewModel.total) {
            itemViewModel.total.collect { total ->
                viewModel.updateTotalValueAndItems()
            }
        }
    }

    // cria um estado para armazenar os cupons aplicados
    val coupons = remember { mutableStateOf(mapOf<String?, Double>()) }
    // cria uma função para calcular o desconto dos cupons
    val couponDiscount: (String?, Double) -> Double = { _, _ -> 0.0 }

    Scaffold(
        containerColor = BgGrey,
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            PageHeader(
                isHomePage = false,
                headerTitle = "Carrinho de Compra",
                handleViewCartEvent = {},
                navController = navController
            )
        },
        bottomBar = {
            if(itemViewModels.value.isEmpty()) {
                BackToStart(onClick = {navController.navigate("home")})
            }else{
                CartBottomCard(
                    btnLabel = "Finalizar Compra",
                    btnOnClick = { viewModel.confirmShoppingCart() },
                    totalValue = totalValue
                )
            }
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            if(itemViewModels.value.isEmpty()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(text = "Seu carrinho está vazio.", color = VibrantBlue, style = medium20)
                }
            }else{
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(itemViewModelsState.value.size) { index ->
                        val itemViewModel = itemViewModels.value[index]
                        CartProductCard(
                            image = itemViewModel.itemDomain.image[0],
                            title = itemViewModel.itemDomain.title,
                            _quantity = itemViewModel.itemDomain.quantity,
                            _inStock = itemViewModel.itemDomain.inStock,
                            _discount = itemViewModel.itemDomain.discount,
                            _price = itemViewModel.itemDomain.price,
                            _total = itemViewModel.total,
                            onQuantityChange = itemViewModel::updateQuantity,
                            onRemove = {
                                viewModel.removeItem(itemViewModel)
                            }
                        )
                    }

                    item {
                        Column(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .fillMaxWidth(0.9f)
                                .background(Color.White)
                        ) {
                            CalculateShippingButton(onClick = {})
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Column(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .fillMaxWidth(0.9f)
                                .background(Color.White)
                        ) {
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
    val showDialog by viewModel.showDialog.collectAsState()
    val success by viewModel.success.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    if(showDialog){
        AlertDialog(
            onDismissRequest = { viewModel.showDialog.value = false },
            title = {
                Text(
                    text = if(success) "Mensagem" else "Erro") },
            text = { Text(text = if(success) "Compra finalizada com sucesso!" else errorMessage!!) },
            confirmButton = {
                Button(
                    onClick = {
                        if(success == true)
                            navController.navigate("purchase-confirm")
                        viewModel.showDialog.value = false
                    }
                ) {
                    Text("OK")
                }
            }
        )
    }
}


@Preview
@Composable
private fun ShoppingCartPagePreview(){
    ShoppingCartPage(navController = rememberNavController())
}