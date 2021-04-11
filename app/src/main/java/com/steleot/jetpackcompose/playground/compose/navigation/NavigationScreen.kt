package com.steleot.jetpackcompose.playground.compose.navigation

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "navigation/NavigationScreen.kt"

@Composable
fun NavigationScreen() {
    DefaultScaffold(
        title = MainNavRoutes.Navigation,
        link = Url,
    ) {
        NavigationExample()
    }
}

@Composable
private fun NavigationExample() {

}