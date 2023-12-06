package com.example.petshopdoginsmobile.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.derivedStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petshopdoginsmobile.domain.ItemDomain
import com.example.petshopdoginsmobile.model.entities.Item
import com.example.petshopdoginsmobile.model.entities.Product
import com.example.petshopdoginsmobile.model.retrofit.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**/
class ItemViewModel(
    val itemDomain: ItemDomain
): ViewModel() {


    val quantity = itemDomain.quantity.asStateFlow()
    val inStock = itemDomain.inStock.asStateFlow()
    val discount = itemDomain.discount.asStateFlow()
    val price = derivedStateOf {
        if (itemDomain.discount.value > 0.0) {
            itemDomain.price.value - (itemDomain.price.value * (itemDomain.discount.value / 100))
        } else {
            itemDomain.price.value
        }
    }
    val total = MutableStateFlow(0.0)

    init {
        // atualizar o total sempre que a quantidade ou o preço mudar
        viewModelScope.launch {
            quantity.collect { newQuantity ->
                total.value = newQuantity * price.value
            }
        }
    }

    fun updateQuantity(newQuantity: Int){
        itemDomain.quantity.value = newQuantity
    }

    fun updateInStock(newInStock: Int){
        itemDomain.inStock.value = newInStock
    }

    fun updateDiscount(newDiscount: Double){
        itemDomain.discount.value = newDiscount
    }
}