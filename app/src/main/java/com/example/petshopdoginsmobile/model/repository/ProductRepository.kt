package com.practice.offlinecaching

import androidx.lifecycle.LiveData
import com.example.petshopdoginsmobile.model.entities.Product
import com.example.petshopdoginsmobile.model.retrofit.ApiClient
import com.example.petshopdoginsmobile.model.retrofit.RetrofitClient.retrofit
import com.example.petshopdoginsmobile.model.room.AppDatabase
import com.example.petshopdoginsmobile.model.room.ProductDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class ProductRepository(private val database: AppDatabase) {

    suspend fun getListOfProducts(): List<Product> {
        return withContext(Dispatchers.IO) {
            var productList: List<Product> = database.productDao().getAllProducts()

            if (productList.isEmpty()) {
                // Chame a API para obter dados
                val response = ApiClient.apiService.findAll().execute()

                if (response.isSuccessful) {
                    productList = response.body() ?: emptyList()
                    // Salve os dados no banco de dados local
                    database.productDao().insertProduct(*productList.toTypedArray())
                } else {
                    // Trate erros da chamada da API, se necessário
                }
            }

            return@withContext productList
        }
    }
}


