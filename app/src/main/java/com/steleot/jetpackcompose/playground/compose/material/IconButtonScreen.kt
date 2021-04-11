package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Panorama
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "material/IconButtonScreen.kt"

@Composable
fun IconButtonScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.IconButton,
        link = Url,
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
private fun DefaultIconButton() {
    IconButton(
        onClick = {},

        content = {
            Icon(
                Icons.Default.Palette,
                modifier = Modifier.size(48.dp),
                contentDescription = "Default Icon Button",
            )
        }
    )
}

@Preview
@Composable
private fun DisabledIconButton() {
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
