package com.steleot.jetpackcompose.playground.compose.externallibraries

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.plusAssign
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.bottomSheet
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import java.util.*

private const val Url = "externallibraries/NavigationMaterialAccompanistScreen.kt"

@Composable
fun NavigationMaterialAccompanistScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.NavigationMaterialAccompanist,
        link = Url,
    ) {
        NavigationMaterialExample()
    }
}

private object Destinations {
    const val Home = "HOME"
    const val Feed = "FEED"
    const val Sheet = "SHEET"
}

@SuppressLint("RestrictedApi")
@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
private fun NavigationMaterialExample() {
    val navController = rememberNavController()
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    navController.navigatorProvider += bottomSheetNavigator
    ModalBottomSheetLayout(bottomSheetNavigator) {
        NavHost(navController, Destinations.Home) {
            composable(Destinations.Home) {
                HomeScreen(
                    showSheet = {
                        navController.navigate(Destinations.Sheet + "?arg=From Home Screen")
                    },
                    showFeed = { navController.navigate(Destinations.Feed) }
                )
            }
            composable(Destinations.Feed) {
                FeedScreen {
                    navController.popBackStack()
                }
            }
            bottomSheet(Destinations.Sheet + "?arg={arg}") { backstackEntry ->
                val arg = backstackEntry.arguments?.getString("arg")
                    ?: stringResource(id = R.string.missing_argument)
                BottomSheet(
                    showFeed = { navController.navigate(Destinations.Feed) },
                    showAnotherSheet = {
                        navController.navigate(Destinations.Sheet + "?arg=${UUID.randomUUID()}")
                    },
                    arg = arg
                )
            }
        }
    }
}

@Composable
private fun HomeScreen(showSheet: () -> Unit, showFeed: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(id = R.string.body))
        Button(onClick = showSheet) {
            Text(stringResource(id = R.string.show_bottom_sheet))
        }
        Button(onClick = showFeed) {
            Text(stringResource(id = R.string.navigate_feed))
        }
    }
}

@Composable
private fun FeedScreen(
    goBack: () -> Unit,
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(id = R.string.feed))
        Button(onClick = goBack) {
            Text(stringResource(id = R.string.go_to_previous))
        }
    }
}

@Composable
private fun BottomSheet(
    showFeed: () -> Unit,
    showAnotherSheet: () -> Unit,
    arg: String
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(id = R.string.bottom_sheet_args, arg))
        Button(
            onClick = showFeed,
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
        ) {
            Text(stringResource(id = R.string.navigate_feed))
        }
        Button(
            onClick = showAnotherSheet,
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
        ) {
            Text(stringResource(id = R.string.show_another_bottom_sheet))
        }
    }
}