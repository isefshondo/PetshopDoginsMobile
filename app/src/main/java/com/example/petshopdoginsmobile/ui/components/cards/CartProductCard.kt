package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.petshopdoginsmobile.R
import com.example.petshopdoginsmobile.model.entities.ProductImage
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.theme.GreyDarkier
import com.example.petshopdoginsmobile.ui.theme.SoftBlue
import com.example.petshopdoginsmobile.ui.theme.VibrantBlue
import com.example.petshopdoginsmobile.ui.theme.White
import com.example.petshopdoginsmobile.ui.theme.medium12
import com.example.petshopdoginsmobile.ui.theme.medium14
import com.example.petshopdoginsmobile.ui.theme.regular12
import com.example.petshopdoginsmobile.ui.utils.CardDimensions
import com.example.petshopdoginsmobile.ui.utils.formatToCurrency
import com.example.petshopdoginsmobile.ui.utils.productImageExample
import com.example.petshopdoginsmobile.ui.viewmodels.ItemViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun CartProductCard(
    image: String,
    title: String,
    _quantity: MutableStateFlow<Int>,
    _inStock: MutableStateFlow<Int>,
    _discount: MutableStateFlow<Double>,
    _price: MutableStateFlow<Double>,
    _total: MutableStateFlow<Double>,
    onQuantityChange: (Int) -> Unit,
    onRemove: () -> Unit
){
    val img = ProductImage(image)
    val configuration = LocalConfiguration.current
    val d = CardDimensions(configuration)
    val quantity = _quantity.collectAsState()
    val inStock = _inStock.collectAsState()
    val discount = _discount.collectAsState()
    val price = _price.collectAsState()
    val formattedPrice = remember {
        derivedStateOf {
            price.value.formatToCurrency() // price é um StateFlow<Double>
        }
    }

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(d.cardWidth)
            .heightIn(min = d.cardHeight)
            .widthIn(max = 360.dp)
            .border(width = 1.dp, color = Grey, shape = RoundedCornerShape(10.dp)),
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
                .padding(
                    top = d.cardTopPadding,
                    start = d.cardHorizontalPadding,
                    end = d.cardHorizontalPadding
                )
        ){
            Column(
                modifier = Modifier.heightIn(d.screenWidth * 0.3f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ){
                LoadBinaryImage(productImage = img, maxWidth = 48.dp, contentDescription = "Product image")
                Column(horizontalAlignment = Alignment.CenterHorizontally){
                    Card(
                        shape = RoundedCornerShape(5.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = SoftBlue
                        )

                    ){
                        Box(modifier = Modifier.padding(horizontal = 2.dp)){
                            Text(
                                text = "-${discount.value}%",
                                style = regular12.copy(VibrantBlue)
                            )
                        }
                    }
                    Text(
                        text = formattedPrice.value,
                        style = medium14
                    )
                }
            }
            Column(
                modifier = Modifier
                    .width(d.colRightWidth),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Row(
                    modifier = Modifier
                        .width(d.colRightWidth)
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
                            .width(d.screenWidth * 0.12f)
                    )
                    IconButton(
                        modifier = Modifier
                            .border(1.dp, Grey, RoundedCornerShape(5.dp))
                            .size(22.dp)
                            .padding(4.dp),
                        onClick = onRemove
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_delete),
                            contentDescription = "Delete item"
                        )
                    }
                }
                Spacer(modifier = Modifier.heightIn(min = d.screenWidth * 0.083f))
                Row{
                    QuantitySelector(
                        _quantity = MutableStateFlow(quantity.value),
                        _inStock = MutableStateFlow(inStock.value),
                        onQuantityChange = onQuantityChange,
                        isCartProductItem = true
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCartProductCard() {
    val quantity = MutableStateFlow(1)
    val inStock = MutableStateFlow(10)
    val discount = MutableStateFlow(20.0)
    val price = MutableStateFlow(49.90)
    val total = MutableStateFlow(0.0)
    val item: ItemViewModel = viewModel()
    CartProductCard(
        image = productImageExample.data,
        title = "Fantasia para Gatos de Unicórnio e Leão Fantasia para Gatos de Unicórnio",
        _quantity = quantity,
        _inStock = inStock,
        _discount = discount,
        _price = price,
        _total = total,
        onQuantityChange = item::updateQuantity,
        onRemove = {}
    )
}


@Composable
fun QuantitySelector(
    _quantity: MutableStateFlow<Int>,
    _inStock: MutableStateFlow<Int>,
    onQuantityChange: (Int) -> Unit,
    isCartProductItem: Boolean = false,
){
    var height = 40.dp
    var widthText = 60.dp
    var widthIconBtn = 44.dp
    var addIconSize = 14.dp
    var decrementIconWidth = 12.dp
    var borderRadius = 10.dp
    var textStyle = medium14

    if(isCartProductItem){
        height = 20.dp
        widthText = 34.dp
        widthIconBtn = 22.dp
        addIconSize = 10.dp
        decrementIconWidth = 8.dp
        borderRadius = 5.dp
        textStyle = medium12
    }

    val quantity = _quantity.collectAsState()
    val inStock = _inStock.collectAsState()

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .height(height)
            .border(1.dp, Grey, RoundedCornerShape(borderRadius))
            .clip(RoundedCornerShape(5.dp))
    ) {
        IconButton(
            modifier = Modifier.width(widthIconBtn),
            onClick = {
                if(quantity.value < inStock.value)
                    onQuantityChange(quantity.value + 1)
            }
        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Add item",
                modifier = Modifier.size(addIconSize),
                tint = GreyDarkier
            )
        }
        Column(
            modifier = Modifier
                .border(1.dp, Grey)
                .height(height)
                .width(widthText),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = quantity.value.toString(),
                style = textStyle,
            )
        }
        IconButton(
            modifier = Modifier.width(widthIconBtn),
            onClick = {
                if (quantity.value > 0)
                    onQuantityChange(quantity.value - 1)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_minus),
                contentDescription = "Decrement item",
                modifier = Modifier.size(decrementIconWidth),
                tint = GreyDarkier
            )
        }
    }
}
/*
@Preview
@Composable
private fun QuantitySelectorPreview() {
    val quantity = remember { MutableStateFlow(1) }
    QuantitySelector(quantity = quantity, inStock = MutableStateFlow(10))
}

 */