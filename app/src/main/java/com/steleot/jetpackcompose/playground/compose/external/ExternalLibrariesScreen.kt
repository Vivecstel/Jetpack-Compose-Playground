package com.steleot.jetpackcompose.playground.compose.external

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen
import java.util.*

val routes = listOf(
    ExternalLibrariesNavRoutes.Coil,
    ExternalLibrariesNavRoutes.Glide,
    ExternalLibrariesNavRoutes.Lottie,
    ExternalLibrariesNavRoutes.Picasso,
)

@Composable
fun ExternalLibrariesScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.ExternalLibraries.capitalize(Locale.getDefault()),
        list = routes,
        showBackArrow = true,
    )
}