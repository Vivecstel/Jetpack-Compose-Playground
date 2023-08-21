package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "ui/DialogScreen.kt"

@Composable
fun DialogScreen() {
    DefaultScaffold(
        title = UiNavRoutes.Dialog,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
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
                    .background(Color.White)
            )
        }
    }

    Button(
        onClick = { openDialog.value = true },
    ) {
        Text(
            text = stringResource(id = R.string.show_dialog)
        )
    }
}