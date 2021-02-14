package com.steleot.jetpackcompose.playground.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

private val purple200 = Color(0xFFBB86FC)
private val purple500 = Color(0xFF6200EE)
private val purple700 = Color(0xFF3700B3)
private val teal200 = Color(0xFF03DAC5)

val DarkColorPalette = darkColors(
    primary = purple200,
    primaryVariant = purple700,
    secondary = teal200,
    surface = purple500,
)

val LightColorPalette = lightColors(
    primary = purple500,
    primaryVariant = purple700,
    secondary = teal200,
    surface = purple500,
)
