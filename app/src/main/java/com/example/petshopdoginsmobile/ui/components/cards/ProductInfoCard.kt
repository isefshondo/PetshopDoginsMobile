package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.R
import com.example.petshopdoginsmobile.ui.components.buttons.CalculateShippingButton
import com.example.petshopdoginsmobile.ui.theme.Blue
import com.example.petshopdoginsmobile.ui.theme.BlueDark
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.theme.GreyDarkier
import com.example.petshopdoginsmobile.ui.theme.PetshopDoginsMobileTheme
import com.example.petshopdoginsmobile.ui.theme.SoftBlue
import com.example.petshopdoginsmobile.ui.theme.VibrantBlue
import com.example.petshopdoginsmobile.ui.theme.White
import com.example.petshopdoginsmobile.ui.theme.medium12
import com.example.petshopdoginsmobile.ui.theme.medium14
import com.example.petshopdoginsmobile.ui.theme.medium20
import com.example.petshopdoginsmobile.ui.theme.regular12

@Composable
fun renderDivider() {
    Spacer(modifier = Modifier.height(10.dp))
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Grey)
    )
    Spacer(modifier = Modifier.height(15.dp))
}

@Composable
fun renderPricesOnDiscount(productPrice: Float, discountValue: Float) {
    val priceDiscount = (productPrice * (100f - discountValue)) / 100f;

    Row (
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(buildAnnotatedString {
            withStyle(SpanStyle(color = GreyDarkier, textDecoration = TextDecoration.LineThrough)) {
                append("R$ $productPrice")
            }
        }, style = medium12)
        Spacer(modifier = Modifier.width(10.dp))
        Box (
            modifier = Modifier
                .background(color = SoftBlue, shape = RoundedCornerShape(5.dp))
                .padding(horizontal = 5.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(buildAnnotatedString {
                withStyle(SpanStyle(color = VibrantBlue)) {
                    append("-$discountValue%")
                }
            }, style = regular12)
        }
        Spacer(modifier = Modifier.width(10.dp))
        Box (
            modifier = Modifier
                .size(15.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.info_icon),
                contentDescription = "Saiba mais sobre este produto...",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
    Row {
        Text(buildAnnotatedString {
            withStyle(SpanStyle(color = VibrantBlue)) {
                append("R$ $priceDiscount")
            }
        }, style = medium20)
    }
    renderDivider()
}

@Composable
fun renderPriceSection(productPrice: Float, discountValue: Float?) {
    if (discountValue !== null) {
        renderPricesOnDiscount(productPrice, discountValue)
    } else {
        Row {
            Text(buildAnnotatedString {
                withStyle(SpanStyle(color = VibrantBlue)) {
                    append("R$ $productPrice")
                }
            }, style = medium20)
        }
        renderDivider()
    }
}

@Composable
fun renderAvailableOptions(availableOptions: List<String>, buttonSize: List<Dp>) {
    LazyRow (
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        items(availableOptions) {item ->
            Box (
                modifier = Modifier
                    .border(width = 2.dp, color = Grey, shape = RoundedCornerShape(10.dp))
                    .size(width = buttonSize[0], height = buttonSize[1]),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = item, style = medium14)
            }
        }
    }
}

@Composable
fun renderApplyCouponSection() {
    var couponTextValue by remember { mutableStateOf("") }
    
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .border(width = 1.dp, color = Grey, shape = RoundedCornerShape(10.dp))
            .padding(horizontal = 16.5.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        BasicTextField (
            value = couponTextValue,
            onValueChange = {currentValue -> couponTextValue = currentValue},
            modifier = Modifier
                .weight(2.5F)
                .fillMaxHeight()
                .border(width = 1.dp, color = SoftBlue, shape = RoundedCornerShape(5.dp)),
            textStyle = regular12,
        ) {
            if (couponTextValue.isEmpty()) {
                Text(
                    text = "Cupom",
                    color = GreyDarkier,
                    style = regular12,
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 10.dp)
                )
            }
        }
        Box (
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
                .clip(RoundedCornerShape(5.dp))
                .background(color = Blue)
                .clickable { /* TODO */ },
            contentAlignment = Alignment.Center,
        ) {
            Text(buildAnnotatedString {
                withStyle(SpanStyle(color = BlueDark)) {
                    append("APLICAR")
                }
            }, style = medium12)
        }
    }
}

@Composable
fun renderProductDescription() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Grey, shape = RoundedCornerShape(10.dp))
            .padding(horizontal = 18.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        Row {
            Column {
                Text(text = "Marca", color = GreyDarkier, style = medium20)
                Text(text = "Letraset sheets containing Lorem Ipsum", color = GreyDarkier, style = regular12)
            }
        }
        Row {
            Column {
                Text(text = "Descrição", color = GreyDarkier, style = medium20)
                Text(
                    text = "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus Pa",
                    color = GreyDarkier,
                    style = regular12
                )
            }
        }
    }
}

@Composable
fun ProductInfoCard(
    productPrice: Float,
    discountValue: Float?,
    availableSizes: List<String>,
    availableVariations: List<String>,
    availableProductQt: Int,
) {
    Column (
        modifier = Modifier
            .shadow(
                elevation = 18.5.dp,
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
            )
            .clip(RoundedCornerShape(30.dp))
            .background(White)
            .padding(23.dp),
    ) {
        Column {
            renderPriceSection(productPrice, discountValue)
        }
        Column {
            Text(buildAnnotatedString {
                withStyle(SpanStyle(color = GreyDarkier)) {
                    append("Tamanhos")
                }
            }, style = medium20)
            Spacer(modifier = Modifier.width(15.dp))
            renderAvailableOptions(availableOptions = availableSizes, buttonSize = listOf(47.36.dp, 47.36.dp))
        }
        Spacer(modifier = Modifier.height(17.dp))
        Column {
            Text(buildAnnotatedString {
                withStyle(SpanStyle(color = GreyDarkier)) {
                    append("Variações")
                }
            }, style = medium20)
            Spacer(modifier = Modifier.width(15.dp))
            renderAvailableOptions(availableOptions = availableVariations, buttonSize = listOf(152.dp, 45.36.dp))
        }
        Spacer(modifier = Modifier.height(17.dp))
        Column {
            Text(buildAnnotatedString {
                withStyle(SpanStyle(color = GreyDarkier)) {
                    append("Quantidade")
                }
            }, style = medium20)
            Spacer(modifier = Modifier.width(15.dp))

        }
        Spacer(modifier = Modifier.height(25.dp))
        Column {
            CalculateShippingButton(onClick = {})
        }
        Spacer(modifier = Modifier.height(21.dp))
        Column {
            renderApplyCouponSection()
        }
        Spacer(modifier = Modifier.height(21.dp))
        Column {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable { /* TODO */ }
                    .background(color = SoftBlue),
                contentAlignment = Alignment.Center
            ) {
                Text(buildAnnotatedString {
                    withStyle(SpanStyle(color = VibrantBlue)) {
                        append("Adicionar ao carrinho")
                    }
                }, style = medium20)
            }
        }
        Spacer(modifier = Modifier.height(21.dp))
        renderProductDescription()
    }
}

@Composable
@Preview(showBackground = true)
fun ProductInfoCardPreview() {
    PetshopDoginsMobileTheme {
        val availableSizes = listOf<String>("P", "M", "G");
        val availableVariations = listOf<String>("Unicórnio", "Leão")
        ProductInfoCard(productPrice = 163.90f, discountValue = 20f, availableSizes, availableVariations, availableProductQt = 5)
    }
}