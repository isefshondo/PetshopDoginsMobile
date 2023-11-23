package com.example.petshopdoginsmobile.model.repository

import com.example.petshopdoginsmobile.model.entities.Update
import com.example.petshopdoginsmobile.model.service.ProductService

class ProductRepository(private val api : ProductService) {

    suspend fun updateProduct(fields: List<Update>) {
        api.updateProductFields(fields)
    }
}