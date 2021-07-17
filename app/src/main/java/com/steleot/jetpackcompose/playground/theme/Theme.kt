package com.steleot.jetpackcompose.playground.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun JetpackComposePlaygroundTheme(
    colorPalette: ColorPalette,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = colorPalette.getMaterialColors(darkTheme),
        typography = typography,
        shapes = shapes,
        content = content
    )
}
