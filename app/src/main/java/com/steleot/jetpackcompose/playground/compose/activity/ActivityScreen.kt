package com.steleot.jetpackcompose.playground.compose.activity

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
import com.steleot.jetpackcompose.playground.navigation.graph.ActivityNavRoutes
import com.steleot.jetpackcompose.playground.navigation.graph.MainNavRoutes

val routes = listOf(
    ActivityNavRoutes.BackHandler,
    ActivityNavRoutes.LauncherForActivityResult1,
    ActivityNavRoutes.LauncherForActivityResult2,
)

@Composable
fun ActivityScreen() {
    MainScreen(
        title = MainNavRoutes.Activity,
        list = routes,
    )
}
