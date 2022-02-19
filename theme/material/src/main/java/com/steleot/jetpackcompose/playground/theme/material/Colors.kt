package com.steleot.jetpackcompose.playground.theme.material

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color
import com.steleot.jetpackcompose.playground.theme.*

/* dark colors */
private val redDarkColors = darkColors(
    primary = red200.toColor(), primaryVariant = red500.toColor(), secondary = teal200.toColor(),
)
private val pinkDarkColors = darkColors(
    primary = pink200.toColor(), primaryVariant = pink500.toColor(), secondary = teal200.toColor(),
)
private val purpleDarkColors = darkColors(
    primary = purple200.toColor(),
    primaryVariant = purple500.toColor(),
    secondary = teal200.toColor(),
)
private val deepPurpleDarkColors = darkColors(
    primary = deepPurple200.toColor(),
    primaryVariant = deepPurple500.toColor(),
    secondary = teal200.toColor(),
)
private val indigoDarkColors = darkColors(
    primary = indigo200.toColor(),
    primaryVariant = indigo500.toColor(),
    secondary = teal200.toColor(),
)
private val blueDarkColors = darkColors(
    primary = blue200.toColor(), primaryVariant = blue500.toColor(), secondary = red200.toColor(),
)
private val lightBlueDarkColors = darkColors(
    primary = lightBlue200.toColor(),
    primaryVariant = lightBlue500.toColor(),
    secondary = red200.toColor(),
)
private val cyanDarkColors = darkColors(
    primary = cyan200.toColor(), primaryVariant = cyan500.toColor(), secondary = red200.toColor(),
)
private val tealDarkColors = darkColors(
    primary = teal200.toColor(), primaryVariant = teal500.toColor(), secondary = red200.toColor(),
)
private val greenDarkColors = darkColors(
    primary = green200.toColor(),
    primaryVariant = green500.toColor(),
    secondary = teal200.toColor(),
)
private val lightGreenDarkColors = darkColors(
    primary = lightGreen200.toColor(),
    primaryVariant = lightGreen500.toColor(),
    secondary = teal200.toColor(),
)
private val limeDarkColors = darkColors(
    primary = lime200.toColor(), primaryVariant = lime500.toColor(), secondary = teal200.toColor(),
)
private val yellowDarkColors = darkColors(
    primary = yellow200.toColor(),
    primaryVariant = yellow500.toColor(),
    secondary = teal200.toColor(),
)
private val amberDarkColors = darkColors(
    primary = amber200.toColor(),
    primaryVariant = amber500.toColor(),
    secondary = teal200.toColor(),
)
private val orangeDarkColors = darkColors(
    primary = orange200.toColor(),
    primaryVariant = orange500.toColor(),
    secondary = teal200.toColor(),
)
private val deepOrangeDarkColors = darkColors(
    primary = deepOrange200.toColor(),
    primaryVariant = deepOrange500.toColor(),
    secondary = teal200.toColor(),
)
private val brownDarkColors = darkColors(
    primary = brown200.toColor(),
    primaryVariant = brown500.toColor(),
    secondary = teal200.toColor(),
)
private val greyDarkColors = darkColors(
    primary = grey200.toColor(), primaryVariant = grey500.toColor(), secondary = teal200.toColor(),
)
private val blueGreyDarkColors = darkColors(
    primary = blueGrey200.toColor(),
    primaryVariant = blueGrey500.toColor(),
    secondary = teal200.toColor(),
)

