package com.steleot.jetpackcompose.playground.compose.foundationlayout

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.FoundationLayoutNavRoutes
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen
import java.util.Locale

val routes = listOf(
    FoundationLayoutNavRoutes.AspectRatio,
    FoundationLayoutNavRoutes.Box,
    FoundationLayoutNavRoutes.BoxWithConstraints,
    FoundationLayoutNavRoutes.Column,
    FoundationLayoutNavRoutes.Intrinsic,
    FoundationLayoutNavRoutes.Offset,
    FoundationLayoutNavRoutes.Padding,
    FoundationLayoutNavRoutes.Row,
    FoundationLayoutNavRoutes.Size,
    FoundationLayoutNavRoutes.Spacer,
)

@Composable
fun FoundationLayoutScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.FoundationLayout.capitalize(Locale.getDefault()),
        list = routes,
        showBackArrow = true,
    )
}
