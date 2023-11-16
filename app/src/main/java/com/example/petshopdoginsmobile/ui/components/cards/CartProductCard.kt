package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.R
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.theme.GreyDarkier
import com.example.petshopdoginsmobile.ui.theme.SoftBlue
import com.example.petshopdoginsmobile.ui.theme.VibrantBlue
import com.example.petshopdoginsmobile.ui.theme.medium12
import com.example.petshopdoginsmobile.ui.theme.medium14
import com.example.petshopdoginsmobile.ui.theme.regular12

@Composable
fun CartProductCard(
    modifier: Modifier = Modifier,
    image: Painter,
    title: String,
    quantity: MutableState<Int>,
    inStock: Int,
    discount: Int,
    price: Double
){
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    /*
    *   Larguras do figma
    *   tela: 360
    *   card: 333
    *   %: 92,5%
    */
    val cardWidth = screenWidth * 0.925f
    val cardHeight = screenWidth * 0.36f
    val cardHorizontalPadding = screenWidth * 0.038f
    val cardTopPadding = screenWidth * 0.05f
    val colRightWidth = screenWidth * 0.684f

    ElevatedCard(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .width(cardWidth)
            .heightIn(min = cardHeight)
            .widthIn(max = 360.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = cardTopPadding, start = cardHorizontalPadding, end = cardHorizontalPadding)
        ){
            Column(
                modifier = Modifier.heightIn(screenWidth * 0.3f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Image(
                    modifier = Modifier.size(48.dp),
                    painter = image,
                    contentDescription = "Product image"
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally){
                    Card(
                        shape = RoundedCornerShape(5.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = SoftBlue
                        )

                    ){
                        Text(
                            text = "-${discount}%",
                            style = regular12.copy(VibrantBlue)
                        )
                    }
                    Text(
                        text = "R$ $price",
                        style = medium14
                    )
                }
            }
            Column(
                modifier = Modifier
                    .width(colRightWidth),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Row(
                    modifier = Modifier
                        .width(colRightWidth)
                        .padding(start = 10.dp),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        modifier = Modifier.weight(1f),
                        text = title,
                        style = regular12.copy(GreyDarkier)
                    )
                    Spacer(
                        modifier = Modifier
                            .width(screenWidth * 0.12f)
                    )
                    IconButton(
                        modifier = Modifier
                            .border(1.dp, Grey, RoundedCornerShape(5.dp))
                            .size(22.dp)
                            .padding(4.dp),
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_delete),
                            contentDescription = "Delete item"
                        )
                    }
                }
                Spacer(modifier = Modifier.heightIn(min = screenWidth * 0.083f))
                Row{
                    QuantitySelector(
                        quantity = quantity,
                        inStock = inStock,
                        onClickDelete = {}
                    )
                }
            }
        }
    }
}
@Preview
@Composable
private fun PreviewCartProductCard() {
    val quantity = remember { mutableStateOf(1) }
    CartProductCard(
        image = painterResource(id = R.drawable.img_cat),
        title = "Fantasia para Gatos de Unicórnio e Leão Fantasia para Gatos de Unicórnio",
        quantity = quantity,
        inStock = 6,
        discount = 20,
        price = 99.99
    )
}



@Composable
fun QuantitySelector(
    quantity: MutableState<Int>,
    inStock: Int,
    modifier: Modifier = Modifier,
    onClickDelete: () -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .height(20.dp)
            .border(1.dp, Grey, RoundedCornerShape(5.dp))
            .clip(RoundedCornerShape(5.dp))
    ) {
        IconButton(
            modifier = Modifier.width(22.dp),
            onClick = {
                if(quantity.value < inStock)
                    quantity.value++
            }
        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Add item",
                modifier = Modifier.size(10.dp),
                tint = GreyDarkier
            )
        }
        Text(
            text = quantity.value.toString(),
            textAlign = TextAlign.Center,
            style = medium12,
            modifier = Modifier
                .border(1.dp, Grey)
                .height(20.dp)
                .width(34.dp)
        )
        IconButton(
            modifier = Modifier.width(22.dp),
            onClick = {
                if (quantity.value > 0)
                    quantity.value--
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_minus),
                contentDescription = "Decrement item",
                modifier = Modifier.size(8.dp),
                tint = GreyDarkier
            )
        }
    }
}

@Preview
@Composable
private fun QuantitySelectorPreview() {
    val quantity = remember { mutableStateOf(1) }
    QuantitySelector(quantity = quantity, inStock = 10, onClickDelete = {})
}