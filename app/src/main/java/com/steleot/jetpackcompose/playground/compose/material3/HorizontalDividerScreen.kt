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

private const val URL = "material3/HorizontalDividerScreen.kt"

@Composable
fun HorizontalDividerScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.HorizontalDivider,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultHorizontalDivider()
            ColoredHorizontalDivider()
            ThickHorizontalDivider()
        }
    }
}

@Preview
@Composable
private fun DefaultHorizontalDivider() {
    HorizontalDivider()
}

@Preview
@Composable
private fun ColoredHorizontalDivider() {
    HorizontalDivider(color = Color.Red)
}

@Preview
@Composable
private fun ThickHorizontalDivider() {
    HorizontalDivider(thickness = 12.dp)
}
