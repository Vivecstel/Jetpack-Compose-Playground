package com.steleot.jetpackcompose.playground.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.MaterialTheme.typography

@Composable
fun JetpackComposePlaygroundTheme(
    colorPalette: ColorPalette,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = colorPalette.getMaterialColors(),
        typography = typography,
        shapes = shapes,
        content = content
    )
}