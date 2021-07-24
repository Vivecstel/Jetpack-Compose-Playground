package com.steleot.jetpackcompose.playground.theme

import androidx.wear.compose.material.Colors

/* Material Red */
private val RedColorPalette = Colors(
    primary = red500,
    primaryVariant = red700,
    secondary = teal200,
)

/* Material Pink */
private val PinkColorPalette = Colors(
    primary = pink500,
    primaryVariant = pink700,
    secondary = teal200,
)

/* Material Purple */
private val PurpleColorPalette = Colors(
    primary = purple500,
    primaryVariant = purple700,
    secondary = teal200,
)

/* Material Deep Purple */
private val DeepPurpleColorPalette = Colors(
    primary = deepPurple500,
    primaryVariant = deepPurple700,
    secondary = teal200,
)

/* Material Indigo */
private val IndigoColorPalette = Colors(
    primary = indigo500,
    primaryVariant = indigo700,
    secondary = teal200,
)

/* Material Blue */
private val BlueColorPalette = Colors(
    primary = blue500,
    primaryVariant = blue700,
    secondary = teal200,
)

/* Material Light Blue */
private val LightBlueColorPalette = Colors(
    primary = lightBlue500,
    primaryVariant = lightBlue700,
    secondary = teal200,
)

/* Material Cyan */
private val CyanColorPalette = Colors(
    primary = cyan500,
    primaryVariant = cyan700,
    secondary = teal200,
)

/* Material Teal */
private val TealColorPalette = Colors(
    primary = teal500,
    primaryVariant = teal700,
    secondary = teal200,
)

/* Material Green */
private val GreenColorPalette = Colors(
    primary = green500,
    primaryVariant = green700,
    secondary = teal200,
)

/* Material Light Green */
private val LightGreenColorPalette = Colors(
    primary = lightGreen500,
    primaryVariant = lightGreen700,
    secondary = teal200,
)

/* Material Lime */
private val LimeColorPalette = Colors(
    primary = lime500,
    primaryVariant = lime700,
    secondary = teal200,
)

/* Material Yellow */
private val YellowColorPalette = Colors(
    primary = yellow500,
    primaryVariant = yellow700,
    secondary = teal200,
)

/* Material Amber */
private val AmberColorPalette = Colors(
    primary = amber500,
    primaryVariant = amber700,
    secondary = teal200,
)

/* Material Orange */
private val OrangeColorPalette = Colors(
    primary = orange500,
    primaryVariant = orange700,
    secondary = teal200,
)

/* Material Deep Orange */
private val DeepOrangeColorPalette = Colors(
    primary = deepOrange500,
    primaryVariant = deepOrange700,
    secondary = teal200,
)

/* Material Brown */
private val BrownColorPalette = Colors(
    primary = brown500,
    primaryVariant = brown700,
    secondary = teal200,
)

/* Material Grey */
private val GreyColorPalette = Colors(
    primary = grey500,
    primaryVariant = grey700,
    secondary = teal200,
)

/* Material Blue Grey */
private val BlueGreyColorPalette = Colors(
    primary = blueGrey500,
    primaryVariant = blueGrey700,
    secondary = teal200,
)

fun ColorPalette.getMaterialColors(): Colors {
    return when (this) {
        ColorPalette.RED -> RedColorPalette
        ColorPalette.PINK -> PinkColorPalette
        ColorPalette.PURPLE -> PurpleColorPalette
        ColorPalette.DEEP_PURPLE -> DeepPurpleColorPalette
        ColorPalette.INDIGO -> IndigoColorPalette
        ColorPalette.BLUE -> BlueColorPalette
        ColorPalette.LIGHT_BLUE -> LightBlueColorPalette
        ColorPalette.CYAN -> CyanColorPalette
        ColorPalette.TEAL -> TealColorPalette
        ColorPalette.GREEN -> GreenColorPalette
        ColorPalette.LIGHT_GREEN -> LightGreenColorPalette
        ColorPalette.LIME -> LimeColorPalette
        ColorPalette.YELLOW -> YellowColorPalette
        ColorPalette.AMBER -> AmberColorPalette
        ColorPalette.ORANGE -> OrangeColorPalette
        ColorPalette.DEEP_ORANGE -> DeepOrangeColorPalette
        ColorPalette.BROWN -> BrownColorPalette
        ColorPalette.GREY -> GreyColorPalette
        ColorPalette.BLUE_GREY -> BlueGreyColorPalette
    }
}