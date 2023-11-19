package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.petshopdoginsmobile.ui.theme.PetshopDoginsMobileTheme

@Composable
fun ProductInfoCard() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
    ) {

    }
}

@Composable
@Preview(showBackground = true)
fun ProductInfoCardPreview() {
    PetshopDoginsMobileTheme {
        ProductInfoCard()
    }
}