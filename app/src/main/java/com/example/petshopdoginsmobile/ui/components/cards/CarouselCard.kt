package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.R
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.ui.platform.LocalConfiguration

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CarouselCard(
    items: List<@Composable () -> Unit>,
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val pagerState = rememberPagerState()

    Box(modifier = Modifier.fillMaxWidth()){
        HorizontalPager(
            pageCount = items.size,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 10.dp),
            key = { items[it].hashCode() },
            pageSize = PageSize.Fixed(screenWidth * 0.95f)
        ) { page ->
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            ){
                items[page]()
            }
        }
    }
}

@Preview
@Composable
private fun CarouselCardPreview(){
    CarouselCard(items = listOf(
        { Image(painter = painterResource(id = R.drawable.img_carousel_01), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxWidth()) },
        { Image(painter = painterResource(id = R.drawable.img_carousel_02), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxWidth()) }
    ))
}
