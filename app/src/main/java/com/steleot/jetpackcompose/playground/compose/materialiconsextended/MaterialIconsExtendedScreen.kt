package com.steleot.jetpackcompose.playground.compose.materialiconsextended

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
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
fun MaterialIconsExtendedScreen() {
    MainScreen(
        title = MainNavRoutes.MaterialIConsExtended,
        list = routes,
    )
}