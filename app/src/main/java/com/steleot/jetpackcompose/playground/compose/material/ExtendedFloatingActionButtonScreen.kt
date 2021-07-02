package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
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

private const val Url = "material/ExtendedFloatingActionButtonScreen.kt"

@Composable
fun ExtendedFloatingActionButtonScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.ExtendedFloatingActionButton,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconExtendedFloatingActionButton()
            ColoredExtendedFloatingActionButton()
            ElevatedExtendedFloatingActionButton()
            ShapeExtendedFloatingActionButton()
        }
    }
}

@Preview
@Composable
private fun IconExtendedFloatingActionButton() {
    ExtendedFloatingActionButton(
        text = { Text(text = "Star") },
        onClick = {},
        icon = {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = "Icon Extended Floating Action Button"
            )
        }
    )
}

@Preview
@Composable
private fun ColoredExtendedFloatingActionButton() {
    ExtendedFloatingActionButton(
        text = { Text(text = "Star") },
        onClick = {},
        backgroundColor = Color.Red,
        contentColor = Color.White,
        icon = {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Colored Extended Floating Action Button"
            )
        },
    )
}

@Preview
@Composable
private fun ElevatedExtendedFloatingActionButton() {
    ExtendedFloatingActionButton(
        text = { Text(text = "Star") },
        onClick = {},
        shape = CutCornerShape(15.dp),
        elevation = FloatingActionButtonDefaults.elevation(20.dp),
        icon = {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Elevated Extended Floating Action Button"
            )
        }
    )
}

@Preview
@Composable
private fun ShapeExtendedFloatingActionButton() {
    ExtendedFloatingActionButton(
        text = { Text(text = "Star") },
        onClick = {},
        shape = RectangleShape,
        icon = {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "my description"
            )
        }
    )
}
