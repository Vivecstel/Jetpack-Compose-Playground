package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "ui/ShadowScreen.kt"

@Composable
fun ShadowScreen() {
    DefaultScaffold(
        title = UiNavRoutes.Shadow,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultShadow()
            ShapeShadow()
            ClipShadow()
        }
    }
}

@Preview
@Composable
private fun DefaultShadow() {
    Box(
        modifier = Modifier
            .size(50.dp)
            .shadow(elevation = 16.dp)
            .background(Color.Magenta)
    )
}

@Preview
@Composable
private fun ShapeShadow() {
    Box(
        modifier = Modifier
            .size(50.dp)
            .shadow(elevation = 16.dp, shape = RectangleShape)
            .background(Color.Green)
    )
}

@Preview
@Composable
private fun ClipShadow() {
    Box(
        modifier = Modifier
            .size(50.dp)
            .shadow(elevation = 16.dp, shape = RectangleShape, clip = false)
            .background(Color.Red)
    )
}