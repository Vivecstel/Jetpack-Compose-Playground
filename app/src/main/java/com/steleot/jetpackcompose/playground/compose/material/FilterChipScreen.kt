package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/FilterChipScreen.kt"

@Composable
fun FilterChipScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.FilterChip,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
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
            BackgroundColorFilterChip()
            ContentColorFilterChip()
            DisabledBackgroundColorFilterChip()
            DisabledContentColorFilterChip()
            LeadingIconColorFilterChip()
            DisabledLeadingIconColorFilterChip()
            SelectedIconFilterChip()
            TrailingIconFilterChip()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun DefaultFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
    ) {
        DefaultText()
    }
}

@Composable
private fun DefaultText() {
    Text(
        text = stringResource(id = R.string.android),
        modifier = Modifier.padding(8.dp)
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun DisabledFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        enabled = false
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun CutCornerShapeFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        shape = CutCornerShape(12.dp),
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun RoundedCornerShapeFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        shape = RoundedCornerShape(12.dp),
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun BorderFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        border = BorderStroke(2.dp, Color.Red),
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
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
        }
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun BackgroundColorFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        colors = ChipDefaults.filterChipColors(
            backgroundColor = Color.Red
        )
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ContentColorFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        colors = ChipDefaults.filterChipColors(
            contentColor = Color.White
        )
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun DisabledBackgroundColorFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        enabled = false,
        colors = ChipDefaults.filterChipColors(
            disabledBackgroundColor = Color.Gray
        )
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun DisabledContentColorFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        enabled = false,
        colors = ChipDefaults.filterChipColors(
            disabledBackgroundColor = Color.Gray,
            disabledContentColor = Color.Black,
        )
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun LeadingIconColorFilterChip() {
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
        colors = ChipDefaults.filterChipColors(
            leadingIconColor = Color.Red
        )
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
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
        colors = ChipDefaults.filterChipColors(
            disabledBackgroundColor = Color.Gray,
            disabledContentColor = Color.Black,
            disabledLeadingIconColor = Color.Black
        )
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SelectedIconFilterChip() {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        selectedIcon = {
            Icon(
                Icons.Filled.Done,
                contentDescription = null,
                modifier = Modifier.requiredSize(ChipDefaults.SelectedIconSize)
            )
        }
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
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
        }
    ) {
        DefaultText()
    }
}