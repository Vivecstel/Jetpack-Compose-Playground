package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.VectorConverter
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.layout.intermediateLayout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlinx.coroutines.launch

private const val URL = "ui/LookaheadScopeScreen.kt"

@Composable
fun LookaheadScopeScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LookaheadScope,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LookaheadScopeExample()
        }
    }
}


@Composable
private fun LookaheadScopeExample() {
    var fullWidth by remember { mutableStateOf(false) }
    Row(
        (if (fullWidth) Modifier.fillMaxWidth() else Modifier.width(100.dp))
            .height(200.dp)
            .animateConstraints()
            .clickable { fullWidth = !fullWidth }) {
        Box(
            Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(color = MaterialTheme.colors.primary)
        )
        Box(
            Modifier
                .weight(2f)
                .fillMaxHeight()
                .background(color = MaterialTheme.colors.primaryVariant)
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
private fun Modifier.animateConstraints() = composed {
    var sizeAnimation: Animatable<IntSize, AnimationVector2D>? by remember {
        mutableStateOf(null)
    }

    this.intermediateLayout { measurable, _ ->
        if (lookaheadSize != sizeAnimation?.targetValue) {
            sizeAnimation?.run {
                launch { animateTo(lookaheadSize) }
            } ?: Animatable(lookaheadSize, IntSize.VectorConverter).let {
                sizeAnimation = it
            }
        }
        val (width, height) = sizeAnimation!!.value
        val animatedConstraints = Constraints.fixed(width, height)
        val placeable = measurable.measure(animatedConstraints)
        layout(placeable.width, placeable.height) {
            placeable.place(0, 0)
        }
    }
}
