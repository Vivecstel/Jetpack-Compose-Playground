package com.steleot.jetpackcompose.playground.theme.material3

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.steleot.jetpackcompose.playground.theme.*

/* dark color scheme */
private val redDarkColorScheme = darkColorScheme(
    primary = red200.toColor(), secondary = red500.toColor(), tertiary = teal200.toColor(),
)
private val pinkDarkColorScheme = darkColorScheme(
    primary = pink200.toColor(), secondary = pink500.toColor(), tertiary = teal200.toColor(),
)
private val purpleDarkColorScheme = darkColorScheme(
    primary = purple200.toColor(), secondary = purple500.toColor(), tertiary = teal200.toColor(),
)
private val deepPurpleDarkColorScheme = darkColorScheme(
    primary = deepPurple200.toColor(),
    secondary = deepPurple500.toColor(),
    tertiary = teal200.toColor(),
)
private val indigoDarkColorScheme = darkColorScheme(
    primary = indigo200.toColor(), secondary = indigo500.toColor(), tertiary = teal200.toColor(),
)
private val blueDarkColorScheme = darkColorScheme(
    primary = blue200.toColor(), secondary = blue500.toColor(), tertiary = red200.toColor(),
)
private val lightBlueDarkColorScheme = darkColorScheme(
    primary = lightBlue200.toColor(),
    secondary = lightBlue500.toColor(),
    tertiary = red200.toColor(),
)
private val cyanDarkColorScheme = darkColorScheme(
    primary = cyan200.toColor(), secondary = cyan500.toColor(), tertiary = red200.toColor(),
)
private val tealDarkColorScheme = darkColorScheme(
    primary = teal200.toColor(), secondary = teal500.toColor(), tertiary = red200.toColor(),
)
private val greenDarkColorScheme = darkColorScheme(
    primary = green200.toColor(), secondary = green500.toColor(), tertiary = teal200.toColor(),
)
private val lightGreenDarkColorScheme = darkColorScheme(
    primary = lightGreen200.toColor(),
    secondary = lightGreen500.toColor(),
    tertiary = teal200.toColor(),
)
private val limeDarkColorScheme = darkColorScheme(
    primary = lime200.toColor(), secondary = lime500.toColor(), tertiary = teal200.toColor(),
)
private val yellowDarkColorScheme = darkColorScheme(
    primary = yellow200.toColor(), secondary = yellow500.toColor(), tertiary = teal200.toColor(),
)
private val amberDarkColorScheme = darkColorScheme(
    primary = amber200.toColor(), secondary = amber500.toColor(), tertiary = teal200.toColor(),
)
private val orangeDarkColorScheme = darkColorScheme(
    primary = orange200.toColor(), secondary = orange500.toColor(), tertiary = teal200.toColor(),
)
private val deepOrangeDarkColorScheme = darkColorScheme(
    primary = deepOrange200.toColor(),
    secondary = deepOrange500.toColor(),
    tertiary = teal200.toColor(),
)
private val brownDarkColorScheme = darkColorScheme(
    primary = brown200.toColor(), secondary = brown500.toColor(), tertiary = teal200.toColor(),
)
private val greyDarkColorScheme = darkColorScheme(
    primary = grey200.toColor(), secondary = grey500.toColor(), tertiary = teal200.toColor(),
)
private val blueGreyDarkColorScheme = darkColorScheme(
    primary = blueGrey200.toColor(),
    secondary = blueGrey500.toColor(),
    tertiary = teal200.toColor(),
)

