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
    /* 2.9.2 release */
    /* 2.9.1 release */
    /* 2.9.0 release */
    MainNavRoutes.ExternalLibraries,
    ExternalLibrariesNavRoutes.PaletteLandscapist,
    MainNavRoutes.Foundation,
    FoundationNavRoutes.ProgressSemantics,
    MainNavRoutes.FoundationLayout,
    FoundationLayoutNavRoutes.AbsolutePadding,
    MainNavRoutes.Ui,
    UiNavRoutes.PointerInput,
)
