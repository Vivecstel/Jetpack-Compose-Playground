package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Panorama
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material3/OutlinedIconButtonScreen.kt"

@Composable
fun OutlinedIconButtonScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.OutlinedIconButton,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultOutlinedIconButton()
            DisabledOutlinedIconButton()
        }
    }
}

@Composable
private fun DefaultOutlinedIconButton() {
    OutlinedIconButton(
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
private fun DisabledOutlinedIconButton() {
    OutlinedIconButton(
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
