package com.steleot.jetpackcompose.playground.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

val Date?.monthDate: String?
    get() = this.toPresentableString("MMMM yyyy")

val Date?.releaseString: String?
    get() = this.toPresentableString("dd/MM/yyyy")

private fun Date?.toPresentableString(
    pattern: String
): String? {
    this?.let {
        val df = SimpleDateFormat(pattern, Locale.getDefault())
        return df.format(it)
    }
    return null
}