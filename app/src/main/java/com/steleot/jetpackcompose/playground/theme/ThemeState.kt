package com.steleot.jetpackcompose.playground.theme

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ThemeState(
    var colorPalette: ColorPalette = ColorPalette.DEEP_PURPLE,
    var isDarkTheme: Boolean = false,
) : Parcelable