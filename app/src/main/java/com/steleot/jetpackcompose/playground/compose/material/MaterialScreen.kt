package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen
import java.util.*

private val routes = listOf(
    MaterialNavRoutes.AlertDialog,
    MaterialNavRoutes.BottomAppBar,
    MaterialNavRoutes.BottomNavigation,
    MaterialNavRoutes.Button,
    MaterialNavRoutes.Card,
    MaterialNavRoutes.Checkbox,
    MaterialNavRoutes.Divider,
    MaterialNavRoutes.FloatingActionButton,
    MaterialNavRoutes.IconButton,
    MaterialNavRoutes.Icon,
    MaterialNavRoutes.Progress,
    MaterialNavRoutes.RadioButton,
    MaterialNavRoutes.Scaffold,
    MaterialNavRoutes.Slider,
    MaterialNavRoutes.SnackBar,
    MaterialNavRoutes.Switch,
    MaterialNavRoutes.TabBar,
    MaterialNavRoutes.TextField,
    MaterialNavRoutes.TopAppBar,
)

@Composable
fun MaterialScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.Material.capitalize(Locale.getDefault()),
        list = routes,
        showBackArrow = true
    )
}
