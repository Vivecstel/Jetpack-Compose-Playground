package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
//noinspection UsingMaterialAndMaterial3Libraries
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
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val URL = "runtime/RememberCoroutineScopeScreen.kt"

@Composable
fun RememberCoroutineScopeScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.RememberCoroutineScope,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RememberCoroutineScopeExample()
        }
    }
}

private const val DELAY = 500L

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
                    delay(DELAY)
                    delayedState.value = context.getString(R.string.text_with_delay, it.text, DELAY)
                }
            },
            textStyle = MaterialTheme.typography.body1,
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = delayedState.value)
    }
}