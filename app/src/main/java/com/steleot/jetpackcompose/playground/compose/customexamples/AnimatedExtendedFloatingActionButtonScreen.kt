package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.CustomExamplesNavRoutes

private const val Url = "customexamples/AnimatedExtendedFloatingActionButtonScreen.kt"

@Composable
fun AnimatedExtendedFloatingActionButtonScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.AnimatedExtendedFloatingActionButton,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedExtendedFloatingActionButtonExample()
        }
    }
}

@Composable
private fun AnimatedExtendedFloatingActionButtonExample() {
    var count by remember { mutableStateOf(0) }
    val animationModifier = Modifier.graphicsLayer(
        rotationX = animateFloatAsState(if (count % 2 == 0) 360f else 0f, tween(800)).value,
    )
    ExtendedFloatingActionButton(
        text = { Text(text = "Pressed $count times", modifier = animationModifier) },
        onClick = {
            count++
        },
        backgroundColor = MaterialTheme.colors.primary,
        icon = {
            Icon(
                imageVector = Icons.Filled.Home,
                tint = Color.Red,
                contentDescription = null,
                modifier = animationModifier
            )
        },
        modifier = Modifier.graphicsLayer(
            rotationY = animateFloatAsState(if (count % 5 == 0) 360f else 0f, tween(800)).value,
        )
    )
}