package com.steleot.jetpackcompose.playground.theme

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color

fun ColorPalette.getMaterialColors(
    darkThemeMode: DarkThemeMode,
    isSystemInDarkTheme: Boolean,
): Colors {
    val isDarkTheme = isDarkTheme(darkThemeMode, isSystemInDarkTheme)
    return when (this) {
        ColorPalette.RED -> if (isDarkTheme) darkColors(
            primary = red200,
            primaryVariant = red500,
            secondary = teal200,
        ) else lightColors(
            primary = red500,
            primaryVariant = red700,
            secondary = teal200,
        )
        ColorPalette.PINK -> if (isDarkTheme) darkColors(
            primary = pink200,
            primaryVariant = pink500,
            secondary = teal200,
        ) else lightColors(
            primary = pink500,
            primaryVariant = pink700,
            secondary = teal200,
        )
        ColorPalette.PURPLE -> if (isDarkTheme) darkColors(
            primary = purple200,
            primaryVariant = purple500,
            secondary = teal200,
        ) else lightColors(
            primary = purple500,
            primaryVariant = purple700,
            secondary = teal200,
        )
        ColorPalette.DEEP_PURPLE -> if (isDarkTheme)
            darkColors(
                primary = deepPurple200,
                primaryVariant = deepPurple500,
                secondary = teal200,
            )
        else lightColors(
            primary = deepPurple500,
            primaryVariant = deepPurple700,
            secondary = teal200,
        )
        ColorPalette.INDIGO -> if (isDarkTheme) darkColors(
            primary = indigo200,
            primaryVariant = indigo500,
            secondary = teal200,
        ) else lightColors(
            primary = indigo500,
            primaryVariant = indigo700,
            secondary = teal200,
        )
        ColorPalette.BLUE -> if (isDarkTheme) darkColors(
            primary = blue200,
            primaryVariant = blue500,
            secondary = red200,
        ) else lightColors(
            primary = blue500,
            primaryVariant = blue700,
            secondary = red200,
        )
        ColorPalette.LIGHT_BLUE -> if (isDarkTheme) darkColors(
            primary = lightBlue200,
            primaryVariant = lightBlue500,
            secondary = red200,
        ) else lightColors(
            primary = lightBlue500,
            primaryVariant = lightBlue700,
            secondary = red200,
        )
        ColorPalette.CYAN -> if (isDarkTheme) darkColors(
            primary = cyan200,
            primaryVariant = cyan500,
            secondary = red200,
        ) else lightColors(
            primary = cyan500,
            primaryVariant = cyan700,
            secondary = red200,
        )
        ColorPalette.TEAL -> if (isDarkTheme) darkColors(
            primary = teal200,
            primaryVariant = teal500,
            secondary = red200,
        ) else lightColors(
            primary = teal500,
            primaryVariant = teal700,
            secondary = red200,
        )
        ColorPalette.GREEN -> if (isDarkTheme) darkColors(
            primary = green200,
            primaryVariant = green500,
            secondary = teal200,
        ) else lightColors(
            primary = green500,
            primaryVariant = green700,
            secondary = teal200,
        )
        ColorPalette.LIGHT_GREEN -> if (isDarkTheme) darkColors(
            primary = lightGreen200,
            primaryVariant = lightGreen500,
            secondary = teal200,
        ) else lightColors(
            primary = lightGreen500,
            primaryVariant = lightGreen700,
            secondary = teal200,
        )
        ColorPalette.LIME -> if (isDarkTheme) darkColors(
            primary = lime200,
            primaryVariant = lime500,
            secondary = teal200,
        ) else lightColors(
            primary = lime500,
            primaryVariant = lime700,
            secondary = teal200,
        )
        ColorPalette.YELLOW -> if (isDarkTheme) darkColors(
            primary = yellow200,
            primaryVariant = yellow500,
            secondary = teal200,
        ) else lightColors(
            primary = yellow500,
            primaryVariant = yellow700,
            secondary = teal200,
        )
        ColorPalette.AMBER -> if (isDarkTheme) darkColors(
            primary = amber200,
            primaryVariant = amber500,
            secondary = teal200,
        ) else lightColors(
            primary = amber500,
            primaryVariant = amber700,
            secondary = teal200,
        )
        ColorPalette.ORANGE -> if (isDarkTheme) darkColors(
            primary = orange200,
            primaryVariant = orange500,
            secondary = teal200,
        ) else lightColors(
            primary = orange500,
            primaryVariant = orange700,
            secondary = teal200,
        )
        ColorPalette.DEEP_ORANGE -> if (isDarkTheme) darkColors(
            primary = deepOrange200,
            primaryVariant = deepOrange500,
            secondary = teal200,
        ) else lightColors(
            primary = deepOrange500,
            primaryVariant = deepOrange700,
            secondary = teal200,
        )
        ColorPalette.BROWN -> if (isDarkTheme) darkColors(
            primary = brown200,
            primaryVariant = brown500,
            secondary = teal200,
        ) else lightColors(
            primary = brown500,
            primaryVariant = brown700,
            secondary = teal200,
        )
        ColorPalette.GREY -> if (isDarkTheme) darkColors(
            primary = grey200,
            primaryVariant = grey500,
            secondary = teal200,
        ) else lightColors(
            primary = grey500,
            primaryVariant = grey700,
            secondary = teal200,
        )
        ColorPalette.BLUE_GREY -> if (isDarkTheme) darkColors(
            primary = blueGrey200,
            primaryVariant = blueGrey500,
            secondary = teal200,
        ) else lightColors(
            primary = blueGrey500,
            primaryVariant = blueGrey700,
            secondary = teal200,
        )
    }
}

