package com.example.petshopdoginsmobile.ui.viewmodels

import androidx.compose.ui.graphics.painter.Painter
import androidx.lifecycle.ViewModel
import com.example.petshopdoginsmobile.domain.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

/**/
class ItemViewModel(
    private val item: Item

): ViewModel() {
    val quantity = item.quantity.asStateFlow()
    val inStock = item.inStock.asStateFlow()
    val discount = item.discount.asStateFlow()
    val price = item.price.asStateFlow()
    val total = item.total.asStateFlow()

    fun updateQuantity(newQuantity: Int){
        item.quantity.value = newQuantity
    }

    fun updateInStock(newInStock: Int){
        item.inStock.value = newInStock
    }

    fun updateDiscount(newDiscount: Double){
        item.discount.value = newDiscount
    }

    fun updatePrice(){
        if(item.discount.value > 0.0)
            item.price.value = item.price.value * (item.discount.value / 100)
    }

    fun updateTotal(){
        item.total.value = item.quantity.value * item.price.value
    }
}