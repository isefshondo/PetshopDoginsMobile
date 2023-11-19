package com.example.petshopdoginsmobile.ui.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.theme.PetshopDoginsMobileTheme
import com.example.petshopdoginsmobile.R
import com.example.petshopdoginsmobile.ui.theme.BlueDark
import com.example.petshopdoginsmobile.ui.theme.regular14

@Composable
fun CalculateShippingButton() {
    Box (
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Grey,
                shape = RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .padding(horizontal = 20.dp, vertical = 15.dp)
            .fillMaxWidth()
            .clickable {  },
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Box (
                    modifier = Modifier
                        .size(20.dp),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.calculator_icon),
                        contentDescription = "Calculator Icon",
                        modifier = Modifier
                            .fillMaxSize(),
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Box (
                    contentAlignment = Alignment.CenterStart,
                ) {
                    Text(text = "Calcular seu frete", style = regular14)
                }
            }
            Row {
                Box (
                    contentAlignment = Alignment.CenterStart,
                ) {
                    Text(text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = BlueDark)) {
                            append("Grátis >".uppercase())
                        }
                    }, style = regular14)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CalculateShippingButtonPreview() {
    PetshopDoginsMobileTheme {
        CalculateShippingButton()
    }
}