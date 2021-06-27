package com.steleot.jetpackcompose.playground.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun JetpackComposeTheme(
    colorPallete: ColorPallete = ColorPallete.PURPLE,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = colorPallete.getMaterialColors(darkTheme),
        typography = typography,
        shapes = shapes,
        content = content
    )
}
