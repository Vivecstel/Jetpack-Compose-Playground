package com.steleot.jetpackcompose.playground.compose.constraintlayout

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.ConstraintLayoutNavRoutes
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen
import java.util.Locale

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
        title = MainNavRoutes.ConstraintLayout.capitalize(Locale.getDefault()),
        list = routes,
        showBackArrow = true,
    )
}