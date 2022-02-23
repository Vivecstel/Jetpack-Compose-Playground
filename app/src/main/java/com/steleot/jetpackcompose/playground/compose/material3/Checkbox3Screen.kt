package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold

private const val Url = "material3/Checkbox3Screen.kt"

@Composable
fun Checkbox3Screen() {
    DefaultScaffold(
        title = Material3NavRoutes.Checkbox3,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultCheckbox()
            CheckedColorCheckbox()
            UncheckedColorCheckbox()
            CheckmarkColorCheckbox()
            DisabledCheckedColorCheckbox()
            DisabledUncheckedColorCheckbox()
            DisabledIndeterminateColorCheckbox()
            DisabledCheckbox()
            LabeledCheckbox()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun CheckedColorCheckbox() {
    val isChecked = remember { mutableStateOf(false) }
    Checkbox(
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Green
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun UncheckedColorCheckbox() {
    val isChecked = remember { mutableStateOf(false) }
    Checkbox(
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = CheckboxDefaults.colors(
            uncheckedColor = Color.Cyan
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun CheckmarkColorCheckbox() {
    val isChecked = remember { mutableStateOf(false) }
    Checkbox(
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = CheckboxDefaults.colors(
            checkmarkColor = Color.Yellow
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun DisabledCheckedColorCheckbox() {
    val isChecked = remember { mutableStateOf(true) }
    Checkbox(
        enabled = false,
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = CheckboxDefaults.colors(
            disabledCheckedColor = Color.Green.copy(alpha = 0.5f)
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun DisabledUncheckedColorCheckbox() {
    val isChecked = remember { mutableStateOf(true) }
    Checkbox(
        enabled = false,
        checked = isChecked.value,
        onCheckedChange = { checked ->
            isChecked.value = checked
        },
        colors = CheckboxDefaults.colors(
            disabledUncheckedColor = Color.Green.copy(alpha = 0.5f)
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
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
        colors = CheckboxDefaults.colors(
            disabledIndeterminateColor = Color.Magenta
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
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

@OptIn(ExperimentalMaterial3Api::class)
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
            text = stringResource(
                id = R.string.checkbox_msg,
                stringResource(id = if (isChecked.value) R.string.is_checked else R.string.is_not_checked)
            ),
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        )
    }
}