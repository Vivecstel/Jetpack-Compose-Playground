package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlinx.coroutines.coroutineScope

private const val URL = "ui/PointerInputScreen.kt"

@Composable
fun PointerInputScreen() {
    DefaultScaffold(
        title = UiNavRoutes.PointerInput,
        link = URL,
    ) {
        var offset by remember { mutableStateOf(Offset.Zero) }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
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
                stringResource(id = R.string.pointer_input, offset.x, offset.y),
                Modifier.align(Alignment.Center)
            )
        }
    }
}