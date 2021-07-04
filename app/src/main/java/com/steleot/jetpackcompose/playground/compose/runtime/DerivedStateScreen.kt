package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.RuntimeNavRoutes

private const val Url = "runtime/DerivedStateScreen.kt"

@Composable
fun DerivedStateScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.DerivedState,
        link = Url,
    ) {
        DerivedStateExample()
    }
}

@Composable
fun DerivedStateExample() {
    var a by remember { mutableStateOf(0) }
    var b by remember { mutableStateOf(0) }
    val sum = remember { derivedStateOf { a + b } }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        IntManipulateComponent(a) { value -> a = value }
        IntManipulateComponent(b) { value -> b = value }
        CountDisplay(sum)
    }
}

@Composable
private fun CountDisplay(count: State<Int>) {
    Text("Count: ${count.value}")
}
