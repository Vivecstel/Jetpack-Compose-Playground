package com.steleot.jetpackcompose.playground.compose.reusable

import androidx.compose.ui.graphics.Path
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.navigation.RuntimeNavRoutes

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
    /* 4.6.0 */
    MainNavRoutes.ExternalLibraries,
    ExternalLibrariesNavRoutes.WebViewAccompanist,
    MainNavRoutes.Material,
    MaterialNavRoutes.Chip,
    MainNavRoutes.Material3,
    Material3NavRoutes.Divider3,
    Material3NavRoutes.ProgressIndicator3,
)
