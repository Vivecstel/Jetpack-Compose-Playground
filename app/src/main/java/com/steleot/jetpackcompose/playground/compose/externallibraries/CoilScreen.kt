package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.utils.randomSampleImageUrl

private const val Url = "externallibraries/CoilScreen.kt"

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CoilScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.Coil,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = randomSampleImageUrl(),
                contentDescription = null
            )
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(randomSampleImageUrl())
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                loading = {
                    CircularProgressIndicator()
                }
            )
            AsyncImage(
                model = randomSampleImageUrl(),
                contentDescription = null,
                modifier = Modifier.clip(CircleShape)
            )
        }
    }
}
