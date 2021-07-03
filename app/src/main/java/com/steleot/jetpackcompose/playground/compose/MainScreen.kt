package com.steleot.jetpackcompose.playground.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.insets.systemBarsPadding
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.customexamples.AdViewExample
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultListItem
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultTopAppBar
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes

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
fun MainScreen(
    navController: NavHostController,
    title: String = stringResource(id = R.string.app_name),
    list: List<String> = routes,
    showBackArrow: Boolean = false,
    navigateToSearch: (() -> Unit)? = { navController.navigate(MainNavRoutes.Search) },
    showSettings: Boolean = false,
    showAd: Boolean = true,
) {
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            DefaultTopAppBar(
                title = title,
                showBackArrow = showBackArrow,
                navigateToSearch = navigateToSearch
            )
        },
        floatingActionButton = {
            if (showSettings) {
                FloatingActionButton(onClick = {
                    navController.navigate(MainNavRoutes.Settings)
                }) {
                    Icon(
                        imageVector = Icons.Outlined.Settings,
                        contentDescription = "Icon Floating Action Button",
                        tint = MaterialTheme.colors.onPrimary
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            list.forEach { item ->
                DefaultListItem(
                    text = item,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    navController.navigate(item)
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
}
