package com.example.petshopdoginsmobile.model.entities

data class Product(
    val id: String? = null,
    val productCategory: String?,
    val productColor: String?,
    val productDescription: String?,
    val productImages: List<String>,
    val brandName: String?,
    val productPrice: Double?,
    val productStock: Int?,
    val size: String?,
    val productName: String?
)