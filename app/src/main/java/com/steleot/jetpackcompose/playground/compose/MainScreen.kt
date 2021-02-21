package com.steleot.jetpackcompose.playground.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultListItem
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultTopAppBar
import dev.chrisbanes.accompanist.insets.statusBarsPadding

private val routes = listOf(
    MainNavRoutes.Animation,
    MainNavRoutes.ConstraintLayout,
    MainNavRoutes.Foundation,
    MainNavRoutes.FoundationLayout,
    MainNavRoutes.Material,
    MainNavRoutes.MaterialIcons,
    MainNavRoutes.MaterialIConsExtended,
    MainNavRoutes.Ui,
)

@Composable
fun MainScreen(
    navController: NavHostController,
    title: String = stringResource(id = R.string.app_name),
    list: List<String> = routes,
    showBackArrow: Boolean = false
) {
    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        topBar = {
            DefaultTopAppBar(
                title = title,
                showBackArrow = showBackArrow,
            )
        }
    ) {
        LazyColumn {
            items(list) {
                DefaultListItem(
                    text = it,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    navController.navigate(it)
                }
            }
        }
    }
}
