package com.example.petshopdoginsmobile.ui.repository

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.petshopdoginsmobile.model.entities.Product
import com.example.petshopdoginsmobile.model.room.ProductDao
import retrofit2.http.GET

class ProductRepository(
    private val productDao: ProductDao
) {
    //logica para ver se sqlite esta vazio:
    // sim -> chama api e chama postToSaveProducts
    // nao -> chama do sqlite

    val listOfProduct = productDao.getAllProducts()

    fun getAllProducts(): List<Product> =
        productDao.getAllProducts()

    fun getProductById(productId: String): Product =
        productDao.getProductById(productId)

    suspend fun insertProduct(product: Product) {
        productDao.insertProduct(product)
    }

    suspend fun updateProduct(product: Product) {
        productDao.updateProduct(product)
    }
}


