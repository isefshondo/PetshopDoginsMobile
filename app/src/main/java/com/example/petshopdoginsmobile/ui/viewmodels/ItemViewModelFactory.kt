package com.example.petshopdoginsmobile.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.petshopdoginsmobile.domain.Item

class ItemViewModelFactory(private val item: Item): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ItemViewModel(item) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
