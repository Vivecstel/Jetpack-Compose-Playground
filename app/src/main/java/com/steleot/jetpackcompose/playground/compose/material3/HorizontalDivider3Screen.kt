package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold

private const val URL = "material3/HorizontalDivider3Screen.kt"

@Composable
fun HorizontalDivider3Screen() {
    DefaultScaffold(
        title = Material3NavRoutes.HorizontalDivider3,
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
        }
    }
}

@Preview
@Composable
private fun DefaultDivider() {
    HorizontalDivider()
}

@Preview
@Composable
private fun ColoredDivider() {
    HorizontalDivider(color = Color.Red)
}

@Preview
@Composable
private fun ThickDividerComponent() {
    HorizontalDivider(thickness = 12.dp)
}
