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
import com.example.petshopdoginsmobile.ui.theme.medium14

@Composable
fun VisualizeProductPage() {
    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 15.dp)
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            VisualizeProductCard()
        }
        Column (
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
        ) {
            Column {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box {
                        Text(buildAnnotatedString {
                            withStyle(SpanStyle(color = GreyDarkier, textDecoration = TextDecoration.LineThrough)) {
                                append("R$ 163,90")
                            }
                        }, style = medium12)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Box (
                        modifier = Modifier
                            .background(color = SoftBlue, shape = RoundedCornerShape(5.dp))
                            .padding(horizontal = 5.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(buildAnnotatedString {
                            withStyle(SpanStyle(color = VibrantBlue)) {
                                append("-20%")
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
                            contentDescription = "Information Icon",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
                Row {
                    Text(buildAnnotatedString {
                        withStyle(SpanStyle(color = VibrantBlue)) {
                            append("R$ 153,91")
                        }
                    }, style = medium20)
                }
            }
        }
        Column {
            Column  {
                Text(buildAnnotatedString {
                    withStyle(SpanStyle(color = GreyDarkier)) {
                        append("Tamanhos")
                    }
                }, style = medium20)
                Row {
                    Box (
                        modifier = Modifier
                            .border(width = 2.dp, color = Grey, shape = RoundedCornerShape(10.dp))
                            .size(48.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "P".uppercase(), style = medium14)
                    }
                    Box (
                        modifier = Modifier
                            .border(width = 2.dp, color = Grey, shape = RoundedCornerShape(10.dp))
                            .size(48.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "M".uppercase(), style = medium14)
                    }
                    Box (
                        modifier = Modifier
                            .border(width = 2.dp, color = Grey, shape = RoundedCornerShape(10.dp))
                            .size(48.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "G".uppercase(), style = medium14)
                    }
                }
            }
            Column  {
                Text(buildAnnotatedString {
                    withStyle(SpanStyle(color = GreyDarkier)) {
                        append("Variações")
                    }
                }, style = medium20)
                Row {
                    Box (
                        modifier = Modifier
                            .border(width = 2.dp, color = Grey, shape = RoundedCornerShape(10.dp))
                            .padding(horizontal = 20.dp, vertical = 12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Unicórnio", style = medium14)
                    }
                    Box (
                        modifier = Modifier
                            .border(width = 2.dp, color = Grey, shape = RoundedCornerShape(10.dp))
                            .padding(horizontal = 20.dp, vertical = 12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Leão", style = medium14)
                    }
                }
            }
            Column  {
                Text(buildAnnotatedString {
                    withStyle(SpanStyle(color = GreyDarkier)) {
                        append("Quantidade")
                    }
                }, style = medium20)
                Row {
                    
                }
            }
        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(98.dp)
                .padding(16.dp)
        ) {
            Box (
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box (
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = SoftBlue, shape = RoundedCornerShape(10.dp))
                        .clickable { },
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = BlueDark)) {
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