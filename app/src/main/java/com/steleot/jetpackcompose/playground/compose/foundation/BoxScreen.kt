package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/BoxScreen.kt"

@Composable
fun BoxScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Box,
        link = URL,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(fraction = 0.8f)
                    .background(Color.Green)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize(fraction = 0.6f)
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize(fraction = 0.4f)
                    .background(Color.Cyan)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize(fraction = 0.2f)
                    .background(Color.Black)
            )
        }
    }
}