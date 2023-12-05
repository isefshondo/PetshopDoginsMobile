package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.R
import com.example.petshopdoginsmobile.ui.theme.GreyDarkier
import com.example.petshopdoginsmobile.ui.theme.VibrantBlue
import com.example.petshopdoginsmobile.ui.theme.White
import com.example.petshopdoginsmobile.ui.theme.medium20
import com.example.petshopdoginsmobile.ui.theme.regular14

@Composable
fun PurchaseCompleted() {
    Column(
        modifier = Modifier
            .background(color = White)
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Compra Finalizada", style = medium20, color = VibrantBlue)

        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(id = R.drawable.purchase_completed_logo),
            contentDescription = null,
            modifier = Modifier
                .size(220.dp,120.dp)
                .padding(top = 10.dp, bottom = 4.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "O vendedor irá preparar sua", style = regular14, color = GreyDarkier)
        Text(text = "compra. Acompanhe seu pedido em", style = regular14, color = GreyDarkier)
        Text(text = "Meus Pedidos!", style = regular14, color = GreyDarkier)
    }
}


@Preview
@Composable
private fun PurchaseCompletedPreview(){
    PurchaseCompleted()
}