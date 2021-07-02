package com.steleot.jetpackcompose.playground.compose.materialicons

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.compose.MainScreen
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.MaterialIconsNavRoutes

val routes = listOf(
    MaterialIconsNavRoutes.Filled,
    MaterialIconsNavRoutes.Outlined,
    MaterialIconsNavRoutes.Rounded,
    MaterialIconsNavRoutes.Sharp,
    MaterialIconsNavRoutes.TwoTone,
)

@Composable
fun MaterialIconsScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.MaterialIcons,
        list = routes,
        showBackArrow = true
    )
}