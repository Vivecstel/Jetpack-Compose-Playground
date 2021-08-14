package com.steleot.jetpackcompose.playground.compose

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.insets.systemBarsPadding
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.customexamples.AdViewExample
import com.steleot.jetpackcompose.playground.compose.reusable.*
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import kotlinx.coroutines.launch

private val routes = listOf(
    MainNavRoutes.Activity,
    MainNavRoutes.Animation,
    MainNavRoutes.ConstraintLayout,
    MainNavRoutes.CustomExamples,
    MainNavRoutes.ExternalLibraries,
    MainNavRoutes.Foundation,
    MainNavRoutes.FoundationLayout,
    MainNavRoutes.Material,
    MainNavRoutes.MaterialIcons,
    MainNavRoutes.MaterialIConsExtended,
    MainNavRoutes.Navigation,
    MainNavRoutes.Paging,
    MainNavRoutes.Runtime,
    MainNavRoutes.Ui,
    MainNavRoutes.ViewModel,
)

@Composable
fun MainScreenWithDrawer(
    navController: NavHostController,
    title: String = stringResource(id = R.string.app_name),
    list: List<String> = routes,
    navigateToSearch: (() -> Unit)? = { navController.navigate(MainNavRoutes.Search) },
    showAd: Boolean = true,
) {
    val state = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    Scaffold(
        scaffoldState = state,
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            MenuTopAppBar(
                title = title,
                openDrawer = {
                    scope.launch {
                        state.drawerState.open()
                    }
                },
                navigateToSearch = navigateToSearch
            )
        },
        drawerContent = {
            DrawerListItem(
                text = "Popular",
                icon = {
                    Icon(
                        Icons.Default.ThumbUp, contentDescription = "Open Popular"
                    )
                }
            ) {
                Toast.makeText(context, "Coming soon", Toast.LENGTH_SHORT).show()
            }
            DrawerListItem(
                text = "Favorite",
                icon = {
                    Icon(
                        Icons.Default.Favorite, contentDescription = "Open Favorites"
                    )
                }
            ) {
                Toast.makeText(context, "Coming soon", Toast.LENGTH_SHORT).show()
            }
            Divider()
            DrawerListItem(
                text = "Settings",
                icon = {
                    Icon(
                        Icons.Default.Settings, contentDescription = "Open Settings"
                    )
                }
            ) {
                scope.launch {
                    state.drawerState.close()

                    navController.navigate(MainNavRoutes.Settings)
                }
            }
        }
    ) {
        MainScreenContent(navController, it, list, showAd)
    }
}

@Composable
fun MainScreen(
    navController: NavHostController,
    title: String = stringResource(id = R.string.app_name),
    list: List<String> = routes,
    navigateToSearch: (() -> Unit)? = { navController.navigate(MainNavRoutes.Search) },
    showAd: Boolean = true,
) {
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            DefaultTopAppBar(
                title = title,
                navigateToSearch = navigateToSearch
            )
        },
    ) {
        MainScreenContent(navController, it, list, showAd)
    }
}

@Composable
private fun MainScreenContent(
    navController: NavHostController,
    paddingValues: PaddingValues,
    list: List<String>,
    showAd: Boolean,
) {
    val routesWithRibbons = remember {
        list.map { route ->
            route to (route in ribbonRoutes)
        }
    }
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .verticalScroll(rememberScrollState())
    ) {
        routesWithRibbons.forEach { (route, shouldShowRibbon) ->
            DefaultCardListItem(
                text = route,
                shouldShowRibbon = shouldShowRibbon
            ) {
                navController.navigate(route)
            }
        }
        if (showAd) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(55.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                AdViewExample(R.string.main_screen_banner_id)
            }
        }
    }
}

@Composable
private fun DrawerListItem(
    text: String,
    icon: @Composable (() -> Unit)? = null,
    onClick: () -> Unit
) {
    DefaultListItem(
        text = AnnotatedString(text),
        modifier = Modifier.clickable(onClick = onClick),
        icon = icon
    )
}
