package com.steleot.jetpackcompose.playground.compose.reusable

import androidx.compose.ui.graphics.Path
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes

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

val ribbonRoutes = setOf(
    /* 4.6.0 */
    MainNavRoutes.ExternalLibraries,
    ExternalLibrariesNavRoutes.WebViewAccompanist,
    MainNavRoutes.Material,
    MaterialNavRoutes.Chip,
    MainNavRoutes.Material3,
    Material3NavRoutes.Divider3,
    Material3NavRoutes.ProgressIndicator3,
    /* 4.5.0 */
    /* 4.4.1 */
    /* 4.4.0 */
)
