package com.steleot.jetpackcompose.playground.compose.foundationlayout

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.FoundationLayoutNavRoutes
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen
import java.util.*

val routes = listOf(
    FoundationLayoutNavRoutes.AspectRatio,
    FoundationLayoutNavRoutes.Box,
    FoundationLayoutNavRoutes.BoxWithConstraints,
    FoundationLayoutNavRoutes.Column,
    FoundationLayoutNavRoutes.Offset,
    FoundationLayoutNavRoutes.Row,
    FoundationLayoutNavRoutes.Size,
    FoundationLayoutNavRoutes.Spacer,
)

@Composable
fun LayoutScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.FoundationLayout.capitalize(Locale.getDefault()),
        list = routes,
        showBackArrow = true,
    )
}
