package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
import com.steleot.jetpackcompose.playground.navigation.graph.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes

val routes = listOf(
    MaterialNavRoutes.AlertDialog,
    MaterialNavRoutes.BackdropScaffold,
    MaterialNavRoutes.BadgedBox,
    MaterialNavRoutes.Badge,
    MaterialNavRoutes.BottomAppBar,
    MaterialNavRoutes.BottomDrawer,
    MaterialNavRoutes.BottomNavigation,
    MaterialNavRoutes.BottomSheetScaffold,
    MaterialNavRoutes.Button,
    MaterialNavRoutes.Card,
    MaterialNavRoutes.Checkbox,
    MaterialNavRoutes.Chip,
    MaterialNavRoutes.DropdownMenu,
    MaterialNavRoutes.Divider,
    MaterialNavRoutes.FloatingActionButton,
    MaterialNavRoutes.ExtendedFloatingActionButton,
    MaterialNavRoutes.FilterChip,
    MaterialNavRoutes.Elevation,
    MaterialNavRoutes.ExposedDropdownMenuBox,
    MaterialNavRoutes.IconToggleButton,
    MaterialNavRoutes.IconButton,
    MaterialNavRoutes.Icon,
    MaterialNavRoutes.ListItem,
    MaterialNavRoutes.LocalAbsoluteElevation,
    MaterialNavRoutes.LocalContentAlpha,
    MaterialNavRoutes.LocalContentColor,
    MaterialNavRoutes.LocalMinimumInteractiveComponentEnforcement,
    MaterialNavRoutes.LocalTextStyle,
    MaterialNavRoutes.MaterialTheme,
    MaterialNavRoutes.ModalBottomSheetLayout,
    MaterialNavRoutes.ModalDrawer,
    MaterialNavRoutes.NavigationRail,
    MaterialNavRoutes.OutlinedButton,
    MaterialNavRoutes.OutlinedTextField,
    MaterialNavRoutes.ProgressIndicator,
    MaterialNavRoutes.PullRefresh,
    MaterialNavRoutes.RadioButton,
    MaterialNavRoutes.RangeSlider,
    MaterialNavRoutes.Scaffold,
    MaterialNavRoutes.ScrollableTabRow,
    MaterialNavRoutes.Slider,
    MaterialNavRoutes.SnackBar,
    MaterialNavRoutes.Surface,
    MaterialNavRoutes.Swipeable,
    MaterialNavRoutes.SwipeToDismiss,
    MaterialNavRoutes.Switch,
    MaterialNavRoutes.TabRow,
    MaterialNavRoutes.TextButton,
    MaterialNavRoutes.TextField,
    MaterialNavRoutes.Text,
    MaterialNavRoutes.TopAppBar,
    MaterialNavRoutes.TriStateCheckbox,
)

@Composable
fun MaterialScreen() {
    MainScreen(
        title = MainNavRoutes.Material,
        list = routes,
    )
}
