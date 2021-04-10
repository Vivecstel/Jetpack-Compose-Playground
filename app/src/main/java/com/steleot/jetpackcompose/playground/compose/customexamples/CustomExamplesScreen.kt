package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen
import java.util.Locale

val routes = listOf(
    CustomExamplesNavRoutes.FirstBaselineToTop,
)

@Composable
fun CustomExamplesScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.CustomExamples.capitalize(Locale.getDefault()),
        list = routes,
        showBackArrow = true,
    )
}