package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import dev.jeziellago.compose.markdowntext.MarkdownText

private const val Url = "external/ComposeMarkdownScreen.kt"

@Composable
fun ComposeMarkdownScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeMarkdown,
        link = Url,
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
    val markdown = """  
	# Sample  
	* Markdown  
	* [Link](https://example.com)  
	![Image](https://example.com/img.png)  
	<a href="https://www.google.com/">Google</a>  
""".trimIndent()
    MarkdownText(
        modifier = Modifier.padding(8.dp),
        markdown = markdown,
        textAlign = TextAlign.Center,
        fontSize = 12.sp,
        color = LocalContentColor.current,
        style = MaterialTheme.typography.overline,
    )
}
