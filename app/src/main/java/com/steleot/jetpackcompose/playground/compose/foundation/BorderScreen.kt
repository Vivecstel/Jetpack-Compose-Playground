package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Brush.Companion.radialGradient
import androidx.compose.ui.graphics.Brush.Companion.sweepGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun BorderScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Border.capitalize(Locale.getDefault())
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Border()
            BorderSolidBrush()
            BorderLinearGradientBrush()
            BorderRadialGradientBrush()
            BorderSweepGradientBrush()
        }
    }
}

@Preview
@Composable
fun Border() {
    Card(border = BorderStroke(2.dp, Color.Black)) {
        Text(
            text = "Jetpack Compose Playground",
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Preview
@Composable
fun BorderSolidBrush() {
    Card(border = BorderStroke(2.dp, SolidColor(Color.Red))) {
        Text(
            text = "Jetpack Compose Playground",
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Preview
@Composable
fun BorderLinearGradientBrush() {
    Card(border = BorderStroke(4.dp, linearGradient(listOf(Color.Red, Color.Blue, Color.Cyan)))) {
        Text(
            text = "Jetpack Compose Playground",
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Preview
@Composable
fun BorderRadialGradientBrush() {
    Card(border = BorderStroke(4.dp, radialGradient(listOf(Color.Red, Color.Blue, Color.Cyan)))) {
        Text(
            text = "Jetpack Compose Playground",
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Preview
@Composable
fun BorderSweepGradientBrush() {
    Card(border = BorderStroke(4.dp, sweepGradient(listOf(Color.Red, Color.Blue, Color.Cyan)))) {
        Text(
            text = "Jetpack Compose Playground",
            modifier = Modifier.padding(12.dp)
        )
    }
}
