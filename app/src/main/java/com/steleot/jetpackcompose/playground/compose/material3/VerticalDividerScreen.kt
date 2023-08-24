package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material3/VerticalDividerScreen.kt"

@Composable
fun VerticalDividerScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.VerticalDivider,
        link = URL,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().height(150.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                DefaultVerticalDivider()
                ColoredVerticalDivider()
                ThickVerticalDivider()
            }
        }
    }
}

@Preview
@Composable
private fun DefaultVerticalDivider() {
    VerticalDivider()
}

@Preview
@Composable
private fun ColoredVerticalDivider() {
    VerticalDivider(color = Color.Red)
}

@Preview
@Composable
private fun ThickVerticalDivider() {
    VerticalDivider(thickness = 12.dp)
}