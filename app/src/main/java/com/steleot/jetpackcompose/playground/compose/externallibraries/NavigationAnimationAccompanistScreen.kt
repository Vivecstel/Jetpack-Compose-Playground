package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "externallibraries/NavigationAnimationAccompanistScreen.kt"

@Composable
fun NavigationAnimationAccompanistScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.NavigationAnimationAccompanist,
        link = Url,
    ) {
        NavigationAnimationExample()
    }
}

private const val Blue = "Blue"
private const val Red = "Red"
private const val Green = "Green"

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun NavigationAnimationExample() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController,
        startDestination = Blue,
        enterTransition = {
            fadeIn(animationSpec = tween(700))
        },
        exitTransition = {
            fadeOut(animationSpec = tween(700))
        }
    ) {
        composable(
            Blue,
            enterTransition = {
                when (initialState.destination.route) {
                    Red ->
                        slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(700))
                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    Red ->
                        slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(700))
                    else -> null
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    Red ->
                        slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(700))
                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    Red ->
                        slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(700))
                    else -> null
                }
            }
        ) { BlueScreen(navController) }
        composable(
            Red,
            enterTransition = {
                when (initialState.destination.route) {
                    Blue ->
                        slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(700))
                    Green ->
                        slideInVertically(initialOffsetY = { 1800 }, animationSpec = tween(700))
                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    Blue ->
                        slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(700))
                    Green ->
                        slideOutVertically(targetOffsetY = { -1800 }, animationSpec = tween(700))
                    else -> null
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    Blue ->
                        slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(700))
                    Green ->
                        slideInVertically(initialOffsetY = { -1800 }, animationSpec = tween(700))
                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    Blue ->
                        slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(700))
                    Green ->
                        slideOutVertically(targetOffsetY = { 1800 }, animationSpec = tween(700))
                    else -> null
                }
            }
        ) { RedScreen(navController) }
        navigation(
            startDestination = Green,
            route = "Inner",
            enterTransition = { expandIn(animationSpec = tween(700)) },
            exitTransition = { shrinkOut(animationSpec = tween(700)) }
        ) {
            composable(
                Green,
                enterTransition = {
                    when (initialState.destination.route) {
                        Red ->
                            slideInVertically(
                                initialOffsetY = { 1800 }, animationSpec = tween(700)
                            )
                        else -> null
                    }
                },
                exitTransition = {
                    when (targetState.destination.route) {
                        Red ->
                            slideOutVertically(
                                targetOffsetY = { -1800 }, animationSpec = tween(700)
                            )
                        else -> null
                    }
                },
                popEnterTransition = {
                    when (initialState.destination.route) {
                        Red ->
                            slideInVertically(
                                initialOffsetY = { -1800 }, animationSpec = tween(700)
                            )
                        else -> null
                    }
                },
                popExitTransition = {
                    when (targetState.destination.route) {
                        Red ->
                            slideOutVertically(
                                targetOffsetY = { 1800 }, animationSpec = tween(700)
                            )
                        else -> null
                    }
                }
            ) { GreenScreen(navController) }
        }
    }
}

@Composable
private fun BlueScreen(navController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Blue)
            .padding(16.dp)
    ) {
        Spacer(Modifier.height(25.dp))
        NavigateButton(
            stringResource(id = R.string.navigate_horizontal),
            Modifier
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
        ) { navController.navigate(Red) }
        Spacer(Modifier.height(25.dp))
        NavigateButton(
            stringResource(id = R.string.navigate_expand),
            Modifier
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
        ) { navController.navigate("Inner") }
        Spacer(Modifier.weight(1f))
        NavigateBackButton(navController)
    }
}

@Composable
private fun RedScreen(navController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(16.dp)
    ) {
        Spacer(Modifier.height(25.dp))
        NavigateButton(
            stringResource(id = R.string.navigate_horizontal),
            Modifier
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
        ) { navController.navigate(Blue) }
        Spacer(Modifier.height(25.dp))
        NavigateButton(
            stringResource(id = R.string.navigate_vertical),
            Modifier
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
        ) { navController.navigate(Green) }
        Spacer(Modifier.weight(1f))
        NavigateBackButton(navController)
    }
}

@Composable
private fun GreenScreen(navController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Spacer(Modifier.height(25.dp))
        NavigateButton(
            stringResource(id = R.string.navigate_to, stringResource(id = R.string.red)),
            Modifier
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
        ) { navController.navigate(Red) }
        Spacer(Modifier.weight(1f))
        NavigateBackButton(navController)
    }
}

@Composable
private fun NavigateButton(
    text: String,
    modifier: Modifier = Modifier,
    listener: () -> Unit = { }
) {
    Button(
        onClick = listener,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Composable
private fun NavigateBackButton(navController: NavController) {
    if (navController.currentBackStackEntry == LocalLifecycleOwner.current &&
        navController.previousBackStackEntry != null
    ) {
        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.go_to_previous))
        }
    }
}