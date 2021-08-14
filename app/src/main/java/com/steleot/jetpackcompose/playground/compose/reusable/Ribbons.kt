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
    /* 2.9.0 release */
    /* 2.8.0 release */
    MainNavRoutes.Animation,
    AnimationNavRoutes.ElevationAnimation,
    AnimationNavRoutes.ScaleAnimation,
    MainNavRoutes.FoundationLayout,
    FoundationLayoutNavRoutes.MatchParentSize,
    FoundationLayoutNavRoutes.PaddingFromBaseline,
    FoundationLayoutNavRoutes.PaddingFrom,
    FoundationLayoutNavRoutes.Weight,
    MainNavRoutes.Material,
    MaterialNavRoutes.LocalAbsoluteElevation,
    MainNavRoutes.Ui,
    UiNavRoutes.LayoutId,
    /* 2.7.1 release */
)
