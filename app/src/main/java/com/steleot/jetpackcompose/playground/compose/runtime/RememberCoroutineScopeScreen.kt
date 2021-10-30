package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.RuntimeNavRoutes
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val Url = "runtime/RememberCoroutineScopeScreen.kt"

@Composable
fun RememberCoroutineScopeScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.RememberCoroutineScope,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RememberCoroutineScopeExample()
        }
    }
}

@Composable
private fun RememberCoroutineScopeExample() {
    val scope = rememberCoroutineScope()
    val state = remember { mutableStateOf(TextFieldValue(text = "Jetpack")) }
    val delayedState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = state.value,
            onValueChange = {
                state.value = it
                scope.launch {
                    delay(500L)
                    delayedState.value = "${it.text} with 500 ms delay"
                }
            },
            textStyle = MaterialTheme.typography.body1,
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = delayedState.value)
    }
}