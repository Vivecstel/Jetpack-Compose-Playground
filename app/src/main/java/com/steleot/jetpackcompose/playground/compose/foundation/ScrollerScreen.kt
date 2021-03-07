package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun ScrollerScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Scroller.capitalize(Locale.getDefault())
    ) {
        ControlledScrollableRowExample()
    }
}

private val colors = listOf(
    Color(0xFFffd7d7.toInt()),
    Color(0xFFffe9d6.toInt()),
    Color(0xFFfffbd0.toInt()),
    Color(0xFFe3ffd9.toInt()),
    Color(0xFFd0fff8.toInt())
)

@Composable
private fun ControlledScrollableRowExample() {
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    Column {
        Row(Modifier.horizontalScroll(scrollState)) {
            repeat(1000) { index ->
                Square(index)
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Scroll")
            Button(
                onClick = {
                    scope.launch { scrollState.scrollTo(scrollState.value - 1000) }
                }
            ) {
                Text("< -")
            }
            Button(
                onClick = {
                    scope.launch { scrollState.scrollBy(10000f) }
                }
            ) {
                Text("--- >")
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Smooth Scroll")
            Button(
                onClick = {
                    scope.launch { scrollState.animateScrollTo(scrollState.value - 1000) }
                }
            ) {
                Text("< -")
            }
            Button(
                onClick = {
                    scope.launch { scrollState.animateScrollBy(10000f) }
                }
            ) {
                Text("--- >")
            }
        }
    }
}

@Composable
private fun Square(index: Int) {
    Box(
        Modifier
            .size(75.dp, 200.dp)
            .background(colors[index % colors.size]),
        contentAlignment = Alignment.Center
    ) {
        Text(index.toString())
    }
}
