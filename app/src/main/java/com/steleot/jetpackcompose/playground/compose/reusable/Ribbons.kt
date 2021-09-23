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
    /* 3.0.0 */
    MainNavRoutes.ExternalLibraries,
    ExternalLibrariesNavRoutes.ComposeTimelineView,
    ExternalLibrariesNavRoutes.Plot,
    /* 2.9.4 */
    MainNavRoutes.CustomExamples,
    CustomExamplesNavRoutes.BottomRoundedArcShape,
    /* 2.9.4 */
    MainNavRoutes.Foundation,
    FoundationNavRoutes.LocalOverScrollConfiguration,
    MainNavRoutes.Ui,
    UiNavRoutes.Blur,
    UiNavRoutes.Inspectable,
    MainNavRoutes.ExternalLibraries,
    ExternalLibrariesNavRoutes.StageStepBar,
    ExternalLibrariesNavRoutes.ComposeNeumorphism,
)
