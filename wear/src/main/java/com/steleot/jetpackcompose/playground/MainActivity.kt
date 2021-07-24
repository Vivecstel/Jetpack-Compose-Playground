package com.steleot.jetpackcompose.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.steleot.jetpackcompose.playground.compose.MainScreen
import com.steleot.jetpackcompose.playground.compose.SettingsScreen
import com.steleot.jetpackcompose.playground.compose.foundation.CurvedRowScreen
import com.steleot.jetpackcompose.playground.compose.foundation.FoundationScreen
import com.steleot.jetpackcompose.playground.compose.material.*
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.theme.JetpackComposePlaygroundTheme
import com.steleot.jetpackcompose.playground.theme.ThemeState

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeApp()
        }
    }
}

@Composable
fun JetpackComposeApp() {
    val isDarkTheme = isSystemInDarkTheme()
    var themeState by rememberSaveable {
        mutableStateOf(ThemeState(isDarkTheme = isDarkTheme))
    }
    JetpackComposePlaygroundTheme(
        colorPalette = themeState.colorPalette
    ) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = MainNavRoutes.Main) {
            /* main */
            composable(route = MainNavRoutes.Main) { MainScreen(navController) }
            composable(route = MainNavRoutes.Foundation) { FoundationScreen(navController) }
            composable(route = MainNavRoutes.Material) { MaterialScreen(navController) }
            composable(route = MainNavRoutes.Settings) { SettingsScreen() }
            /* foundation */
            composable(route = FoundationNavRoutes.CurvedRow) { CurvedRowScreen() }
            /* material */
            composable(route = MaterialNavRoutes.AppCard) { AppCardScreen() }
            composable(route = MaterialNavRoutes.Button) { ButtonScreen() }
            composable(route = MaterialNavRoutes.Card) { CardScreen() }
            composable(route = MaterialNavRoutes.Chip) { ChipScreen() }
            composable(route = MaterialNavRoutes.CompatButton) { CompactButtonScreen() }
            composable(route = MaterialNavRoutes.CompatChip) { CompatChipScreen() }
            composable(route = MaterialNavRoutes.SplitToggleChip) { SplitToggleChipScreen() }
            composable(route = MaterialNavRoutes.ToggleButton) { ToggleButtonScreen() }
            composable(route = MaterialNavRoutes.ToggleChip) { ToggleChipScreen() }
        }
    }
}
