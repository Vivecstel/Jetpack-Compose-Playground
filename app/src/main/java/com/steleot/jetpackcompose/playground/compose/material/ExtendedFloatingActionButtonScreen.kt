package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ExtendedFloatingActionButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.FloatingActionButtonDefaults
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/ExtendedFloatingActionButtonScreen.kt"

@Composable
fun ExtendedFloatingActionButtonScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.ExtendedFloatingActionButton,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
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
        text = { Text(text = stringResource(id = R.string.star)) },
        onClick = {},
        icon = {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null
            )
        }
    )
}

@Preview
@Composable
private fun ColoredExtendedFloatingActionButton() {
    ExtendedFloatingActionButton(
        text = { Text(text = stringResource(id = R.string.star)) },
        onClick = {},
        backgroundColor = Color.Red,
        contentColor = Color.White,
        icon = {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null
            )
        },
    )
}

@Preview
@Composable
private fun ElevatedExtendedFloatingActionButton() {
    ExtendedFloatingActionButton(
        text = { Text(text = stringResource(id = R.string.star)) },
        onClick = {},
        shape = CutCornerShape(15.dp),
        elevation = FloatingActionButtonDefaults.elevation(20.dp),
        icon = {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null
            )
        }
    )
}

@Preview
@Composable
private fun ShapeExtendedFloatingActionButton() {
    ExtendedFloatingActionButton(
        text = { Text(text = stringResource(id = R.string.star)) },
        onClick = {},
        shape = RectangleShape,
        icon = {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null
            )
        }
    )
}
