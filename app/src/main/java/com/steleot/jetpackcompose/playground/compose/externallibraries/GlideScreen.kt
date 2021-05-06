package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.glide.rememberGlidePainter
import com.google.accompanist.imageloading.ImageLoadState
import com.google.accompanist.imageloading.LoadPainter
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import timber.log.Timber

private const val Url = "external/GlideScreen.kt"

@Composable
fun GlideScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.Glide,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GlideImageExample()
            GlideImageExample(
                rememberCoilPainter(
                    request = "https://picsum.photos/300/300",
                    requestBuilder = {
                        transformations(CircleCropTransformation())
                    })
            )
            GlideImageExample()
        }
    }
}

@Composable
private fun GlideImageExample(
    painter: LoadPainter<Any> = rememberGlidePainter("https://picsum.photos/300/300")
) {
    Box {
        Image(
            painter = painter,
            contentDescription = "Content description",
            modifier = Modifier.size(150.dp)
        )
        when (painter.loadState) {
            is ImageLoadState.Loading -> {
                Box(Modifier.matchParentSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }
            is ImageLoadState.Error -> {
                Image(
                    imageVector = Icons.Filled.Build,
                    contentDescription = "Vector"
                )
            }
            else -> {
                Timber.d("Else image load states")
            }
        }
    }
}