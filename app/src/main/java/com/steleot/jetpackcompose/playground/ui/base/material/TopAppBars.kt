package com.steleot.jetpackcompose.playground.ui.base.material

import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.localproviders.LocalNavController
import com.steleot.jetpackcompose.playground.navigation.graph.MainNavRoutes

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
            BackArrowIconButton()
        },
        actions = {

            if (link != null) {
                GoToGithubIconButton(link)
                DefaultDropdownMenu(title) {
                    DropdownIconButton(it)
                }
            } else if (shouldAllowSearch == true) {
                val navController = LocalNavController.current
                SearchIconButton {
                    navController.navigate(MainNavRoutes.Search)
                }
            }
        },
        backgroundColor = MaterialTheme.colors.primary
    )
}

@Composable
fun MenuTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    openDrawer: (() -> Unit)? = null,
) {
    TopAppBar(
        title = {
            TitleText(title)
        },
        modifier = modifier,
        navigationIcon = {
            openDrawer?.let {
                OpenDrawerIconButton(it)
            }
        },
        actions = {
            val navController = LocalNavController.current
            SearchIconButton {
                navController.navigate(MainNavRoutes.Search)
            }
        },
        backgroundColor = MaterialTheme.colors.primary
    )
}