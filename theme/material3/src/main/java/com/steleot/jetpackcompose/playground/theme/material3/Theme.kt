package com.steleot.jetpackcompose.playground.theme.material3

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.steleot.jetpackcompose.playground.theme.ThemeState

@Composable
fun JetpackComposePlaygroundTheme(
    themeState: ThemeState = ThemeState(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = themeState.colorPalette.getMaterial3ColorScheme(
            LocalContext.current,
            themeState.darkThemeMode,
            themeState.isSystemInDarkTheme
        ),
        typography = typography,
        content = content
    )
}