package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "external/OrchestraBalloonScreen.kt"

@Composable
fun OrchestraBalloonScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.OrchestraBalloon,
        link = Url,
    ) {

    }
}

@Composable
private fun BalloonAnchorExample() {

}
