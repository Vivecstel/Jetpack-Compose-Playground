package com.steleot.jetpackcompose.playground.compose.materialiconsextended

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.MaterialIconsExtendedNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen
import java.util.*

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
        title = MainNavRoutes.MaterialIConsExtended.capitalize(Locale.getDefault()),
        list = routes,
        showBackArrow = true
    )
}