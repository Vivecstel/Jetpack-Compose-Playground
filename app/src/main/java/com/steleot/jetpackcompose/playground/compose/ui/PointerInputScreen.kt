package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes
import kotlinx.coroutines.coroutineScope

private const val Url = "ui/PointerInputScreen.kt"

@Composable
fun PointerInputScreen() {
    DefaultScaffold(
        title = UiNavRoutes.PointerInput,
        link = Url,
    ) {
        var offset by remember { mutableStateOf(Offset.Zero) }
        Box(modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                coroutineScope {
                    while (true) {
                        offset = awaitPointerEventScope {
                            awaitFirstDown().position
                        }
                    }
                }
            }
        ) {
            Text(
                "Current offset is : {${offset.x}, ${offset.y}}.\nTap to change.",
                Modifier.align(Alignment.Center)
            )
        }
    }
}