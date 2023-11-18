package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
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
                    .fillMaxWidth(),
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