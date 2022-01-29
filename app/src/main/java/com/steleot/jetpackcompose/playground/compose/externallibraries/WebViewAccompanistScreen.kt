package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes

private const val Url = "externallibraries/WebViewAccompanistScreen.kt"

@Composable
fun WebViewAccompanistScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.WebViewAccompanist,
        link = Url,
    ) {
        WebViewExample()
    }
}

@Composable
private fun WebViewExample() {
    val state = rememberWebViewState("https://github.com/Vivecstel/Jetpack-Compose-Playground")
    WebView(
        state = state,
        modifier = Modifier.fillMaxSize()
    )
}