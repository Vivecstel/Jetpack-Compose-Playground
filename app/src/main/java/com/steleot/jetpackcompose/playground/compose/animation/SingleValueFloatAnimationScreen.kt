package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.AnimationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "animation/SingleValueFloatAnimationScreen.kt"

@Composable
fun SingleValueFloatAnimationScreen() {
    DefaultScaffold(
        title = AnimationNavRoutes.SingleValueFloatAnimation,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SingleValueAnimationFloatExample()
        }
    }
}

@Composable
private fun SingleValueAnimationFloatExample() {
    var enabled by remember { mutableStateOf(true) }
    val value by animateFloatAsState(
        targetValue = if (enabled) 0f else 100f,
        animationSpec = tween(500)
    )
    Box(modifier = Modifier
        .padding(value.dp)
        .clickable(
            onClick = {
                enabled = !enabled
            }
        )) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Green)
        )
    }
}