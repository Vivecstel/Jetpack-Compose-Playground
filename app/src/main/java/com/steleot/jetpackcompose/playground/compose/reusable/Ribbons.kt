package com.steleot.jetpackcompose.playground.compose.reusable

import androidx.compose.ui.graphics.Path
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
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
    /* 3.3.0 */
    MainNavRoutes.Material,
    MaterialNavRoutes.ExposedDropdownMenuBox,
    /* 3.2.0 */
    MainNavRoutes.ExternalLibraries,
    ExternalLibrariesNavRoutes.ComposeParticleSystem,
    ExternalLibrariesNavRoutes.SSJetPackComposeProgressButton,
    MainNavRoutes.Ui,
    UiNavRoutes.ModifierLocal,
    /* 3.1.0 */
)
