package com.steleot.jetpackcompose.playground.compose.reusable

import androidx.compose.ui.graphics.Path
import com.steleot.jetpackcompose.playground.navigation.*

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
    /* 4.9.0 */
    MainNavRoutes.Ui,
    UiNavRoutes.LocalFontFamilyResolver,
    /* 4.8.0 */
    MainNavRoutes.Material3,
    Material3NavRoutes.Card3,
    Material3NavRoutes.DropdownMenu3,
    Material3NavRoutes.ElevatedCard,
    Material3NavRoutes.OutlinedCard,
    MainNavRoutes.Runtime,
    RuntimeNavRoutes.MovableContentOf,
    /* 4.7.0 */
    MainNavRoutes.ExternalLibraries,
    ExternalLibrariesNavRoutes.GoogleMaps,
)
