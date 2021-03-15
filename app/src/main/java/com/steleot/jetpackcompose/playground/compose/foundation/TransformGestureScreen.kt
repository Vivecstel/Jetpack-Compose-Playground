package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import com.steleot.jetpackcompose.playground.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale
import kotlin.math.roundToInt

private const val Url = "foundation/TransformGestureScreen.kt"

@Composable
fun TransformGestureScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.TransformGesture.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        DetectTransformGesturesExample()
    }
}

@Composable
private fun DetectTransformGesturesExample() {
    var angle by remember { mutableStateOf(0f) }
    var zoom by remember { mutableStateOf(1f) }
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }
    Box(
        Modifier
            .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
            .graphicsLayer(
                scaleX = zoom,
                scaleY = zoom,
                rotationZ = angle
            )
            .background(Color.Blue)
            .pointerInput(Unit) {
                detectTransformGestures(
                    onGesture = { _, pan, gestureZoom, gestureRotate ->
                        angle += gestureRotate
                        zoom *= gestureZoom
                        offsetX += pan.x
                        offsetY += pan.y
                    }
                )
            }
            .fillMaxSize()
    )
}