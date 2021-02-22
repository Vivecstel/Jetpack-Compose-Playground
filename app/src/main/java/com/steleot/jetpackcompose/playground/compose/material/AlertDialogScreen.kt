package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun AlertDialogScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.AlertDialog.capitalize(Locale.getDefault())
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultAlertDialog()
            ContentColorAlertDialog()
            BackgroundColorAlertDialog()
        }
    }
}

@Preview
@Composable
private fun DefaultAlertDialog() {
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
            buttons = {
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Close",
                        modifier = Modifier.padding(16.dp).clickable(onClick = {
                            showingDialog.value = false
                        })
                    )
                }
            })
    }
    Button(
        onClick = { showingDialog.value = true },
    ) {
        Text(
            text = "Show Default dialog"
        )
    }
}

@Preview
@Composable
private fun ContentColorAlertDialog() {
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
                Text(text = "Continue",
                    modifier = Modifier.padding(16.dp).clickable(onClick = {
                        showingDialog.value = false
                    })
                )
            },
            dismissButton = {
                Text(text = "Close",
                    modifier = Modifier.padding(16.dp).clickable(onClick = {
                        showingDialog.value = false
                    })
                )
            },
            contentColor = Color.White,
            shape = RectangleShape
        )
    }
    Button(onClick = {
        showingDialog.value = true
    }) {
        Text(
            text = "Show Content Color Alert Dialog"
        )
    }
}

@Preview
@Composable
private fun BackgroundColorAlertDialog() {
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
                Text(text = "Close",
                    modifier = Modifier.padding(16.dp).clickable(onClick = {
                        showingDialog.value = false
                    })
                )
            },
            backgroundColor = Color.White,
            shape = CutCornerShape(12.dp),
        )
    }
    Button(onClick = {
        showingDialog.value = true
    }) {
        Text(
            text = "Show Background Color Alert Dialog"
        )
    }
}
