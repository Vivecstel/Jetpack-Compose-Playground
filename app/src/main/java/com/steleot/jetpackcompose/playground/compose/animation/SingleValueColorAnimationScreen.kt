package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.AnimationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "animation/SingleValueColorAnimationScreen.kt"

@Composable
fun SingleValueColorAnimationScreen() {
    DefaultScaffold(
        title = AnimationNavRoutes.SingleValueColorAnimation,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
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
        animationSpec = tween(500),
        label = "SingleValueAnimationColorExample",
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
            text = stringResource(id = R.string.click_me_change_color),
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
