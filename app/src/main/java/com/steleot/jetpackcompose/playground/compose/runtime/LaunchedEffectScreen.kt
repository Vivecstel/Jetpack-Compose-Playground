package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import com.steleot.jetpackcompose.playground.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "runtime/LaunchedEffectScreen.kt"

@Composable
fun LaunchedEffectScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.LaunchedEffect.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LaunchedEffectExample()
        }
    }
}

@Composable
private fun LaunchedEffectExample() {
    val animatedAlpha = remember { Animatable(0f) }
    Text(
        "Hello Jetpack Compose Playground",
        Modifier.graphicsLayer {
            alpha = animatedAlpha.value
            clip = true
        }
    )
    LaunchedEffect(animatedAlpha) {
        animatedAlpha.animateTo(
            1f,
            animationSpec = tween(1_000)
        )
    }
}
