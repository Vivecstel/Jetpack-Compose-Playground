package com.steleot.jetpackcompose.playground.theme.material

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.theme.ThemeState

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