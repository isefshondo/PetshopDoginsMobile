package com.example.petshopdoginsmobile.ui.utils

import android.content.res.Configuration
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Dimensions {
    val CARD_WIDTH_PERCENT = 0.925f
    val CARD_HEIGHT_PERCENT = 0.36f
    val CARD_HORIZONTAL_PADDING_PERCENT = 0.038f
    val CARD_TOP_PADDING_PERCENT = 0.05f
    val COL_RIGHT_WIDTH_PERCENT = 0.684f

    val SCREEN_PADDING = 20.dp
    val VERTICAL_SPACING = 18.dp
}

class CardDimensions(configuration: Configuration) {
    val screenWidth: Dp = configuration.screenWidthDp.dp

    /*
    *   Larguras do figma
    *   tela: 360
    *   card: 333
    *   %: 92,5%
    */
    val cardWidth: Dp = screenWidth * Dimensions.CARD_WIDTH_PERCENT
    val cardHeight: Dp = screenWidth * Dimensions.CARD_HEIGHT_PERCENT
    val cardHorizontalPadding: Dp = screenWidth * Dimensions.CARD_HORIZONTAL_PADDING_PERCENT
    val cardTopPadding: Dp = screenWidth * Dimensions.CARD_TOP_PADDING_PERCENT
    val colRightWidth: Dp = screenWidth * Dimensions.COL_RIGHT_WIDTH_PERCENT
}
