package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.animation.core.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.AnimationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "animation/DoubleTapToLikeScreen.kt"

@Composable
fun DoubleTapToLikeScreen() {
    DefaultScaffold(
        title = AnimationNavRoutes.DoubleTapToLike,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            DoubleTapToLike()
        }
    }
}

@Composable
private fun DoubleTapToLike() {
    var transitionState by remember {
        mutableStateOf(MutableTransitionState(LikedStates.Disappeared))
    }

    Box(
        Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = {
                        transitionState = MutableTransitionState(LikedStates.Initial)
                    }
                )
            }
    ) {
        if (transitionState.currentState == LikedStates.Initial) {
            transitionState.targetState = LikedStates.Liked
        } else if (transitionState.currentState == LikedStates.Liked) {
            transitionState.targetState = LikedStates.Disappeared
        }

        val transition = updateTransition(transitionState = transitionState, label = null)
        val alpha by transition.animateFloat(
            transitionSpec = {
                when {
                    LikedStates.Initial isTransitioningTo LikedStates.Liked ->
                        keyframes {
                            durationMillis = 500
                            0f at 0
                            0.5f at 100
                            1f at 225
                        }
                    LikedStates.Liked isTransitioningTo LikedStates.Disappeared ->
                        tween(durationMillis = 200)
                    else -> snap()
                }
            },
            label = "DoubleTapToLikeAlpha",
        ) {
            if (it == LikedStates.Liked) 1f else 0f
        }

        val scale by transition.animateFloat(
            transitionSpec = {
                when {
                    LikedStates.Initial isTransitioningTo LikedStates.Liked ->
                        spring(dampingRatio = Spring.DampingRatioHighBouncy)
                    LikedStates.Liked isTransitioningTo LikedStates.Disappeared ->
                        tween(200)
                    else -> snap()
                }
            },
            label = "DoubleTapToLikeScale",
        ) {
            when (it) {
                LikedStates.Initial -> 0f
                LikedStates.Liked -> 4f
                LikedStates.Disappeared -> 2f
            }
        }

        Icon(
            Icons.Filled.Favorite,
            stringResource(id = R.string.like),
            Modifier
                .align(Alignment.Center)
                .graphicsLayer(
                    alpha = alpha,
                    scaleX = scale,
                    scaleY = scale
                ),
            tint = Color.Red
        )
    }
}

enum class LikedStates {
    Initial,
    Liked,
    Disappeared
}