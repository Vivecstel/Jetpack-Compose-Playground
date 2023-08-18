package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.LocalContentColor
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import dev.jeziellago.compose.markdowntext.MarkdownText

private const val URL = "externallibraries/ComposeMarkdownScreen.kt"

@Composable
fun ComposeMarkdownScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeMarkdown,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ComposeMarkdownExample()
        }
    }
}

@Composable
private fun ComposeMarkdownExample() {
    MarkdownText(
        modifier = Modifier.padding(8.dp),
        markdown = stringResource(id = R.string.markdown),
        textAlign = TextAlign.Center,
        fontSize = 12.sp,
        color = LocalContentColor.current,
        style = MaterialTheme.typography.overline,
    )
}
