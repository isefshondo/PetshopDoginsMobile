package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.ui.theme.Blue
import com.example.petshopdoginsmobile.ui.theme.BlueDark
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.theme.medium16
import com.example.petshopdoginsmobile.ui.theme.medium20
import com.example.petshopdoginsmobile.ui.utils.formatToCurrency

@Composable
fun CartBottomCard(
    btnBgColor: Color = Blue,
    btnLabel: String,
    btnOnClick: () -> Unit,
    totalValue: State<Double>,
    textColor: Color = BlueDark
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .drawWithContent {
                val strokeWidth = 2f // Espessura da borda
                val color = Grey // Cor da borda
                drawContent()
                drawLine(
                    color,
                    Offset(0f, strokeWidth / 2),
                    Offset(size.width, strokeWidth / 2),
                    strokeWidth
                )
            },
        shape = RoundedCornerShape(0.dp),
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(vertical = 10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ){
                if(totalValue != null)
                    Text(
                        text = "Total: ${totalValue.value.formatToCurrency()}",
                        style = medium16.copy(textColor)
                    )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = btnBgColor,
                        contentColor = BlueDark
                    ),
                    onClick = btnOnClick
                ){
                    Text(
                        text = btnLabel,
                        style = medium20.copy(BlueDark)
                    )
                }
            }

        }
    }
}
