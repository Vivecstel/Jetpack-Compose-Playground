package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay

private const val Url = "runtime/SnapshotFlowScreen.kt"

@Composable
fun SnapshotFlowScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.SnapshotFlow,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SnapshotFlowExample()
        }
    }
}

@OptIn(InternalCoroutinesApi::class)
@Composable
private fun SnapshotFlowExample() {
    val context = LocalContext.current
    var greeting by remember { mutableStateOf(context.getString(R.string.hello)) }
    var person by remember { mutableStateOf("Jetpack Compose Playground") }
    val snapshot = snapshotFlow { "$greeting, $person" }
    val state by snapshot.collectAsState("")

    Text(text = state)

    LaunchedEffect(true) {
        delay(1_000L)
        Snapshot.withMutableSnapshot {
            greeting = context.getString(R.string.ahoy)
            person = "Compose Playground"
        }
    }
}
