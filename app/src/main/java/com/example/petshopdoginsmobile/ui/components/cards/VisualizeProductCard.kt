package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.petshopdoginsmobile.R
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.ui.components.buttons.IconButton
import com.example.petshopdoginsmobile.ui.theme.Blue
import com.example.petshopdoginsmobile.ui.theme.GreyDarkier
import com.example.petshopdoginsmobile.ui.theme.PetshopDoginsMobileTheme
import com.example.petshopdoginsmobile.ui.theme.medium20


@Composable
fun VisualizeProductCard() {
    Box {
        Column {
            Box (
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = GreyDarkier)) {
                        append("Fantasia para Gatos de XXX Unicórnio e Leão")
                    }
                }, style = medium20)
            }
            Box (
                modifier = Modifier
                    .height(259.dp)
                    .fillMaxWidth(),
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Box (
                        modifier = Modifier
                            .weight(1F)
                            .fillMaxHeight()
                            .background(Blue),
                    ) {
                        Box (
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.TopCenter,
                        ) {
                            IconButton(image = R.drawable.share_icon, onClick = {})
                        }
                    }
                    Box (
                        modifier = Modifier
                            .weight(3F)
                            .fillMaxHeight()
                            .background(Color.Red)
                    ) {

                    }
                    Box (
                        modifier = Modifier
                            .weight(1F)
                            .fillMaxHeight()
                            .background(Color.Yellow)
                    ) {
                        Box (
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.TopCenter
                        ) {
                            IconButton(image = R.drawable.share_icon, onClick = {})
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun VisualizeProductCardPreview() {
    PetshopDoginsMobileTheme {
        VisualizeProductCard()
    }
}