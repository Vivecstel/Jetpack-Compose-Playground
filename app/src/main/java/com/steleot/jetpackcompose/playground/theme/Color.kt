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

val colors = listOf(
    Color(0xFFffd7d7.toInt()),
    Color(0xFFffe9d6.toInt()),
    Color(0xFFfffbd0.toInt()),
    Color(0xFFe3ffd9.toInt()),
    Color(0xFFd0fff8.toInt())
)
