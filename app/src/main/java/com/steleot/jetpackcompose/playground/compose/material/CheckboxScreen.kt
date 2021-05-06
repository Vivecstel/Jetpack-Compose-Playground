package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults.colors
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

private const val Url = "material/CheckboxScreen.kt"

@Composable
fun CheckboxScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.Checkbox,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultCheckbox()
            CheckedColorCheckbox()
            UncheckedColorCheckbox()
            CheckmarkColorCheckbox()
            DisabledColorCheckbox()
            DisabledIndeterminateColorCheckbox()
            DisabledCheckbox()
            LabeledCheckbox()
        }
    }
}

@Preview
@Composable
private fun DefaultCheckbox() {
    val isChecked = remember { mutableStateOf(false) }
    Checkbox(
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        }
    )
}

@Preview
@Composable
private fun CheckedColorCheckbox() {
    val isChecked = remember { mutableStateOf(false) }
    Checkbox(
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            checkedColor = Color.Green
        )
    )
}

@Preview
@Composable
private fun UncheckedColorCheckbox() {
    val isChecked = remember { mutableStateOf(false) }
    Checkbox(
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            uncheckedColor = Color.Cyan
        )
    )
}

@Preview
@Composable
private fun CheckmarkColorCheckbox() {
    val isChecked = remember { mutableStateOf(false) }
    Checkbox(
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            checkmarkColor = Color.Yellow
        )
    )
}

@Preview
@Composable
private fun DisabledColorCheckbox() {
    val isChecked = remember { mutableStateOf(true) }
    Checkbox(
        enabled = false,
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            disabledColor = Color.Black
        )
    )
}

@Preview
@Composable
private fun DisabledIndeterminateColorCheckbox() {
    val isChecked = remember { mutableStateOf(true) }
    Checkbox(
        enabled = false,
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = colors(
            disabledIndeterminateColor = Color.Magenta
        )
    )
}

@Preview
@Composable
private fun DisabledCheckbox() {
    val isChecked = remember { mutableStateOf(true) }
    Checkbox(
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        enabled = false
    )
}

@Preview
@Composable
private fun LabeledCheckbox() {
    val isChecked = remember { mutableStateOf(false) }
    Row(modifier = Modifier.clickable(onClick = {
        isChecked.value = !isChecked.value
    })) {
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { checked ->
                isChecked.value = checked
            }
        )
        Text(
            text = "Checkbox label: ${if (isChecked.value) "is checked" else "is not checked"}",
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
