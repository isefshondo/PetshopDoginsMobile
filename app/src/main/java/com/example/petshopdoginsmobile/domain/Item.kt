package com.example.petshopdoginsmobile.domain

import androidx.compose.ui.graphics.painter.Painter
import kotlinx.coroutines.flow.MutableStateFlow

data class Item(
    val image: Painter,
    val title: String,
    val discount: MutableStateFlow<Double>,
    val inStock: MutableStateFlow<Int>,
    val quantity: MutableStateFlow<Int>,
    val price: MutableStateFlow<Double>,
    val total: MutableStateFlow<Double>
)
