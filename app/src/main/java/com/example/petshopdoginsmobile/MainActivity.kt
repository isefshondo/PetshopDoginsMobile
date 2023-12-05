package com.example.petshopdoginsmobile

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.petshopdoginsmobile.ui.pages.HomePage
import com.example.petshopdoginsmobile.ui.pages.PurchaseConfirmPage
import com.example.petshopdoginsmobile.ui.pages.ShoppingCartPage
import com.example.petshopdoginsmobile.ui.pages.VisualizeProductPage
import com.example.petshopdoginsmobile.ui.theme.PetshopDoginsMobileTheme
import com.example.petshopdoginsmobile.ui.viewmodels.ProductsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetshopDoginsMobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = "shopping-cart"){
                        composable("home") { HomePage(navController) }
                        composable("visualize-product/{productId}") { backStackEntry ->
                            val viewModel: ProductsViewModel by viewModels()
                            val productId = backStackEntry.arguments?.getString("productId")
                            val context = LocalContext.current
                            if(productId != null) {
                                VisualizeProductPage(navController, productId, viewModel = viewModel)
                            } else {
                                LaunchedEffect(Unit) {
                                    Toast.makeText(context, "Erro: ID do produto inválido.", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                        composable("shopping-cart") { ShoppingCartPage(navController) }
                        composable("purchase-confirm") { PurchaseConfirmPage(navController) }
                    }
                }
            }
        }
    }
}