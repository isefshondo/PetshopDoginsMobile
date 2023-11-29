package com.example.petshopdoginsmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.petshopdoginsmobile.ui.components.cards.Carousel
import com.example.petshopdoginsmobile.ui.pages.ShoppingCartPage
import com.example.petshopdoginsmobile.ui.theme.PetshopDoginsMobileTheme

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
                    Carousel(items = listOf(
                        R.drawable.img_carousel_01,
                        R.drawable.img_carousel_02
                    ))
                }
            }
        }
    }
}