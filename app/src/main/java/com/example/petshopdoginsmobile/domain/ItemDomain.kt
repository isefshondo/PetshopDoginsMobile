package com.example.petshopdoginsmobile.domain

import kotlinx.coroutines.flow.MutableStateFlow

data class ItemDomain(
    val id: String,
    val image: List<String>,
    val title: String,
    val discount: MutableStateFlow<Double>,
    val inStock: MutableStateFlow<Int>,
    val quantity: MutableStateFlow<Int>,
    val price: MutableStateFlow<Double>,
    val total: MutableStateFlow<Double>
)
