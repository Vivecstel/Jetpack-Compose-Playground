package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.AnimationNavRoutes
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen
import java.util.*

val routes = listOf(
    AnimationNavRoutes.Animatable,
    AnimationNavRoutes.AnimatedValues,
    AnimationNavRoutes.AnimatedVisibility,
    AnimationNavRoutes.AnimationModifier,
    AnimationNavRoutes.CrossfadeAnimation,
    AnimationNavRoutes.GestureAnimation,
    AnimationNavRoutes.InfiniteTransition,
    AnimationNavRoutes.RotatingShape,
    AnimationNavRoutes.SingleValueColorAnimation,
    AnimationNavRoutes.SingleValueFloatAnimation,
    AnimationNavRoutes.SuspendAnimation,
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