package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "external/OrchestraSpinnerScreen.kt"

@Composable
fun OrchestraSpinnerScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.OrchestraSpinner,
        link = Url,
    ) {

    }
}
