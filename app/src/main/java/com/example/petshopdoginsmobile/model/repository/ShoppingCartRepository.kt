package com.example.petshopdoginsmobile.model.repository

import com.example.petshopdoginsmobile.model.entities.Item
import com.example.petshopdoginsmobile.model.entities.ShoppingCart
import com.example.petshopdoginsmobile.model.retrofit.ApiClient.apiCartService
import com.example.petshopdoginsmobile.model.service.ProductService
import com.example.petshopdoginsmobile.model.service.ShoppingCartService

class ShoppingCartRepository(private val apiService: ShoppingCartService) {
    suspend fun shoppingCartConfirmed(purchaseIsConfirmed: Boolean): String{
        return apiService.shoppingCartConfirmed(purchaseIsConfirmed)
    }

    suspend fun createShoppingCart(shoppingCartItemsList: List<Item>): List<Item> {
        return apiService.createShoppingCart(shoppingCartItemsList)
    }
}