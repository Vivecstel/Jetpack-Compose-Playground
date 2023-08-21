package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "externallibraries/WebViewAccompanistScreen.kt"

@Composable
fun WebViewAccompanistScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.WebViewAccompanist,
        link = URL,
    ) {
        WebViewExample(paddingValues = it)
    }
}

@Composable
private fun WebViewExample(paddingValues: PaddingValues) {
    val state = rememberWebViewState("https://github.com/Vivecstel/Jetpack-Compose-Playground")
    WebView(
        state = state,
        modifier = Modifier.fillMaxSize().padding(paddingValues = paddingValues)
    )
}