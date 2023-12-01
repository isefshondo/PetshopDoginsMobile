package com.example.petshopdoginsmobile.ui.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.R
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.theme.regular10

@Composable
fun CategoryButtons(
    icon: Int,
    text: String,
    onClick: () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .clickable{ onClick() }
    ) {
        ElevatedCard(
            shape = CircleShape,
            elevation = CardDefaults.cardElevation(2.dp),
            modifier = Modifier
                .size(50.dp)

        ) {
            IconButton(
                modifier = Modifier
                    .padding(7.dp),
                onClick = onClick
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "Product category icon"
                )
            }
        }
        Text(
            text = text,
            style = regular10.copy(Grey)
        )
    }
}

@Preview
@Composable
private fun CategoryButtonsPreview(){
    CategoryButtons(
        icon = R.drawable.ic_accessories,
        text = "Acessórios",
        onClick = {}
    )
}