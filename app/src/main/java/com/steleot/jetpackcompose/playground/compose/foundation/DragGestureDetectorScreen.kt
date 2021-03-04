package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.awaitVerticalDragOrCancellation
import androidx.compose.foundation.gestures.awaitVerticalTouchSlopOrCancellation
import androidx.compose.foundation.gestures.forEachGesture
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.consumePositionChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*
import kotlin.math.roundToInt

@Composable
fun DragGestureDetectorScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.DragGestureDetector.capitalize(Locale.getDefault())
    ) {
        AwaitVerticalDragOrCancellationExample()
    }
}

@Composable
fun AwaitVerticalDragOrCancellationExample() {
    val offsetX = remember { mutableStateOf(0f) }
    val offsetY = remember { mutableStateOf(0f) }
    var height by remember { mutableStateOf(0f) }
    Box(
        Modifier.fillMaxSize()
            .onSizeChanged { height = it.height.toFloat() }
    ) {
        Box(
            Modifier.offset { IntOffset(offsetX.value.roundToInt(), offsetY.value.roundToInt()) }
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Blue)
                .pointerInput(Unit) {
                    forEachGesture {
                        awaitPointerEventScope {
                            val down = awaitFirstDown()
                            var change =
                                awaitVerticalTouchSlopOrCancellation(down.id) { change, over ->
                                    val originalY = offsetY.value
                                    val newValue = (originalY + over)
                                        .coerceIn(0f, height - 50.dp.toPx())
                                    change.consumePositionChange()
                                    offsetY.value = newValue
                                }
                            while (change != null && change.pressed) {
                                change = awaitVerticalDragOrCancellation(change.id)
                                if (change != null && change.pressed) {
                                    val originalY = offsetY.value
                                    val newValue = (originalY + change.positionChange().y)
                                        .coerceIn(0f, height - 50.dp.toPx())
                                    change.consumePositionChange()
                                    offsetY.value = newValue
                                }
                            }
                        }
                    }
                }
        )
    }
}