/* light colors */
private val redLightColors = lightColors(
    primary = red500.toColor(), primaryVariant = red700.toColor(), secondary = teal200.toColor(),
)
private val pinkLightColors = lightColors(
    primary = pink500.toColor(), primaryVariant = pink700.toColor(), secondary = teal200.toColor(),
)
private val purpleLightColors = lightColors(
    primary = purple500.toColor(),
    primaryVariant = purple700.toColor(),
    secondary = teal200.toColor(),
)
private val deepPurpleLightColors = lightColors(
    primary = deepPurple500.toColor(),
    primaryVariant = deepPurple700.toColor(),
    secondary = teal200.toColor(),
)
private val indigoLightColors = lightColors(
    primary = indigo500.toColor(),
    primaryVariant = indigo700.toColor(),
    secondary = teal200.toColor(),
)
private val blueLightColors = lightColors(
    primary = blue500.toColor(), primaryVariant = blue700.toColor(), secondary = red200.toColor(),
)
private val lightBlueLightColors = lightColors(
    primary = lightBlue500.toColor(),
    primaryVariant = lightBlue700.toColor(),
    secondary = red200.toColor(),
)
private val cyanLightColors = lightColors(
    primary = cyan500.toColor(), primaryVariant = cyan700.toColor(), secondary = red200.toColor(),
)
private val tealLightColors = lightColors(
    primary = teal500.toColor(), primaryVariant = teal700.toColor(), secondary = red200.toColor(),
)
private val greenLightColors = lightColors(
    primary = green500.toColor(),
    primaryVariant = green700.toColor(),
    secondary = teal200.toColor(),
)
private val lightGreenLightColors = lightColors(
    primary = lightGreen500.toColor(),
    primaryVariant = lightGreen700.toColor(),
    secondary = teal200.toColor(),
)
private val limeLightColors = lightColors(
    primary = lime500.toColor(), primaryVariant = lime700.toColor(), secondary = teal200.toColor(),
)
private val yellowLightColors = lightColors(
    primary = yellow500.toColor(),
    primaryVariant = yellow700.toColor(),
    secondary = teal200.toColor(),
)
private val amberLightColors = lightColors(
    primary = amber500.toColor(),
    primaryVariant = amber700.toColor(),
    secondary = teal200.toColor(),
)
private val orangeLightColors = lightColors(
    primary = orange500.toColor(),
    primaryVariant = orange700.toColor(),
    secondary = teal200.toColor(),
)
private val deepOrangeLightColors = lightColors(
    primary = deepOrange500.toColor(),
    primaryVariant = deepOrange700.toColor(),
    secondary = teal200.toColor(),
)
private val brownLightColors = lightColors(
    primary = brown500.toColor(),
    primaryVariant = brown700.toColor(),
    secondary = teal200.toColor(),
)
private val greyLightColors = lightColors(
    primary = grey500.toColor(), primaryVariant = grey700.toColor(), secondary = teal200.toColor(),
)
private val blueGreyLightColors = lightColors(
    primary = blueGrey500.toColor(),
    primaryVariant = blueGrey700.toColor(),
    secondary = teal200.toColor(),
)

private fun Long.toColor() = Color(this)

fun ColorPalette.getMaterialColors(
    darkThemeMode: DarkThemeMode,
    isSystemInDarkTheme: Boolean,
): Colors {
    val isDarkTheme = darkThemeMode.isDarkTheme(isSystemInDarkTheme)
    return when (this) {
        ColorPalette.RED -> if (isDarkTheme) redDarkColors else redLightColors
        ColorPalette.PINK -> if (isDarkTheme) pinkDarkColors else pinkLightColors
        ColorPalette.PURPLE -> if (isDarkTheme) purpleDarkColors else purpleLightColors
        ColorPalette.DEEP_PURPLE -> if (isDarkTheme) deepPurpleDarkColors else deepPurpleLightColors
        ColorPalette.INDIGO -> if (isDarkTheme) indigoDarkColors else indigoLightColors
        ColorPalette.BLUE -> if (isDarkTheme) blueDarkColors else blueLightColors
        ColorPalette.LIGHT_BLUE -> if (isDarkTheme) lightBlueDarkColors else lightBlueLightColors
        ColorPalette.CYAN -> if (isDarkTheme) cyanDarkColors else cyanLightColors
        ColorPalette.TEAL -> if (isDarkTheme) tealDarkColors else tealLightColors
        ColorPalette.GREEN -> if (isDarkTheme) greenDarkColors else greenLightColors
        ColorPalette.LIGHT_GREEN -> if (isDarkTheme) lightGreenDarkColors else lightGreenLightColors
        ColorPalette.LIME -> if (isDarkTheme) limeDarkColors else limeLightColors
        ColorPalette.YELLOW -> if (isDarkTheme) yellowDarkColors else yellowLightColors
        ColorPalette.AMBER -> if (isDarkTheme) amberDarkColors else amberLightColors
        ColorPalette.ORANGE -> if (isDarkTheme) orangeDarkColors else orangeLightColors
        ColorPalette.DEEP_ORANGE -> if (isDarkTheme) deepOrangeDarkColors else deepOrangeLightColors
        ColorPalette.BROWN -> if (isDarkTheme) brownDarkColors else brownLightColors
        ColorPalette.GREY -> if (isDarkTheme) greyDarkColors else greyLightColors
        ColorPalette.BLUE_GREY -> if (isDarkTheme) blueGreyDarkColors else blueGreyLightColors
    }
}