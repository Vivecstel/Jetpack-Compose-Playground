package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.AnimationNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun SingleValueFloatAnimationScreen() {
    DefaultScaffold(
        title = AnimationNavRoutes.SingleValueFloatAnimation.capitalize(Locale.getDefault())
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SingleValueAnimationFloatExample()
        }
    }
}

@Composable
private fun SingleValueAnimationFloatExample() {
    var enabled by remember { mutableStateOf(true) }
    val transition: Transition<Boolean> = updateTransition(targetState = enabled)
    val padding: Dp by transition.animateDp { state ->
        if (state) 0.dp else 100.dp
    }
    Box(modifier = Modifier
        .padding(padding)
        .clickable(
            onClick = {
                enabled = !enabled
            }
        )) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Green)
        )
    }
}