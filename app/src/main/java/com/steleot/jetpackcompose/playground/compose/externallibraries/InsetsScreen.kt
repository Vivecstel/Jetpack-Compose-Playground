package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.LocalWindowInsets
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes

private const val Url = "external/InsetsScreen.kt"

@Composable
fun InsetsScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.Insets,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InsetsExample()
        }
    }
}

@Composable
private fun InsetsExample() {
    val windowInsets = LocalWindowInsets.current
    val systemBarsInsets = windowInsets.systemBars.layoutInsets
    Text(
        text = """
        System bars insets:
        top: ${systemBarsInsets.top}
        left: ${systemBarsInsets.left}
        right: ${systemBarsInsets.right}
        bottom: ${systemBarsInsets.bottom}
        """.trimIndent()
    )
}