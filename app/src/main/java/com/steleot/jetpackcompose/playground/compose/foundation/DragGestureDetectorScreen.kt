package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.awaitVerticalDragOrCancellation
import androidx.compose.foundation.gestures.awaitVerticalTouchSlopOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlin.math.roundToInt

private const val URL = "foundation/DragGestureDetectorScreen.kt"

@Composable
fun DragGestureDetectorScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.DragGestureDetector,
        link = URL,
    ) {
        AwaitVerticalDragOrCancellationExample(paddingValues = it)
    }
}

@Composable
private fun AwaitVerticalDragOrCancellationExample(paddingValues: PaddingValues) {
    val offsetX = remember { mutableFloatStateOf(0f) }
    val offsetY = remember { mutableFloatStateOf(0f) }
    var height by remember { mutableFloatStateOf(0f) }
    Box(
        Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
            .onSizeChanged { height = it.height.toFloat() }
    ) {
        Box(
            Modifier
                .offset {
                    IntOffset(
                        offsetX.floatValue.roundToInt(),
                        offsetY.floatValue.roundToInt()
                    )
                }
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Blue)
                .pointerInput(Unit) {
                    awaitEachGesture {
                        val down = awaitFirstDown()
                        var change =
                            awaitVerticalTouchSlopOrCancellation(down.id) { change, over ->
                                val originalY = offsetY.floatValue
                                val newValue = (originalY + over)
                                    .coerceIn(0f, height - 50.dp.toPx())
                                if (change.positionChange() != Offset.Zero) change.consume()
                                offsetY.floatValue = newValue
                            }
                        while (change != null && change.pressed) {
                            change = awaitVerticalDragOrCancellation(change.id)
                            if (change != null && change.pressed) {
                                val originalY = offsetY.floatValue
                                val newValue = (originalY + change.positionChange().y)
                                    .coerceIn(0f, height - 50.dp.toPx())
                                if (change.positionChange() != Offset.Zero) change.consume()
                                offsetY.floatValue = newValue
                            }
                        }
                    }
                }
        )
    }
}
