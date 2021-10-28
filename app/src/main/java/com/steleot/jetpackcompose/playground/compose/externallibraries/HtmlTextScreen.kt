package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes

private const val Url = "externallibraries/HtmlTextScreen.kt"

@Composable
fun HtmlTextScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.HtmlText,
        link = Url,
    ) {
        // todo
    }
}