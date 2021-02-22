package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun SliderScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.Slider.capitalize(Locale.getDefault())
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultSlider()
            RangedSlider()
            SteppedSlider()
            ColoredSlider()
            EndListenerSlider()
        }
    }
}

@Preview
@Composable
private fun DefaultSlider() {
    val state = remember { mutableStateOf(0f) }
    Slider(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@Preview
@Composable
private fun RangedSlider() {
    val state = remember { mutableStateOf(0f) }
    Slider(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        modifier = Modifier.padding(horizontal = 16.dp),
        valueRange = 0f..2.5f,
    )
}

@Preview
@Composable
private fun SteppedSlider() {
    val state = remember { mutableStateOf(0f) }
    Slider(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        modifier = Modifier.padding(horizontal = 16.dp),
        valueRange = 0f..2.5f,
        steps = 3,
    )
}

@Preview
@Composable
private fun ColoredSlider() {
    val state = remember { mutableStateOf(0f) }
    Slider(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        modifier = Modifier.padding(horizontal = 16.dp),
        steps = 5,
        thumbColor = Color.Red,
        activeTickColor = Color.Magenta,
        inactiveTickColor = Color.Yellow
    )
}

@Preview
@Composable
private fun EndListenerSlider() {
    val state = remember { mutableStateOf(0f) }
    val endState = remember { mutableStateOf(0f) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = endState.value.toString())
        Slider(
            value = state.value,
            onValueChange = {
                state.value = it
            },
            modifier = Modifier.padding(horizontal = 16.dp),
            onValueChangeEnd = {
                endState.value = state.value
            },
            thumbColor = Color.Red,
        )
    }
}
