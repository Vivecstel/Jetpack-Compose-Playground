package com.steleot.jetpackcompose.playground.compose.materialicons

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
import com.steleot.jetpackcompose.playground.navigation.graph.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialIconsNavRoutes

val routes = listOf(
    MaterialIconsNavRoutes.Filled,
    MaterialIconsNavRoutes.Outlined,
    MaterialIconsNavRoutes.Rounded,
    MaterialIconsNavRoutes.Sharp,
    MaterialIconsNavRoutes.TwoTone,
)

@Composable
fun MaterialIconsScreen() {
    MainScreen(
        title = MainNavRoutes.MaterialIcons,
        list = routes,
    )
}