package com.steleot.jetpackcompose.playground.compose.external

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.LocalSystemUiController
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale


private const val Url = "external/SystemUiControllerScreen.kt"

@Composable
fun SystemUiControllerScreen(navController: NavHostController) {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.SystemUiController.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        SystemUiControllerExample(navController)
    }
}

@Composable
private fun SystemUiControllerExample(navController: NavHostController) {
    val backDispatcher = LocalOnBackPressedDispatcherOwner.current
    val systemUiController = LocalSystemUiController.current
    val useDarkIcons = MaterialTheme.colors.isLight
    val originalStatusBarColor = colorResource(id = R.color.colorPrimaryDark)

    backDispatcher?.onBackPressedDispatcher?.addCallback(object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            systemUiController.setSystemBarsColor(
                color = originalStatusBarColor,
                darkIcons = !useDarkIcons
            )
            navController.popBackStack()
        }
    })

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            systemUiController.setStatusBarColor(
                color = Color.Red,
                darkIcons = useDarkIcons
            )
        }) {
            Text(text = "Change System Bar Colors")
        }
        Button(onClick = {
            systemUiController.setStatusBarColor(
                color = originalStatusBarColor,
                darkIcons = !useDarkIcons
            )
        }) {
            Text(text = "Restore System Bar Colors")
        }
        Button(onClick = {
            systemUiController.setNavigationBarColor(
                color = Color.Red,
                darkIcons = useDarkIcons
            )
        }) {
            Text(text = "Change Navigation Bar Colors")
        }
        Button(onClick = {
            systemUiController.setNavigationBarColor(
                color = originalStatusBarColor,
                darkIcons = !useDarkIcons
            )
        }) {
            Text(text = "Restore Navigation Bar Colors")
        }
    }
}
