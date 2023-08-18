package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.localproviders.LocalNavController
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.theme.colors
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "externallibraries/SystemUiControllerAccompanistScreen.kt"

@Composable
fun SystemUiControllerAccompanistScreen(
    systemUiController: SystemUiController,
) {
    val navController = LocalNavController.current
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.SystemUiControllerAccompanist,
        link = URL,
    ) {
        SystemUiControllerExample(navController, systemUiController)
    }
}

@Composable
private fun SystemUiControllerExample(
    navController: NavHostController,
    systemUiController: SystemUiController,
) {
    val backDispatcher = LocalOnBackPressedDispatcherOwner.current
    val useDarkIcons = MaterialTheme.colors.isLight
    val originalStatusBarColor = MaterialTheme.colors.primaryVariant

    DisposableEffect(Unit) {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                systemUiController.setSystemBarsColor(
                    color = originalStatusBarColor,
                    darkIcons = !useDarkIcons
                )
                navController.popBackStack()
            }
        }
        backDispatcher?.onBackPressedDispatcher?.addCallback(callback)
        onDispose {
            callback.remove()
        }
    }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            systemUiController.setStatusBarColor(
                color = Color(colors.random()),
                darkIcons = useDarkIcons
            )
        }) {
            Text(text = stringResource(id = R.string.change_system_bar_colors))
        }
        Button(onClick = {
            systemUiController.setStatusBarColor(
                color = originalStatusBarColor,
                darkIcons = !useDarkIcons
            )
        }) {
            Text(text = stringResource(id = R.string.restore_system_bar_colors))
        }
        Button(onClick = {
            systemUiController.setNavigationBarColor(
                color = Color(colors.random()),
                darkIcons = useDarkIcons
            )
        }) {
            Text(text = stringResource(id = R.string.change_navigation_bar_colors))
        }
        Button(onClick = {
            systemUiController.setNavigationBarColor(
                color = originalStatusBarColor,
                darkIcons = !useDarkIcons
            )
        }) {
            Text(text = stringResource(id = R.string.restore_navigation_bar_colors))
        }
    }
}
