package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.systemBarsPadding
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultTopAppBar
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes
import kotlinx.coroutines.launch

private const val Url = "material/SnackBarScreen.kt"

@Composable
fun SnackBarScreen() {
    val state = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            DefaultTopAppBar(
                title = MaterialNavRoutes.SnackBar,
                link = Url,
            )
        },
        scaffoldState = state,
        snackbarHost = { hostState ->
            hostState.currentSnackbarData?.let { DefaultSnackbar(it.message) }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val helloWorld = stringResource(id = R.string.hello_world)
            Button(
                onClick = {
                    scope.launch {
                        state.snackbarHostState.showSnackbar(helloWorld)
                    }
                }
            ) {
                Text(text = stringResource(id = R.string.show_snackbar))
            }
            DefaultSnackbar()
            ShapeSnackbar()
            BackgroundColorSnackbar()
            ElevationSnackbar()
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
private fun BackgroundColorSnackbar() {
    Snackbar(
        content = { Text(text = stringResource(id = R.string.app_name), color = Color.White) },
        backgroundColor = Color.Red,
    )
}

@Preview
@Composable
private fun ElevationSnackbar() {
    Snackbar(
        content = { Text(text = stringResource(id = R.string.app_name), color = Color.White) },
        elevation = 8.dp
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
                    color = MaterialTheme.colors.primary
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
                    color = MaterialTheme.colors.primary
                )
            )
        },
        actionOnNewLine = true
    )
}