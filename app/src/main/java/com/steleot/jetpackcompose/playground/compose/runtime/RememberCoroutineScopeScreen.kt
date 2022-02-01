package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
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

private const val Delay = 500L

@Composable
private fun RememberCoroutineScopeExample() {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
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
                    delay(Delay)
                    delayedState.value = context.getString(R.string.text_with_delay, it.text, Delay)
                }
            },
            textStyle = MaterialTheme.typography.body1,
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = delayedState.value)
    }
}