package com.practice.offlinecaching

import androidx.lifecycle.LiveData
import com.example.petshopdoginsmobile.model.entities.Product
import com.example.petshopdoginsmobile.model.room.AppDatabase
import com.example.petshopdoginsmobile.model.room.ProductDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("your_endpoint")
    suspend fun getCars(): List<Product>
}

class CarsRepository(private val database: AppDatabase) {

    private val retrofit = Retrofit.Builder()
        .baseUrl("your_base_url")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(ApiService::class.java)

    fun getListOfProducts(key: String?): List<Product> {
        return database.productDao().getAllProducts()
    }

    suspend fun refreshCars(type: String?, token: String?) {
        withContext(Dispatchers.IO) {
            val response = service.getCars()

            response?.let {
                if (it.isSuccessful) {
                    val list = it.body() ?: emptyList()
                    // Aqui você pode inserir os produtos na base de dados
                    // database.productDao().insertProduct(*list.toTypedArray())
                }
            }

        }
    }
}
