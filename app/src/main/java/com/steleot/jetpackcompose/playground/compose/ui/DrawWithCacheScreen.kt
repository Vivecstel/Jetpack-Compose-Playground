package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

private const val Url = "ui/DrawWithCacheScreen.kt"

@Composable
fun DrawWithCacheScreen() {
    DefaultScaffold(
        title = UiNavRoutes.DrawWithCache,
        link = Url,
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