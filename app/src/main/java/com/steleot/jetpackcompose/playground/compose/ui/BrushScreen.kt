package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun BrushScreen() {
    DefaultScaffold(
        title = UiNavRoutes.Brush.capitalize(Locale.getDefault())
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val linear = Brush.linearGradient(listOf(Color.Red, Color.Blue))

            Box(modifier = Modifier
                .size(120.dp)
                .background(linear))

            Spacer(modifier = Modifier.size(20.dp))

            val radial = Brush.radialGradient(listOf(Color.Green, Color.Magenta))
            Box(modifier = Modifier
                .size(120.dp)
                .background(radial))

            Spacer(modifier = Modifier.size(20.dp))

            val sweep = Brush.sweepGradient(listOf(Color.Cyan, Color.Magenta))
            Box(modifier = Modifier
                .size(120.dp)
                .background(sweep))
        }
    }
}