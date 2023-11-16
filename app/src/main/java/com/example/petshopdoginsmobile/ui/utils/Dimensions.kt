package com.example.petshopdoginsmobile.ui.utils

import android.content.res.Configuration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class CardDimensions(configuration: Configuration) {
    val screenWidth: Dp = configuration.screenWidthDp.dp

    /*
    *   Larguras do figma
    *   tela: 360
    *   card: 333
    *   %: 92,5%
    */
    val cardWidth: Dp = screenWidth * 0.925f
    val cardHeight: Dp = screenWidth * 0.36f
    val cardHorizontalPadding: Dp = screenWidth * 0.038f
    val cardTopPadding: Dp = screenWidth * 0.05f
    val colRightWidth: Dp = screenWidth * 0.684f
}
