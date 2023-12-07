package com.example.petshopdoginsmobile.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petshopdoginsmobile.model.entities.Item
import com.example.petshopdoginsmobile.model.entities.Product
import com.example.petshopdoginsmobile.model.retrofit.ApiClient
import com.example.petshopdoginsmobile.ui.utils.calculateDiscountedPrice
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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

    private val _selectedProductId = MutableStateFlow<String?>(null)
    val selectedProductId: StateFlow<String?> = _selectedProductId

    private val _isLoading = MutableStateFlow<Boolean>(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private val _quantity = MutableStateFlow<Int>(1)
    val quantity: StateFlow<Int> = _quantity.asStateFlow()

    private val _success = MutableStateFlow<Boolean>(false)
    val success: StateFlow<Boolean> = _success

    val showDialog = MutableStateFlow(false)

    private val discount = MutableStateFlow(20.0)

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

    fun setSelectedProductId(productId: String) {
        _selectedProductId.value = productId
    }

    fun fetchSpecificProduct() {
        val productId = selectedProductId.value
        if (productId !== null) {
            viewModelScope.launch {
                try {
                    _isLoading.value = true
                    _product.value = ApiClient.apiService.findById(productId)
                } catch (e: Exception) {
                    Log.i("fetchSpecificProductError", "${e.message}")
                } finally {
                    _isLoading.value = false
                }
            }
        }
    }

    fun addToShoppingCart(){
        val priceDiscount = calculateDiscountedPrice(_product.value.productPrice!!, discount.value)
        val item = Item(
            id = _product.value.id!!,
            discount = discount.value,
            image = _product.value.productImages,
            inStock = _product.value.productStock!!,
            price = _product.value.productPrice!!,
            quantity = _quantity.value,
            title = _product.value.brandName!!,
            total = priceDiscount
        )
        viewModelScope.launch {
            try{
                val itemList: List<Item> = ApiClient.apiCartService.createShoppingCart(listOf(item))
                if(itemList.isNotEmpty()){
                    _success.value = true
                }else{
                    _errorMessage.value = "Erro ao tentar adicionar o produto ao carrinho"
                }
            }catch(e: Exception){
                Log.i("addToShoppingCartError", "${e.message}")
                _errorMessage.value = e.message
            }finally {
                showDialog.value = true
            }
        }
    }

    fun updateQuantity(newQuantity: Int){
        _quantity.value = newQuantity
    }
}
