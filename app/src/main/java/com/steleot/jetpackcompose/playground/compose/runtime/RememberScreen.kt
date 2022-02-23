package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.graph.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

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
        Text(
            stringResource(id = R.string.clicked_count, count.value),
            color = MaterialTheme.colors.onPrimary
        )
    }
}

@Composable
private fun DestructuredRememberExample() {
    val (count, setCount) = remember { mutableStateOf(0) }
    CustomButton(onClick = { setCount(count + 1) }) {
        Text(
            stringResource(id = R.string.clicked_count, count),
            color = MaterialTheme.colors.onPrimary
        )
    }
}

@Composable
private fun DelegatedRememberExample() {
    var count by remember { mutableStateOf(0) }
    CustomButton(onClick = { count += 1 }) {
        Text(
            stringResource(id = R.string.clicked_count, count),
            color = MaterialTheme.colors.onPrimary
        )
    }
}

@Composable
private fun ReadOnlyRememberExample() {

    @Composable
    fun observeData(): State<String> = object : State<String> {
        override val value: String = "Jetpack"
    }

    val currentValue by observeData()

    Text(currentValue)
}