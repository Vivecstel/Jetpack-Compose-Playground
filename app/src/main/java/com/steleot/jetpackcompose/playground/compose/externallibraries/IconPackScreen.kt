package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "external/IconPackScreen.kt"

@Composable
fun IconPackScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.IconPack,
        link = Url,
    ) {
//        val icons = remember { FontAwesomeIcons.AllIcons}
    }
}