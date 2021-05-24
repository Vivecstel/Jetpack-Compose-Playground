package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold


private const val Url = "external/OrchestraColorPickerScreen.kt"

@Composable
fun OrchestraColorPickerScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.OrchestraColorPicker,
        link = Url,
    ) {

    }
}
