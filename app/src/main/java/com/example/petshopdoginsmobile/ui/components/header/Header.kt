package com.example.petshopdoginsmobile.ui.components.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.R
import com.example.petshopdoginsmobile.ui.theme.Blue
import com.example.petshopdoginsmobile.ui.theme.PetshopDoginsMobileTheme
import com.example.petshopdoginsmobile.ui.theme.VibrantBlue
import com.example.petshopdoginsmobile.ui.theme.regular14

@Composable
fun renderIcon(icon: Painter, onClick: () -> Unit, iconDescription: String) {
    Box (
        modifier = Modifier
            .size(20.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = icon,
            contentDescription = iconDescription,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun Header(
    headerTitle: String,
    handleGoBackEvent: () -> Unit,
    handleSearchEvent: () -> Unit,
    handleViewCartEvent: () -> Unit,
) {
    Row (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Blue)
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row (
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            renderIcon(
                icon = painterResource(R.drawable.arrow_back_icon),
                onClick = { handleGoBackEvent },
                iconDescription = "Go back to the last page"
            )
            Text(text = headerTitle, color = VibrantBlue, style = regular14)
        }
        Row (
            horizontalArrangement = Arrangement.spacedBy(23.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            renderIcon(
                icon = painterResource(id = R.drawable.carbon_search),
                onClick = { handleSearchEvent },
                iconDescription = "Search for a product..."
            )
            renderIcon(
                icon = painterResource(id = R.drawable.cart_icon),
                onClick = { handleViewCartEvent },
                iconDescription = "Go to your cart..."
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HeaderPreview() {
    val headerTitle = "Detalhes"
    PetshopDoginsMobileTheme {
        Header(
            headerTitle,
            handleGoBackEvent = {},
            handleSearchEvent = {},
            handleViewCartEvent = {}
        )
    }
}