package com.example.petshopdoginsmobile.ui.components.cards

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.petshopdoginsmobile.R
import android.content.res.Configuration
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.platform.LocalConfiguration

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Carousel(
    items: List<Int>,
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val pagerState = rememberPagerState()

    Box(modifier = Modifier.fillMaxWidth()){
        HorizontalPager(
            pageCount = items.size,
            state = pagerState,
            key = { items[it] },
            pageSize = PageSize.Fixed(screenWidth * 0.9f)
        ) { page ->
            Image(
                painter = painterResource(id = items[page]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .offset(x = 20.dp)
            )
        }
    }
}



@Preview
@Composable
private fun CarouselPreview(){
    Carousel(items = listOf(
        R.drawable.img_carousel_01,
        R.drawable.img_carousel_02
    ))
}