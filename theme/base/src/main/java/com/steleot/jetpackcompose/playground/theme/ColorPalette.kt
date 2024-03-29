package com.steleot.jetpackcompose.playground.theme

enum class ColorPalette {
    RED,
    PINK,
    PURPLE,
    DEEP_PURPLE,
    INDIGO,
    BLUE,
    LIGHT_BLUE,
    CYAN,
    TEAL,
    GREEN,
    LIGHT_GREEN,
    LIME,
    YELLOW,
    AMBER,
    ORANGE,
    DEEP_ORANGE,
    BROWN,
    GREY,
    BLUE_GREY;

    companion object {
        fun valueOfSafe(name: String): ColorPalette =
            values().find { it.name == name } ?: DEEP_PURPLE
    }
}
