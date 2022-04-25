package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultTopAppBar

private const val Url = "material/BottomAppBarScreen.kt"

@Composable
fun BottomAppBarScreen() {
    val selectedLayout = remember { mutableStateOf(0) }
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            DefaultTopAppBar(
                title = MaterialNavRoutes.BottomAppBar,
                link = Url,
            )
        },
        bottomBar = {
            when (selectedLayout.value) {
                0 -> DefaultBottomAppBar()
                1 -> BackgroundColorBottomAppBar()
                2 -> ContentColorBottomAppBar()
                3 -> ElevationBottomAppBar()
                4, 5, 6 -> StyledBottomAppBar()
            }
        },
        floatingActionButton = {
            if (selectedLayout.value == 5 || selectedLayout.value == 6) {
                FloatingActionButton(onClick = {}) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = stringResource(id = R.string.add)
                    )
                }
            }
        },
        isFloatingActionButtonDocked = selectedLayout.value == 6
    ) {
        Column(
            modifier = Modifier.padding(it).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = {
                    selectedLayout.value =
                        if (selectedLayout.value == 6) 0 else selectedLayout.value + 1
                }
            ) {
                Text(text = stringResource(id = R.string.switch_args, "Bottom app bar"))
            }
        }
    }
}

@Preview
@Composable
private fun DefaultBottomAppBar() {
    BottomAppBar {
        BottomBarText()
    }
}

@Composable
private fun BottomBarText() {
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = Modifier.padding(16.dp)
    )
}

@Preview
@Composable
private fun BackgroundColorBottomAppBar() {
    BottomAppBar(
        backgroundColor = Color.Yellow
    ) {
        BottomBarText()
    }
}

@Preview
@Composable
private fun ContentColorBottomAppBar() {
    BottomAppBar(
        contentColor = Color.Black
    ) {
        BottomBarText()
    }
}

@Preview
@Composable
private fun ElevationBottomAppBar() {
    BottomAppBar(
        elevation = 12.dp,
    ) {
        BottomBarText()
    }
}

@Composable
private fun StyledBottomAppBar() {
    BottomAppBar(
        elevation = 12.dp,
        contentColor = Color.Blue,
        backgroundColor = Color.Magenta,
        cutoutShape = CircleShape
    ) {
        BottomBarText()
    }
}
