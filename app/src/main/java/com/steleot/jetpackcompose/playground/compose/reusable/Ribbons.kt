package com.steleot.jetpackcompose.playground.compose.reusable

import androidx.compose.ui.graphics.Path
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

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
    /* 4.0.0 */
    MainNavRoutes.Foundation,
    FoundationNavRoutes.AnimateItemPlacement,
    FoundationNavRoutes.BringIntoViewRequester,
    MainNavRoutes.ExternalLibraries,
    ExternalLibrariesNavRoutes.Gap,
    ExternalLibrariesNavRoutes.HtmlText,
    ExternalLibrariesNavRoutes.Snapper,
    MainNavRoutes.Material,
    MaterialNavRoutes.Badge,
    MaterialNavRoutes.OutlinedButton,
    MaterialNavRoutes.TextButton,
    MainNavRoutes.Material3,
    Material3NavRoutes.AlertDialog3,
    Material3NavRoutes.Badge3,
    Material3NavRoutes.BadgedBox3,
    Material3NavRoutes.Button3,
    MainNavRoutes.Ui,
    UiNavRoutes.OnPlaced,
    /* 3.3.0 */
    MainNavRoutes.Material,
    MaterialNavRoutes.ExposedDropdownMenuBox,
    /* 3.2.0 */
    MainNavRoutes.ExternalLibraries,
    ExternalLibrariesNavRoutes.ComposeParticleSystem,
    ExternalLibrariesNavRoutes.SSJetPackComposeProgressButton,
    MainNavRoutes.Ui,
    UiNavRoutes.ModifierLocal,
)
