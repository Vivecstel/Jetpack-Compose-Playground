package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "ui/DrawWithCacheScreen.kt"

@Composable
fun DrawWithCacheScreen() {
    DefaultScaffold(
        title = UiNavRoutes.DrawWithCache,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DrawWithCacheExample()
        }
    }
}

@Composable
private fun DrawWithCacheExample() {
    Box(
        Modifier
            .size(60.dp)
            .drawWithCache {
                val gradient = Brush.linearGradient(
                    colors = listOf(Color.Red, Color.Blue),
                    start = Offset.Zero,
                    end = Offset(size.width, size.height)
                )
                onDrawBehind {
                    drawRect(gradient)
                }
            }
    )
}