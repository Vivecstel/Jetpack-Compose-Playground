package com.steleot.jetpackcompose.playground.utils

import java.util.*

fun String.capitalizeFirstLetter(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}