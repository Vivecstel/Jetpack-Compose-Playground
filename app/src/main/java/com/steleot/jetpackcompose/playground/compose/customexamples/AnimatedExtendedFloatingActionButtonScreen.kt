package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ExtendedFloatingActionButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "customexamples/AnimatedExtendedFloatingActionButtonScreen.kt"

@Composable
fun AnimatedExtendedFloatingActionButtonScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.AnimatedExtendedFloatingActionButton,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedExtendedFloatingActionButtonExample()
        }
    }
}

@Composable
private fun AnimatedExtendedFloatingActionButtonExample() {
    var count by remember { mutableIntStateOf(0) }
    val animationModifier = Modifier.graphicsLayer(
        rotationX = animateFloatAsState(
            if (count % 2 == 0) 360f else 0f, tween(800),
            label = "AnimatedExtendedFloatingActionButtonExampleRotationX"
        ).value,
    )
    ExtendedFloatingActionButton(
        text = {
            Text(
                text = stringResource(id = R.string.pressed_count, count),
                modifier = animationModifier
            )
        },
        onClick = {
            count++
        },
        backgroundColor = MaterialTheme.colors.primary,
        icon = {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = null,
                modifier = animationModifier
            )
        },
        modifier = Modifier.graphicsLayer(
            rotationY = animateFloatAsState(
                if (count % 5 == 0) 360f else 0f, tween(800),
                label = "AnimatedExtendedFloatingActionButtonExampleRotationY"
            ).value,
        )
    )
}