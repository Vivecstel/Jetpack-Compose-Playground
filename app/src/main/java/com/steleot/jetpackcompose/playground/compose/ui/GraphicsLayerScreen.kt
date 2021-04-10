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

private const val Url = "ui/GraphicsLayerScreen.kt"

@Composable
fun GraphicsLayerScreen() {
    DefaultScaffold(
        title = UiNavRoutes.GraphicsLayer,
        link = Url,
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

private const val ConstantText = "Hello Jetpack compose"

@Composable
private fun GraphicsLayerScaleXExample() {
    Text(ConstantText, Modifier.graphicsLayer(scaleX = 0.5f, clip = true))
}

@Composable
private fun GraphicsLayerScaleYExample() {
    Text(ConstantText, Modifier.graphicsLayer(scaleY = 0.5f, clip = true))
}

@Composable
private fun GraphicsLayerAlphaExample() {
    Text(ConstantText, Modifier.graphicsLayer(alpha = 0.5f, clip = true))
}

@Composable
private fun GraphicsLayerTranslationXExample() {
    Text(ConstantText, Modifier.graphicsLayer(translationX = 0.5f, clip = true))
}

@Composable
private fun GraphicsLayerTranslationYExample() {
    Text(ConstantText, Modifier.graphicsLayer(translationY = 0.5f, clip = true))
}

@Composable
private fun GraphicsLayerShadowElevationExample() {
    Text(ConstantText, Modifier.graphicsLayer(shadowElevation = 1.5f, clip = true))
}

@Composable
private fun GraphicsLayerRotationXExample() {
    Text(ConstantText, Modifier.graphicsLayer(rotationX = 180f, clip = true))
}

@Composable
private fun GraphicsLayerRotationYExample() {
    Text(ConstantText, Modifier.graphicsLayer(rotationY = 180f, clip = true))
}

@Composable
private fun GraphicsLayerRotationZExample() {
    Text(ConstantText, Modifier.graphicsLayer(rotationZ = 180f, clip = true))
}

@Composable
private fun GraphicsLayerCameraDistanceExample() {
    Text(ConstantText, Modifier.graphicsLayer(cameraDistance = 16f, clip = true))
}

@Composable
private fun GraphicsLayerTransformOriginExample() {
    Text(
        ConstantText,
        Modifier.graphicsLayer(transformOrigin = TransformOrigin(2f, 2f), clip = true)
    )
}