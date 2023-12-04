package com.example.petshopdoginsmobile.model.retrofit

import com.example.petshopdoginsmobile.model.entities.Product
import com.example.petshopdoginsmobile.model.entities.Update
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface ProductService {
    @GET("/dogins/products/{id}")
    fun findById(@Path("id") id: String): Call<Product>

    @GET("/dogins/products")
    fun findAll(): Call<List<Product>>

    @GET("/dogins/products/{id}/quantity")
    fun getProductQuantity(@Path("id") id: String): Call<Int>

    @PATCH("/dogins/products")
    fun updateProductFields(@Body fields: List<Update>): Call<ResponseBody>
}