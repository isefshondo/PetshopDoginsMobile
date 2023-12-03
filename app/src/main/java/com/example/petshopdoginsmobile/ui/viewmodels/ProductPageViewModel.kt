package com.example.petshopdoginsmobile.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petshopdoginsmobile.domain.ProductInformation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductPageViewModel: ViewModel() {
    private val _productInformation = MutableLiveData<ProductInformation>()
    val productInformation: LiveData<ProductInformation> get() = _productInformation
    fun loadProductInformation(productId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // _productInformation.postValue()
                // Do the same as below to the following attributes
                // _universalProductCode.postValue()
                // _productName.postValue()
                // _productImages.postValue()
                // _productPrice.postValues()
                // _size.postValue()
                // _productStock.postValue()
                // _brandName.postValue()
                // _productDescription.postValue()
            } catch (e: Exception) {
                Log.e("REQUEST_ERROR", "An error has occurred and it wasn't possible to load the information. See more: $e")
            }
        }
    }
}