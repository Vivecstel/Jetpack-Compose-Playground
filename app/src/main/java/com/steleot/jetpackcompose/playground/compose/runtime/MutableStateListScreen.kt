package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

@Composable
fun MutableStateListScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.MutableStateList.capitalize(Locale.getDefault())
    ) {
        MutableStateListExample()
    }
}

@Composable
private fun MutableStateListExample() {
    var name by remember { mutableStateOf("item") }
    val names = remember { mutableStateListOf<String>() }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row {
            TextField(
                value = name,
                onValueChange = { name = it }
            )
            Button(
                onClick = { names.add(name) },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(horizontal = 8.dp)
            ) {
                Text("Add")
            }
        }
        Text("Added items:", modifier = Modifier.padding(vertical = 16.dp))
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            for (addedName in names) {
                Text(addedName, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}