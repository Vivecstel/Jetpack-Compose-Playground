package com.steleot.jetpackcompose.playground.compose.materialicons

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.MaterialIconsNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen
import java.util.Locale

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
        title = MainNavRoutes.MaterialIcons.capitalize(Locale.getDefault()),
        list = routes,
        showBackArrow = true
    )
}