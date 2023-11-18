package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import com.example.petshopdoginsmobile.R
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.ui.components.buttons.IconButton
import com.example.petshopdoginsmobile.ui.theme.GreyDarkier
import com.example.petshopdoginsmobile.ui.theme.PetshopDoginsMobileTheme
import com.example.petshopdoginsmobile.ui.theme.medium20

@Composable
fun VisualizeProductCard(
    title: String
) {
    Box {
        Column {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(
                            color = GreyDarkier,
                        )) {
                            append(title)
                        }
                    },
                    style = medium20
                )
            }
            Row (
                modifier = Modifier
                    .height(259.dp)
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxHeight(),
                ) {
                    IconButton()
                }
                Column (
                    modifier = Modifier
                        .fillMaxHeight(),
                ) {
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun VisualizeProductCardPreview() {
    PetshopDoginsMobileTheme {
        VisualizeProductCard(
            title = "Fantasia para Gatos de XXX Unicórnio e Leão"
        )
    }
}