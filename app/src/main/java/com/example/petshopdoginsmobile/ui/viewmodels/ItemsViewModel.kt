package com.example.petshopdoginsmobile.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petshopdoginsmobile.domain.ItemDomain
import com.example.petshopdoginsmobile.model.entities.Item
import com.example.petshopdoginsmobile.model.exceptions.EmptyListException
import com.example.petshopdoginsmobile.model.retrofit.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ItemsViewModel: ViewModel(){
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private val _success = MutableStateFlow(false)
    val success: StateFlow<Boolean> = _success

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    val showDialog = MutableStateFlow(false)

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items

    private val _itemViewModels = MutableStateFlow<MutableList<ItemViewModel>>(mutableListOf())
    val itemViewModels: StateFlow<MutableList<ItemViewModel>> = _itemViewModels

    init{
        fetchItems()
    }

    private fun fetchItems(){
        viewModelScope.launch {
            try{
                _isLoading.value = true
                val items = ApiClient.apiCartService.findAllItemsInShoppingCart()
                if(items != null && items.isNotEmpty()){
                    _items.value = items
                    _itemViewModels.value = items.map { itemToViewModel(it) }.toMutableList()
                }
            }catch(e: KotlinNullPointerException){
                Log.i("fetchItemsError", "${e.message}")
            }catch(e: Exception){
                Log.i("fetchItemsError", "$e")
                _errorMessage.value = e.message
            }finally{
                _isLoading.value = false
            }
        }
    }

    fun itemToViewModel(item: Item): ItemViewModel {
        val itemDomain = ItemDomain(
            id = item.id!!,
            image = item.image,
            title = item.title!!,
            quantity = MutableStateFlow(item.quantity!!),
            inStock = MutableStateFlow(item.inStock!!),
            discount = MutableStateFlow(item.discount!!),
            price = MutableStateFlow(item.price!!),
            total = MutableStateFlow(item.total!!)
        )
        return ItemViewModel(itemDomain)
    }

    fun removeItem(itemViewModel: ItemViewModel) {
        viewModelScope.launch {
            try {
                ApiClient.apiCartService.deleteItemInShoppingCart(itemViewModel.itemDomain.id)
                _itemViewModels.value.remove(itemViewModel)
            } catch(e: Exception) {
                Log.i("removeItemError", "${e.message}")
                _errorMessage.value = e.message
            }
        }
    }

}