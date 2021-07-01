package com.steleot.jetpackcompose.playground.theme

data class ThemeState(
    var pallete: ColorPallete = ColorPallete.DEEP_PURPLE,
    var isDarkTheme: Boolean = false,
)