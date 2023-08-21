package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.AlertDialog
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/AlertDialogScreen.kt"

@Composable
fun AlertDialogScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.AlertDialog,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
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
            contentColor = MaterialTheme.colors.primary,
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
            backgroundColor = MaterialTheme.colors.primary,
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
