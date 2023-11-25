package com.example.petshopdoginsmobile.model.entities

import androidx.room.Entity

@Entity(tableName = "productImage")
data class ProductImage(
    val type: Long,
    val data: String,
)