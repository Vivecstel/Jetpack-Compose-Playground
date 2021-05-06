package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.steleot.jetpackcompose.playground.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "ui/DialogScreen.kt"

@Composable
fun DialogScreen() {
    DefaultScaffold(
        title = UiNavRoutes.Dialog,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultDialog()
        }
    }
}

@Composable
private fun DefaultDialog() {
    val openDialog = remember { mutableStateOf(false) }
    val dialogWidth = 200.dp
    val dialogHeight = 50.dp

    if (openDialog.value) {
        Dialog(onDismissRequest = { openDialog.value = false }) {
            Box(
                Modifier
                    .size(dialogWidth, dialogHeight)
                    .background(Color.White))
        }
    }

    Button(
        onClick = { openDialog.value = true },
    ) {
        Text(
            text = "Show dialog"
        )
    }
}