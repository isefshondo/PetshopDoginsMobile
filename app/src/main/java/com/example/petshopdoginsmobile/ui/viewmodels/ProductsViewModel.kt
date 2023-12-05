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

    private val _product = MutableStateFlow(
        Product(
            id = null,
            productCategory = null,
            productColor = null,
            productDescription = null,
            productImages = emptyList(),
            brandName = null,
            productPrice = null,
            productStock = null,
            size = null,
            productName = null
        )
    )
    val product: StateFlow<Product> = _product


    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init{
        fetchProducts()
    }

    private fun fetchProducts(){
        viewModelScope.launch {
            try{
                _products.value = ApiClient.apiService.findAll()
            }catch(e: Exception){
                Log.i("fetchProductsError", "${e.message}")
                _errorMessage.value = e.message
            }
        }
    }

    private fun fetchSpecificProduct(id: String) {
        viewModelScope.launch {
            try {
                _product.value = ApiClient.apiService.findById(id)
            } catch (e: Exception) {
                Log.i("fetchSpecificProductError", "${e.message}")
            }
        }
    }
}
