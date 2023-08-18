package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Panorama
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold

private const val URL = "material3/FilledIconButtonScreen.kt"

@Composable
fun FilledIconButtonScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.FilledIconButton,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultFilledIconButton()
            DisabledFilledIconButton()
        }
    }
}

@Composable
private fun DefaultFilledIconButton() {
    FilledIconButton(
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

@Composable
private fun DisabledFilledIconButton() {
    FilledIconButton(
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