package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold

private const val Url = "material3/SmallFloatingActionButtonScreen.kt"

@Composable
fun SmallFloatingActionButtonScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.SmallFloatingActionButton,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconSmallFloatingActionButton()
            ColoredSmallFloatingActionButton()
            ElevatedSmallFloatingActionButton()
            RectangleShapeSmallFloatingActionButton()
        }
    }
}

@Preview
@Composable
private fun IconSmallFloatingActionButton() {
    SmallFloatingActionButton(onClick = {}) {
        Icon(
            imageVector = Icons.Outlined.Star,
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun ColoredSmallFloatingActionButton() {
    SmallFloatingActionButton(
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
private fun ElevatedSmallFloatingActionButton() {
    SmallFloatingActionButton(
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
private fun RectangleShapeSmallFloatingActionButton() {
    SmallFloatingActionButton(
        onClick = {},
        shape = RectangleShape
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = null
        )
    }
}