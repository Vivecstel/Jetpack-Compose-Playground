package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

private const val Url = "ui/LocalUriHandlerScreen.kt"

@Composable
fun LocalUriHandlerScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalUriHandler,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LocalUriHandlerExample()
        }
    }
}

@Composable
private fun LocalUriHandlerExample() {
    val uriHandler = LocalUriHandler.current
    Button(onClick = {
        uriHandler.openUri("https://www.google.gr/")
    }) {
        Text(text = "Press me to google")
    }
}