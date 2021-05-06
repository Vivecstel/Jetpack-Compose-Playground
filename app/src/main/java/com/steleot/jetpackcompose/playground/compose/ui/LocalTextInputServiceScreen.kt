package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "ui/LocalTextInputServiceScreen.kt"

@Composable
fun LocalTextInputServiceScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalTextInputService,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            LocalTextInputServiceExample()
        }
    }
}

@Composable
private fun LocalTextInputServiceExample() {
    val textInputService = LocalTextInputService.current
    val (text, setText) = remember { mutableStateOf("Empty text field") }
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            text,
            setText,
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            textInputService?.showSoftwareKeyboard()
        }) {
            Text(text = "Press me to show keyboard")
        }
        Button(onClick = {
            textInputService?.hideSoftwareKeyboard()
        }) {
            Text(text = "Press me to hide keyboard")
        }
    }
}