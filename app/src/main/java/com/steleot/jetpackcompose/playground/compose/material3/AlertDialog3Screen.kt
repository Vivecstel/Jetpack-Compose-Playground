package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold3
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes

private const val Url = "material3/AlertDialog3Screen.kt"

@Composable
fun AlertDialog3Screen() {
    DefaultScaffold3(
        title = Material3NavRoutes.AlertDialog3,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultAlertDialog3()
        }
    }
}

@Composable
private fun DefaultAlertDialog3() {
    val showingDialog = remember { mutableStateOf(false) }
    if (showingDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showingDialog.value = false
            },
            text = {
                Text(text = "Text")
            },
            title = {
                Text(text = "Title")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showingDialog.value = false
                    },
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text("Close")
                }
            },
        )
    }
    Button(
        onClick = { showingDialog.value = true },
    ) {
        Text(
            text = "Show Default dialog"
        )
    }
}