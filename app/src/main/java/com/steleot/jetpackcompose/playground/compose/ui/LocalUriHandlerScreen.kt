package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import timber.log.Timber

private const val URL = "ui/LocalUriHandlerScreen.kt"

@Composable
fun LocalUriHandlerScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalUriHandler,
        link = URL,
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
        try {
            uriHandler.openUri("https://www.google.gr/")
        } catch (e: Exception) {
            Timber.e(e, "Failed to open uri")
        }
    }) {
        Text(text = stringResource(id = R.string.press_me))
    }
}