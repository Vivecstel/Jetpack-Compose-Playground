package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.VectorConverter
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.layout.LookaheadLayout
import androidx.compose.ui.layout.LookaheadLayoutScope
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlinx.coroutines.launch

private const val Url = "ui/LookaheadLayoutScreen.kt"

@Composable
fun LookaheadLayoutScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalWindowInfo,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LookaheadLayoutExample()
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun LookaheadLayoutExample() {
    LookaheadLayout(
        content = {
            var fullWidth by remember { mutableStateOf(false) }
            Row(
                (if (fullWidth) Modifier.fillMaxWidth() else Modifier.width(100.dp))
                    .height(200.dp)
                    .animateConstraints(this@LookaheadLayout)
                    .clickable { fullWidth = !fullWidth }) {
                Box(
                    Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(MaterialTheme.colors.primary)
                )
                Box(
                    Modifier
                        .weight(2f)
                        .fillMaxHeight()
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
        }
    ) { measurables, constraints ->
        val placeables = measurables.map { it.measure(constraints) }
        val maxWidth: Int = placeables.maxOf { it.width }
        val maxHeight = placeables.maxOf { it.height }

        layout(maxWidth, maxHeight) {
            placeables.forEach {
                it.place(0, 0)
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
private fun Modifier.animateConstraints(lookaheadScope: LookaheadLayoutScope) = composed {
    var sizeAnimation: Animatable<IntSize, AnimationVector2D>? by remember {
        mutableStateOf(null)
    }
    var targetSize: IntSize? by remember { mutableStateOf(null) }

    LaunchedEffect(Unit) {
        snapshotFlow { targetSize }.collect { target ->
            if (target != null && target != sizeAnimation?.targetValue) {
                sizeAnimation?.run {
                    launch { animateTo(target) }
                } ?: Animatable(target, IntSize.VectorConverter).let {
                    sizeAnimation = it
                }
            }
        }
    }
    with(lookaheadScope) {

        this@composed.intermediateLayout { measurable, _, lookaheadSize ->

            targetSize = lookaheadSize

            val (width, height) = sizeAnimation?.value ?: lookaheadSize

            val animatedConstraints = Constraints.fixed(width, height)

            val placeable = measurable.measure(animatedConstraints)
            layout(placeable.width, placeable.height) {
                placeable.place(0, 0)
            }
        }
    }
}