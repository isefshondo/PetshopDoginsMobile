package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.theme.Red
import com.example.petshopdoginsmobile.ui.theme.bold12
import com.example.petshopdoginsmobile.ui.theme.medium12

@Composable
fun CouponCard(
    couponCode: String,
    discount: String,
    icon: ImageVector? = Icons.Filled.Favorite
){
    Card(
        modifier = Modifier
            .border(1.dp, Grey, RoundedCornerShape(5.dp)),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Cupom ", style = medium12)
            Text(
                text = couponCode,
                style = bold12.copy(Red)
            )
            Text(text = " $discount ", style = medium12)
            if (icon != null) {
                Icon(
                    icon,
                    contentDescription = null,
                    tint = Red
                )
            }
        }
    }
}

@Preview
@Composable
private fun CouponCardPreview(){
    CouponCard(couponCode = "AUDACIOSO1", discount = "10% OFF")
}