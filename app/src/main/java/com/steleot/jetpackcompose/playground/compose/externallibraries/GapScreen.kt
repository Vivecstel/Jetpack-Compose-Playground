package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes

private const val Url = "externallibraries/GapScreen.kt"

@Composable
fun GapScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.Gap,
        link = Url,
    ) {
        // todo
    }
}