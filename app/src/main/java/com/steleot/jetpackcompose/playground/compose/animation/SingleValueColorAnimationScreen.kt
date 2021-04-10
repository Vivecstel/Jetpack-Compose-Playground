package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.steleot.jetpackcompose.playground.AnimationNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "animation/SingleValueColorAnimationScreen.kt"

@Composable
fun SingleValueColorAnimationScreen() {
    DefaultScaffold(
        title = AnimationNavRoutes.SingleValueColorAnimation,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SingleValueAnimationColorExample()
        }
    }
}

@Preview
@Composable
private fun SingleValueAnimationColorExample() {
    var enabled by remember { mutableStateOf(true) }
    val color by animateColorAsState(
        targetValue = if (enabled) Color.Green else Color.Red,
        animationSpec = tween(500)
    )
    Box {
        Box(
            Modifier
                .fillMaxSize()
                .clickable(onClick = {
                    enabled = !enabled
                })
                .background(color),
        )
        Text(
            text = "Click me to change color!",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
