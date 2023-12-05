package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.example.petshopdoginsmobile.R
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.ui.components.buttons.IconButton
import com.example.petshopdoginsmobile.ui.theme.Grey
import com.example.petshopdoginsmobile.ui.theme.GreyDarkier
import com.example.petshopdoginsmobile.ui.theme.medium20
import com.example.petshopdoginsmobile.ui.theme.regular12
import com.example.petshopdoginsmobile.ui.theme.regular14
import com.example.petshopdoginsmobile.model.entities.Product
import com.example.petshopdoginsmobile.model.entities.ProductImage
import com.example.petshopdoginsmobile.ui.theme.Blue
import com.example.petshopdoginsmobile.ui.theme.VibrantBlue

@Composable
fun LoadProductImages(productImages: List<String>) {
    if (productImages.isNotEmpty()) {
        LazyRow (
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(productImages) {image ->
                Box (
                    modifier = Modifier
                        .border(width = 2.dp, color = Blue, shape = RoundedCornerShape(10.dp))
                        .clip(RoundedCornerShape(10.dp))
                        .size(50.dp)
                ) {
                    LoadBinaryImage(productImage = ProductImage(image), isFullWidthImage = true)
                }
            }
        }
    }
}

@Composable
fun VisualizeProductCard(
    productRating: Float,
    reviewQuantity: Int,
    allProductComments: Int,
    product: Product,
) {
    val productImage = ProductImage(product.productImages[0])
    Box {
        Column {
            Row (
                modifier = Modifier.fillMaxWidth(),
            ) {
                Row (
                    modifier = Modifier
                        .size(width = 100.dp, height = 40.dp),
                ) {
                    Row (
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Grey,
                                shape = RoundedCornerShape(
                                    topStart = 10.dp,
                                    topEnd = 0.dp,
                                    bottomStart = 10.dp,
                                    bottomEnd = 0.dp
                                )
                            )
                            .clip(
                                RoundedCornerShape(
                                    topStart = 10.dp,
                                    topEnd = 0.dp,
                                    bottomStart = 10.dp,
                                    bottomEnd = 0.dp
                                )
                            )
                            .weight(1F)
                            .fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Box (
                            modifier = Modifier
                                .size(width = 15.dp, height = 16.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.star_icon),
                                contentDescription = "Favorite Icon",
                                modifier = Modifier
                                    .fillMaxSize(),
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Box (
                            contentAlignment = Alignment.CenterStart,
                        ) {
                            Text(text = productRating.toString(), style = regular12)
                        }
                    }
                    Row (
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Grey,
                                shape = RoundedCornerShape(
                                    topStart = 0.dp,
                                    topEnd = 10.dp,
                                    bottomStart = 0.dp,
                                    bottomEnd = 10.dp
                                )
                            )
                            .clip(
                                RoundedCornerShape(
                                    topStart = 0.dp,
                                    topEnd = 10.dp,
                                    bottomStart = 0.dp,
                                    bottomEnd = 10.dp
                                )
                            )
                            .weight(1F)
                            .fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text(text = reviewQuantity.toString(), style = regular14)
                    }
                }
                Spacer(modifier = Modifier.width(6.dp))
                Row (
                    modifier = Modifier
                        .size(width = 62.dp, height = 40.dp),
                ) {
                    Row (
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Grey,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clip(
                                RoundedCornerShape(
                                    topStart = 10.dp,
                                    topEnd = 0.dp,
                                    bottomStart = 10.dp,
                                    bottomEnd = 0.dp
                                )
                            )
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Box (
                            modifier = Modifier
                                .size(16.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.message_icon),
                                contentDescription = "Favorite Icon",
                                modifier = Modifier
                                    .fillMaxSize(),
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box (
                            contentAlignment = Alignment.CenterStart,
                        ) {
                            Text(text = allProductComments.toString(), style = regular12)
                        }
                    }
                }
            }
            Box (
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = GreyDarkier)) {
                        append(product.productName)
                    }
                }, style = medium20)
            }
            Box (
                modifier = Modifier
                    .height(259.dp)
                    .fillMaxWidth(),
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Box (
                        modifier = Modifier
                            .weight(1F)
                            .fillMaxHeight(),
                    ) {
                        Box (
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.TopCenter,
                        ) {
                            IconButton(
                                image = R.drawable.share_icon,
                                imageDescription = "Share Button",
                                onClick = {}
                            )
                        }
                    }
                    Box (
                        modifier = Modifier
                            .weight(3F)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center,
                    ) {
                        LoadBinaryImage(productImage = productImage)
                    }
                    Box (
                        modifier = Modifier
                            .weight(1F)
                            .fillMaxHeight(),
                    ) {
                        Box (
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.TopCenter
                        ) {
                            IconButton(image = R.drawable.heart_icon, imageDescription = "Like Button", onClick = {})
                        }
                    }
                }
            }
            Row (
                modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth(),
            ) {
                Column (modifier = Modifier.weight(.75F)) {}
                Column (modifier = Modifier.weight(1F)) {
                    LoadProductImages(product.productImages)
                }
            }
        }
    }
}