package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "runtime/LaunchedEffectScreen.kt"

@Composable
fun LaunchedEffectScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.LaunchedEffect,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
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
        stringResource(id = R.string.hello_world),
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
