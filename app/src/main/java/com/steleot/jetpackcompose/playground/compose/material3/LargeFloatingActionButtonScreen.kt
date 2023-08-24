package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold

private const val URL = "material3/LargeFloatingActionButtonScreen.kt"

@Composable
fun LargeFloatingActionButtonScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.LargeFloatingActionButton,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconLargeFloatingActionButton()
            ColoredLargeFloatingActionButton()
            ElevatedLargeFloatingActionButton()
            RectangleShapeLargeFloatingActionButton()
        }
    }
}

@Preview
@Composable
private fun IconLargeFloatingActionButton() {
    LargeFloatingActionButton(onClick = {}) {
        Icon(
            imageVector = Icons.Outlined.Star,
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun ColoredLargeFloatingActionButton() {
    LargeFloatingActionButton(
        onClick = {},
        containerColor = Color.Red,
        contentColor = Color.White
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun ElevatedLargeFloatingActionButton() {
    LargeFloatingActionButton(
        onClick = {},
        shape = CutCornerShape(15.dp),
        elevation = FloatingActionButtonDefaults.elevation(20.dp),
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun RectangleShapeLargeFloatingActionButton() {
    LargeFloatingActionButton(
        onClick = {},
        shape = RectangleShape
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = null
        )
    }
}