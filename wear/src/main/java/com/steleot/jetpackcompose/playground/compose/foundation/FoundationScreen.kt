package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.compose.MainScreen
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

val routes = listOf(
    FoundationNavRoutes.CurvedRow,
)

@Composable
fun FoundationScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        list = routes,
    )
}