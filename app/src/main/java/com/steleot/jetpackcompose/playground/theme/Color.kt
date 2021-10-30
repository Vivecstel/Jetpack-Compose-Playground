package com.steleot.jetpackcompose.playground.theme

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
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
            surface = red200,
        ) else lightColors(
            primary = red500,
            primaryVariant = red700,
            secondary = teal200,
            surface = red500,
        )
        ColorPalette.PINK -> if (isDarkTheme) darkColors(
            primary = pink200,
            primaryVariant = pink500,
            secondary = teal200,
            surface = pink200,
        ) else lightColors(
            primary = pink500,
            primaryVariant = pink700,
            secondary = teal200,
            surface = pink500,
        )
        ColorPalette.PURPLE -> if (isDarkTheme) darkColors(
            primary = purple200,
            primaryVariant = purple500,
            secondary = teal200,
            surface = purple200,
        ) else lightColors(
            primary = purple500,
            primaryVariant = purple700,
            secondary = teal200,
            surface = purple500,
        )
        ColorPalette.DEEP_PURPLE -> if (isDarkTheme)
            darkColors(
                primary = deepPurple200,
                primaryVariant = deepPurple500,
                secondary = teal200,
                surface = deepPurple200,
            )
        else lightColors(
            primary = deepPurple500,
            primaryVariant = deepPurple700,
            secondary = teal200,
            surface = deepPurple500,
        )
        ColorPalette.INDIGO -> if (isDarkTheme) darkColors(
            primary = indigo200,
            primaryVariant = indigo500,
            secondary = teal200,
            surface = indigo200,
        ) else lightColors(
            primary = indigo500,
            primaryVariant = indigo700,
            secondary = teal200,
            surface = indigo500,
        )
        ColorPalette.BLUE -> if (isDarkTheme) darkColors(
            primary = blue200,
            primaryVariant = blue500,
            secondary = red200,
            surface = blue200,
        ) else lightColors(
            primary = blue500,
            primaryVariant = blue700,
            secondary = red200,
            surface = blue500,
        )
        ColorPalette.LIGHT_BLUE -> if (isDarkTheme) darkColors(
            primary = lightBlue200,
            primaryVariant = lightBlue500,
            secondary = red200,
            surface = lightBlue200,
        ) else lightColors(
            primary = lightBlue500,
            primaryVariant = lightBlue700,
            secondary = red200,
            surface = lightBlue500,
        )
        ColorPalette.CYAN -> if (isDarkTheme) darkColors(
            primary = cyan200,
            primaryVariant = cyan500,
            secondary = red200,
            surface = cyan200,
        ) else lightColors(
            primary = cyan500,
            primaryVariant = cyan700,
            secondary = red200,
            surface = cyan500,
        )
        ColorPalette.TEAL -> if (isDarkTheme) darkColors(
            primary = teal200,
            primaryVariant = teal500,
            secondary = red200,
            surface = teal200,
        ) else lightColors(
            primary = teal500,
            primaryVariant = teal700,
            secondary = red200,
            surface = teal500,
        )
        ColorPalette.GREEN -> if (isDarkTheme) darkColors(
            primary = green200,
            primaryVariant = green500,
            secondary = teal200,
            surface = green200,
        ) else lightColors(
            primary = green500,
            primaryVariant = green700,
            secondary = teal200,
            surface = green500,
        )
        ColorPalette.LIGHT_GREEN -> if (isDarkTheme) darkColors(
            primary = lightGreen200,
            primaryVariant = lightGreen500,
            secondary = teal200,
            surface = lightGreen200,
        ) else lightColors(
            primary = lightGreen500,
            primaryVariant = lightGreen700,
            secondary = teal200,
            surface = lightGreen500,
        )
        ColorPalette.LIME -> if (isDarkTheme) darkColors(
            primary = lime200,
            primaryVariant = lime500,
            secondary = teal200,
            surface = lime200,
        ) else lightColors(
            primary = lime500,
            primaryVariant = lime700,
            secondary = teal200,
            surface = lime500,
        )
        ColorPalette.YELLOW -> if (isDarkTheme) darkColors(
            primary = yellow200,
            primaryVariant = yellow500,
            secondary = teal200,
            surface = yellow200,
        ) else lightColors(
            primary = yellow500,
            primaryVariant = yellow700,
            secondary = teal200,
            surface = yellow500,
        )
        ColorPalette.AMBER -> if (isDarkTheme) darkColors(
            primary = amber200,
            primaryVariant = amber500,
            secondary = teal200,
            surface = amber200,
        ) else lightColors(
            primary = amber500,
            primaryVariant = amber700,
            secondary = teal200,
            surface = amber500,
        )
        ColorPalette.ORANGE -> if (isDarkTheme) darkColors(
            primary = orange200,
            primaryVariant = orange500,
            secondary = teal200,
            surface = orange200,
        ) else lightColors(
            primary = orange500,
            primaryVariant = orange700,
            secondary = teal200,
            surface = orange500,
        )
        ColorPalette.DEEP_ORANGE -> if (isDarkTheme) darkColors(
            primary = deepOrange200,
            primaryVariant = deepOrange500,
            secondary = teal200,
            surface = deepOrange200,
        ) else lightColors(
            primary = deepOrange500,
            primaryVariant = deepOrange700,
            secondary = teal200,
            surface = deepOrange500,
        )
        ColorPalette.BROWN -> if (isDarkTheme) darkColors(
            primary = brown200,
            primaryVariant = brown500,
            secondary = teal200,
            surface = brown200,
        ) else lightColors(
            primary = brown500,
            primaryVariant = brown700,
            secondary = teal200,
            surface = brown500,
        )
        ColorPalette.GREY -> if (isDarkTheme) darkColors(
            primary = grey200,
            primaryVariant = grey500,
            secondary = teal200,
            surface = grey200,
        ) else lightColors(
            primary = grey500,
            primaryVariant = grey700,
            secondary = teal200,
            surface = grey500,
        )
        ColorPalette.BLUE_GREY -> if (isDarkTheme) darkColors(
            primary = blueGrey200,
            primaryVariant = blueGrey500,
            secondary = teal200,
            surface = blueGrey200,
        ) else lightColors(
            primary = blueGrey500,
            primaryVariant = blueGrey700,
            secondary = teal200,
            surface = blueGrey500,
        )
    }
}

