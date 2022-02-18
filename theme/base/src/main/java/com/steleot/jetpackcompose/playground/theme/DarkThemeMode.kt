package com.steleot.jetpackcompose.playground.theme

enum class DarkThemeMode {
    SYSTEM,
    LIGHT,
    DARK;

    companion object {
        fun valueOfSafe(name: String): DarkThemeMode = values().find { it.name == name } ?: SYSTEM
    }
}