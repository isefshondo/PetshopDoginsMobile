package com.example.petshopdoginsmobile.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petshopdoginsmobile.model.entities.Product
import com.example.petshopdoginsmobile.model.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {
    val products = MutableLiveData<List<Product>>()

    init{
        fetchProducts()
    }

    private fun fetchProducts(){
        viewModelScope.launch {
            try{
                products.value = repository.findAll()
            }catch(e: Exception){
                Log.i("fetchProductsError", "${e.message}")
            }
        }
    }
}
