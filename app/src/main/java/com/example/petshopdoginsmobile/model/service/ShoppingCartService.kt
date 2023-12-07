package com.example.petshopdoginsmobile.model.service

import com.example.petshopdoginsmobile.model.entities.Item
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface ShoppingCartService {
    @GET("dogins/shopping-cart")
    suspend fun findAllItemsInShoppingCart(): List<Item>?

    @POST("dogins/shopping-cart")
    suspend fun createShoppingCart(@Body shoppingCartItemsList: List<Item>): List<Item>

    @DELETE("dogins/shopping-cart/item/{id}")
    suspend fun deleteItemInShoppingCart(@Path("id") id: String)

    @PATCH("dogins/products/{purchaseIsConfirmed}")
    suspend fun shoppingCartConfirmed(@Path("purchaseIsConfirmed") purchaseIsConfirmed: Boolean): String
}