package com.steleot.jetpackcompose.playground.compose.reusable

import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.material3.MaterialTheme as MaterialTheme3

object DefaultListItemPreviewParameter : PreviewParameterProvider<String> {
    override val values: Sequence<String>
        get() = sequenceOf("Jetpack Compose Playground")

}

@Preview
@Composable
fun DefaultTopAppBar(
    @PreviewParameter(DefaultListItemPreviewParameter::class) title: String,
    modifier: Modifier = Modifier,
    navigateToSearch: (() -> Unit)? = null,
    link: String? = null
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
            link?.let {
                GoToGithubIconButton(it)
                DefaultDropdownMenu(title)
            }
            navigateToSearch?.let {
                SearchIconButton(it)
            }
        },
        backgroundColor = MaterialTheme.colors.primary
    )
}

@Preview
@Composable
fun MenuTopAppBar(
    @PreviewParameter(DefaultListItemPreviewParameter::class) title: String,
    modifier: Modifier = Modifier,
    openDrawer: (() -> Unit)? = null,
    navigateToSearch: (() -> Unit)? = null,
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
            navigateToSearch?.let {
                SearchIconButton(it)
            }
        },
        backgroundColor = MaterialTheme.colors.primary
    )
}

@Preview
@Composable
fun DefaultSmallTopAppBar(
    @PreviewParameter(DefaultListItemPreviewParameter::class) title: String,
    modifier: Modifier = Modifier,
    navigateToSearch: (() -> Unit)? = null,
    link: String? = null
) {
    SmallTopAppBar(
        title = {
            TitleText3(title)
        },
        modifier = modifier,
        navigationIcon = {
            BackArrow3()
        },
        actions = {
            link?.let {
                GoToGithubButton3(it)
            }
            navigateToSearch?.let {
                SearchIconButton3(it)
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme3.colorScheme.primary,
            navigationIconContentColor = MaterialTheme3.colorScheme.onPrimary,
            titleContentColor = MaterialTheme3.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme3.colorScheme.onPrimary,
        )
    )
}