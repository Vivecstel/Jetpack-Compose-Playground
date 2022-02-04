package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.AnimationNavRoutes
import androidx.compose.animation.Animatable as AnimatableColor
import androidx.compose.animation.core.Animatable as AnimatableFloat

private const val Url = "animation/AnimatedValuesScreen.kt"

@Composable
fun AnimatedValuesScreen() {
    DefaultScaffold(
        title = AnimationNavRoutes.AnimatedValues,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedFloat()
            AnimatedColor()
        }
    }
}

@Composable
private fun AnimatedFloat() {
    val expandedState = remember { mutableStateOf(false) }
    val viewHeight = if (expandedState.value) remember { AnimatableFloat(150f) } else remember {
        AnimatableFloat(50f)
    }
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(viewHeight.value.dp)
        .clickable(
            onClick = {
                expandedState.value = !expandedState.value
            }
        )
        .background(Color.Red))
}

@Composable
private fun AnimatedColor() {
    val expandedState = remember { mutableStateOf(false) }
    val viewColor =
        if (expandedState.value) remember { AnimatableColor(Color.Red) } else remember {
            AnimatableColor(
                Color.Green
            )
        }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .clickable(onClick = {
                expandedState.value = !expandedState.value
            })
            .background(viewColor.value)
    )
}