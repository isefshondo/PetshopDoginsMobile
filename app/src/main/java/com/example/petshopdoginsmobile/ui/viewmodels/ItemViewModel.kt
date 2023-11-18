package com.example.petshopdoginsmobile.ui.viewmodels

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petshopdoginsmobile.domain.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**/
class ItemViewModel(
    val item: Item
): ViewModel() {
    val quantity = item.quantity.asStateFlow()
    val inStock = item.inStock.asStateFlow()
    val discount = item.discount.asStateFlow()
    val price = derivedStateOf {
        if (item.discount.value > 0.0) {
            item.price.value - (item.price.value * (item.discount.value / 100))
        } else {
            item.price.value
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
        item.quantity.value = newQuantity
    }

    fun updateInStock(newInStock: Int){
        item.inStock.value = newInStock
    }

    fun updateDiscount(newDiscount: Double){
        item.discount.value = newDiscount
    }
}