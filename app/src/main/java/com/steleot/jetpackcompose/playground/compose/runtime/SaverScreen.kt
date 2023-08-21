package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "runtime/SaverScreen.kt"

@Composable
fun SaverScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.Saver,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SaverExample()
        }
    }
}

@Composable
private fun SaverExample() {
    data class Holder(var value: Int)

    val holderSaver = Saver<Holder, Int>(
        save = { it.value },
        restore = { Holder(it) }
    )

    var holder by rememberSaveable(stateSaver = holderSaver) { mutableStateOf(Holder(0)) }

    IntManipulateComponent(value = holder.value, setValue = { value -> holder = Holder(value) })
}