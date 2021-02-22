package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen
import java.util.*

val routes = listOf(
    FoundationNavRoutes.Background,
    FoundationNavRoutes.Border,
    FoundationNavRoutes.Canvas,
    FoundationNavRoutes.Clickable,
    FoundationNavRoutes.Focusable,
    FoundationNavRoutes.Image,
    FoundationNavRoutes.Scroll,
    FoundationNavRoutes.Shape,
    FoundationNavRoutes.Text,
    FoundationNavRoutes.TextStyle,
)

@Composable
fun FoundationScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.Foundation.capitalize(Locale.getDefault()),
        list = routes,
        showBackArrow = true
    )
}
