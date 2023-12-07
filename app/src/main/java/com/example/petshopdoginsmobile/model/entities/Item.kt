package com.example.petshopdoginsmobile.model.entities

data class Item(
    val id: String? = null,
    val image: List<String>,
    val title: String,
    val discount: Double,
    val inStock: Int,
    val quantity: Int,
    val price: Double,
    val total: Double
)