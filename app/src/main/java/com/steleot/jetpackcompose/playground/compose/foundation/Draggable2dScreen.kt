package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.draggable2D
import androidx.compose.foundation.gestures.rememberDraggable2DState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlin.math.roundToInt

private const val URL = "foundation/Draggable2dScreen.kt"

@Composable
fun Draggable2dScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Draggable2d,
        link = URL,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Draggable2dExample()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Draggable2dExample() {
    val max = 250.dp
    val min = 0.dp
    val boxSize = 50.dp
    val (minPx, maxPx) = with(LocalDensity.current) {
        min.toPx() to max.toPx() - boxSize.toPx()
    }
    var offsetPositionX by remember { mutableFloatStateOf(0f) }
    var offsetPositionY by remember { mutableFloatStateOf(0f) }

    Box(
        modifier = Modifier
            .width(max)
            .height(max)
            .draggable2D(
                state = rememberDraggable2DState { delta ->
                    val newValueX = offsetPositionX + delta.x
                    val newValueY = offsetPositionY + delta.y
                    offsetPositionX = newValueX.coerceIn(minPx, maxPx)
                    offsetPositionY = newValueY.coerceIn(minPx, maxPx)
                }
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.primary,
                shape = MaterialTheme.shapes.medium
            )
    ) {
        Box(
            Modifier
                .offset {
                    IntOffset(
                        offsetPositionX.roundToInt(),
                        offsetPositionY.roundToInt()
                    )
                }
                .size(50.dp)
                .background(color = MaterialTheme.colors.primary)
        )
    }
}