package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.AnimationNavRoutes
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen
import java.util.*

private val routes = listOf(
    AnimationNavRoutes.AnimatedValues,
    AnimationNavRoutes.CrossfadeAnimation,
    AnimationNavRoutes.GestureAnimation,
    AnimationNavRoutes.GrowingShape,
    AnimationNavRoutes.InteractionAnimation,
    AnimationNavRoutes.RotatingShape,
    AnimationNavRoutes.SingleValueColorAnimation,
    AnimationNavRoutes.SingleValueFloatAnimation,
    AnimationNavRoutes.TransitionAnimation,
)

@Composable
fun AnimationScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.Animation.capitalize(Locale.getDefault()),
        list = routes,
        showBackArrow = true,
    )
}