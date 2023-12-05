package com.example.petshopdoginsmobile.model.repository

import com.example.petshopdoginsmobile.model.entities.Product
import com.example.petshopdoginsmobile.model.service.ProductService

class ProductRepository(private val apiService: ProductService) {
    suspend fun findAll(): List<Product> {
        return apiService.findAll()
    }
}
