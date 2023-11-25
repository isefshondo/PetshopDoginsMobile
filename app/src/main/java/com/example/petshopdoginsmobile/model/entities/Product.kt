package com.example.petshopdoginsmobile.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "products")
data class Product(
    @PrimaryKey val id: String? = null,
    @ColumnInfo(name = "productCategory") val productCategory: String?,
    @ColumnInfo(name = "productColor") val productColor: String?,
    @ColumnInfo(name = "productDescription") val productDescription: String?,
    @ColumnInfo(name = "productImages") val productImages: List<ProductImage>,
    @ColumnInfo(name = "brandName") val brandName: String?,
    @ColumnInfo(name = "productPrice") val productPrice: Double?,
    @ColumnInfo(name = "productStock") val productStock: Int?,
    @ColumnInfo(name = "size") val size: String?,
    @ColumnInfo(name = "productName") val productName: String?
)

