package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petshopdoginsmobile.model.entities.Product
import com.example.petshopdoginsmobile.model.entities.ProductImage
import com.example.petshopdoginsmobile.ui.components.buttons.ClickableLinkText
import com.example.petshopdoginsmobile.ui.theme.BgGrey
import com.example.petshopdoginsmobile.ui.theme.Green
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.theme.GreyDarkier
import com.example.petshopdoginsmobile.ui.theme.VibrantBlue
import com.example.petshopdoginsmobile.ui.theme.medium14
import com.example.petshopdoginsmobile.ui.theme.regular10
import com.example.petshopdoginsmobile.ui.theme.regular12
import com.example.petshopdoginsmobile.ui.utils.CardDimensions
import com.example.petshopdoginsmobile.ui.utils.Dimensions
import com.example.petshopdoginsmobile.ui.utils.formatToCurrency
import com.example.petshopdoginsmobile.ui.utils.productImageExample

@Composable
fun ProductCatalogue(
    navController: NavController,
    products: List<Product>,
    shippingCost: Double = 0.0
){
    val configuration = LocalConfiguration.current
    val d = CardDimensions(configuration)
    val cardWidth = d.screenWidth - (Dimensions.SCREEN_PADDING * 2)
    val itemWidth = cardWidth / 2

    ElevatedCard(
        modifier = Modifier.width(cardWidth),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ){
        Column(modifier = Modifier.width(cardWidth)){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 21.dp, vertical = 8.dp)
            ){
                Text(
                    text = "Produtos AUUdaciosos",
                    style = regular12.copy(GreyDarkier)
                )
            }
            Divider(color = BgGrey)
            Column(modifier = Modifier.width(cardWidth)) {
                val maxProducts = minOf(products.size, 4) // Limita a quantidade de produtos
                for (index in 0 until maxProducts step 2) {
                    Row(modifier = Modifier.width(cardWidth)) {
                        for (columnIndex in 0 until 2) {
                            val productIndex = index + columnIndex
                            if (productIndex < maxProducts) {
                                var itemModifier = Modifier.widthIn(min = itemWidth)
                                if(columnIndex == 0) {
                                    itemModifier = itemModifier.drawBehind {
                                        val strokeWidth = 1.dp.toPx() // Define a espessura da borda
                                        val color = BgGrey // Define a cor da borda
                                        drawRect(
                                            color,
                                            Offset(size.width - strokeWidth, 0f),
                                            Size(strokeWidth, size.height)
                                        )
                                    }
                                }
                                Box{
                                    Column(
                                        modifier = itemModifier,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ){
                                        ProductItem(
                                            product = products[productIndex],
                                            shippingCost = shippingCost,
                                            navController = navController
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Divider(color = BgGrey)
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ){
                ClickableLinkText(text = "Veja mais", onClick = {})
            }
        }
    }
}

@Composable
private fun ProductItem(
    navController: NavController,
    product: Product,
    shippingCost: Double = 0.0,
){
    val productImage = ProductImage(product.productImages[0])
    Column(
        modifier = Modifier
            .widthIn(max = 160.dp)
            .padding(12.dp)
            .clickable { navController.navigate("visualize-product/${product.id}") },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        LoadBinaryImage(productImage = productImage, "Product image")
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ){
            Text(
                modifier = Modifier.height(16.dp),
                text = product.productPrice!!.formatToCurrency(),
                style = medium14.copy(VibrantBlue)
            )
            Text(
                text = product.productDescription!!,
                style = regular10.copy(Grey),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = if(shippingCost == 0.0) "Frete grátis"
                else shippingCost.formatToCurrency(),
                style = regular10.copy(Green)
            )
        }
    }
}

@Preview
@Composable
private fun ProductCataloguePreview(){
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
    ProductCatalogue(products = products, navController = rememberNavController())
}

@Preview
@Composable
private fun ProductItemPreview(){
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
    ProductItem(product = product, navController = rememberNavController())
}
