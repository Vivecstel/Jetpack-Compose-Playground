package com.steleot.jetpackcompose.playground.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.MaterialTheme as MaterialTheme3

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

@Composable
fun JetpackComposePlaygroundTheme3(
    themeState: ThemeState = ThemeState(),
    content: @Composable () -> Unit
) {
    MaterialTheme3(
        colorScheme = themeState.colorPalette.getMaterial3ColorScheme(
            LocalContext.current,
            themeState.darkThemeMode,
            themeState.isSystemInDarkTheme
        ),
        typography = typography3,
        content = content
    )
}
