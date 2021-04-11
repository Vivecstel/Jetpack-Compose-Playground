package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.ConstraintLayoutNavRoutes
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen

val routes = listOf(
    ConstraintLayoutNavRoutes.Barrier,
    ConstraintLayoutNavRoutes.Chain,
    ConstraintLayoutNavRoutes.ConstraintSet,
    ConstraintLayoutNavRoutes.CreateRefs,
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