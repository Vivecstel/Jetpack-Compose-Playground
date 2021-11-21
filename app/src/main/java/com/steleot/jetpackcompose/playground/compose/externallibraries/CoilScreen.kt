package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import timber.log.Timber

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
            CoilImageExample(rememberImagePainter(randomSampleImageUrl()))
            CoilImageExample(
                rememberImagePainter(
                    data = randomSampleImageUrl(),
                    builder = {
                        transformations(CircleCropTransformation())
                    })
            )
            CoilImageExample(rememberImagePainter(randomSampleImageUrl()))
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
private fun CoilImageExample(
    painter: ImagePainter,
) {
    Box {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )
        when (painter.state) {
            is ImagePainter.State.Loading -> {
                Box(Modifier.matchParentSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }
            is ImagePainter.State.Error -> {
                Image(
                    imageVector = Icons.Filled.Error,
                    contentDescription = stringResource(id = R.string.error)
                )
            }
            else -> {
                Timber.d("Else image load states")
            }
        }
    }
}
