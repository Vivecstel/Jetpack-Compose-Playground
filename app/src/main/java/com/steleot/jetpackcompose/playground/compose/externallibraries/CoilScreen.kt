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
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.google.accompanist.coil.CoilImage
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "external/CoilScreen.kt"

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
            CoilImage(
                data = "https://picsum.photos/300/300",
                contentDescription = "Content description",
                modifier = Modifier.size(150.dp)
            ) {
                Box(Modifier.matchParentSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }
            CoilImage(
                data = "https://picsum.photos/300/300",
                contentDescription = "Content description",
                requestBuilder = {
                    transformations(CircleCropTransformation())
                },
                modifier = Modifier.size(150.dp)
            ) {
                Box(Modifier.matchParentSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }
            CoilImage(
                data = "https://picsum.photos/300/300",
                contentDescription = "Content description",
                error = {
                    Image(
                        imageVector = Icons.Filled.Build,
                        contentDescription = "Vector"
                    )
                },
                modifier = Modifier.size(150.dp)
            ) {
                Box(Modifier.matchParentSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }
        }
    }
}