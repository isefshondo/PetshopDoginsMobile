package com.example.petshopdoginsmobile.ui.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.R
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.theme.PetshopDoginsMobileTheme
import com.example.petshopdoginsmobile.ui.theme.White

@Composable
fun IconButton(
    image: Int,
    imageDescription: String,
    onClick: () -> Unit,
) {
    Box (
        modifier = Modifier
            .size(50.dp)
            .border(1.dp, Grey, CircleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
    ) {
        Box (
            modifier = Modifier.size(30.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painterResource(id = image),
                contentDescription = imageDescription,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun IconButtonPreview() {
    PetshopDoginsMobileTheme {
        IconButton(image = R.drawable.share_icon, imageDescription = "Share Button", onClick = {})
    }
}