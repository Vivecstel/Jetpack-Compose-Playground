package com.steleot.jetpackcompose.playground.compose.foundationlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.steleot.jetpackcompose.playground.FoundationLayoutNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "foundationlayout/BoxScreen.kt"

@Composable
fun BoxScreen() {
    DefaultScaffold(
        title = FoundationLayoutNavRoutes.Box.capitalize(Locale.getDefault()),
        link = Url,
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