package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "ui/LocalClipboardManagerScreen.kt"

@Composable
fun LocalClipboardManagerScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalClipboardManager.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LocalClipboardManagerExample()
        }
    }
}

@Composable
private fun LocalClipboardManagerExample() {
    val clipboardManager = LocalClipboardManager.current
    clipboardManager.getText()?.let {
        clipboardManager.setText(AnnotatedString("Local Clipboard manager example"))
    }
    Text(text = "Value in clipboard:\n${clipboardManager.getText()}")
}