@SuppressLint("NewApi")
fun ColorPalette.getMaterial3ColorScheme(
    context: Context,
    darkThemeMode: DarkThemeMode,
    isSystemInDarkTheme: Boolean,
): ColorScheme {
    val isDarkTheme = isDarkTheme(darkThemeMode, isSystemInDarkTheme)
    val hasDynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    return when {
        hasDynamicColor && isDarkTheme -> dynamicDarkColorScheme(context)
        hasDynamicColor && !isDarkTheme -> dynamicLightColorScheme(context)
        else -> getMaterial3ColorSchemeInternal(isDarkTheme)
    }
}

private fun ColorPalette.getMaterial3ColorSchemeInternal(
    isDarkTheme: Boolean
): ColorScheme {
    return when (this) {
        ColorPalette.RED -> if (isDarkTheme) RedDarkColorScheme else RedLightColorScheme
        ColorPalette.PINK -> if (isDarkTheme) PinkDarkColorScheme else PinkLightColorScheme
        ColorPalette.PURPLE -> if (isDarkTheme) PurpleDarkColorScheme else PurpleLightColorScheme
        ColorPalette.DEEP_PURPLE -> if (isDarkTheme) DeepPurpleDarkColorScheme else DeepPurpleLightColorScheme
        ColorPalette.INDIGO -> if (isDarkTheme) IndigoDarkColorScheme else IndigoLightColorScheme
        ColorPalette.BLUE -> if (isDarkTheme) BlueDarkColorScheme else BlueLightColorScheme
        ColorPalette.LIGHT_BLUE -> if (isDarkTheme) LightBlueDarkColorScheme else LightBlueLightColorScheme
        ColorPalette.CYAN -> if (isDarkTheme) CyanDarkColorScheme else CyanLightColorScheme
        ColorPalette.TEAL -> if (isDarkTheme) TealDarkColorScheme else TealLightColorScheme
        ColorPalette.GREEN -> if (isDarkTheme) GreenDarkColorScheme else GreenLightColorScheme
        ColorPalette.LIGHT_GREEN -> if (isDarkTheme) LightGreenDarkColorScheme else LightGreenLightColorScheme
        ColorPalette.LIME -> if (isDarkTheme) LimeDarkColorScheme else LimeLightColorScheme
        ColorPalette.YELLOW -> if (isDarkTheme) YellowDarkColorScheme else YellowLightColorScheme
        ColorPalette.AMBER -> if (isDarkTheme) AmberDarkColorScheme else AmberLightColorScheme
        ColorPalette.ORANGE -> if (isDarkTheme) OrangeDarkColorScheme else OrangeLightColorScheme
        ColorPalette.DEEP_ORANGE -> if (isDarkTheme) DeepOrangeDarkColorScheme else DeepOrangeLightColorScheme
        ColorPalette.BROWN -> if (isDarkTheme) BrownDarkColorScheme else BrownLightColorScheme
        ColorPalette.GREY -> if (isDarkTheme) GreyDarkColorScheme else GreyLightColorScheme
        ColorPalette.BLUE_GREY -> if (isDarkTheme) BlueGreyDarkColorScheme else BlueGreyLightColorScheme
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
