package com.steleot.jetpackcompose.playground.compose.external

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.google.accompanist.coil.CoilImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import kotlin.math.absoluteValue

private const val Url = "external/PagerScreen.kt"

@Composable
fun PagerScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.Pager,
        link = Url,
    ) {
        PagerExample()
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun PagerExample() {
    val pagerState = rememberPagerState(pageCount = 10)
    Column(Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            offscreenLimit = 2,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
        ) { page ->
            Card(
                Modifier
                    .graphicsLayer {
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }

                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }

            ) {
                Box {
                    CoilImage(
                        data = randomSampleImageUrl(width = 600),
                        contentDescription = null,
                        fadeIn = true,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .aspectRatio(1f)
                    )

                    ProfilePicture(
                        Modifier
                            .align(Alignment.BottomCenter)
                            .padding(16.dp)
                            .offset {
                                val pageOffset =
                                    this@HorizontalPager.calculateCurrentOffsetForPage(page)
                                IntOffset(
                                    x = (36.dp * pageOffset).roundToPx(),
                                    y = 0
                                )
                            }
                    )
                }
            }
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            indicatorShape = RoundedCornerShape(0.dp)
        )
    }
}

private fun randomSampleImageUrl(
    seed: Int = (0..100000).random(),
    width: Int = 300,
    height: Int = width,
): String {
    return "https://picsum.photos/seed/$seed/$width/$height"
}

@Composable
private fun ProfilePicture(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = CircleShape,
        border = BorderStroke(4.dp, MaterialTheme.colors.surface)
    ) {
        CoilImage(
            data = randomSampleImageUrl(),
            contentDescription = null,
            fadeIn = true,
            modifier = Modifier.size(72.dp)
        )
    }
}