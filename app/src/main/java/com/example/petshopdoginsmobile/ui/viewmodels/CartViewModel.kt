package com.example.petshopdoginsmobile.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class CartViewModel(
    itemsViewModel: List<ItemViewModel>
): ViewModel(){
    val _totalValue = MutableStateFlow<Double>(0.0)
    val _totalItems = MutableStateFlow<Int>(0)
    val _shippingCost = MutableStateFlow<Double>(0.0)
    val _coupons =  MutableStateFlow<Map<String?, Double>?>(null)
    val couponDiscount: (String?, Double) -> Double = { _, _ -> 0.0 }
}