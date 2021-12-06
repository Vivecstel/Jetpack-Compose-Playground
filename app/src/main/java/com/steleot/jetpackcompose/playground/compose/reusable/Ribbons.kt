package com.steleot.jetpackcompose.playground.compose.reusable

import androidx.compose.ui.graphics.Path
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes

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
    /* 4.2.1 */
    /* 4.2.0 */
    MainNavRoutes.Material3,
    Material3NavRoutes.Checkbox3,
    Material3NavRoutes.RadioButton3,
    /* 4.1.0 */
    MainNavRoutes.ExternalLibraries,
    ExternalLibrariesNavRoutes.ComposeShimmer,
    ExternalLibrariesNavRoutes.ComposeTreeMap,
    ExternalLibrariesNavRoutes.ZoomableComposeImage,
)
