package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petshopdoginsmobile.ui.theme.BlueDark
import com.example.petshopdoginsmobile.ui.theme.GreyDarkier
import com.example.petshopdoginsmobile.ui.theme.SoftBlue
import com.example.petshopdoginsmobile.ui.theme.medium12
import com.example.petshopdoginsmobile.ui.theme.medium14
import com.example.petshopdoginsmobile.ui.theme.regular12

@Composable
fun PromotionCard(
    discount: String,
    description: String,
    onClick: () -> Unit
){
    Card(
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(containerColor = SoftBlue)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ){
            Column {
                Text(
                    modifier = Modifier.height(20.dp),
                    text = discount,
                    style = medium14.copy(lineHeight = 14.sp, color = BlueDark)
                )
                Text(text = description, style = regular12.copy(GreyDarkier))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .height(35.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BlueDark),
                onClick = onClick
            ) {
                Text(text = "USAR CUPOM", style = medium12)
            }
        }
    }
}

@Preview
@Composable
private fun PromotionCardPreview(){
    PromotionCard(
        discount = "20% OFF + Frete grátis ",
        description = "na primeira compra",
        onClick = {}
    )
}