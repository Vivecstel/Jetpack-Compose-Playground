package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun ProgressScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.Progress.capitalize(Locale.getDefault())
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
fun DefaultCircularProgressIndicator() {
    CircularProgressIndicator()
}

@Preview
@Composable
fun StaticCircularProgressIndicator() {
    CircularProgressIndicator(0.5f, color = Color.Cyan)
}

@Preview
@Composable
fun StrokeCircularProgressIndicator() {
    CircularProgressIndicator(0.5f, strokeWidth = 8.dp)
}

@Preview
@Composable
fun DefaultLinearProgressIndicator() {
    LinearProgressIndicator()
}

@Preview
@Composable
fun ColoredLinearProgressIndicator() {
    LinearProgressIndicator(
        backgroundColor = Color.White,
        color = Color.Red
    )
}