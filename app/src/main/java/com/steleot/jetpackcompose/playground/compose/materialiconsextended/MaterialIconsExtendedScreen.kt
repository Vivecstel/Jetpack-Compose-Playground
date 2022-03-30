package com.steleot.jetpackcompose.playground.compose.materialiconsextended

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
import com.steleot.jetpackcompose.playground.navigation.graph.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialIconsExtendedNavRoutes

val routes = listOf(
    MaterialIconsExtendedNavRoutes.ExtendedFilled,
    MaterialIconsExtendedNavRoutes.ExtendedOutlined,
    MaterialIconsExtendedNavRoutes.ExtendedRounded,
    MaterialIconsExtendedNavRoutes.ExtendedSharp,
    MaterialIconsExtendedNavRoutes.ExtendedTwoTone,
)

@Composable
fun MaterialIconsExtendedScreen() {
    MainScreen(
        title = MainNavRoutes.MaterialIConsExtended,
        list = routes,
    )
}