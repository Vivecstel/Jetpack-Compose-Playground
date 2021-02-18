package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun SnackBarScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.SnackBar.capitalize(Locale.getDefault())
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
fun DefaultSnackbar() {
    Snackbar(
        text = { Text(text = "Jetpack Compose Playground Snackbar", color = Color.White) }
    )
}

@Preview
@Composable
fun ShapeSnackbar() {
    Snackbar(
        text = { Text(text = "Jetpack Compose Playground Snackbar", color = Color.White) },
        shape = RoundedCornerShape(8.dp)
    )
}

@Preview
@Composable
fun BackgroundColorSnackbar() {
    Snackbar(
        text = { Text(text = "Jetpack Compose Playground Snackbar", color = Color.White) },
        backgroundColor = Color.Red,
    )
}

@Preview
@Composable
fun ElevationSnackbar() {
    Snackbar(
        text = { Text(text = "Jetpack Compose Playground Snackbar", color = Color.White) },
        elevation = 8.dp
    )
}

@Preview
@Composable
fun ActionSnackbar() {
    Snackbar(
        text = { Text(text = "Jetpack Compose Playground Snackbar", color = Color.White) },
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
fun ActionOnNewLineSnackbar() {
    Snackbar(
        text = {
            Text(
                text = "Jetpack Compose Playground Snackbar Jetpack Compose Playground Snackbar",
                color = Color.White
            )
        },
        action = {
            Text(
                text = "Undo",
                modifier = Modifier.padding(end = 16.dp)
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