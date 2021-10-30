package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.RuntimeNavRoutes

private const val Url = "runtime/RememberSaveableStateHolderScreen.kt"

@Composable
fun RememberSaveableStateHolderScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.RememberSaveableStateHolder,
        link = Url,
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            var screen by rememberSaveable { mutableStateOf("screen1") }
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Button(onClick = { screen = "screen1" }) {
                    Text("Go to screen1")
                }
                Button(onClick = { screen = "screen2" }) {
                    Text("Go to screen2")
                }
            }
            Navigation(screen, Modifier.fillMaxSize()) { currentScreen ->
                if (currentScreen == "screen1") {
                    Screen1()
                } else {
                    Screen2()
                }
            }
        }
    }
}

@Composable
private fun <T : Any> Navigation(
    currentScreen: T,
    modifier: Modifier = Modifier,
    content: @Composable (T) -> Unit
) {
    val saveableStateHolder = rememberSaveableStateHolder()
    Box(modifier) {
        saveableStateHolder.SaveableStateProvider(currentScreen) {
            content(currentScreen)
        }
    }
}

@Composable
private fun Screen1() {
    var counter by rememberSaveable { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CustomButton(onClick = { counter++ }) {
            Text("Counter=$counter on Screen1")
        }
    }
}

@Composable
internal fun CustomButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        modifier
            .clickable(onClick = onClick)
            .background(MaterialTheme.colors.primary, RoundedCornerShape(4.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        content()
    }
}

@Composable
private fun Screen2() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Screen2")
    }
}