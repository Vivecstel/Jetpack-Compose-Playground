package com.steleot.jetpackcompose.playground.ui.base.material3

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.localproviders.LocalNavController
import com.steleot.jetpackcompose.playground.navigation.graph.MainNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultDropdownMenu
import com.steleot.jetpackcompose.playground.utils.navigateSafe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    link: String? = null,
    shouldAllowSearch: Boolean? = null
) {
    TopAppBar(
        title = {
            TitleText(title)
        },
        modifier = modifier,
        navigationIcon = {
            BackArrow()
        },
        actions = {
            if (link != null) {
                GoToGithubButton(link)
                DefaultDropdownMenu(title) {
                    DropdownIconButton(it)
                }
            } else if (shouldAllowSearch == true) {
                val navController = LocalNavController.current
                SearchIconButton {
                    navController.navigateSafe(MainNavRoutes.Search)
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
        )
    )
}