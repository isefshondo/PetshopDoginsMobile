package com.example.petshopdoginsmobile.model.entities

import android.content.ClipData.Item

data class ShoppingCart(
    val id: String? = null,
    val itemList: List<Item>
)