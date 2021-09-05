package com.steleot.jetpackcompose.playground.utils

import java.text.SimpleDateFormat
import java.util.*

val Date?.monthDate: String?
    get() {
        this?.let {
            val df = SimpleDateFormat("MMMM yyyy", Locale.getDefault())
            return df.format(it)
        }
        return null
    }