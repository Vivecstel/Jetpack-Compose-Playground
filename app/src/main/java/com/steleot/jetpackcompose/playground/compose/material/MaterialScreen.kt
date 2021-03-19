package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen
import java.util.Locale

val routes = listOf(
    MaterialNavRoutes.AlertDialog,
    MaterialNavRoutes.BackdropScaffold,
    MaterialNavRoutes.BottomAppBar,
//    MaterialNavRoutes.BottomDrawerLayout,
    MaterialNavRoutes.BottomNavigation,
    MaterialNavRoutes.BottomSheetScaffold,
    MaterialNavRoutes.Button,
    MaterialNavRoutes.Card,
    MaterialNavRoutes.Checkbox,
    MaterialNavRoutes.DropdownMenu,
    MaterialNavRoutes.Divider,
    MaterialNavRoutes.FloatingActionButton,
    MaterialNavRoutes.ExtendedFloatingActionButton,
    MaterialNavRoutes.Elevation,
    MaterialNavRoutes.IconToggleButton,
    MaterialNavRoutes.IconButton,
    MaterialNavRoutes.Icon,
    MaterialNavRoutes.ModalBottomSheetLayout,
//    MaterialNavRoutes.ModalDrawerLayout,
    MaterialNavRoutes.ListItem,
    MaterialNavRoutes.LocalContentAlpha,
    MaterialNavRoutes.LocalContentColor,
    MaterialNavRoutes.OutlinedTextField,
    MaterialNavRoutes.Progress,
    MaterialNavRoutes.RadioButton,
    MaterialNavRoutes.Scaffold,
    MaterialNavRoutes.ScrollableTabRow,
    MaterialNavRoutes.Slider,
    MaterialNavRoutes.SnackBar,
    MaterialNavRoutes.Surface,
    MaterialNavRoutes.Swipeable,
    MaterialNavRoutes.SwipeToDismiss,
    MaterialNavRoutes.Switch,
    MaterialNavRoutes.TabRow,
    MaterialNavRoutes.TextField,
    MaterialNavRoutes.TopAppBar,
    MaterialNavRoutes.TriStateCheckbox,
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
