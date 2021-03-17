package com.steleot.jetpackcompose.playground.compose.viewmodel

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.ViewModelNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen
import java.util.Locale

val routes = listOf(
    ViewModelNavRoutes.Flow,
    ViewModelNavRoutes.LiveData,
    ViewModelNavRoutes.State,
)

@Composable
fun ViewModelScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.ViewModel.capitalize(Locale.getDefault()),
        list = routes,
        showBackArrow = true
    )
}
