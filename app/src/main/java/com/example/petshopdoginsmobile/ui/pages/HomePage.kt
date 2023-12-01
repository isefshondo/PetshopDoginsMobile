package com.example.petshopdoginsmobile.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.R
import com.example.petshopdoginsmobile.ui.components.buttons.CategoryButtonsRow
import com.example.petshopdoginsmobile.ui.components.cards.CarouselCard
import com.example.petshopdoginsmobile.ui.components.cards.CouponCard
import com.example.petshopdoginsmobile.ui.components.cards.PromotionCard

@Composable
fun HomePage(){
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        Hero()
        ProductCategories()
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            PromotionCard(
                discount = "20% OFF + Frete grátis ",
                description = "na primeira compra",
                onClick = {}
            )
        }
    }
}

@Composable
private fun Hero(){
    CarouselCard(
        items = listOf(
            {
                Image(
                    painter = painterResource(id = R.drawable.img_carousel_01),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            {
                Image(
                    painter = painterResource(id = R.drawable.img_carousel_02),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        )
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ){
        CouponCard(couponCode = "AUDACIOSO1", discount = "10% OFF")
    }
}

@Composable
private fun ProductCategories(){
    CategoryButtonsRow(
        buttons = listOf(
            Pair(R.drawable.ic_accessories, "Acessórios"),
            Pair(R.drawable.ic_accessories, "Acessórios"),
            Pair(R.drawable.ic_accessories, "Acessórios"),
            Pair(R.drawable.ic_accessories, "Acessórios"),
            Pair(R.drawable.ic_accessories, "Acessórios"),
            Pair(R.drawable.ic_accessories, "Acessórios")
        )
    )
}

@Preview
@Composable
private fun HomePagePreview(){
    HomePage()
}