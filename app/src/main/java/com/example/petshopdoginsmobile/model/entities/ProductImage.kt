package com.example.petshopdoginsmobile.model.entities

data class ProductImage(
    val data: String
)

data class BinaryData(
    val binary: Binary
)

data class Binary(
    val base64: String,
    val subType: String
)
