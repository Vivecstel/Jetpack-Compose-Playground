package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes

val routes = listOf(
    Material3NavRoutes.AlertDialog3,
    Material3NavRoutes.BadgedBox3,
    Material3NavRoutes.Badge,
    Material3NavRoutes.Button3,
    Material3NavRoutes.CenterAlignedTopAppBar,
    Material3NavRoutes.ElevatedButton,
    Material3NavRoutes.ExtendedFloatingActionButton3,
    Material3NavRoutes.FilledTonalButton,
    Material3NavRoutes.FloatingActionButton3,
    Material3NavRoutes.IconButton3,
    Material3NavRoutes.Icon3,
    Material3NavRoutes.IconToggleButton,
    Material3NavRoutes.LargeFloatingActionButton,
    Material3NavRoutes.LargeTopAppBar,
    Material3NavRoutes.LocalAbsoluteTonalElevation,
    Material3NavRoutes.LocalContentColor3,
    Material3NavRoutes.LocalMinimumTouchTargetEnforcement,
    Material3NavRoutes.LocalTextStyle,
    Material3NavRoutes.MaterialTheme3,
    Material3NavRoutes.MediumTopAppBar,
    Material3NavRoutes.NavigationBar,
    Material3NavRoutes.NavigationDrawer,
    Material3NavRoutes.NavigationRail3,
    Material3NavRoutes.OutlinedButton,
    Material3NavRoutes.Scaffold3,
    Material3NavRoutes.SmallFloatingActionButton,
    Material3NavRoutes.SmallTopAppBar,
    Material3NavRoutes.Surface3,
    Material3NavRoutes.TextButton,
    Material3NavRoutes.Text3,
)

@Composable
fun Material3Screen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.Material3,
        list = routes,
    )
}