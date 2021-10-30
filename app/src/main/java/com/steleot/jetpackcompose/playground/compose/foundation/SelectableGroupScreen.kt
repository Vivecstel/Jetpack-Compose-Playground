package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundation/SelectableGroupScreen.kt"

@Composable
fun SelectableGroupScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.SelectableGroup,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SelectableGroupExample()
        }
    }
}

@Composable
private fun SelectableGroupExample(
    items: List<String> = listOf("Jetpack", "Compose", "Playground")
) {
    val state = remember { mutableStateOf("") }
    Column(
        modifier = Modifier.selectableGroup()
    ) {
        items.forEach { item ->
            Row(modifier = Modifier.padding(10.dp)) {
                RadioButton(
                    selected = state.value == item,
                    onClick = {
                        state.value = item
                    }
                )
                Text(
                    text = item,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}