package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.compose.MainScreen
import com.steleot.jetpackcompose.playground.navigation.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes

val routes = listOf(
    CustomExamplesNavRoutes.AdMobBanner,
    CustomExamplesNavRoutes.AnimatedDeleteList,
    CustomExamplesNavRoutes.AnimatedExtendedFloatingActionButton,
    CustomExamplesNavRoutes.AnimatedShowList,
    CustomExamplesNavRoutes.AnimatedText,
    CustomExamplesNavRoutes.BarChart,
    CustomExamplesNavRoutes.CameraX,
    CustomExamplesNavRoutes.CollapsingToolbar,
    CustomExamplesNavRoutes.ColorMatrix,
    CustomExamplesNavRoutes.CurvedScrollView,
    CustomExamplesNavRoutes.FirstBaselineToTop,
    CustomExamplesNavRoutes.StaggeredGridList,
)

@Composable
fun CustomExamplesScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.CustomExamples,
        list = routes,
        showBackArrow = true,
    )
}