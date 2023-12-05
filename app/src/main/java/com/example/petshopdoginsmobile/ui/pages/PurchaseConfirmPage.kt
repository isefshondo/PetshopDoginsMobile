package com.example.petshopdoginsmobile.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.ui.components.buttons.BackToStart
import com.example.petshopdoginsmobile.ui.components.cards.PurchaseCompleted
import com.example.petshopdoginsmobile.ui.theme.BgGrey
import com.example.petshopdoginsmobile.ui.utils.Dimensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PurchaseConfirmPage() {
    Scaffold(
        containerColor = BgGrey
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .padding(start = 22.dp, end = 22.dp) // Adicionando margem aos cantos
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(Dimensions.VERTICAL_SPACING)
            ) {
                item { PurchaseCompleted() }
                item { BackToStart {}}
            }
        }
    }
}


@Preview
@Composable
private fun PurchaseConfirmPagePreview(){
    PurchaseConfirmPage()
}