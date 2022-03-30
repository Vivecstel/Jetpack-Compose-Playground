package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "ui/DrawBehindScreen.kt"

@Composable
fun DrawBehindScreen() {
    DefaultScaffold(
        title = UiNavRoutes.DrawBehind,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DrawBehindExample()
        }
    }
}

@Composable
private fun DrawBehindExample() {
    Box(
        modifier = Modifier
            .size(120.dp)
            .drawBehind {
                drawRect(Color.Red, size = size)
            }
            .background(color = MaterialTheme.colors.primary, shape = RoundedCornerShape(16.dp))

    )
}