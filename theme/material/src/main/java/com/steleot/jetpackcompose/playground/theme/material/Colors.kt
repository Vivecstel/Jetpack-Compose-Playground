package com.steleot.jetpackcompose.playground.theme.material

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import com.steleot.jetpackcompose.playground.theme.*

/* dark colors */
private val redDarkColors = darkColors(
    primary = red200, primaryVariant = red500, secondary = teal200,
)
private val pinkDarkColors = darkColors(
    primary = pink200, primaryVariant = pink500, secondary = teal200,
)
private val purpleDarkColors = darkColors(
    primary = purple200, primaryVariant = purple500, secondary = teal200,
)
private val deepPurpleDarkColors = darkColors(
    primary = deepPurple200, primaryVariant = deepPurple500, secondary = teal200,
)
private val indigoDarkColors = darkColors(
    primary = indigo200, primaryVariant = indigo500, secondary = teal200,
)
private val blueDarkColors = darkColors(
    primary = blue200, primaryVariant = blue500, secondary = red200,
)
private val lightBlueDarkColors = darkColors(
    primary = lightBlue200, primaryVariant = lightBlue500, secondary = red200,
)
private val cyanDarkColors = darkColors(
    primary = cyan200, primaryVariant = cyan500, secondary = red200,
)
private val tealDarkColors = darkColors(
    primary = teal200, primaryVariant = teal500, secondary = red200,
)
private val greenDarkColors = darkColors(
    primary = green200, primaryVariant = green500, secondary = teal200,
)
private val lightGreenDarkColors = darkColors(
    primary = lightGreen200, primaryVariant = lightGreen500, secondary = teal200,
)
private val limeDarkColors = darkColors(
    primary = lime200, primaryVariant = lime500, secondary = teal200,
)
private val yellowDarkColors = darkColors(
    primary = yellow200, primaryVariant = yellow500, secondary = teal200,
)
private val amberDarkColors = darkColors(
    primary = amber200, primaryVariant = amber500, secondary = teal200,
)
private val orangeDarkColors = darkColors(
    primary = orange200, primaryVariant = orange500, secondary = teal200,
)
private val deepOrangeDarkColors = darkColors(
    primary = deepOrange200, primaryVariant = deepOrange500, secondary = teal200,
)
private val brownDarkColors = darkColors(
    primary = brown200, primaryVariant = brown500, secondary = teal200,
)
private val greyDarkColors = darkColors(
    primary = grey200, primaryVariant = grey500, secondary = teal200,
)
private val blueGreyDarkColors = darkColors(
    primary = blueGrey200, primaryVariant = blueGrey500, secondary = teal200,
)

/* light colors */
private val redLightColors = lightColors(
    primary = red500, primaryVariant = red700, secondary = teal200,
)
private val pinkLightColors = lightColors(
    primary = pink500, primaryVariant = pink700, secondary = teal200,
)
private val purpleLightColors = lightColors(
    primary = purple500, primaryVariant = purple700, secondary = teal200,
)
private val deepPurpleLightColors = lightColors(
    primary = deepPurple500, primaryVariant = deepPurple700, secondary = teal200,
)
private val indigoLightColors = lightColors(
    primary = indigo500, primaryVariant = indigo700, secondary = teal200,
)
private val blueLightColors = lightColors(
    primary = blue500, primaryVariant = blue700, secondary = red200,
)
private val lightBlueLightColors = lightColors(
    primary = lightBlue500, primaryVariant = lightBlue700, secondary = red200,
)
private val cyanLightColors = lightColors(
    primary = cyan500, primaryVariant = cyan700, secondary = red200,
)
private val tealLightColors = lightColors(
    primary = teal500, primaryVariant = teal700, secondary = red200,
)
private val greenLightColors = lightColors(
    primary = green500, primaryVariant = green700, secondary = teal200,
)
private val lightGreenLightColors = lightColors(
    primary = lightGreen500, primaryVariant = lightGreen700, secondary = teal200,
)
private val limeLightColors = lightColors(
    primary = lime500, primaryVariant = lime700, secondary = teal200,
)
private val yellowLightColors = lightColors(
    primary = yellow500, primaryVariant = yellow700, secondary = teal200,
)
private val amberLightColors = lightColors(
    primary = amber500, primaryVariant = amber700, secondary = teal200,
)
private val orangeLightColors = lightColors(
    primary = orange500, primaryVariant = orange700, secondary = teal200,
)
private val deepOrangeLightColors = lightColors(
    primary = deepOrange500, primaryVariant = deepOrange700, secondary = teal200,
)
private val brownLightColors = lightColors(
    primary = brown500, primaryVariant = brown700, secondary = teal200,
)
private val greyLightColors = lightColors(
    primary = grey500, primaryVariant = grey700, secondary = teal200,
)
private val blueGreyLightColors = lightColors(
    primary = blueGrey500, primaryVariant = blueGrey700, secondary = teal200,
)

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