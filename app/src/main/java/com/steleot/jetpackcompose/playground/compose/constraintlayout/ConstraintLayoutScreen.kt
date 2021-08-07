package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.compose.MainScreen
import com.steleot.jetpackcompose.playground.navigation.ConstraintLayoutNavRoutes
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes

val routes = listOf(
    ConstraintLayoutNavRoutes.Barrier,
    ConstraintLayoutNavRoutes.Chain,
    ConstraintLayoutNavRoutes.Circular,
    ConstraintLayoutNavRoutes.ConstraintSet,
    ConstraintLayoutNavRoutes.CreateGuideline,
    ConstraintLayoutNavRoutes.CreateRefs,
    ConstraintLayoutNavRoutes.JsonConstraintSet,
    ConstraintLayoutNavRoutes.JsonConstraintSetWithVariables,
    ConstraintLayoutNavRoutes.MotionLayout1,
    ConstraintLayoutNavRoutes.MotionLayout2,
    ConstraintLayoutNavRoutes.MotionLayout3,
)

@Composable
fun ConstraintLayoutScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.ConstraintLayout,
        list = routes,
        showBackArrow = true,
    )
}