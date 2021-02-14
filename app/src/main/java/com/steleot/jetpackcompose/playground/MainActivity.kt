package com.steleot.jetpackcompose.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.steleot.jetpackcompose.playground.compose.MainScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimationScreen
import com.steleot.jetpackcompose.playground.compose.core.CoreScreen
import com.steleot.jetpackcompose.playground.compose.foundation.FoundationScreen
import com.steleot.jetpackcompose.playground.compose.graphics.GraphicsScreen
import com.steleot.jetpackcompose.playground.compose.layout.LayoutScreen
import com.steleot.jetpackcompose.playground.compose.material.*
import com.steleot.jetpackcompose.playground.compose.resource.ResourceScreen
import com.steleot.jetpackcompose.playground.theme.PlaygroundTheme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundApp()
        }
    }
}

@Composable
fun PlaygroundApp() {
    ProvideWindowInsets {
        PlaygroundTheme {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = MainNavRoutes.Main) {
                /* main */
                composable(route = MainNavRoutes.Main) { MainScreen(navController) }
                composable(route = MainNavRoutes.Animation) { AnimationScreen() }
                composable(route = MainNavRoutes.Core) { CoreScreen() }
                composable(route = MainNavRoutes.Foundation) { FoundationScreen() }
                composable(route = MainNavRoutes.Graphics) { GraphicsScreen() }
                composable(route = MainNavRoutes.Layout) { LayoutScreen() }
                composable(route = MainNavRoutes.Material) { MaterialScreen(navController) }
                composable(route = MainNavRoutes.Resource) { ResourceScreen() }
                /* material */
                composable(route = MaterialNavRoutes.AlertDialog) { AlertDialogScreen() }
                composable(route = MaterialNavRoutes.AlertDialog) { AlertDialogScreen() }
                composable(route = MaterialNavRoutes.BottomAppBar) { BottomAppBarScreen() }
                composable(route = MaterialNavRoutes.BottomNavigation) { BottomNavigationScreen() }
                composable(route = MaterialNavRoutes.Button) { ButtonScreen() }
                composable(route = MaterialNavRoutes.Card) { CardScreen() }
                composable(route = MaterialNavRoutes.Checkbox) { CheckboxScreen() }
                composable(route = MaterialNavRoutes.Divider) { DividerScreen() }
                composable(route = MaterialNavRoutes.FloatingActionButton) { FloatingActionButtonScreen() }
                composable(route = MaterialNavRoutes.IconButton) { IconButtonScreen() }
                composable(route = MaterialNavRoutes.Progress) { ProgressScreen() }
                composable(route = MaterialNavRoutes.RadioButton) { RadioButtonScreen() }
                composable(route = MaterialNavRoutes.Scaffold) { ScaffoldScreen() }
                composable(route = MaterialNavRoutes.Slider) { SliderScreen() }
                composable(route = MaterialNavRoutes.SnackBar) { SnackBarScreen() }
                composable(route = MaterialNavRoutes.Switch) { SwitchScreen() }
                composable(route = MaterialNavRoutes.TabBar) { TabBarScreen() }
                composable(route = MaterialNavRoutes.TextField) { TextFieldScreen() }
                composable(route = MaterialNavRoutes.TopAppBar) { TopAppBarScreen() }
            }
        }
    }
}
