package com.example.petshopdoginsmobile.ui.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.petshopdoginsmobile.R
import com.example.petshopdoginsmobile.domain.Product
import com.example.petshopdoginsmobile.ui.components.buttons.CategoryButtonsRow
import com.example.petshopdoginsmobile.ui.components.cards.CarouselCard
import com.example.petshopdoginsmobile.ui.components.cards.CouponCard
import com.example.petshopdoginsmobile.ui.components.cards.ProductCatalogue
import com.example.petshopdoginsmobile.ui.components.cards.ProdutctCardsRow
import com.example.petshopdoginsmobile.ui.components.cards.PromotionCard
import com.example.petshopdoginsmobile.ui.theme.BgGrey
import com.example.petshopdoginsmobile.ui.utils.Dimensions

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(){
    Scaffold(
        containerColor = BgGrey,
    ){
        LazyColumn(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(Dimensions.VERTICAL_SPACING)
        ) {
            item { Hero() }
            item { ProductCategories() }
            item {
                Row(
                    modifier = Modifier
                        .padding(horizontal = Dimensions.SCREEN_PADDING)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    PromotionCard(
                        discount = "20% OFF + Frete grátis ",
                        description = "na primeira compra",
                        onClick = {}
                    )
                }
            }
            item { ProductsSection() }
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
    Spacer(modifier = Modifier.height(Dimensions.VERTICAL_SPACING))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimensions.SCREEN_PADDING)
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

@Composable
private fun ProductsSection(){
    val product1 = Product(
        image = R.drawable.img_cat,
        description = "Fantasia para Gatos de xxxx Unicórnio e Leão",
        price = 163.90
    )
    val product2 = Product(
        image = R.drawable.img_cat,
        description = "Fantasia para Gatos de xxxx Unicórnio e Leão",
        price = 163.90
    )
    val product3 = Product(
        image = R.drawable.img_cat,
        description = "Fantasia para Gatos de xxxx Unicórnio e Leão",
        price = 163.90
    )
    val product4 = Product(
        image = R.drawable.img_cat,
        description = "Fantasia para Gatos de xxxx Unicórnio e Leão",
        price = 163.90
    )
    val product5 = Product(
        image = R.drawable.img_cat,
        description = "Fantasia para Gatos de xxxx Unicórnio e Leão",
        price = 163.90
    )
    val products = listOf(product1, product2, product3, product4, product5)
    ProdutctCardsRow(products = products, discount = 20.0)
    Spacer(modifier = Modifier.height(Dimensions.VERTICAL_SPACING))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        ProductCatalogue(products = products)
    }
}

@Preview
@Composable
private fun HomePagePreview(){
    HomePage()
}