package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults.colors
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
fun RadioButtonScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.RadioButton.capitalize(Locale.getDefault())
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultRadioButton()
            DisabledRadioButton()
            SelectedColoredRadioButton()
            UnselectedColoredRadioButton()
            DisabledColoredRadioButton()
            RadioButtonWithLabel()
            RadioButtonGroup()
        }
    }
}

@Preview
@Composable
private fun DefaultRadioButton(
    text: String = "Jetpack Compose Playground"
) {
    val state = remember { mutableStateOf("") }
    RadioButton(
        selected = state.value == text,
        onClick = {
            state.value = text
        }
    )
}

@Preview
@Composable
private fun DisabledRadioButton(
    text: String = "Jetpack Compose Playground"
) {
    val state = remember { mutableStateOf("") }
    RadioButton(
        selected = state.value == text,
        onClick = {
            state.value = text
        },
        enabled = false
    )
}

@Preview
@Composable
private fun SelectedColoredRadioButton(
    text: String = "Jetpack Compose Playground"
) {
    val state = remember { mutableStateOf("") }
    RadioButton(
        selected = state.value == text,
        onClick = {
            state.value = text
        },
        colors = colors(
            selectedColor = Color.Cyan
        )
    )
}

@Preview
@Composable
private fun UnselectedColoredRadioButton(
    text: String = "Jetpack Compose Playground"
) {
    val state = remember { mutableStateOf("") }
    RadioButton(
        selected = state.value == text,
        onClick = {
            state.value = text
        },
        colors = colors(
            unselectedColor = Color.Red
        )
    )
}

@Preview
@Composable
private fun DisabledColoredRadioButton(
    text: String = "Jetpack Compose Playground"
) {
    val state = remember { mutableStateOf("") }
    RadioButton(
        selected = state.value == text,
        onClick = {
            state.value = text
        },
        colors = colors(
            disabledColor = Color.Magenta,
        )
    )
}

@Composable
private fun RadioButtonWithLabel(
    text: String = "Jetpack Compose Playground"
) {
    val state = remember { mutableStateOf("") }
    Row(modifier = Modifier.padding(10.dp)) {
        RadioButton(
            selected = state.value == text,
            onClick = {
                state.value = text
            }
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Preview
@Composable
private fun RadioButtonGroup(
    items: List<String> = listOf("Jetpack", "Compose", "Playground")
) {
    val state = remember { mutableStateOf("") }
    Column {
        items.forEach { item ->
            Row(modifier = Modifier.padding(10.dp)) {
                RadioButton(
                    selected = state.value == item,
                    onClick = {
                        state.value = item
                    }
                )
                Text(
                    text = item,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}
