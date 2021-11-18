package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
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
            DefaultAlertDialog()
            TextContentColorAlertDialog()
            ContainerColorAlertDialog()
        }
    }
}

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
            confirmButton = {
                TextButton(
                    onClick = {
                        showingDialog.value = false
                    },
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(stringResource(id = R.string.close))
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

@Composable
private fun TextContentColorAlertDialog() {
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
                    text = stringResource(id = android.R.string.ok),
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable(onClick = {
                            showingDialog.value = false
                        })
                )
            },
            dismissButton = {
                Text(
                    text = stringResource(id = R.string.cancel),
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable(onClick = {
                            showingDialog.value = false
                        })
                )
            },
            textContentColor = MaterialTheme.colorScheme.secondary,
            shape = RectangleShape,
        )
    }
    Button(onClick = {
        showingDialog.value = true
    }) {
        Text(
            text = stringResource(id = R.string.show_args, "Text Color Alert Dialog")
        )
    }
}

@Preview
@Composable
private fun ContainerColorAlertDialog() {
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
            containerColor = MaterialTheme.colorScheme.tertiary,
            shape = CutCornerShape(12.dp),
        )
    }
    Button(onClick = {
        showingDialog.value = true
    }) {
        Text(
            text = stringResource(id = R.string.show_args, "Container Color Alert Dialog")
        )
    }
}
