package com.steleot.jetpackcompose.playground.compose.reusable

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.insets.statusBarsPadding
import java.util.*

@Preview
@Composable
fun DefaultListItem(
    @PreviewParameter(DefaultListItemPreviewParameter::class) text: String,
    modifier: Modifier = Modifier,
    cardClickAction: () -> Unit = {},
) {
    Card(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable(onClick = cardClickAction)
    ) {
        Text(
            text.capitalize(Locale.getDefault()),
            style = MaterialTheme.typography.body1,
            modifier = modifier
                .padding(16.dp)
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
    showBackArrow: Boolean = false,
) {
    val ambient = LocalOnBackPressedDispatcherOwner.current
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            if (showBackArrow) {
                IconButton(onClick = {
                    ambient.onBackPressedDispatcher.onBackPressed()
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back Arrow")
                }
            }
        }
    )
}

@Composable
fun DefaultScaffold(
    title: String = "",
    bodyContent: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        topBar = {
            DefaultTopAppBar(
                title = title,
                showBackArrow = true,
            )
        },
        bodyContent = bodyContent
    )
}
