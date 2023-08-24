package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultTopAppBar
import kotlinx.coroutines.launch

private const val URL = "material3/Snackbar3Screen.kt"

@Composable
fun Snackbar3Screen() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            DefaultTopAppBar(
                title = Material3NavRoutes.SnackBar3,
                link = URL,
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val helloWorld = stringResource(id = R.string.hello_world)
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(helloWorld)
                    }
                }
            ) {
                Text(text = stringResource(id = R.string.show_snackbar))
            }
            DefaultSnackbar()
            ShapeSnackbar()
            ContainerColorSnackbar()
            ActionSnackbar()
            ActionOnNewLineSnackbar()
        }
    }
}

@Preview
@Composable
private fun DefaultSnackbar(
    text: String = stringResource(id = R.string.app_name)
) {
    Snackbar(
        content = { Text(text = text, color = Color.White) }
    )
}

@Preview
@Composable
private fun ShapeSnackbar() {
    Snackbar(
        content = { Text(text = stringResource(id = R.string.app_name), color = Color.White) },
        shape = RoundedCornerShape(8.dp)
    )
}

@Preview
@Composable
private fun ContainerColorSnackbar() {
    Snackbar(
        content = { Text(text = stringResource(id = R.string.app_name), color = Color.White) },
        containerColor = Color.Red,
    )
}

@Preview
@Composable
private fun ActionSnackbar() {
    Snackbar(
        content = { Text(text = stringResource(id = R.string.app_name), color = Color.White) },
        action = {
            Text(
                text = "Undo",
                modifier = Modifier
                    .padding(end = 16.dp)
                    .clickable(onClick = {}),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            )
        }
    )
}

@Preview
@Composable
private fun ActionOnNewLineSnackbar() {
    Snackbar(
        content = {
            Text(
                text = stringResource(id = R.string.app_name).repeat(3),
                color = Color.White
            )
        },
        action = {
            Text(
                text = "Undo",
                modifier = Modifier
                    .padding(end = 16.dp)
                    .clickable(onClick = {}),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            )
        },
        actionOnNewLine = true
    )
}