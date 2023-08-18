package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Slider
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.SliderDefaults
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/SliderScreen.kt"

@Composable
fun SliderScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.Slider,
        link = URL,
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
    val state = remember { mutableFloatStateOf(0f) }
    Slider(
        value = state.floatValue,
        onValueChange = {
            state.floatValue = it
        },
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@Preview
@Composable
private fun RangedSlider() {
    val state = remember { mutableFloatStateOf(0f) }
    Slider(
        value = state.floatValue,
        onValueChange = {
            state.floatValue = it
        },
        modifier = Modifier.padding(horizontal = 16.dp),
        valueRange = 0f..2.5f,
    )
}

@Preview
@Composable
private fun SteppedSlider() {
    val state = remember { mutableFloatStateOf(0f) }
    Slider(
        value = state.floatValue,
        onValueChange = {
            state.floatValue = it
        },
        modifier = Modifier.padding(horizontal = 16.dp),
        valueRange = 0f..2.5f,
        steps = 3,
    )
}

@Preview
@Composable
private fun ColoredSlider() {
    val state = remember { mutableFloatStateOf(0f) }
    Slider(
        value = state.floatValue,
        onValueChange = {
            state.floatValue = it
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
    val state = remember { mutableFloatStateOf(0f) }
    val endState = remember { mutableFloatStateOf(0f) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = endState.floatValue.toString())
        Slider(
            value = state.floatValue,
            onValueChange = {
                state.floatValue = it
            },
            modifier = Modifier.padding(horizontal = 16.dp),
            onValueChangeFinished = {
                endState.floatValue = state.floatValue
            },
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
            )
        )
    }
}
