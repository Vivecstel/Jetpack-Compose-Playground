package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.rememberAsyncImagePainter
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import com.steleot.jetpackcompose.playground.utils.randomSampleImageUrl
import me.rerere.zoomableimage.ZoomableImage

private const val Url = "externallibraries/ZoomableComposeImageScreen.kt"

@Composable
fun ZoomableComposeImageScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ZoomableComposeImage,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ZoomableComposeImageExample()
        }
    }
}

@Composable
private fun ZoomableComposeImageExample() {
    ZoomableImage(
        modifier = Modifier.fillMaxSize(0.8f),
        painter = rememberAsyncImagePainter(randomSampleImageUrl())
    )
}