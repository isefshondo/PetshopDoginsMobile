package com.example.petshopdoginsmobile.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.ui.components.cards.VisualizeProductCard
import com.example.petshopdoginsmobile.ui.theme.BlueDark
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.theme.GreyDarkier
import com.example.petshopdoginsmobile.ui.theme.PetshopDoginsMobileTheme
import com.example.petshopdoginsmobile.ui.theme.SoftBlue
import com.example.petshopdoginsmobile.ui.theme.VibrantBlue
import com.example.petshopdoginsmobile.ui.theme.medium12
import com.example.petshopdoginsmobile.ui.theme.medium20
import com.example.petshopdoginsmobile.ui.theme.regular12
import com.example.petshopdoginsmobile.R
import com.example.petshopdoginsmobile.ui.components.cards.ProductInfoCard
import com.example.petshopdoginsmobile.ui.theme.medium14

@Composable
fun VisualizeProductPage() {
    val availableSizes = listOf<String>("P", "M", "G");
    val availableVariations = listOf<String>("Unicórnio", "Leão")

    Column {
        // Header
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .weight(.25F)
                .background(Color.Yellow),
        ) {
            // Here comes the Header
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
                VisualizeProductCard()
            }
            Row {
                ProductInfoCard(productPrice = 163.90f, discountValue = 20f, availableSizes, availableVariations, availableProductQt = 5)
            }
        }
        // Buy Button Column
        Column (
            modifier = Modifier
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
                        .background(color = SoftBlue, shape = RoundedCornerShape(10.dp))
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
        VisualizeProductPage()
    }
}