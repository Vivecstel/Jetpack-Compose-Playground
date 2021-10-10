package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundation/Padding.kt"

@Composable
fun PaddingScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Padding,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(0.8f)
                    .background(Color.Yellow)
                    .padding(16.dp)
                    .background(Color.Green)
                    .padding(16.dp)
                    .background(Color.Red)
                    .padding(16.dp)
                    .background(Color.Cyan)
                    .padding(16.dp)
                    .background(Color.Black)
            )
        }
    }
}