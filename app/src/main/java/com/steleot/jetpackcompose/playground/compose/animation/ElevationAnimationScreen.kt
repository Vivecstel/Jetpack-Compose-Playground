package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.AnimationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "animation/ElevationAnimationScreen.kt"

@Composable
fun ElevationAnimationScreen() {
    DefaultScaffold(
        title = AnimationNavRoutes.ElevationAnimation,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevationAnimationExample()
        }
    }
}

@Composable
private fun ElevationAnimationExample() {
    val infiniteTransition = rememberInfiniteTransition()
    val elevation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 25f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    Box(
        Modifier
            .shadow(elevation.dp, RectangleShape, clip = false)
            .size(200.dp)
            .background(Color.Blue)
    )
}