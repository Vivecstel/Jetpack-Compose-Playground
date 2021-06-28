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
import com.bumptech.glide.request.RequestOptions
import com.google.accompanist.glide.rememberGlidePainter
import com.google.accompanist.imageloading.ImageLoadState
import com.google.accompanist.imageloading.LoadPainter
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import timber.log.Timber

private const val Url = "external/GlideAccompanistScreen.kt"

@Composable
fun GlideAccompanistScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.GlideAccompanist,
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
                rememberGlidePainter(
                    request = randomSampleImageUrl(),
                    requestBuilder = {
                        apply(RequestOptions().circleCrop())
                    })
            )
            GlideImageExample()
        }
    }
}

@Composable
private fun GlideImageExample(
    painter: LoadPainter<Any> = rememberGlidePainter(randomSampleImageUrl())
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