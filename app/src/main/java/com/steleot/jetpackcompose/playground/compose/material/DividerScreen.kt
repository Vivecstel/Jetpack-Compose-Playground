package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
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
fun DividerScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.Divider.capitalize(Locale.getDefault())
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultDivider()
            ColoredDivider()
            ThickDividerComponent()
            IndentDivider()
        }
    }
}

@Preview
@Composable
fun DefaultDivider() {
    Divider()
}

@Preview
@Composable
fun ColoredDivider() {
    Divider(color = Color.Red)
}

@Preview
@Composable
fun ThickDividerComponent() {
    Divider(thickness = 12.dp)
}

@Preview
@Composable
fun IndentDivider() {
    Divider(startIndent = 12.dp)
}