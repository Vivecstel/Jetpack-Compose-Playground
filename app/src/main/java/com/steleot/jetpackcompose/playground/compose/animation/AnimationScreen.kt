package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.compose.MainScreen
import com.steleot.jetpackcompose.playground.navigation.AnimationNavRoutes
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes

val routes = listOf(
    AnimationNavRoutes.Animatable,
    AnimationNavRoutes.AnimatedContent,
    AnimationNavRoutes.AnimatedValues,
    AnimationNavRoutes.AnimatedVector,
    AnimationNavRoutes.AnimatedVisibility,
    AnimationNavRoutes.AnimateEnterExit,
    AnimationNavRoutes.AnimationModifier,
    AnimationNavRoutes.CrossfadeAnimation,
    AnimationNavRoutes.DoubleTapToLike,
    AnimationNavRoutes.ElevationAnimation,
    AnimationNavRoutes.GestureAnimation,
    AnimationNavRoutes.InfiniteTransition,
    AnimationNavRoutes.RotateAnimation,
    AnimationNavRoutes.ScaleAnimation,
    AnimationNavRoutes.SingleValueColorAnimation,
    AnimationNavRoutes.SingleValueFloatAnimation,
    AnimationNavRoutes.SuspendAnimation,
)

@Composable
fun AnimationScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.Animation,
        list = routes,
    )
}