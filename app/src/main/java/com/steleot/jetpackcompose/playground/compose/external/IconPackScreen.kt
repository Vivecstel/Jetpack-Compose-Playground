package com.steleot.jetpackcompose.playground.compose.external

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "external/IconPackScreen.kt"

@Composable
fun IconPackScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.IconPack.capitalize(Locale.getDefault()),
        link = Url,
    ) {
//        val icons = remember { FontAwesomeIcons.AllIcons}
    }
}