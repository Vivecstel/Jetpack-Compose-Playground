package com.steleot.jetpackcompose.playground.ui.base.material3

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DefaultSmallTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    link: String? = null,
    shouldAllowSearch: Boolean? = null
) {
    SmallTopAppBar(
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
                // todo stelios
//                DefaultDropdownMenu(title) {
//                    DropdownIconButton3(it)
//                }
            } else if (shouldAllowSearch == true) {
                // todo stelios
//                val navController = LocalNavController.current
//                SearchIconButton {
//                    navController.navigate(MainNavRoutes.Search)
//                }
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
        )
    )
}