package com.steleot.jetpackcompose.playground.compose.materialiconsextended

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.compose.MainScreen
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.MaterialIconsExtendedNavRoutes

val routes = listOf(
    MaterialIconsExtendedNavRoutes.ExtendedFilled,
    MaterialIconsExtendedNavRoutes.ExtendedOutlined,
    MaterialIconsExtendedNavRoutes.ExtendedRounded,
    MaterialIconsExtendedNavRoutes.ExtendedSharp,
    MaterialIconsExtendedNavRoutes.ExtendedTwoTone,
)

@Composable
fun MaterialIconsExtendedScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.MaterialIConsExtended,
        list = routes,
    )
}