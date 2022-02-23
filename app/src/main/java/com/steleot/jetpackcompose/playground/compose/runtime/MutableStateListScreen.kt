package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "runtime/MutableStateListScreen.kt"

@Composable
fun MutableStateListScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.MutableStateList,
        link = Url,
    ) {
        MutableStateListExample()
    }
}

@Composable
private fun MutableStateListExample() {
    val context = LocalContext.current
    var name by remember { mutableStateOf(context.getString(R.string.single_item)) }
    val names = remember { mutableStateListOf<String>() }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row {
            TextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier.weight(2f)
            )
            Button(
                onClick = { names.add(name) },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            ) {
                Text(context.getString(R.string.add))
            }
        }
        Text(
            context.getString(R.string.added_items),
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            for (addedName in names) {
                Text(addedName, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}