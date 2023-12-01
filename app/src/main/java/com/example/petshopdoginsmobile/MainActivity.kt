package com.example.petshopdoginsmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.petshopdoginsmobile.ui.components.cards.CarouselCard
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
                    /*CarouselCard(items = listOf(
                        R.drawable.img_carousel_01,
                        R.drawable.img_carousel_02
                    ))*/
                    CarouselCard(items = listOf(
                        { Image(painter = painterResource(id = R.drawable.img_carousel_01), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxWidth()) },
                        { Image(painter = painterResource(id = R.drawable.img_carousel_02), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxWidth()) }
                    ))
                }
            }
        }
    }
}