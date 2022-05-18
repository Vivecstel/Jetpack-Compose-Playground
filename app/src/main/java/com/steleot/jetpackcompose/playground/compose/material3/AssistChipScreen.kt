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

private const val Url = "material3/AssistChipScreen.kt"

@Composable
fun AssistChipScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.AssistChip,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DefaultAssistChip()
            DisabledAssistChip()
            CutCornerShapeAssistChip()
            RoundedCornerShapeAssistChip()
            BorderAssistChip()
            LeadingIconAssistChip()
            ContainerColorAssistChip()
            LabelColorAssistChip()
            DisabledContainerColorAssistChip()
            DisabledLabelColorAssistChip()
            LeadingIconContentColorAssistChip()
            DisabledLeadingIconContentColorAssistChip()
            ElevatedAssistChip()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DefaultAssistChip() {
    AssistChip(
        onClick = { },
        label =  { DefaultText() }
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
private fun DisabledAssistChip() {
    AssistChip(
        onClick = { },
        enabled = false,
        label =  { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CutCornerShapeAssistChip() {
    AssistChip(
        onClick = { },
        shape = CutCornerShape(12.dp),
        label =  { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RoundedCornerShapeAssistChip() {
    AssistChip(
        onClick = {},
        shape = RoundedCornerShape(12.dp),
        label =  { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BorderAssistChip() {
    AssistChip(
        onClick = {},
        border = AssistChipDefaults.assistChipBorder(
            borderColor = Color.Red,
            borderWidth = 2.dp,
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LeadingIconAssistChip() {
    AssistChip(
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
private fun ContainerColorAssistChip() {
    AssistChip(
        onClick = {},
        colors = AssistChipDefaults.assistChipColors(
            containerColor = Color.Red
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LabelColorAssistChip() {
    AssistChip(
        onClick = {},
        colors = AssistChipDefaults.assistChipColors(
            labelColor = Color.Green
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DisabledContainerColorAssistChip() {
    AssistChip(
        onClick = {},
        enabled = false,
        colors = AssistChipDefaults.assistChipColors(
            disabledContainerColor = Color.Gray
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DisabledLabelColorAssistChip() {
    AssistChip(
        onClick = {},
        enabled = false,
        colors = AssistChipDefaults.assistChipColors(
            disabledContainerColor = Color.Gray,
            disabledLabelColor = Color.Black,
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LeadingIconContentColorAssistChip() {
    AssistChip(
        onClick = {},
        leadingIcon = {
            Icon(
                Icons.Filled.Android,
                contentDescription = stringResource(id = R.string.android)
            )
        },
        colors = AssistChipDefaults.assistChipColors(
            leadingIconContentColor = Color.Red
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DisabledLeadingIconContentColorAssistChip() {
    AssistChip(
        onClick = {},
        enabled = false,
        leadingIcon = {
            Icon(
                Icons.Filled.Android,
                contentDescription = stringResource(id = R.string.android)
            )
        },
        colors = AssistChipDefaults.assistChipColors(
            disabledContainerColor = Color.Gray,
            disabledLabelColor = Color.Black,
            disabledLeadingIconContentColor = Color.Black
        ),
        label = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ElevatedAssistChip() {
    AssistChip(
        onClick = {},
        label = { DefaultText() },
        elevation = AssistChipDefaults.assistChipElevation(
            defaultElevation = 8.dp,
            pressedElevation = 16.dp
        ),
    )
}