package com.example.petshopdoginsmobile.ui.components.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petshopdoginsmobile.R
import com.example.petshopdoginsmobile.ui.theme.Blue
import com.example.petshopdoginsmobile.ui.theme.BlueDark
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.theme.GreyDarkier
import com.example.petshopdoginsmobile.ui.theme.PetshopDoginsMobileTheme
import com.example.petshopdoginsmobile.ui.theme.VibrantBlue
import com.example.petshopdoginsmobile.ui.theme.White
import com.example.petshopdoginsmobile.ui.theme.regular12
import com.example.petshopdoginsmobile.ui.theme.regular14

@Composable
fun RenderIcon(icon: Painter, iconDescription: String, onClick: () -> Unit) {
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
fun PageHeader(
    isHomePage: Boolean,
    headerTitle: String,
    handleViewCartEvent: () -> Unit,
    navController: NavController
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(59.dp)
            .background(Blue)
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        var searchTextValue by remember { mutableStateOf("") }

        if (!isHomePage) {
            Row (horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                RenderIcon(
                    icon = painterResource(id = R.drawable.arrow_back_icon),
                    iconDescription = "Go back to the last page",
                    onClick = { navController.popBackStack() }
                )
                Text(text = headerTitle, style = regular14, color = VibrantBlue)
            }
            Row (horizontalArrangement = Arrangement.spacedBy(25.dp)) {
                RenderIcon(
                    icon = painterResource(id = R.drawable.carbon_search),
                    iconDescription = "Search for a new product..."
                ) {}
                RenderIcon(
                    icon = painterResource(id = R.drawable.cart_icon),
                    iconDescription = "Visualize cart page...",
                    onClick = handleViewCartEvent
                )
            }
        } else {
            Column (
                modifier = Modifier.weight(1F),
                horizontalAlignment = Alignment.Start,
            ) {
                RenderIcon(
                    icon = painterResource(id = R.drawable.menu_icon),
                    iconDescription = "See all categories..."
                ) {}
            }
            Column (modifier = Modifier.weight(5F)) {
                BasicTextField(
                    value = searchTextValue,
                    onValueChange = {currentValue -> searchTextValue = currentValue},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(White),
                ) {
                    Row (
                        modifier = Modifier
                            .padding(horizontal = 13.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        RenderIcon(
                            icon = painterResource(id = R.drawable.carbon_search),
                            iconDescription = "Search for something..."
                        ) {}
                        if (searchTextValue.isEmpty()) {
                            Text(text = "Pesquise por algo", color = BlueDark, style = regular12)
                        } else {
                            Text(text = searchTextValue, color = GreyDarkier, style = regular12)
                        }
                    }
                }
            }
            Column (
                modifier = Modifier.weight(1F),
                horizontalAlignment = Alignment.End,
            ) {
                RenderIcon(
                    icon = painterResource(id = R.drawable.cart_icon),
                    iconDescription = "Visualize cart page...",
                    onClick = handleViewCartEvent
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HeaderPreview() {
    val headerTitle = "Detalhes"
    PetshopDoginsMobileTheme {
        PageHeader(
            isHomePage = true,
            headerTitle,
            handleViewCartEvent = {},
            navController = rememberNavController()
        )
    }
}