package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun GraphicsLayerScreen() {
    DefaultScaffold(
        title = UiNavRoutes.GraphicsLayer.capitalize(Locale.getDefault())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 32.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GraphicsLayerScaleXExample()
            GraphicsLayerScaleYExample()
            GraphicsLayerAlphaExample()
            GraphicsLayerTranslationXExample()
            GraphicsLayerTranslationYExample()
            GraphicsLayerShadowElevationExample()
            GraphicsLayerRotationXExample()
            GraphicsLayerRotationYExample()
            GraphicsLayerRotationZExample()
            GraphicsLayerCameraDistanceExample()
            GraphicsLayerTransformOriginExample()
        }
    }
}

@Composable
private fun GraphicsLayerScaleXExample() {
    Text("Hello Jetpack compose", Modifier.graphicsLayer(scaleX = 0.5f, clip = true))
}

@Composable
private fun GraphicsLayerScaleYExample() {
    Text("Hello Jetpack compose", Modifier.graphicsLayer(scaleY = 0.5f, clip = true))
}

@Composable
private fun GraphicsLayerAlphaExample() {
    Text("Hello Jetpack compose", Modifier.graphicsLayer(alpha = 0.5f, clip = true))
}

@Composable
private fun GraphicsLayerTranslationXExample() {
    Text("Hello Jetpack compose", Modifier.graphicsLayer(translationX = 0.5f, clip = true))
}

@Composable
private fun GraphicsLayerTranslationYExample() {
    Text("Hello Jetpack compose", Modifier.graphicsLayer(translationY = 0.5f, clip = true))
}

@Composable
private fun GraphicsLayerShadowElevationExample() {
    Text("Hello Jetpack compose", Modifier.graphicsLayer(shadowElevation = 1.5f, clip = true))
}

@Composable
private fun GraphicsLayerRotationXExample() {
    Text("Hello Jetpack compose", Modifier.graphicsLayer(rotationX = 180f, clip = true))
}

@Composable
private fun GraphicsLayerRotationYExample() {
    Text("Hello Jetpack compose", Modifier.graphicsLayer(rotationY = 180f, clip = true))
}

@Composable
private fun GraphicsLayerRotationZExample() {
    Text("Hello Jetpack compose", Modifier.graphicsLayer(rotationZ = 180f, clip = true))
}

@Composable
private fun GraphicsLayerCameraDistanceExample() {
    Text("Hello Jetpack compose", Modifier.graphicsLayer(cameraDistance = 16f, clip = true))
}

@Composable
private fun GraphicsLayerTransformOriginExample() {
    Text(
        "Hello Jetpack compose",
        Modifier.graphicsLayer(transformOrigin = TransformOrigin(2f, 2f), clip = true)
    )
}