package com.steleot.jetpackcompose.playground.compose.foundationlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.FoundationLayoutNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "foundationlayout/AspectRationScreen.kt"

@Composable
fun PaddingScreen() {
    DefaultScaffold(
        title = FoundationLayoutNavRoutes.Padding.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
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