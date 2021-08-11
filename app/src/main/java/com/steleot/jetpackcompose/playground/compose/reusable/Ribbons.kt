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

val ribbonRoutes = listOf(
    /* 2.7.1 release */
    /* 2.7.0 release */
    MainNavRoutes.Activity,
    ActivityNavRoutes.LauncherForActivityResult1,
    ActivityNavRoutes.LauncherForActivityResult2,
    MainNavRoutes.CustomExamples,
    CustomExamplesNavRoutes.StyledText,
    MainNavRoutes.FoundationLayout,
    FoundationLayoutNavRoutes.DefaultMinSize,
    /* 2.6.0 release */
    MainNavRoutes.ConstraintLayout,
    ConstraintLayoutNavRoutes.Circular,
    ConstraintLayoutNavRoutes.CreateGuideline,
    ConstraintLayoutNavRoutes.JsonConstraintSet,
    ConstraintLayoutNavRoutes.JsonConstraintSetWithVariables,
    ConstraintLayoutNavRoutes.MotionLayout1,
    ConstraintLayoutNavRoutes.MotionLayout2,
    ConstraintLayoutNavRoutes.MotionLayout3,
)
