package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundation/SelectableScreen.kt"

@Composable
fun SelectableScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Selectable,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SelectableExample()
        }
    }
}

@Composable
private fun SelectableExample() {
    val option1 = Color.Red
    val option2 = Color.Blue
    var selectedOption by remember { mutableStateOf(option1) }
    Column {
        Text(
            stringResource(
                id = R.string.selected_color,
                stringResource(id = if (selectedOption == option1) R.string.red else R.string.blue)
            ),
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(32.dp)
        ) {
            listOf(option1, option2).forEach { color ->
                val selected = selectedOption == color
                Box(
                    Modifier
                        .size(100.dp)
                        .background(color = color, shape = RoundedCornerShape(4.dp))
                        .selectable(
                            selected = selected,
                            onClick = { selectedOption = color }
                        )
                )
            }
        }
    }
}