@Suppress("UNUSED_VARIABLE", "UNUSED_PARAMETER")
@SuppressLint("NewApi")
fun ColorPalette.getMaterial3ColorScheme(
    context: Context,
    darkThemeMode: DarkThemeMode,
    isSystemInDarkTheme: Boolean,
): ColorScheme {
    val isDarkTheme = isDarkTheme(darkThemeMode, isSystemInDarkTheme)
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
        ColorPalette.RED -> if (isDarkTheme) darkColorScheme(
            primary = red200,
            secondary = red500,
            tertiary = teal200,
        ) else lightColorScheme(
            primary = red500,
            secondary = red700,
            tertiary = teal200,
        )
        ColorPalette.PINK -> if (isDarkTheme) darkColorScheme(
            primary = pink200,
            secondary = pink500,
            tertiary = teal200,
        ) else lightColorScheme(
            primary = pink500,
            secondary = pink700,
            tertiary = teal200,
        )
        ColorPalette.PURPLE -> if (isDarkTheme) darkColorScheme(
            primary = purple200,
            secondary = purple500,
            tertiary = teal200,
        ) else lightColorScheme(
            primary = purple500,
            secondary = purple700,
            tertiary = teal200,
        )
        ColorPalette.DEEP_PURPLE -> if (isDarkTheme) darkColorScheme(
            primary = deepPurple200,
            secondary = deepPurple500,
            tertiary = teal200,
        ) else lightColorScheme(
            primary = deepPurple500,
            secondary = deepPurple700,
            tertiary = teal200,
        )
        ColorPalette.INDIGO -> if (isDarkTheme) darkColorScheme(
            primary = indigo200,
            secondary = indigo500,
            tertiary = teal200,
        ) else lightColorScheme(
            primary = indigo500,
            secondary = indigo700,
            tertiary = teal200,
        )
        ColorPalette.BLUE -> if (isDarkTheme) darkColorScheme(
            primary = blue200,
            secondary = blue500,
            tertiary = red200,
        ) else lightColorScheme(
            primary = blue500,
            secondary = blue700,
            tertiary = red200,
        )
        ColorPalette.LIGHT_BLUE -> if (isDarkTheme) darkColorScheme(
            primary = lightBlue200,
            secondary = lightBlue500,
            tertiary = red200,
        ) else lightColorScheme(
            primary = lightBlue500,
            secondary = lightBlue700,
            tertiary = red200,
        )
        ColorPalette.CYAN -> if (isDarkTheme) darkColorScheme(
            primary = cyan200,
            secondary = cyan500,
            tertiary = red200,
        ) else lightColorScheme(
            primary = cyan500,
            secondary = cyan700,
            tertiary = red200,
        )
        ColorPalette.TEAL -> if (isDarkTheme) darkColorScheme(
            primary = teal200,
            secondary = teal500,
            tertiary = red200,
        ) else lightColorScheme(
            primary = teal500,
            secondary = teal700,
            tertiary = red200,
        )
        ColorPalette.GREEN -> if (isDarkTheme) darkColorScheme(
            primary = green200,
            secondary = green500,
            tertiary = teal200,
        ) else lightColorScheme(
            primary = green500,
            secondary = green700,
            tertiary = teal200,
        )
        ColorPalette.LIGHT_GREEN -> if (isDarkTheme) darkColorScheme(
            primary = lightGreen200,
            secondary = lightGreen500,
            tertiary = teal200,
        ) else lightColorScheme(
            primary = lightGreen500,
            secondary = lightGreen700,
            tertiary = teal200,
        )
        ColorPalette.LIME -> if (isDarkTheme) darkColorScheme(
            primary = lime200,
            secondary = lime500,
            tertiary = teal200,
        ) else lightColorScheme(
            primary = lime500,
            secondary = lime700,
            tertiary = teal200,
        )
        ColorPalette.YELLOW -> if (isDarkTheme) darkColorScheme(
            primary = yellow200,
            secondary = yellow500,
            tertiary = teal200,
        ) else lightColorScheme(
            primary = yellow500,
            secondary = yellow700,
            tertiary = teal200,
        )
        ColorPalette.AMBER -> if (isDarkTheme) darkColorScheme(
            primary = amber200,
            secondary = amber500,
            tertiary = teal200,
        ) else lightColorScheme(
            primary = amber500,
            secondary = amber700,
            tertiary = teal200,
        )
        ColorPalette.ORANGE -> if (isDarkTheme) darkColorScheme(
            primary = orange200,
            secondary = orange500,
            tertiary = teal200,
        ) else lightColorScheme(
            primary = orange500,
            secondary = orange700,
            tertiary = teal200,
        )
        ColorPalette.DEEP_ORANGE -> if (isDarkTheme) darkColorScheme(
            primary = deepOrange200,
            secondary = deepOrange500,
            tertiary = teal200,
        ) else lightColorScheme(
            primary = deepOrange500,
            secondary = deepOrange700,
            tertiary = teal200,
        )
        ColorPalette.BROWN -> if (isDarkTheme) darkColorScheme(
            primary = brown200,
            secondary = brown500,
            tertiary = teal200,
        ) else lightColorScheme(
            primary = brown500,
            secondary = brown700,
            tertiary = teal200,
        )
        ColorPalette.GREY -> if (isDarkTheme) darkColorScheme(
            primary = grey200,
            secondary = grey500,
            tertiary = teal200,
        ) else lightColorScheme(
            primary = grey500,
            secondary = grey700,
            tertiary = teal200,
        )
        ColorPalette.BLUE_GREY -> if (isDarkTheme) darkColorScheme(
            primary = blueGrey200,
            secondary = blueGrey500,
            tertiary = teal200,
        ) else lightColorScheme(
            primary = blueGrey500,
            secondary = blueGrey700,
            tertiary = teal200,
        )
    }
}

fun isDarkTheme(
    darkThemeMode: DarkThemeMode,
    isSystemInDarkTheme: Boolean,
): Boolean {
    return when (darkThemeMode) {
        DarkThemeMode.SYSTEM -> isSystemInDarkTheme
        DarkThemeMode.DARK -> true
        DarkThemeMode.LIGHT -> false
    }
}

val colors = listOf(
    Color(0xFFffd7d7.toInt()),
    Color(0xFFffe9d6.toInt()),
    Color(0xFFfffbd0.toInt()),
    Color(0xFFe3ffd9.toInt()),
    Color(0xFFd0fff8.toInt())
)
