package com.steleot.jetpackcompose.playground.theme

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

private val purple200 = Color(0XFFCE93D8)
val purple500 = Color(0XFF9C27B0)
private val purple700 = Color(0XFF7B1FA2)
private val teal200 = Color(0XFF80DEEA)

private val DarkPurpleColorPalette = darkColors(
    primary = purple200,
    primaryVariant = purple500,
    secondary = teal200,
    surface = purple200,
)

private val LightPurpleColorPalette = lightColors(
    primary = purple500,
    primaryVariant = purple700,
    secondary = teal200,
    surface = purple500,
)

private val blue200 = Color(0XFF90CAF9)
val blue500 = Color(0xFF2195F2)
private val blue700 = Color(0xFF1976D2)

private val DarkBlueColorPalette = darkColors(
    primary = blue200,
    primaryVariant = blue500,
    secondary = teal200,
    surface = blue200,
)

private val LightBlueColorPalette = lightColors(
    primary = blue500,
    primaryVariant = blue700,
    secondary = teal200,
    surface = blue500,
)

private val orange200 = Color(0XFFFFCC80)
val orange500 = Color(0XFFFF9800)
private val orange700 = Color(0XFFF57C00)

private val DarkOrangeColorPalette = darkColors(
    primary = orange200,
    primaryVariant = orange500,
    secondary = teal200,
    surface = orange200,
)

private val LightOrangeColorPalette = lightColors(
    primary = orange500,
    primaryVariant = orange700,
    secondary = teal200,
    surface = orange500,
)

private val green200 = Color(0XFFA5D6A7)
val green500 = Color(0XFF4CAF50)
private val green700 = Color(0XFF388E3C)

private val DarkGreenColorPalette = darkColors(
    primary = green200,
    primaryVariant = green500,
    secondary = teal200,
    surface = green200,
)

private val LightGreenColorPalette = lightColors(
    primary = green500,
    primaryVariant = green700,
    secondary = teal200,
    surface = green500,
)

private val yellow200 = Color(0XFFFFF59D)
val yellow500 = Color(0XFFFFEB3B)
private val yellow700 = Color(0XFFFBC02D)

private val DarkYellowColorPalette = darkColors(
    primary = yellow200,
    primaryVariant = yellow500,
    secondary = teal200,
    surface = yellow200,
)

private val LightYellowColorPalette = lightColors(
    primary = yellow500,
    primaryVariant = yellow700,
    secondary = teal200,
    surface = yellow500,
)

enum class ColorPallete {
    PURPLE, GREEN, ORANGE, BLUE, YELLOW
}

fun ColorPallete.getMaterialColors(darkTheme: Boolean): Colors {
    return when (this) {
        ColorPallete.PURPLE -> if (darkTheme) DarkPurpleColorPalette else LightPurpleColorPalette
        ColorPallete.GREEN -> if (darkTheme) DarkGreenColorPalette else LightGreenColorPalette
        ColorPallete.ORANGE -> if (darkTheme) DarkOrangeColorPalette else LightOrangeColorPalette
        ColorPallete.BLUE -> if (darkTheme) DarkBlueColorPalette else LightBlueColorPalette
        ColorPallete.YELLOW -> if (darkTheme) DarkYellowColorPalette else LightYellowColorPalette
    }
}

val colors = listOf(
    Color(0xFFffd7d7.toInt()),
    Color(0xFFffe9d6.toInt()),
    Color(0xFFfffbd0.toInt()),
    Color(0xFFe3ffd9.toInt()),
    Color(0xFFd0fff8.toInt())
)
