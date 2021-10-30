package com.steleot.jetpackcompose.playground.compose.reusable

import androidx.compose.material.TopAppBar
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

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
            }
            navigateToSearch?.let {
                SearchIconButton(it)
            }
        }
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
        }
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
        }
    )
}