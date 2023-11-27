package com.example.petshopdoginsmobile.model.retrofit

import com.example.petshopdoginsmobile.model.service.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:8080"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

object ApiClient {
    val apiService: ProductService by lazy {
        RetrofitClient.retrofit.create(ProductService::class.java)
    }
}