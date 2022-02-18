package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
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
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold3
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes

private const val Url = "material3/RadioButton3Screen.kt"

@Composable
fun RadioButton3Screen() {
    DefaultScaffold3(
        title = Material3NavRoutes.RadioButton3,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultRadioButton()
            DisabledRadioButton()
            SelectedColorRadioButton()
            UnselectedColorRadioButton()
            DisabledSelectedColorRadioButton()
            DisabledUnselectedColorRadioButton()
            RadioButtonWithLabel()
            RadioButtonGroup()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun DefaultRadioButton(
    text: String = stringResource(id = R.string.app_name)
) {
    val state = remember { mutableStateOf("") }
    RadioButton(
        selected = state.value == text,
        onClick = {
            state.value = text
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun DisabledRadioButton(
    text: String = stringResource(id = R.string.app_name)
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun SelectedColorRadioButton(
    text: String = stringResource(id = R.string.app_name)
) {
    val state = remember { mutableStateOf("") }
    RadioButton(
        selected = state.value == text,
        onClick = {
            state.value = text
        },
        colors = RadioButtonDefaults.colors(
            selectedColor = Color.Cyan
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun UnselectedColorRadioButton(
    text: String = stringResource(id = R.string.app_name)
) {
    val state = remember { mutableStateOf("") }
    RadioButton(
        selected = state.value == text,
        onClick = {
            state.value = text
        },
        colors = RadioButtonDefaults.colors(
            unselectedColor = Color.Red
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun DisabledSelectedColorRadioButton(
    text: String = stringResource(id = R.string.app_name)
) {
    val state = remember { mutableStateOf("") }
    RadioButton(
        selected = state.value == text,
        onClick = {
            state.value = text
        },
        colors = RadioButtonDefaults.colors(
            disabledSelectedColor = Color.Magenta,
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun DisabledUnselectedColorRadioButton(
    text: String = stringResource(id = R.string.app_name)
) {
    val state = remember { mutableStateOf("") }
    RadioButton(
        selected = state.value == text,
        onClick = {
            state.value = text
        },
        colors = RadioButtonDefaults.colors(
            disabledUnselectedColor = Color.Magenta,
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RadioButtonWithLabel(
    text: String = stringResource(id = R.string.app_name)
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
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.CenterVertically)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun RadioButtonGroup(
    items: List<String> = stringResource(id = R.string.app_name).split(' ')
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
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}