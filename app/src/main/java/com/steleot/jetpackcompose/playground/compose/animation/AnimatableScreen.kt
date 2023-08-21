package com.steleot.jetpackcompose.playground.compose.animation

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.AnimationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

private const val URL = "animation/AnimatableScreen.kt"

@Composable
fun AnimatableScreen() {
    DefaultScaffold(
        title = AnimationNavRoutes.Animatable,
        link = URL,
    ) {
        AnimatableExample(paddingValues = it)
    }
}

@SuppressLint("ReturnFromAwaitPointerEventScope")
@Composable
private fun AnimatableExample(paddingValues: PaddingValues) {
    val animatedOffset = remember { Animatable(Offset(0f, 0f), Offset.VectorConverter) }

    Box(
        Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
            .background(Color.LightGray)
            .pointerInput(Unit) {
                coroutineScope {
                    while (true) {
                        val offset = awaitPointerEventScope {
                            awaitFirstDown().position
                        }
                        launch {
                            animatedOffset.animateTo(
                                offset,
                                animationSpec = spring(stiffness = Spring.StiffnessLow)
                            )
                        }
                    }
                }
            }
    ) {
        Text(stringResource(id = R.string.tap_anywhere), Modifier.align(Alignment.Center))
        Box(
            Modifier
                .offset {
                    IntOffset(
                        animatedOffset.value.x.roundToInt(),
                        animatedOffset.value.y.roundToInt()
                    )
                }
                .size(40.dp)
                .background(MaterialTheme.colors.primary, CircleShape)
        )
    }
}
