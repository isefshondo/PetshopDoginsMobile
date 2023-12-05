package com.example.petshopdoginsmobile.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petshopdoginsmobile.domain.StaticProduct
import com.example.petshopdoginsmobile.model.entities.Product
import com.example.petshopdoginsmobile.ui.components.cards.VisualizeProductCard
import com.example.petshopdoginsmobile.ui.theme.BlueDark
import com.example.petshopdoginsmobile.ui.theme.PetshopDoginsMobileTheme
import com.example.petshopdoginsmobile.ui.theme.medium20
import com.example.petshopdoginsmobile.ui.components.cards.ProductInfoCard
import com.example.petshopdoginsmobile.ui.components.header.PageHeader
import com.example.petshopdoginsmobile.ui.theme.Blue
import com.example.petshopdoginsmobile.ui.theme.White
import com.example.petshopdoginsmobile.ui.utils.productImageExample

@Composable
fun VisualizeProductPage(navController: NavController, productId: String) {
    val staticProductInfo = StaticProduct(
        productRating = 4.5f,
        productRatingQuantity = 129,
        productComments = 50
    )

    val product = Product(
        productImages = listOf(productImageExample.data),
        productCategory = "",
        brandName = "",
        productColor = "",
        productName = "",
        productStock = 10,
        size = "",
        productDescription = "Fantasia para Gatos de xxxx Unicórnio e Leão",
        productPrice = 163.90
    )
    Column {
        // Header
        Column (
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            PageHeader (
                isHomePage = false,
                headerTitle = "Detalhes",
                handleViewCartEvent = { navController.navigate("shopping-cart") },
                navController = navController
            )
        }
        // Visualize product and its info
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .weight(2F)
                .verticalScroll(rememberScrollState()),
        ) {
            Row (
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 29.dp)
            ) {
                VisualizeProductCard(
                    productRating = staticProductInfo.productRating,
                    reviewQuantity = staticProductInfo.productRatingQuantity,
                    allProductComments = staticProductInfo.productComments,
                    product
                )
            }

            Row {
                ProductInfoCard(product)
            }
        }
        // Buy Button Column
        Column (
            modifier = Modifier
                .shadow(elevation = 18.5.dp)
                .background(White)
                .fillMaxWidth()
                .weight(.25F),
        ) {
            Row (
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Box (
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Blue, shape = RoundedCornerShape(10.dp))
                        .clickable { },
                    contentAlignment = Alignment.Center,
                ) {
                    Text(buildAnnotatedString {
                        withStyle(SpanStyle(BlueDark)) {
                            append("Comprar")
                        }
                    }, style = medium20)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun VisualizeProductPagePreview() {
    PetshopDoginsMobileTheme {
        VisualizeProductPage(productId = "", navController = rememberNavController())
    }
}