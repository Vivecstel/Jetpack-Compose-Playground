package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.RuntimeNavRoutes

private const val Url = "runtime/RememberScreen.kt"

@Composable
fun RememberScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.Remember,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RememberExample()
            DestructuredRememberExample()
            DelegatedRememberExample()
            ReadOnlyRememberExample()
        }
    }
}

@Composable
private fun RememberExample() {
    val count = remember { mutableStateOf(0) }
    CustomButton(onClick = { count.value++ }) {
        Text("You clicked ${count.value} times", color = MaterialTheme.colors.onPrimary)
    }
}

@Composable
private fun DestructuredRememberExample() {
    val (count, setCount) = remember { mutableStateOf(0) }
    CustomButton(onClick = { setCount(count + 1) }) {
        Text("You clicked $count times", color = MaterialTheme.colors.onPrimary)
    }
}

@Composable
private fun DelegatedRememberExample() {
    var count by remember { mutableStateOf(0) }
    CustomButton(onClick = { count += 1 }) {
        Text("You clicked $count times", color = MaterialTheme.colors.onPrimary)
    }
}

@Composable
private fun ReadOnlyRememberExample() {

    @Composable
    fun observeData(): State<String> = object : State<String> {
        override val value: String = "Current value"
    }

    val currentValue by observeData()

    Text("Data: $currentValue")
}