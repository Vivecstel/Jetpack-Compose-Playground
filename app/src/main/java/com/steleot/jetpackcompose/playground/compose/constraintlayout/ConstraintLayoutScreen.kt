package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
import com.steleot.jetpackcompose.playground.navigation.graph.ConstraintLayoutNavRoutes
import com.steleot.jetpackcompose.playground.navigation.graph.MainNavRoutes

val routes = listOf(
    ConstraintLayoutNavRoutes.Barrier,
    ConstraintLayoutNavRoutes.Chain,
    ConstraintLayoutNavRoutes.Circular,
    ConstraintLayoutNavRoutes.ConstraintGridDsl,
    ConstraintLayoutNavRoutes.ConstraintHorizontalFlow,
    ConstraintLayoutNavRoutes.ConstraintSet,
    ConstraintLayoutNavRoutes.ConstraintVerticalFlow,
    ConstraintLayoutNavRoutes.CreateGuideline,
    ConstraintLayoutNavRoutes.CreateRefs,
    ConstraintLayoutNavRoutes.JsonConstraintSet,
    ConstraintLayoutNavRoutes.JsonConstraintSetWithVariables,
    ConstraintLayoutNavRoutes.MotionLayout1,
    ConstraintLayoutNavRoutes.MotionLayout2,
    ConstraintLayoutNavRoutes.MotionLayout3,
)

@Composable
fun ConstraintLayoutScreen() {
    MainScreen(
        title = MainNavRoutes.ConstraintLayout,
        list = routes,
    )
}