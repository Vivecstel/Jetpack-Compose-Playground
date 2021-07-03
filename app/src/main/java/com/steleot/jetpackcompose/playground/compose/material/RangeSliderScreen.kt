package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes

private const val Url = "material/RangeSliderScreen.kt"

@Composable
fun RangeSliderScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.RangeSlider,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultRangeSlider()
            RangedSlider()
            SteppedSlider()
            ColoredSlider()
            EndListenerSlider()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun DefaultRangeSlider() {
    val state = remember { mutableStateOf(0f..5f) }
    RangeSlider(
        values = state.value,
        onValueChange = {
            state.value = it
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun RangedSlider() {
    val state = remember { mutableStateOf(0f..5f) }
    RangeSlider(
        values = state.value,
        onValueChange = {
            state.value = it
        },
        modifier = Modifier.padding(horizontal = 16.dp),
        valueRange = 0f..10f,
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun SteppedSlider() {
    val state = remember { mutableStateOf(0f..5f) }
    RangeSlider(
        values = state.value,
        onValueChange = {
            state.value = it
        },
        modifier = Modifier.padding(horizontal = 16.dp),
        valueRange = 0f..10f,
        steps = 3,
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun ColoredSlider() {
    val state = remember { mutableStateOf(0f..5f) }
    RangeSlider(
        values = state.value,
        onValueChange = {
            state.value = it
        },
        modifier = Modifier.padding(horizontal = 16.dp),
        steps = 5,
        colors = SliderDefaults.colors(
            thumbColor = Color.Red,
            activeTickColor = Color.Magenta,
            inactiveTickColor = Color.Yellow,
        ),
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun EndListenerSlider() {
    val state = remember { mutableStateOf(0f..5f) }
    var endState by remember { mutableStateOf(0f..0f) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "start: ${endState.start}, end: ${endState.start}")
        RangeSlider(
            values = state.value,
            onValueChange = {
                state.value = it
            },
            modifier = Modifier.padding(horizontal = 16.dp),
            onValueChangeFinished = {
                endState = state.value
            },
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
            )
        )
    }
}
