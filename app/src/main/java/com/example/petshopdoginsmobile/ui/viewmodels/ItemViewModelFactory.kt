package com.example.petshopdoginsmobile.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.petshopdoginsmobile.domain.ItemDomain

class ItemViewModelFactory(private val itemDomain: ItemDomain): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ItemViewModel(itemDomain) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
