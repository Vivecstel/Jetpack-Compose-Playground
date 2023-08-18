package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Done
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

private const val URL = "material3/FilterChip3Screen.kt"

@Composable
fun FilterChip3Screen() {
    DefaultScaffold(
        title = Material3NavRoutes.FilterChip3,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DefaultFilterChip()
            DisabledFilterChip()
            CutCornerShapeFilterChip()
            RoundedCornerShapeFilterChip()
            BorderFilterChip()
            LeadingIconFilterChip()
            ContainerColorFilterChip()
            LabelColorFilterChip()
            DisabledContainerColorFilterChip()
            DisabledLabelColorFilterChip()
            IconColorFilterChip()
            DisabledLeadingIconColorFilterChip()
            SelectedIconFilterChip()
            TrailingIconFilterChip()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DefaultFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        label = { DefaultText() }
    )
}

@Composable
private fun DefaultText() {
    Text(
        text = stringResource(id = R.string.android),
        modifier = Modifier.padding(8.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DisabledFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        enabled = false,
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CutCornerShapeFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        shape = CutCornerShape(12.dp),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RoundedCornerShapeFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        shape = RoundedCornerShape(12.dp),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BorderFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        border = FilterChipDefaults.filterChipBorder(
            borderColor = Color.Red,
            borderWidth = 2.dp
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LeadingIconFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
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
private fun ContainerColorFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.Red
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LabelColorFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        colors = FilterChipDefaults.filterChipColors(
            labelColor = Color.White
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DisabledContainerColorFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        enabled = false,
        colors = FilterChipDefaults.filterChipColors(
            disabledContainerColor = Color.Gray
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DisabledLabelColorFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        enabled = false,
        colors = FilterChipDefaults.filterChipColors(
            disabledContainerColor = Color.Gray,
            disabledLabelColor = Color.Black,
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun IconColorFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        leadingIcon = {
            Icon(
                Icons.Filled.Android,
                contentDescription = stringResource(id = R.string.android)
            )
        },
        colors = FilterChipDefaults.filterChipColors(
            iconColor = Color.Red
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DisabledLeadingIconColorFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        enabled = false,
        leadingIcon = {
            Icon(
                Icons.Filled.Android,
                contentDescription = stringResource(id = R.string.android)
            )
        },
        colors = FilterChipDefaults.filterChipColors(
            disabledContainerColor = Color.Gray,
            disabledLabelColor = Color.Black,
            disabledLeadingIconColor = Color.Black
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SelectedIconFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        leadingIcon = if (state.value) {
            {
                Icon(
                    Icons.Filled.Done,
                    contentDescription = null,
                    modifier = Modifier.requiredSize(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TrailingIconFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        trailingIcon = {
            Icon(
                Icons.Filled.Android,
                contentDescription = stringResource(id = R.string.android)
            )
        },
        label = { DefaultText() }
    )
}