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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "material3/InputChipScreen.kt"

@Composable
fun InputChipScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.InputChip,
        link = Url,
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
            LeadingIconContentColorInputChip()
            DisabledLeadingIconContentColorInputChip()
            AvatarInputChip()
            TrailingIconInputChip()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DefaultInputChip() {
    InputChip(
        onClick = { },
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
    InputChip(
        onClick = { },
        enabled = false,
        label =  { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CutCornerShapeInputChip() {
    InputChip(
        onClick = { },
        shape = CutCornerShape(12.dp),
        label =  { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RoundedCornerShapeInputChip() {
    InputChip(
        onClick = {},
        shape = RoundedCornerShape(12.dp),
        label =  { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BorderInputChip() {
    InputChip(
        onClick = {},
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
    InputChip(
        onClick = {},
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
    InputChip(
        onClick = {},
        colors = InputChipDefaults.inputChipColors(
            containerColor = Color.Red
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LabelColorInputChip() {
    InputChip(
        onClick = {},
        colors = InputChipDefaults.inputChipColors(
            labelColor = Color.Green
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DisabledContainerColorInputChip() {
    InputChip(
        onClick = {},
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
    InputChip(
        onClick = {},
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
private fun LeadingIconContentColorInputChip() {
    InputChip(
        onClick = {},
        leadingIcon = {
            Icon(
                Icons.Filled.Android,
                contentDescription = stringResource(id = R.string.android)
            )
        },
        colors = InputChipDefaults.inputChipColors(
            leadingIconContentColor = Color.Red
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DisabledLeadingIconContentColorInputChip() {
    InputChip(
        onClick = {},
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
            disabledLeadingIconContentColor = Color.Black
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AvatarInputChip() {
    InputChip(
        onClick = {},
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
    InputChip(
        onClick = {},
        label = { DefaultText() },
        trailingIcon = {
            Icon(
                Icons.Filled.Android,
                contentDescription = stringResource(id = R.string.android)
            )
        },
    )
}