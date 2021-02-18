package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Panorama
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun IconButtonScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.IconButton.capitalize(Locale.getDefault())
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultIconButton()
            DisabledIconButton()
        }
    }
}

@Preview
@Composable
fun DefaultIconButton() {
    IconButton(
        onClick = {},
        content = {
            Icon(
                Icons.Default.Palette,
                contentDescription = "Default Icon Button"
            )
        }
    )
}

@Preview
@Composable
fun DisabledIconButton() {
    IconButton(
        onClick = {},
        content = {
            Icon(
                Icons.Default.Panorama,
                contentDescription = "Disabled Icon Button"
            )
        },
        enabled = false
    )
}
