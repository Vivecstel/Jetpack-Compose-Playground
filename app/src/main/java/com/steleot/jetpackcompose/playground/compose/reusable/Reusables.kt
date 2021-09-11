package com.steleot.jetpackcompose.playground.compose.reusable

import android.app.Activity
import android.content.Intent
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.google.accompanist.insets.systemBarsPadding
import com.steleot.jetpackcompose.playground.BuildConfig
import com.steleot.jetpackcompose.playground.LocalInAppReviewer
import com.steleot.jetpackcompose.playground.utils.capitalizeFirstLetter

@Composable
fun DefaultCardListItem(
    text: String,
    shouldShowRibbon: Boolean = false,
    cardClickAction: () -> Unit = {},
) {
    DefaultCardListItem(
        AnnotatedString(text.capitalizeFirstLetter()), shouldShowRibbon, cardClickAction
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DefaultCardListItem(
    text: AnnotatedString,
    shouldShowRibbon: Boolean = false,
    cardClickAction: () -> Unit = {},
) {
    with(LocalDensity.current) {
        val offset = 28.dp.toPx()
        val secondaryColor = MaterialTheme.colors.secondary
        Card(
            onClick = cardClickAction,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 4.dp),
            elevation = 4.dp
        ) {
            DefaultListItem(text = text) {
                if (shouldShowRibbon) {
                    Canvas(
                        modifier = Modifier
                            .height(48.dp)
                            .width(15.dp)
                    ) {
                        drawPath(
                            getRibbonPath(size.width, size.height - offset),
                            secondaryColor
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DefaultListItem(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    icon: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null
) {
    ListItem(
        modifier = modifier,
        icon = icon,
        trailing = trailing
    ) {
        Text(
            text,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
        )
    }
}

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
            BackArrow()
        },
        actions = {
            link?.let {
                GoToGithubButton(it)
            }
            navigateToSearch?.let {
                IconButton(onClick = it) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                    )
                }
            }
        }
    )
}

@Composable
private fun TitleText(
    title: String,
) {
    Text(
        text = title.capitalizeFirstLetter(),
        style = MaterialTheme.typography.h6,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
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
                IconButton(onClick = it) {
                    Icon(
                        Icons.Filled.Menu, contentDescription = "Open Drawer"
                    )
                }
            }
        },
        actions = {
            navigateToSearch?.let {
                IconButton(onClick = it) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                    )
                }
            }
        }
    )
}

@Composable
fun GoToGithubButton(link: String) {
    val context = LocalContext.current
    IconButton(onClick = {
        context.startActivity(Intent(Intent.ACTION_VIEW).apply {
            data = "${BuildConfig.BASE_URL}$link".toUri()
        })
    }) {
        Icon(
            imageVector = Icons.Filled.ExitToApp,
            contentDescription = "Open Github",
        )
    }
}

@Composable
fun BackArrow() {
    val backDispatcher = LocalOnBackPressedDispatcherOwner.current
    IconButton(onClick = {
        backDispatcher?.onBackPressedDispatcher?.onBackPressed()
    }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back Arrow",
        )
    }
}

@Composable
fun DefaultScaffold(
    topBar: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    val context = LocalContext.current
    val inAppReviewer = LocalInAppReviewer.current
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = topBar,
        content = content,
    )
    LaunchedEffect(Unit) {
        if (context is Activity) inAppReviewer.requestReview(context)
    }
}

@Composable
fun DefaultScaffold(
    title: String,
    link: String? = null,
    content: @Composable (PaddingValues) -> Unit,
) {
    DefaultScaffold(
        topBar = {
            DefaultTopAppBar(
                title = title,
                link = link,
            )
        },
        content = content
    )
}
