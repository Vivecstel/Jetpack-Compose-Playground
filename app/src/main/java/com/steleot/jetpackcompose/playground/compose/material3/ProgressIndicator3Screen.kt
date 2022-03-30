package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold

private const val Url = "material3/ProgressIndicator3Screen.kt"

@Composable
fun ProgressIndicator3Screen() {
    DefaultScaffold(
        title = Material3NavRoutes.ProgressIndicator3,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultCircularProgressIndicator()
            StaticCircularProgressIndicator()
            StrokeCircularProgressIndicator()
            DefaultLinearProgressIndicator()
            ColoredLinearProgressIndicator()
        }
    }
}

@Preview
@Composable
private fun DefaultCircularProgressIndicator() {
    CircularProgressIndicator()
}

@Preview
@Composable
private fun StaticCircularProgressIndicator() {
    CircularProgressIndicator(0.5f, color = Color.Cyan)
}

@Preview
@Composable
private fun StrokeCircularProgressIndicator() {
    CircularProgressIndicator(0.5f, strokeWidth = 8.dp)
}

@Preview
@Composable
private fun DefaultLinearProgressIndicator() {
    LinearProgressIndicator()
}

@Preview
@Composable
private fun ColoredLinearProgressIndicator() {
    LinearProgressIndicator(
        trackColor = Color.White,
        color = Color.Red
    )
}