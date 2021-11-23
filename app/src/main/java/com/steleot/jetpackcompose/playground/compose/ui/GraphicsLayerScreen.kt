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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

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

@Composable
private fun GraphicsLayerScaleXExample() {
    Text(stringResource(id = R.string.app_name), Modifier.graphicsLayer(scaleX = 0.5f, clip = true))
}

@Composable
private fun GraphicsLayerScaleYExample() {
    Text(stringResource(id = R.string.app_name), Modifier.graphicsLayer(scaleY = 0.5f, clip = true))
}

@Composable
private fun GraphicsLayerAlphaExample() {
    Text(stringResource(id = R.string.app_name), Modifier.graphicsLayer(alpha = 0.5f, clip = true))
}

@Composable
private fun GraphicsLayerTranslationXExample() {
    Text(
        stringResource(id = R.string.app_name),
        Modifier.graphicsLayer(translationX = 0.5f, clip = true)
    )
}

@Composable
private fun GraphicsLayerTranslationYExample() {
    Text(
        stringResource(id = R.string.app_name),
        Modifier.graphicsLayer(translationY = 0.5f, clip = true)
    )
}

@Composable
private fun GraphicsLayerShadowElevationExample() {
    Text(
        stringResource(id = R.string.app_name),
        Modifier.graphicsLayer(shadowElevation = 1.5f, clip = true)
    )
}

@Composable
private fun GraphicsLayerRotationXExample() {
    Text(
        stringResource(id = R.string.app_name),
        Modifier.graphicsLayer(rotationX = 180f, clip = true)
    )
}

@Composable
private fun GraphicsLayerRotationYExample() {
    Text(
        stringResource(id = R.string.app_name),
        Modifier.graphicsLayer(rotationY = 180f, clip = true)
    )
}

@Composable
private fun GraphicsLayerRotationZExample() {
    Text(
        stringResource(id = R.string.app_name),
        Modifier.graphicsLayer(rotationZ = 180f, clip = true)
    )
}

@Composable
private fun GraphicsLayerCameraDistanceExample() {
    Text(
        stringResource(id = R.string.app_name),
        Modifier.graphicsLayer(cameraDistance = 16f, clip = true)
    )
}

@Composable
private fun GraphicsLayerTransformOriginExample() {
    Text(
        stringResource(id = R.string.app_name),
        Modifier.graphicsLayer(transformOrigin = TransformOrigin(2f, 2f), clip = true)
    )
}