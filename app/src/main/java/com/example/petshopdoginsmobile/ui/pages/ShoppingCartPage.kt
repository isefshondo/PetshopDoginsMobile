package com.example.petshopdoginsmobile.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.R
import com.example.petshopdoginsmobile.domain.Item
import com.example.petshopdoginsmobile.ui.components.cards.CartProductCard
import com.example.petshopdoginsmobile.ui.components.cards.OrderSummaryCard
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.viewmodels.ItemViewModel
import com.example.petshopdoginsmobile.ui.viewmodels.ItemViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartPage(){
    /*val item1: ItemViewModel = viewModel(factory = ItemViewModelFactory(
        Item(
            image = painterResource(id = R.drawable.img_cat),
            title = "Fantasia para Gatos de Unicórnio e Leão Fantasia para Gatos de Unicórnio",
            quantity = mutableStateOf<Int>(1) },
            inStock = 6,
            discount = 20,
            price = 62.00
        )
    ))

    /*
    val item2 = Item(
        image = painterResource(id = R.drawable.img_cat),
        title = "Fantasia para Gatos de Unicórnio e Leão Fantasia para Gatos de Unicórnio",
        quantity = remember { mutableStateOf(1) },
        inStock = 6,
        discount = 20,
        price = 62.00
    )
    val items = listOf(item1, item2)
    val listState = rememberLazyListState()
    val totalValue = remember {
        mutableStateOf(items.sumOf {
            it.price * it.quantity.value
        })
    }
    val totalItems = remember {
        mutableStateOf(items.size)
    }
    val coupons = remember { mutableStateOf(mapOf<String?, Int>()) }
    val couponDiscount: (String?, Double) -> Double = { _, _ -> 0.0 }
*/
    Scaffold(
        modifier = Modifier.background(Grey)
    ){ innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .background(Grey)
                .padding(innerPadding)
        ){
            LazyColumn(
                state = listState,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ){
                items.forEach { item ->
                    item {
                        CartProductCard(
                            image = item.image,
                            title = item.title,
                            quantity = item.quantity,
                            inStock = item.inStock,
                            discount = item.discount,
                            price = item.price
                        )
                    }
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

        Button(
            onClick = {

            }
        ) {

        }

    }*/
}

@Preview
@Composable
fun ShoppingCartPagePreview(){
    ShoppingCartPage()
}