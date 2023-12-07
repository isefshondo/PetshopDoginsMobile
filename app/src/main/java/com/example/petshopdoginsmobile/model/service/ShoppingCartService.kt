package com.example.petshopdoginsmobile.model.service

import com.example.petshopdoginsmobile.model.entities.Item
import com.example.petshopdoginsmobile.model.entities.ShoppingCart
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface ShoppingCartService {
    @PATCH("/{purchaseIsConfirmed}")
    suspend fun shoppingCartConfirmed(@Path("purchaseIsConfirmed") purchaseIsConfirmed: Boolean): String

    @POST("dogins/shopping-cart")
    suspend fun createShoppingCart(@Body shoppingCartItemsList: List<Item>): List<Item>
}