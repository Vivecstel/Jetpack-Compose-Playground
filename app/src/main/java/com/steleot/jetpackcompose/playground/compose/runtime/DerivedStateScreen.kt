package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "runtime/DerivedStateScreen.kt"

@Composable
fun DerivedStateScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.DerivedState,
        link = URL,
    ) {
        DerivedStateExample(paddingValues = it)
    }
}

@Composable
fun DerivedStateExample(paddingValues: PaddingValues) {
    var a by remember { mutableIntStateOf(0) }
    var b by remember { mutableIntStateOf(0) }
    val sum = remember { derivedStateOf { a + b } }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
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
    Text(stringResource(id = R.string.count_args, count.value))
}
