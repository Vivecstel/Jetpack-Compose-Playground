package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/ChipScreen.kt"

@Composable
fun ChipScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.Chip,
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
            DefaultChip()
            DisabledChip()
            CutCornerShapeChip()
            RoundedCornerShapeChip()
            BorderChip()
            LeadingIconChip()
            BackgroundColorChip()
            ContentColorChip()
            DisabledBackgroundColorChip()
            DisabledContentColorChip()
            LeadingIconContentColorChip()
            DisabledLeadingIconContentColorChip()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun DefaultChip() {
    Chip(onClick = { }) {
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
private fun DisabledChip() {
    Chip(
        onClick = { },
        enabled = false
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun CutCornerShapeChip() {
    Chip(
        onClick = { },
        shape = CutCornerShape(12.dp),
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun RoundedCornerShapeChip() {
    Chip(
        onClick = {},
        shape = RoundedCornerShape(12.dp),
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun BorderChip() {
    Chip(
        onClick = {},
        border = BorderStroke(2.dp, Color.Red),
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun LeadingIconChip() {
    Chip(
        onClick = {},
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
private fun BackgroundColorChip() {
    Chip(
        onClick = {},
        colors = ChipDefaults.chipColors(
            backgroundColor = Color.Red
        )
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ContentColorChip() {
    Chip(
        onClick = {},
        colors = ChipDefaults.chipColors(
            contentColor = Color.White
        )
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun DisabledBackgroundColorChip() {
    Chip(
        onClick = {},
        enabled = false,
        colors = ChipDefaults.chipColors(
            disabledBackgroundColor = Color.Gray
        )
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun DisabledContentColorChip() {
    Chip(
        onClick = {},
        enabled = false,
        colors = ChipDefaults.chipColors(
            disabledBackgroundColor = Color.Gray,
            disabledContentColor = Color.Black,
        )
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun LeadingIconContentColorChip() {
    Chip(
        onClick = {},
        leadingIcon = {
            Icon(
                Icons.Filled.Android,
                contentDescription = stringResource(id = R.string.android)
            )
        },
        colors = ChipDefaults.chipColors(
            leadingIconContentColor = Color.Red
        )
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun DisabledLeadingIconContentColorChip() {
    Chip(
        onClick = {},
        enabled = false,
        leadingIcon = {
            Icon(
                Icons.Filled.Android,
                contentDescription = stringResource(id = R.string.android)
            )
        },
        colors = ChipDefaults.chipColors(
            disabledBackgroundColor = Color.Gray,
            disabledContentColor = Color.Black,
            disabledLeadingIconContentColor = Color.Black
        )
    ) {
        DefaultText()
    }
}