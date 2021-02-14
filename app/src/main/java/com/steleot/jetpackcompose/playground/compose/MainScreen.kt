package com.steleot.jetpackcompose.playground.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultListItem
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultTopAppBar
import dev.chrisbanes.accompanist.insets.statusBarsPadding

private val routes = listOf(
    MainNavRoutes.Animation,
    MainNavRoutes.Core,
    MainNavRoutes.Foundation,
    MainNavRoutes.Graphics,
    MainNavRoutes.Layout,
    MainNavRoutes.Material,
    MainNavRoutes.Resource,
)

@Composable
fun MainScreen(
    navController: NavHostController,
    list: List<String> = routes,
    showBackArrow: Boolean = false
) {
    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        topBar = {
            DefaultTopAppBar(navController = navController, showBackArrow = showBackArrow)
        }
    ) {
        LazyColumn {
            items(list) {
                DefaultListItem(
                    text = it,
                    navController = navController,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
