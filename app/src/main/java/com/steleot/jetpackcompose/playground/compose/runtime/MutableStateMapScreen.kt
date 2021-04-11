package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "runtime/MutableStateMapScreen.kt"

@Composable
fun MutableStateMapScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.MutableStateMap,
        link = Url,
    ) {
        MutableStateMapExample()
    }
}

@Composable
private fun MutableStateMapExample() {
    var name by remember { mutableStateOf("name") }
    var saying by remember { mutableStateOf("saying") }
    val sayings = remember {
        mutableStateMapOf(
            "Caesar" to "Et tu, Brute?",
            "Hamlet" to "To be or not to be",
            "Richard III" to "My kingdom for a horse"
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = name,
            onValueChange = { name = it }
        )
        TextField(
            value = saying,
            onValueChange = { saying = it }
        )
        Button(onClick = { sayings[name] = saying }) {
            Text("Add")
        }
        Button(onClick = { sayings.remove(name) }) {
            Text("Remove")
        }
        Text("Sayings:")
        Column {
            for (entry in sayings) {
                Text("${entry.key} says '${entry.value}'")
            }
        }
    }
}