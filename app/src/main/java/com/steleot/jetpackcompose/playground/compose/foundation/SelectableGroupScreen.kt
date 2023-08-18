package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.RadioButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/SelectableGroupScreen.kt"

@Composable
fun SelectableGroupScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.SelectableGroup,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SelectableGroupExample(stringResource(id = R.string.app_name).split(" "))
        }
    }
}

@Composable
private fun SelectableGroupExample(
    items: List<String>
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
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}