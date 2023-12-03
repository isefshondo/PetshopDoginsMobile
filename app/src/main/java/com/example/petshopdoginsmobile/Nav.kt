package com.example.petshopdoginsmobile

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.petshopdoginsmobile.ui.pages.HomePage
import com.example.petshopdoginsmobile.ui.pages.ShoppingCartPage
import com.example.petshopdoginsmobile.ui.pages.VisualizeProductPage

@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "index") {
        composable("index") {
            HomePage(navController)
        }
        composable("visualizeProduct") {
            VisualizeProductPage(navController)
        }
        composable("shoppingCartPage") {
            ShoppingCartPage(navController)
        }
    }
}