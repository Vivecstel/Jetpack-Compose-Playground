package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes

private const val Url = "externallibraries/ComposeZoomableImageScreen.kt"

@Composable
fun ComposeZoomableImageScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeZoomableImage,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //ComposeZoomableImageExample()
        }
    }
}

/*
@ExperimentalCoilApi
@Composable
private fun ComposeZoomableImageExample() {
    val painter = rememberImagePainter(randomSampleImageUrl())

    ZoomableImage(
        painter = painter,
        isRotation = false,
        modifier = Modifier.fillMaxWidth().size(250.dp)
    )
}*/
