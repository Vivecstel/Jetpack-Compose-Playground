package com.steleot.jetpackcompose.playground.compose.activity

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.ActivityNavRoutes
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen
import java.util.Locale

val routes = listOf(
    ActivityNavRoutes.BackHandler,
    ActivityNavRoutes.LauncherForActivityResult,
)

@Composable
fun ActivityScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.Activity.capitalize(Locale.getDefault()),
        list = routes,
        showBackArrow = true,
    )
}
