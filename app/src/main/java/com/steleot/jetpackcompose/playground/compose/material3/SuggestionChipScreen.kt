package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material3/SuggestionChipScreen.kt"

@Composable
fun SuggestionChipScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.SuggestionChip,
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
            DefaultSuggestionChip()
            DisabledSuggestionChip()
            CutCornerShapeSuggestionChip()
            RoundedCornerShapeSuggestionChip()
            BorderSuggestionChip()
            ContainerColorSuggestionChip()
            LabelColorSuggestionChip()
            DisabledContainerColorSuggestionChip()
            DisabledLabelColorSuggestionChip()
        }
    }
}

@Composable
private fun DefaultSuggestionChip() {
    SuggestionChip(
        onClick = { },
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

@Composable
private fun DisabledSuggestionChip() {
    SuggestionChip(
        onClick = { },
        enabled = false,
        label = { DefaultText() }
    )
}

@Composable
private fun CutCornerShapeSuggestionChip() {
    SuggestionChip(
        onClick = { },
        shape = CutCornerShape(12.dp),
        label = { DefaultText() }
    )
}

@Composable
private fun RoundedCornerShapeSuggestionChip() {
    SuggestionChip(
        onClick = {},
        shape = RoundedCornerShape(12.dp),
        label = { DefaultText() }
    )
}

@Composable
private fun BorderSuggestionChip() {
    SuggestionChip(
        onClick = {},
        border = SuggestionChipDefaults.suggestionChipBorder(
            enabled = true,
            borderColor = Color.Red,
            borderWidth = 2.dp,
        ),
        label = { DefaultText() }
    )
}

@Composable
private fun ContainerColorSuggestionChip() {
    SuggestionChip(
        onClick = {},
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = Color.Red
        ),
        label = { DefaultText() }
    )
}

@Composable
private fun LabelColorSuggestionChip() {
    SuggestionChip(
        onClick = {},
        colors = SuggestionChipDefaults.suggestionChipColors(
            labelColor = Color.Green
        ),
        label = { DefaultText() }
    )
}

@Composable
private fun DisabledContainerColorSuggestionChip() {
    SuggestionChip(
        onClick = {},
        enabled = false,
        colors = SuggestionChipDefaults.suggestionChipColors(
            disabledContainerColor = Color.Gray
        ),
        label = { DefaultText() }
    )
}

@Composable
private fun DisabledLabelColorSuggestionChip() {
    SuggestionChip(
        onClick = {},
        enabled = false,
        colors = SuggestionChipDefaults.suggestionChipColors(
            disabledContainerColor = Color.Gray,
            disabledLabelColor = Color.Black,
        ),
        label = { DefaultText() }
    )
}
