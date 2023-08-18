package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material3/InputChipScreen.kt"

@Composable
fun InputChipScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.InputChip,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DefaultInputChip()
            DisabledInputChip()
            CutCornerShapeInputChip()
            RoundedCornerShapeInputChip()
            BorderInputChip()
            LeadingIconInputChip()
            ContainerColorInputChip()
            LabelColorInputChip()
            DisabledContainerColorInputChip()
            DisabledLabelColorInputChip()
            LeadingIconColorInputChip()
            DisabledLeadingIconColorInputChip()
            AvatarInputChip()
            TrailingIconInputChip()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DefaultInputChip() {
    val state = remember { mutableStateOf(false) }
    InputChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        label =  { DefaultText() }
    )
}

@Composable
private fun DefaultText() {
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = Modifier.padding(8.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DisabledInputChip() {
    val state = remember { mutableStateOf(false) }
    InputChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        enabled = false,
        label =  { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CutCornerShapeInputChip() {
    val state = remember { mutableStateOf(false) }
    InputChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        shape = CutCornerShape(12.dp),
        label =  { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RoundedCornerShapeInputChip() {
    val state = remember { mutableStateOf(false) }
    InputChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        shape = RoundedCornerShape(12.dp),
        label =  { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BorderInputChip() {
    val state = remember { mutableStateOf(false) }
    InputChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        border = InputChipDefaults.inputChipBorder(
            borderColor = Color.Red,
            borderWidth = 2.dp,
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LeadingIconInputChip() {
    val state = remember { mutableStateOf(false) }
    InputChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        leadingIcon = {
            Icon(
                Icons.Filled.Android,
                contentDescription = stringResource(id = R.string.android)
            )
        },
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ContainerColorInputChip() {
    val state = remember { mutableStateOf(false) }
    InputChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        colors = InputChipDefaults.inputChipColors(
            containerColor = Color.Red
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LabelColorInputChip() {
    val state = remember { mutableStateOf(false) }
    InputChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        colors = InputChipDefaults.inputChipColors(
            labelColor = Color.Green
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DisabledContainerColorInputChip() {
    val state = remember { mutableStateOf(false) }
    InputChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        enabled = false,
        colors = InputChipDefaults.inputChipColors(
            disabledContainerColor = Color.Gray
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DisabledLabelColorInputChip() {
    val state = remember { mutableStateOf(false) }
    InputChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        enabled = false,
        colors = InputChipDefaults.inputChipColors(
            disabledContainerColor = Color.Gray,
            disabledLabelColor = Color.Black,
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LeadingIconColorInputChip() {
    val state = remember { mutableStateOf(false) }
    InputChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        leadingIcon = {
            Icon(
                Icons.Filled.Android,
                contentDescription = stringResource(id = R.string.android)
            )
        },
        colors = InputChipDefaults.inputChipColors(
            leadingIconColor = Color.Red
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DisabledLeadingIconColorInputChip() {
    val state = remember { mutableStateOf(false) }
    InputChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        enabled = false,
        leadingIcon = {
            Icon(
                Icons.Filled.Android,
                contentDescription = stringResource(id = R.string.android)
            )
        },
        colors = InputChipDefaults.inputChipColors(
            disabledContainerColor = Color.Gray,
            disabledLabelColor = Color.Black,
            disabledLeadingIconColor = Color.Black
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AvatarInputChip() {
    val state = remember { mutableStateOf(false) }
    InputChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        label = { DefaultText() },
        avatar = {
            Icon(
                Icons.Filled.Android,
                contentDescription = stringResource(id = R.string.android)
            )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TrailingIconInputChip() {
    val state = remember { mutableStateOf(false) }
    InputChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        label = { DefaultText() },
        trailingIcon = {
            Icon(
                Icons.Filled.Android,
                contentDescription = stringResource(id = R.string.android)
            )
        },
    )
}