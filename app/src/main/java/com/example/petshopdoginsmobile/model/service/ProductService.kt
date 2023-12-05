package com.example.petshopdoginsmobile.model.service

import com.example.petshopdoginsmobile.domain.Item
import com.example.petshopdoginsmobile.model.entities.Product
import com.example.petshopdoginsmobile.model.entities.Update
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductService {
    @GET("/dogins/products/{id}")
    suspend fun findById(@Path("id") id: String): Product

    @GET("/dogins/products")
    suspend fun findAll(): List<Product>

    @GET("/dogins/products/{id}/quantity")
    suspend fun getProductQuantity(@Path("id") id: String): Int

//    @PATCH("/dogins/products")
//    suspend fun updateProductFields(@Body fields: List<Update>): ResponseBody

    @POST("/dogins/shopping-cart")
    suspend fun updateProductFields(@Body fields: List<Item>): List<Item>
}
