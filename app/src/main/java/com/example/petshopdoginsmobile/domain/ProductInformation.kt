package com.example.petshopdoginsmobile.domain

import androidx.compose.ui.graphics.ImageBitmap

data class ProductInformation(
    val universalProductCode: String,
    val productName: String,
    val productImages: List<String>,
    val productPrice: Float,
    val size: String,
    val productStock: Int,
    val brandName: String,
    val productDescription: String
)