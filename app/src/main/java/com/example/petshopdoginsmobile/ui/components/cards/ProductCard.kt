package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petshopdoginsmobile.model.entities.Product
import com.example.petshopdoginsmobile.model.entities.ProductImage
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.theme.GreyDarkier
import com.example.petshopdoginsmobile.ui.theme.VibrantBlue
import com.example.petshopdoginsmobile.ui.theme.discount
import com.example.petshopdoginsmobile.ui.theme.medium14
import com.example.petshopdoginsmobile.ui.theme.regular10
import com.example.petshopdoginsmobile.ui.utils.calculateDiscountedPrice
import com.example.petshopdoginsmobile.ui.utils.formatToCurrency
import com.example.petshopdoginsmobile.ui.utils.productImageExample

@Composable
fun ProductCard(
    navController: NavController,
    product: Product,
    discountValue: Double = 0.0,
){
    val productImage = ProductImage(product.productImages[0])
    val price = calculateDiscountedPrice(product.productPrice!!, discountValue)
    ElevatedCard(
        modifier = Modifier
            .widthIn(max = 133.dp)
            .clickable { navController.navigate("visualize-product/${product.id}") },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ){
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            LoadBinaryImage(productImage = productImage, "Product image")
            Text(
                text = product.productDescription!!,
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
                    text = product.productPrice.formatToCurrency(),
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
    ProductCard(
        rememberNavController(),
        product = product,
        discountValue = 20.0
    )
}

@Composable
fun ProdutctCardsRow(
    navController: NavController,
    products: List<Product>,
    discount: Double = 0.0
){
    LazyRow {
        items(products) { product ->
            Spacer(modifier = Modifier.width(20.dp))
            ProductCard(product = product, discountValue = discount, navController = navController)
        }
    }
}

@Preview
@Composable
private fun ProductCardsRowPreview(){
    val product1 = Product(
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
    val product2 = Product(
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
    val product3 = Product(
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
    val product4 = Product(
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
    val product5 = Product(
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
    val products = listOf(product1, product2, product3, product4, product5)
    ProdutctCardsRow(products = products, discount = 20.0, navController = rememberNavController())
}