package com.steleot.jetpackcompose.playground.compose.accompanist

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.AccompanistNavRoutes
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen
import java.util.*

val routes = listOf(
    AccompanistNavRoutes.Coil,
    AccompanistNavRoutes.Glide,
    AccompanistNavRoutes.Picasso,
)

@Composable
fun AccompanistScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.Accompanist.capitalize(Locale.getDefault()),
        list = routes,
        showBackArrow = true,
    )
}