package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/DividerScreen.kt"

@Composable
fun DividerScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.Divider,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
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
private fun DefaultDivider() {
    Divider()
}

@Preview
@Composable
private fun ColoredDivider() {
    Divider(color = Color.Red)
}

@Preview
@Composable
private fun ThickDividerComponent() {
    Divider(thickness = 12.dp)
}

@Preview
@Composable
private fun IndentDivider() {
    Divider(startIndent = 12.dp)
}