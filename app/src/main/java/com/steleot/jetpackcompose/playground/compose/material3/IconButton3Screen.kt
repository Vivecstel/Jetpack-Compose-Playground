package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Panorama
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold3
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes

private const val Url = "material3/IconButton3Screen.kt"

@Composable
fun IconButton3Screen() {
    DefaultScaffold3(
        title = Material3NavRoutes.IconButton3,
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
                Icons.Filled.Palette,
                modifier = Modifier.size(48.dp),
                contentDescription = null,
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
                Icons.Filled.Panorama,
                contentDescription = null
            )
        },
        enabled = false
    )
}