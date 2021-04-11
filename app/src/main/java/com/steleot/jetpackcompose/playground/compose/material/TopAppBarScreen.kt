package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "material/TopAppBarScreen.kt"

@Composable
fun TopAppBarScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.TopAppBar,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBarExample()
            BackgroundColorTopAppBar()
            ContentColorTopAppBar()
            ElevationTopAppBar()
            StyledTopAppBar()
        }
    }
}

@Preview
@Composable
private fun TopAppBarExample() {
    TopAppBar {
        TopBarText()
    }
}

@Composable
private fun TopBarText() {
    Text(
        text = "Jetpack Compose Playground",
        modifier = Modifier.padding(16.dp)
    )
}

@Preview
@Composable
private fun BackgroundColorTopAppBar() {
    TopAppBar(
        backgroundColor = Color.Yellow
    ) {
        TopBarText()
    }
}

@Preview
@Composable
private fun ContentColorTopAppBar() {
    TopAppBar(
        contentColor = Color.Black
    ) {
        TopBarText()
    }
}

@Preview
@Composable
private fun ElevationTopAppBar() {
    TopAppBar(
        elevation = 12.dp,
    ) {
        TopBarText()
    }
}

@Composable
private fun StyledTopAppBar() {
    TopAppBar(
        elevation = 12.dp,
        contentColor = Color.Blue,
        backgroundColor = Color.Magenta,
        contentPadding = PaddingValues(10.dp)
    ) {
        TopBarText()
    }
}