/* light color scheme */
private val redLightColorScheme = lightColorScheme(
    primary = red500.toColor(), secondary = red700.toColor(), tertiary = teal200.toColor(),
)
private val pinkLightColorScheme = lightColorScheme(
    primary = pink500.toColor(), secondary = pink700.toColor(), tertiary = teal200.toColor(),
)
private val purpleLightColorScheme = lightColorScheme(
    primary = purple500.toColor(), secondary = purple700.toColor(), tertiary = teal200.toColor(),
)
private val deepPurpleLightColorScheme = lightColorScheme(
    primary = deepPurple500.toColor(),
    secondary = deepPurple700.toColor(),
    tertiary = teal200.toColor(),
)
private val indigoLightColorScheme = lightColorScheme(
    primary = indigo500.toColor(), secondary = indigo700.toColor(), tertiary = teal200.toColor(),
)
private val blueLightColorScheme = lightColorScheme(
    primary = blue500.toColor(), secondary = blue700.toColor(), tertiary = red200.toColor(),
)
private val lightBlueLightColorScheme = lightColorScheme(
    primary = lightBlue500.toColor(),
    secondary = lightBlue700.toColor(),
    tertiary = red200.toColor(),
)
private val cyanLightColorScheme = lightColorScheme(
    primary = cyan500.toColor(), secondary = cyan700.toColor(), tertiary = red200.toColor(),
)
private val tealLightColorScheme = lightColorScheme(
    primary = teal500.toColor(), secondary = teal700.toColor(), tertiary = red200.toColor(),
)
private val greenLightColorScheme = lightColorScheme(
    primary = green500.toColor(), secondary = green700.toColor(), tertiary = teal200.toColor(),
)
private val lightGreenLightColorScheme = lightColorScheme(
    primary = lightGreen500.toColor(),
    secondary = lightGreen700.toColor(),
    tertiary = teal200.toColor(),
)
private val limeLightColorScheme = lightColorScheme(
    primary = lime500.toColor(), secondary = lime700.toColor(), tertiary = teal200.toColor(),
)
private val yellowLightColorScheme = lightColorScheme(
    primary = yellow500.toColor(), secondary = yellow700.toColor(), tertiary = teal200.toColor(),
)
private val amberLightColorScheme = lightColorScheme(
    primary = amber500.toColor(), secondary = amber700.toColor(), tertiary = teal200.toColor(),
)
private val orangeLightColorScheme = lightColorScheme(
    primary = orange500.toColor(), secondary = orange700.toColor(), tertiary = teal200.toColor(),
)
private val deepOrangeLightColorScheme = lightColorScheme(
    primary = deepOrange500.toColor(),
    secondary = deepOrange700.toColor(),
    tertiary = teal200.toColor(),
)
private val brownLightColorScheme = lightColorScheme(
    primary = brown500.toColor(), secondary = brown700.toColor(), tertiary = teal200.toColor(),
)
private val greyLightColorScheme = lightColorScheme(
    primary = grey500.toColor(), secondary = grey700.toColor(), tertiary = teal200.toColor(),
)
private val blueGreyLightColorScheme = lightColorScheme(
    primary = blueGrey500.toColor(),
    secondary = blueGrey700.toColor(),
    tertiary = teal200.toColor(),
)

private fun Long.toColor() = Color(this)

@Suppress("UNUSED_VARIABLE", "UNUSED_PARAMETER")
@SuppressLint("NewApi")
fun ColorPalette.getMaterial3ColorScheme(
    context: Context,
    darkThemeMode: DarkThemeMode,
    isSystemInDarkTheme: Boolean,
): ColorScheme {
    val isDarkTheme = darkThemeMode.isDarkTheme(isSystemInDarkTheme)
    val hasDynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    return when { // todo stelios handle status bar when android 12
//        hasDynamicColor && isDarkTheme -> dynamicDarkColorScheme(context)
//        hasDynamicColor && !isDarkTheme -> dynamicLightColorScheme(context)
        else -> getMaterial3ColorSchemeInternal(isDarkTheme)
    }
}

private fun ColorPalette.getMaterial3ColorSchemeInternal(
    isDarkTheme: Boolean
): ColorScheme {
    return when (this) {
        ColorPalette.RED -> if (isDarkTheme) redDarkColorScheme else redLightColorScheme
        ColorPalette.PINK -> if (isDarkTheme) pinkDarkColorScheme else pinkLightColorScheme
        ColorPalette.PURPLE -> if (isDarkTheme) purpleDarkColorScheme else purpleLightColorScheme
        ColorPalette.DEEP_PURPLE -> if (isDarkTheme) deepPurpleDarkColorScheme else deepPurpleLightColorScheme
        ColorPalette.INDIGO -> if (isDarkTheme) indigoDarkColorScheme else indigoLightColorScheme
        ColorPalette.BLUE -> if (isDarkTheme) blueDarkColorScheme else blueLightColorScheme
        ColorPalette.LIGHT_BLUE -> if (isDarkTheme) lightBlueDarkColorScheme else lightBlueLightColorScheme
        ColorPalette.CYAN -> if (isDarkTheme) cyanDarkColorScheme else cyanLightColorScheme
        ColorPalette.TEAL -> if (isDarkTheme) tealDarkColorScheme else tealLightColorScheme
        ColorPalette.GREEN -> if (isDarkTheme) greenDarkColorScheme else greenLightColorScheme
        ColorPalette.LIGHT_GREEN -> if (isDarkTheme) lightGreenDarkColorScheme else lightGreenLightColorScheme
        ColorPalette.LIME -> if (isDarkTheme) limeDarkColorScheme else limeLightColorScheme
        ColorPalette.YELLOW -> if (isDarkTheme) yellowDarkColorScheme else yellowLightColorScheme
        ColorPalette.AMBER -> if (isDarkTheme) amberDarkColorScheme else amberLightColorScheme
        ColorPalette.ORANGE -> if (isDarkTheme) orangeDarkColorScheme else orangeLightColorScheme
        ColorPalette.DEEP_ORANGE -> if (isDarkTheme) deepOrangeDarkColorScheme else deepOrangeLightColorScheme
        ColorPalette.BROWN -> if (isDarkTheme) brownDarkColorScheme else brownLightColorScheme
        ColorPalette.GREY -> if (isDarkTheme) greyDarkColorScheme else greyLightColorScheme
        ColorPalette.BLUE_GREY -> if (isDarkTheme) blueGreyDarkColorScheme else blueGreyLightColorScheme
    }
}