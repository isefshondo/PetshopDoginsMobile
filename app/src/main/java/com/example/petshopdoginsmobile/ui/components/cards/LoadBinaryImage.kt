package com.example.petshopdoginsmobile.ui.components.cards

import android.graphics.BitmapFactory
import android.util.Base64
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.model.entities.ProductImage
import com.example.petshopdoginsmobile.ui.utils.productImageExample

@Composable
fun LoadBinaryImage(
    productImage: ProductImage,
    contentDescription: String = "",
    maxWidth: Dp = 75.dp,
    isFullWidthImage: Boolean = false,
) {
    val imageBytes = Base64.decode(productImage.data, Base64.DEFAULT)
    val bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    if (bitmap != null) {
        val imageBitmap = bitmap.asImageBitmap()
        if (!isFullWidthImage) {
            Image(
                bitmap = imageBitmap,
                contentDescription = contentDescription,
                modifier = Modifier.heightIn(max= maxWidth)
            )
        } else {
            Image(
                bitmap = imageBitmap,
                contentDescription = contentDescription,
                modifier = Modifier.fillMaxSize(),
            )
        }
    } else {
        Text("Não foi possível carregar a imagem")
    }
}


@Preview
@Composable
fun PreviewLoadBinaryImage() {
    LoadBinaryImage(productImageExample)
}