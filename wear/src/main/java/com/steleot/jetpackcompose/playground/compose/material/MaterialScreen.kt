package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.compose.MainScreen
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes

val routes = listOf(
    MaterialNavRoutes.AppCard,
    MaterialNavRoutes.Button,
    MaterialNavRoutes.Card,
    MaterialNavRoutes.Chip,
    MaterialNavRoutes.CompatButton,
    MaterialNavRoutes.CompatChip,
    MaterialNavRoutes.SplitToggleChip,
    MaterialNavRoutes.ToggleButton,
    MaterialNavRoutes.ToggleChip,
)

@Composable
fun MaterialScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        list = routes,
    )
}
