package com.example.petshopdoginsmobile.model.entities

data class ProductImage(
    val type: Long,
    val data: BinaryData,
)

data class BinaryData(
    val base64: String,
    val subType: String
)