package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.R
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.theme.GreyDarkier
import com.example.petshopdoginsmobile.ui.theme.VibrantBlue
import com.example.petshopdoginsmobile.ui.theme.discount
import com.example.petshopdoginsmobile.ui.theme.medium14
import com.example.petshopdoginsmobile.ui.theme.regular10
import com.example.petshopdoginsmobile.ui.utils.calculateDiscountedPrice
import com.example.petshopdoginsmobile.ui.utils.formatToCurrency

@Composable
fun ProductCard(
    image: Int,
    description: String,
    originalPrice: Double,
    discountValue: Double = 0.0,
){
    val price = calculateDiscountedPrice(originalPrice, discountValue)
    ElevatedCard(
        modifier = Modifier.widthIn(max = 133.dp)
    ){
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            Image(
                painter = painterResource(id = image),
                contentDescription = "Product image"
            )
            Text(
                text = description,
                style = regular10.copy(Grey),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ){
                Text(
                    modifier = Modifier.height(16.dp),
                    text = originalPrice.formatToCurrency(),
                    style = discount.copy(
                        color = GreyDarkier,
                        textDecoration = TextDecoration.LineThrough
                    )
                )
                Text(
                    modifier = Modifier.height(20.dp),
                    text = price.formatToCurrency(),
                    style = medium14.copy(VibrantBlue)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductCardView(){
    ProductCard(
        image = R.drawable.img_cat,
        description = "Fantasia para Gatos de xxxx Unicórnio e Leão",
        originalPrice = 163.90,
        discountValue = 20.0
    )
}