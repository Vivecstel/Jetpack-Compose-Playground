package com.steleot.jetpackcompose.playground.compose.reusable

import androidx.compose.ui.graphics.Path
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
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
    /* 2.9.3 release */
    MainNavRoutes.Foundation,
    FoundationNavRoutes.LocalOverScrollConfiguration,
    MainNavRoutes.Ui,
    UiNavRoutes.Blur,
    UiNavRoutes.Inspectable,
    MainNavRoutes.ExternalLibraries,
    ExternalLibrariesNavRoutes.StageStepBar,
    ExternalLibrariesNavRoutes.ComposeNeumorphism,
    /* 2.9.2 release */
    /* 2.9.1 release */
)
