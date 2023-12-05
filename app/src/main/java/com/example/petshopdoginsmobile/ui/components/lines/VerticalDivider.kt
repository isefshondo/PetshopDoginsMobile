package com.example.petshopdoginsmobile.ui.components.lines

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.ui.theme.BgGrey

@Composable
fun VerticalDivider(
    color: Color = BgGrey,
    thickness: Dp = 1.dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(thickness)
            .fillMaxHeight()
            .background(color)
    )
}