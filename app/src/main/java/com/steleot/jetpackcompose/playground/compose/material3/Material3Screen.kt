package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
import com.steleot.jetpackcompose.playground.navigation.graph.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes

val routes = listOf(
    Material3NavRoutes.AlertDialog3,
    Material3NavRoutes.AssistChip,
    Material3NavRoutes.Badge3,
    Material3NavRoutes.BadgedBox3,
    Material3NavRoutes.Button3,
    Material3NavRoutes.Card3,
    Material3NavRoutes.CenterAlignedTopAppBar,
    Material3NavRoutes.Checkbox3,
    Material3NavRoutes.HorizontalDivider3,
    Material3NavRoutes.DropdownMenu3,
    Material3NavRoutes.ElevatedButton,
    Material3NavRoutes.ElevatedCard,
    Material3NavRoutes.ExtendedFloatingActionButton3,
    Material3NavRoutes.FilledIconButton,
    Material3NavRoutes.FilledTonalButton,
    Material3NavRoutes.FilledTonalIconButton,
    Material3NavRoutes.FilterChip3,
    Material3NavRoutes.FloatingActionButton3,
    Material3NavRoutes.IconButton3,
    Material3NavRoutes.Icon3,
    Material3NavRoutes.IconToggleButton3,
    Material3NavRoutes.InputChip,
    Material3NavRoutes.LargeFloatingActionButton,
    Material3NavRoutes.LargeTopAppBar,
    Material3NavRoutes.ListItem3,
    Material3NavRoutes.LocalAbsoluteTonalElevation,
    Material3NavRoutes.LocalContentColor3,
    Material3NavRoutes.LocalMinimumTouchTargetEnforcement,
    Material3NavRoutes.LocalTextStyle3,
    Material3NavRoutes.MaterialTheme3,
    Material3NavRoutes.MediumTopAppBar,
    Material3NavRoutes.ModalNavigationDrawer,
    Material3NavRoutes.NavigationBar,
    Material3NavRoutes.NavigationRail3,
    Material3NavRoutes.OutlinedButton3,
    Material3NavRoutes.OutlinedCard,
    Material3NavRoutes.OutlinedIconButton,
    Material3NavRoutes.OutlinedTextField3,
    Material3NavRoutes.ProgressIndicator3,
    Material3NavRoutes.RadioButton3,
    Material3NavRoutes.RangeSlider3,
    Material3NavRoutes.Scaffold3,
    Material3NavRoutes.Slider3,
    Material3NavRoutes.SmallFloatingActionButton,
    Material3NavRoutes.SmallTopAppBar,
    Material3NavRoutes.SuggestionChip,
    Material3NavRoutes.Surface3,
    Material3NavRoutes.Switch3,
    Material3NavRoutes.TabRow3,
    Material3NavRoutes.Text3,
    Material3NavRoutes.TextButton3,
    Material3NavRoutes.TextField3,
)

@Composable
fun Material3Screen() {
    MainScreen(
        title = MainNavRoutes.Material3,
        list = routes,
    )
}