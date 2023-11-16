package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.ui.components.buttons.ClickableLinkText
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.theme.medium12
import com.example.petshopdoginsmobile.ui.utils.CardDimensions

@Composable
fun OrderSummaryCard(
    totalItems: MutableState<Int>,
    totalValue: MutableState<Double>,
    shippingCost: Double,
    coupons: MutableState<Map<String, Int>>,
    couponDiscount: (String, Double) -> Double
){
    val configuration = LocalConfiguration.current
    val d = CardDimensions(configuration)

    ElevatedCard(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .width(d.cardWidth)
            .heightIn(min = d.cardHeight)
            .widthIn(max = 360.dp)
            .border(1.dp, Grey)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Resumo do pedido",
                style = medium12
            )
            ClickableLinkText(
                text = "Ver detalhes",
                onClick = {}
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Column {
                Text(text = "Produtos (${totalItems.value})")
                Text(text = "Frete")
            }
            Column {

            }
        }
    }
}

@Preview
@Composable
fun PreviewOrderSummaryCard() {
    val totalItems = remember { mutableStateOf(5) }
    val totalValue = remember { mutableStateOf(100.0) }
    val shippingCost = 10.0
    val coupons = remember { mutableStateOf(mapOf("Coupon1" to 10)) }
    val couponDiscount: (String, Double) -> Double = { _, _ -> 0.0 }

    OrderSummaryCard(
        totalItems = totalItems,
        totalValue = totalValue,
        shippingCost = shippingCost,
        coupons = coupons,
        couponDiscount = couponDiscount
    )
}
