package com.steleot.jetpackcompose.playground.compose.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes

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
    val navController = rememberNavController()
    Scaffold { innerPadding ->
        NavHost(navController, Screen.Profile.route, Modifier.padding(innerPadding)) {
            composable(Screen.Profile.route) { Profile(navController) }
            composable(Screen.Dashboard.route) { Dashboard(navController) }
            composable(Screen.Scrollable.route) { Scrollable(navController) }
        }
    }
}

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Profile : Screen("profile", R.string.profile)
    object Dashboard : Screen("dashboard", R.string.dashboard)
    object Scrollable : Screen("scrollable", R.string.scrollable)
}

@Composable
fun Profile(navController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .then(Modifier.padding(8.dp))
    ) {
        Text(text = stringResource(Screen.Profile.resourceId))
        Spacer(Modifier.weight(1f))
        NavigateButton(stringResource(Screen.Dashboard.resourceId)) {
            navController.navigate(Screen.Dashboard.route)
        }
        Divider(color = MaterialTheme.colors.onSurface)
        NavigateButton(stringResource(Screen.Scrollable.resourceId)) {
            navController.navigate(Screen.Scrollable.route)
        }
        NavigateBackButton(navController)
    }
}

@Composable
fun Dashboard(navController: NavController, title: String? = null) {
    Column(
        Modifier
            .fillMaxSize()
            .then(Modifier.padding(8.dp))
    ) {
        Text(text = title ?: stringResource(Screen.Dashboard.resourceId))
        Spacer(Modifier.weight(1f))
        NavigateBackButton(navController)
    }
}

@Composable
fun Scrollable(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .then(Modifier.padding(8.dp))
    ) {
        NavigateButton(stringResource(Screen.Dashboard.resourceId)) {
            navController.navigate(Screen.Dashboard.route)
        }
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(phrases) { phrase ->
                Text(phrase, fontSize = 20.sp)
            }
        }
        NavigateBackButton(navController)
    }
}

@Composable
private fun NavigateButton(
    text: String,
    listener: () -> Unit = { }
) {
    Button(
        onClick = listener,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Navigate to $text")
    }
}

@Composable
private fun NavigateBackButton(navController: NavController) {
    if (navController.previousBackStackEntry != null) {
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Go to Previous screen")
        }
    }
}

private val phrases = listOf(
    "Easy As Pie",
    "Wouldn't Harm a Fly",
    "No-Brainer",
    "Keep On Truckin'",
    "An Arm and a Leg",
    "Down To Earth",
    "Under the Weather",
    "Up In Arms",
    "Cup Of Joe",
    "Not the Sharpest Tool in the Shed",
    "Ring Any Bells?",
    "Son of a Gun",
    "Hard Pill to Swallow",
    "Close But No Cigar",
    "Beating a Dead Horse",
    "If You Can't Stand the Heat, Get Out of the Kitchen",
    "Cut To The Chase",
    "Heads Up",
    "Goody Two-Shoes",
    "Fish Out Of Water",
    "Cry Over Spilt Milk",
    "Elephant in the Room",
    "There's No I in Team",
    "Poke Fun At",
    "Talk the Talk",
    "Know the Ropes",
    "Fool's Gold",
    "It's Not Brain Surgery",
    "Fight Fire With Fire",
    "Go For Broke"
)