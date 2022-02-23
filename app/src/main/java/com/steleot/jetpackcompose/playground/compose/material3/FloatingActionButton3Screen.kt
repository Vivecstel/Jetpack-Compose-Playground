package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold

private const val Url = "material3/FloatingActionButton3Screen.kt"

@Composable
fun FloatingActionButton3Screen() {
    DefaultScaffold(
        title = Material3NavRoutes.FloatingActionButton3,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconFloatingActionButton()
            ColoredFloatingActionButton()
            ElevatedFloatingActionButton()
            RectangleShapeFloatingActionButton()
        }
    }
}

@Preview
@Composable
private fun IconFloatingActionButton() {
    FloatingActionButton(onClick = {}) {
        Icon(
            imageVector = Icons.Outlined.Star,
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun ColoredFloatingActionButton() {
    FloatingActionButton(
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
private fun ElevatedFloatingActionButton() {
    FloatingActionButton(
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
private fun RectangleShapeFloatingActionButton() {
    FloatingActionButton(
        onClick = {},
        shape = RectangleShape
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = null
        )
    }
}