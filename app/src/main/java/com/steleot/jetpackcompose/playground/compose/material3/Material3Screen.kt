package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes

val routes = listOf(
    Material3NavRoutes.AlertDialog3,
    Material3NavRoutes.Badge3,
    Material3NavRoutes.BadgedBox3,
    Material3NavRoutes.Button3,
    Material3NavRoutes.Card3,
    Material3NavRoutes.CenterAlignedTopAppBar,
    Material3NavRoutes.Checkbox3,
    Material3NavRoutes.Divider3,
    Material3NavRoutes.DropdownMenu3,
    Material3NavRoutes.ElevatedButton,
    Material3NavRoutes.ElevatedCard,
    Material3NavRoutes.ExtendedFloatingActionButton3,
    Material3NavRoutes.FilledTonalButton,
    Material3NavRoutes.FloatingActionButton3,
    Material3NavRoutes.IconButton3,
    Material3NavRoutes.Icon3,
    Material3NavRoutes.IconToggleButton3,
    Material3NavRoutes.LargeFloatingActionButton,
    Material3NavRoutes.LargeTopAppBar,
    Material3NavRoutes.LocalAbsoluteTonalElevation,
    Material3NavRoutes.LocalContentColor3,
    Material3NavRoutes.LocalMinimumTouchTargetEnforcement,
    Material3NavRoutes.LocalTextStyle3,
    Material3NavRoutes.MaterialTheme3,
    Material3NavRoutes.MediumTopAppBar,
    Material3NavRoutes.NavigationBar,
    Material3NavRoutes.NavigationDrawer,
    Material3NavRoutes.NavigationRail3,
    Material3NavRoutes.OutlinedButton3,
    Material3NavRoutes.OutlinedCard,
    Material3NavRoutes.ProgressIndicator3,
    Material3NavRoutes.RadioButton3,
    Material3NavRoutes.Scaffold3,
    Material3NavRoutes.SmallFloatingActionButton,
    Material3NavRoutes.SmallTopAppBar,
    Material3NavRoutes.Surface3,
    Material3NavRoutes.Text3,
    Material3NavRoutes.TextButton3,
)

@Composable
fun Material3Screen() {
    MainScreen(
        title = MainNavRoutes.Material3,
        list = routes,
    )
}