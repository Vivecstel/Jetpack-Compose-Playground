package com.steleot.jetpackcompose.playground.compose.external

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "external/InsetsScreen.kt"

@Composable
fun InsetsScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.Insets.capitalize(Locale.getDefault()),
        link = Url,
    ) {

    }
}