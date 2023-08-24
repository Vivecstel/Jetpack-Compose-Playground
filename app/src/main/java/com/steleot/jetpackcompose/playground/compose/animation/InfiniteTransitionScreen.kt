package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.AnimationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "animation/InfiniteTransitionScreen.kt"

@Composable
fun InfiniteTransitionScreen() {
    DefaultScaffold(
        title = AnimationNavRoutes.InfiniteTransition,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InfiniteTransitionExample()
            InfiniteLoading()
        }
    }
}

@Composable
private fun InfiniteTransitionExample() {
    val infiniteTransition = rememberInfiniteTransition(
        label = "InfiniteTransitionExampleInfiniteTransition",
    )

    val scale by infiniteTransition.animateFloat(
        initialValue = 2f,
        targetValue = 4f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Restart
        ),
        label = "InfiniteTransitionExampleScale",
    )

    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color(0xff800000),
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "InfiniteTransitionExampleColor",
    )

    Box(Modifier.fillMaxWidth()) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale
                ),
            tint = color
        )
    }
}

@Composable
private fun InfiniteLoading() {
    val infiniteTransition = rememberInfiniteTransition(
        label = "InfiniteLoadingInfiniteTransition",
    )
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1000
                0.7f at 500
            },
            repeatMode = RepeatMode.Reverse
        ),
        label = "InfiniteLoadingAlpha",
    )
    Row(
        modifier = Modifier
            .heightIn(min = 64.dp)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color.LightGray.copy(alpha = alpha))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .background(Color.LightGray.copy(alpha = alpha))
        )
    }
}
