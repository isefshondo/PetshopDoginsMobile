package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.ui.components.buttons.ClickableLinkText
import com.example.petshopdoginsmobile.ui.theme.Green
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.theme.medium12
import com.example.petshopdoginsmobile.ui.theme.medium14
import com.example.petshopdoginsmobile.ui.utils.CardDimensions
import com.example.petshopdoginsmobile.ui.utils.formatToCurrency
import kotlinx.coroutines.flow.MutableStateFlow


@Composable
fun OrderSummaryCard(
    totalItems: State<Int>,
    totalValue: State<Double>,
    shippingCost: Double,
    coupons: MutableState<Map<String?, Double>>,
    couponDiscount: (String?, Double) -> Double
){
    val configuration = LocalConfiguration.current
    val d = CardDimensions(configuration)

    val total = remember {
        derivedStateOf {
            totalValue.value + shippingCost - couponDiscount(coupons.value.keys.firstOrNull(), totalValue.value)
        }
    }


    ElevatedCard(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .width(d.cardWidth)
            .heightIn(min = d.cardHeight)
            .widthIn(max = 360.dp)
            .border(1.dp, Grey)
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(d.screenWidth * 0.027f),
            modifier = Modifier.padding(
                top = d.screenWidth * 0.042f,
                bottom = d.screenWidth * 0.08f,
                start = d.screenWidth * 0.058f,
                end = d.screenWidth * 0.058f,
            )
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
                    Text(
                        text = "Produtos (${totalItems.value})",
                        style = medium12.copy(Grey)
                    )
                    Text(
                        text = "Frete",
                        style = medium12.copy(Grey)
                    )
                    Text(
                        text = "(${coupons.value.size}) Cupons aplicados",
                        style = medium12.copy(Grey)
                    )

                }
                Column(horizontalAlignment = Alignment.End){
                    Text(
                        text = totalValue.value.formatToCurrency(),
                        style = medium12.copy(Grey)
                    )
                    Text(
                        text = if(shippingCost == 0.0) "Grátis"
                        else shippingCost.formatToCurrency(),
                        style = medium12.copy(Green)
                    )
                }
            }
            Divider(
                modifier = Modifier,
                color = Grey
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Total",
                    style = medium14
                )
                Text(
                    text = total.value.formatToCurrency(),
                    style = medium14
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewOrderSummaryCard() {
    val totalItems = remember { mutableStateOf(2) }
    val totalValue = remember { mutableStateOf(200.0) }
    val coupons = remember { mutableStateOf(mapOf<String?, Double>()) }
    val couponDiscount: (String?, Double) -> Double = { _, _ -> 0.0 }

    OrderSummaryCard(
        totalItems = totalItems,
        totalValue = totalValue,
        shippingCost = 10.0,
        coupons = coupons,
        couponDiscount = couponDiscount
    )
}

