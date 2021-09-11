package com.steleot.jetpackcompose.playground.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun JetpackComposePlaygroundTheme(
    themeState: ThemeState = ThemeState(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = themeState.colorPalette.getMaterialColors(
            themeState.darkThemeMode,
            themeState.isSystemInDarkTheme
        ),
        typography = typography,
        shapes = shapes,
        content = content
    )
}
