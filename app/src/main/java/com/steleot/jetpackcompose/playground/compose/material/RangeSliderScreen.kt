package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ExperimentalMaterialApi
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.RangeSlider
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.SliderDefaults
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/RangeSliderScreen.kt"

@Composable
fun RangeSliderScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.RangeSlider,
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

@OptIn(ExperimentalMaterialApi::class)
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

@OptIn(ExperimentalMaterialApi::class)
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

@OptIn(ExperimentalMaterialApi::class)
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

@OptIn(ExperimentalMaterialApi::class)
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

@OptIn(ExperimentalMaterialApi::class)
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
