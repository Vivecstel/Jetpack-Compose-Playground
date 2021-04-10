package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.steleot.jetpackcompose.playground.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

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
        Text("You clicked ${count.value} times", color = Color.White)
    }
}

@Composable
private fun DestructuredRememberExample() {
    val (count, setCount) = remember { mutableStateOf(0) }
    CustomButton(onClick = { setCount(count + 1) }) {
        Text("You clicked $count times", color = Color.White)
    }
}

@Composable
private fun DelegatedRememberExample() {
    var count by remember { mutableStateOf(0) }
    CustomButton(onClick = { count += 1 }) {
        Text("You clicked $count times", color = Color.White)
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