package com.steleot.jetpackcompose.playground.compose.viewmodel

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.ViewModelNavRoutes

val routes = listOf(
    ViewModelNavRoutes.Flow,
    ViewModelNavRoutes.LiveData,
    ViewModelNavRoutes.State,
)

@Composable
fun ViewModelScreen() {
    MainScreen(
        title = MainNavRoutes.ViewModel,
        list = routes,
    )
}
