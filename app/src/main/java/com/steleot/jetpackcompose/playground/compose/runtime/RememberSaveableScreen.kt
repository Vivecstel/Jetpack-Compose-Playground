package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "runtime/RememberSaveableScreen.kt"

@Composable
fun RememberSaveableScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.RememberSaveable.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Try orientation here")
            RememberSaveableExample()
        }
    }
}

@Composable
private fun RememberSaveableExample() {
    var count by rememberSaveable { mutableStateOf(0) }
    IntManipulateComponent(count) { value -> count = value }
}

@Composable
internal fun IntManipulateComponent(
    value: Int,
    setValue: (Int) -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Button(
            onClick = { setValue(value - 1) }
        ) {
            Text(text = "Decrement")
        }
        Text(
            text = value.toString(),
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Button(
            onClick = { setValue(value + 1) }
        ) {
            Text(text = "Increment")
        }
    }
}
