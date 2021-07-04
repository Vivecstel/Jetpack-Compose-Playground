package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

private const val Url = "ui/LocalViewConfigurationScreen.kt"

@Composable
fun LocalViewConfigurationScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalViewConfiguration,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LocalViewConfigurationExample()
        }
    }
}

@Composable
private fun LocalViewConfigurationExample() {
    val viewConfiguration = LocalViewConfiguration.current
    Text(
        text = """
        Local view configuration values:
        doubleTapMinTimeMillis: ${viewConfiguration.doubleTapMinTimeMillis}
        doubleTapTimeoutMillis: ${viewConfiguration.doubleTapTimeoutMillis}
        longPressTimeoutMillis: ${viewConfiguration.longPressTimeoutMillis}
        touchSlop: ${viewConfiguration.touchSlop}
    """.trimIndent()
    )
}