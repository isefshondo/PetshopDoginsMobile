package com.example.petshopdoginsmobile.ui.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.ui.theme.Blue
import com.example.petshopdoginsmobile.ui.theme.BlueDark
import com.example.petshopdoginsmobile.ui.theme.PetshopDoginsMobileTheme
import com.example.petshopdoginsmobile.ui.theme.medium20

@Composable
fun BackToStart(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .background(color = Blue, shape = RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .padding(start = 16.dp, end = 16.dp) // Adicionando margem aos cantos
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "Voltar ao Início", color = BlueDark, style = medium20)
    }
}


@Composable
@Preview(showBackground = true)
fun BackToStartPreview() {
    PetshopDoginsMobileTheme {
        BackToStart(onClick = {})
    }
}