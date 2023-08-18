package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material3/RangeSlider3Screen.kt"

@Composable
fun RangeSlider3Screen() {
    DefaultScaffold(
        title = Material3NavRoutes.RangeSlider3,
        link = URL,
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

@Preview
@Composable
private fun DefaultRangeSlider() {
    val state = remember { mutableStateOf(0f..5f) }
    RangeSlider(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        modifier = Modifier.padding(horizontal = 16.dp),
    )
}

@Preview
@Composable
private fun RangedSlider() {
    val state = remember { mutableStateOf(0f..5f) }
    RangeSlider(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        modifier = Modifier.padding(horizontal = 16.dp),
        valueRange = 0f..10f,
    )
}

@Preview
@Composable
private fun SteppedSlider() {
    val state = remember { mutableStateOf(0f..5f) }
    RangeSlider(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        modifier = Modifier.padding(horizontal = 16.dp),
        valueRange = 0f..10f,
        steps = 3,
    )
}

@Preview
@Composable
private fun ColoredSlider() {
    val state = remember { mutableStateOf(0f..5f) }
    RangeSlider(
        value = state.value,
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

@Preview
@Composable
private fun EndListenerSlider() {
    val state = remember { mutableStateOf(0f..5f) }
    var endState by remember { mutableStateOf(0f..0f) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(id = R.string.range_slider_value, endState.start))
        RangeSlider(
            value = state.value,
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