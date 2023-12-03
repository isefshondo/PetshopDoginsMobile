package com.example.petshopdoginsmobile.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petshopdoginsmobile.model.entities.Product
import com.example.petshopdoginsmobile.model.retrofit.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init{
        fetchProducts()
    }

    private fun fetchProducts(){
        viewModelScope.launch {
            try{
                _products.value = ApiClient.apiService.findAll()
            }catch(e: Exception){
                Log.i("fetchProductsError", "${e.message}")
            }
        }
    }
}
