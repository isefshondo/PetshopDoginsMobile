package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.R
import com.example.petshopdoginsmobile.domain.Product
import com.example.petshopdoginsmobile.ui.components.buttons.ClickableLinkText
import com.example.petshopdoginsmobile.ui.components.lines.VerticalDivider
import com.example.petshopdoginsmobile.ui.theme.BgGrey
import com.example.petshopdoginsmobile.ui.theme.Green
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.theme.GreyDarkier
import com.example.petshopdoginsmobile.ui.theme.VibrantBlue
import com.example.petshopdoginsmobile.ui.theme.discount
import com.example.petshopdoginsmobile.ui.theme.medium14
import com.example.petshopdoginsmobile.ui.theme.regular10
import com.example.petshopdoginsmobile.ui.theme.regular12
import com.example.petshopdoginsmobile.ui.utils.CardDimensions
import com.example.petshopdoginsmobile.ui.utils.Dimensions
import com.example.petshopdoginsmobile.ui.utils.formatToCurrency

@Composable
fun ProductCatalogue(
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
                    .padding(start = 21.dp)
            ){
                Text(
                    text = "Produtos AUUdaciosos",
                    style = regular12.copy(GreyDarkier)
                )
            }
            Divider(color = BgGrey)
            LazyColumn(modifier = Modifier.width(cardWidth)){
                items((products.size + 1) / 2) { rowIndex ->
                    Row(modifier = Modifier.width(cardWidth)) {
                        for (columnIndex in 0 until 2) {
                            val index = rowIndex * 2 + columnIndex
                            if (index < products.size) {
                                Column(
                                    modifier = Modifier
                                        .widthIn(min = itemWidth),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ){
                                    ProductItem(
                                        product = products[index],
                                        shippingCost = shippingCost
                                    )
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
            ){
                ClickableLinkText(text = "Veja mais", onClick = {})
            }
        }
    }
}

@Composable
private fun ProductItem(
    product: Product,
    shippingCost: Double = 0.0,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .widthIn(max = 160.dp)
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        Image(
            painter = painterResource(id = product.image),
            contentDescription = "Product image"
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ){
            Text(
                modifier = Modifier.height(16.dp),
                text = product.price.formatToCurrency(),
                style = medium14.copy(VibrantBlue)
            )
            Text(
                text = product.description,
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
    ProductCatalogue(products = products)
}

@Preview
@Composable
private fun ProductItemPreview(){
    val product = Product(
        image = R.drawable.img_cat,
        description = "Fantasia para Gatos de xxxx Unicórnio e Leão",
        price = 163.90
    )
    ProductItem(product)
}
