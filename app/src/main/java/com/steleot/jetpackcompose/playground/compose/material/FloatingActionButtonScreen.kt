package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults.elevation
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes

private const val Url = "material/FloatingActionButtonScreen.kt"

@Composable
fun FloatingActionButtonScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.FloatingActionButton,
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
            contentDescription = "Icon Floating Action Button"
        )
    }
}

@Preview
@Composable
private fun ColoredFloatingActionButton() {
    FloatingActionButton(
        onClick = {},
        backgroundColor = Color.Red,
        contentColor = Color.White
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "Colored Floating Action Button"
        )
    }
}

@Preview
@Composable
private fun ElevatedFloatingActionButton() {
    FloatingActionButton(
        onClick = {},
        shape = CutCornerShape(15.dp),
        elevation = elevation(20.dp),
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "Elevated Floating Action Button"
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
            contentDescription = "Rectangle Shape Floating Action Button"
        )
    }
}
