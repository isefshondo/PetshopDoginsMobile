package com.example.petshopdoginsmobile.ui.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.R
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.theme.regular10

@Composable
fun TypeButton(
    modifier: Modifier = Modifier,
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
        IconButton(
            modifier = Modifier
                .size(70.dp)
                .clip(shape = CircleShape),
            onClick = onClick
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "Pet type"
            )
        }

        Text(
            text = text,
            style = regular10.copy(Grey)
        )
    }
}

@Preview
@Composable
private fun TypeButtonPreview(){
    TypeButton(icon = R.drawable.ic_type_dog, text = "Cachorro", onClick = {})
}

@Composable
fun TypeButtonsRow(
    modifier: Modifier = Modifier,
    buttons: List<Pair<Int, String>>
){
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ){
        items(buttons) { (icon, text) ->
            TypeButton(
                icon = icon,
                text = text,
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
private fun TypeButtonsRowPreview(){
    TypeButtonsRow(
        buttons = listOf(
            Pair(R.drawable.ic_type_dog, "Cachorro"),
            Pair(R.drawable.ic_type_cat, "Gatos"),
            Pair(R.drawable.ic_type_puppies, "Filhotes"),
            Pair(R.drawable.ic_other_types, "Outros pets")
        )
    )
}