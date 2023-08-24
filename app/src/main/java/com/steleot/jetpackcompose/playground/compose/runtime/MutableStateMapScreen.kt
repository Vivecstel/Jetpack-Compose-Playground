package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "runtime/MutableStateMapScreen.kt"

@Composable
fun MutableStateMapScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.MutableStateMap,
        link = URL,
    ) {
        MutableStateMapExample(paddingValues = it)
    }
}

@Composable
private fun MutableStateMapExample(paddingValues: PaddingValues) {
    val context = LocalContext.current
    var name by remember { mutableStateOf(context.getString(R.string.name_hint)) }
    var saying by remember { mutableStateOf(context.getString(R.string.saying)) }
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
            .padding(paddingValues = paddingValues)
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
            Text(context.getString(R.string.add))
        }
        Button(onClick = { sayings.remove(name) }) {
            Text(context.getString(R.string.remove))
        }
        Text(context.getString(R.string.sayings))
        Column {
            for ((key, value) in sayings) {
                Text(context.getString(R.string.says, key, value))
            }
        }
    }
}