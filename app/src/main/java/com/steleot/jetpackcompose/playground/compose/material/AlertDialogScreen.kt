package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes

private const val Url = "material/AlertDialog3Screen.kt"

@Composable
fun AlertDialogScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.AlertDialog,
        link = Url,
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
                Text(text = stringResource(id = R.string.text_args, 1))
            },
            title = {
                Text(text = stringResource(id = R.string.title))
            },
            buttons = {
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.close),
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable(onClick = {
                                showingDialog.value = false
                            })
                    )
                }
            },
        )
    }
    Button(
        onClick = { showingDialog.value = true },
    ) {
        Text(
            text = stringResource(id = R.string.show_args, "Default dialog")
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
                Text(text = stringResource(id = R.string.text_args, 1))
            },
            title = {
                Text(text = stringResource(id = R.string.title))
            },
            confirmButton = {
                Text(
                    text = stringResource(id = R.string.cancel),
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable(onClick = {
                            showingDialog.value = false
                        })
                )
            },
            dismissButton = {
                Text(
                    text = stringResource(id = R.string.close),
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable(onClick = {
                            showingDialog.value = false
                        })
                )
            },
            contentColor = Color.White,
            shape = RectangleShape,
        )
    }
    Button(onClick = {
        showingDialog.value = true
    }) {
        Text(
            text = stringResource(id = R.string.show_args, "Content Color Alert Dialog")
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
                Text(text = stringResource(id = R.string.text_args, 1))
            },
            title = {
                Text(text = stringResource(id = R.string.title))
            },
            confirmButton = {
                Text(
                    text = stringResource(id = R.string.close),
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable(onClick = {
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
            text = stringResource(id = R.string.show_args, "Background Color Alert Dialog")
        )
    }
}
