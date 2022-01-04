package com.steleot.jetpackcompose.playground.compose.reusable

import androidx.compose.ui.graphics.Path

fun getRibbonPath(
    width: Float,
    height: Float,
) = Path().apply {
    lineTo(0f, height)
    lineTo(width / 2, height / 2)
    lineTo(width, height)
    lineTo(width, 0f)
    close()
}

val ribbonRoutes = setOf<String>(
    /* 4.4.1 */
    /* 4.4.0 */
    /* 4.3.1 */
    /* 4.3.0 */
)
