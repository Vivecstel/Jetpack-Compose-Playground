package com.steleot.jetpackcompose.playground.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry
import com.steleot.jetpackcompose.playground.navigation.graph.MainNavRoutes

const val NavigationDuration = 600
private val fadeRoutes = listOf(
    MainNavRoutes.Popular,
    MainNavRoutes.Search,
    MainNavRoutes.Settings,
    MainNavRoutes.ReleaseNotes,
    MainNavRoutes.New,
    FavoritesRoute,
)

fun AnimatedContentTransitionScope<NavBackStackEntry>.getEnterTransition(
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

fun AnimatedContentTransitionScope<NavBackStackEntry>.getExitTransition(
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
