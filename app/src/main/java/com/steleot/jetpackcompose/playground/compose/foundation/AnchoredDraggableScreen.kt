package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlin.math.roundToInt

private const val URL = "foundation/AnchoredDraggableScreen.kt"

@Composable
fun AnchoredDraggableScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.AnchoredDraggable,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnchoredDraggableExample()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun AnchoredDraggableExample() {
    val density = LocalDensity.current
    val animationSpec = tween<Float>()
    val positionalThreshold = { distance: Float -> distance * 0.5f }
    val velocityThreshold = { with(density) { 125.dp.toPx() } }
    val state = rememberSaveable(
        density,
        saver = AnchoredDraggableState.Saver(
            animationSpec, positionalThreshold, velocityThreshold
        )
    ) {
        AnchoredDraggableState(
            initialValue = AnchoredDraggableValue.Center,
            positionalThreshold = positionalThreshold,
            velocityThreshold = velocityThreshold,
            animationSpec = animationSpec,
        )
    }

    val draggableWidth = 70.dp
    val containerWidthPx = with(density) { draggableWidth.toPx() }

    SideEffect {
        state.updateAnchors(
            DraggableAnchors {
                AnchoredDraggableValue.Start at 0f
                AnchoredDraggableValue.Center at containerWidthPx / 2f
                AnchoredDraggableValue.End at containerWidthPx
            }
        )
    }

    Box(
        modifier = Modifier
            .width(width = draggableWidth)
            .background(
                color = MaterialTheme.colors.primaryVariant.copy(
                    alpha = 0.4f,
                ),
                shape = MaterialTheme.shapes.small
            )
    ) {
        Box(
            modifier = Modifier
                .size(size = 50.dp)
                .offset {
                    IntOffset(
                        x = state
                            .requireOffset()
                            .roundToInt(),
                        y = 0
                    )
                }
                .anchoredDraggable(state = state, orientation = Orientation.Horizontal)
                .background(
                    color = MaterialTheme.colors.primary,
                    shape = MaterialTheme.shapes.small
                )
        )
    }
}

private enum class AnchoredDraggableValue {
    Start, Center, End
}
