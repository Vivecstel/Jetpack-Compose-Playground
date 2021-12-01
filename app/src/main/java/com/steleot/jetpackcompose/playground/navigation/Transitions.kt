package com.steleot.jetpackcompose.playground.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavBackStackEntry

const val NavigationDuration = 600
private val fadeRoutes = listOf(
    MainNavRoutes.Popular,
    MainNavRoutes.Search,
    MainNavRoutes.Settings,
    MainNavRoutes.ReleaseNotes,
    MainNavRoutes.New,
    FavoritesRoute,
)

@OptIn(ExperimentalAnimationApi::class)
fun AnimatedContentScope<NavBackStackEntry>.getEnterTransition(
    screenWidth: Int,
    isItPop: Boolean = false,
): EnterTransition {
    val initialRoute = initialState.destination.route
    val targetRoute = targetState.destination.route
    if (targetRoute == MainNavRoutes.Discover) {
        return fadeIn(animationSpec = tween(0))
    }
    val route = if (isItPop) initialRoute else targetRoute
    return if (route in fadeRoutes) {
        fadeIn(animationSpec = tween(NavigationDuration))
    } else {
        slideInHorizontally(
            initialOffsetX = { screenWidth },
            animationSpec = tween(NavigationDuration)
        ) + fadeIn(
            initialAlpha = 0.5f,
            animationSpec = tween(NavigationDuration)
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun AnimatedContentScope<NavBackStackEntry>.getExitTransition(
    screenWidth: Int,
    isItPop: Boolean = false,
): ExitTransition {
    val initialRoute = initialState.destination.route
    val targetRoute = targetState.destination.route
    val route = if (isItPop) initialRoute else targetRoute
    return if (route in fadeRoutes) {
        fadeOut(animationSpec = tween(NavigationDuration))
    } else {
        slideOutHorizontally(
            targetOffsetX = { screenWidth },
            animationSpec = tween(NavigationDuration)
        ) + fadeOut(
            targetAlpha = 0.5f,
            animationSpec = tween(NavigationDuration)
        )
    }
}
