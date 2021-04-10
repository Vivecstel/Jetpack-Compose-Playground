package com.steleot.jetpackcompose.playground.compose.external

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.google.accompanist.glide.GlideImage
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

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
                .padding(32.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GlideImage(
                data = "https://picsum.photos/300/300",
                contentDescription = "Content description"
            )
            GlideImage(
                data = "https://picsum.photos/300/300",
                contentDescription = "Content description",
                requestBuilder = {
                    apply(RequestOptions().circleCrop())
                }
            )
            GlideImage(
                data = "https://picsum.photos/300/300",
                contentDescription = "Content description",
                loading = {
                    Box(Modifier.matchParentSize()) {
                        CircularProgressIndicator(Modifier.align(Alignment.Center))
                    }
                },
                error = {
                    Image(
                        imageVector = Icons.Filled.Build,
                        contentDescription = "Vector"
                    )
                }
            )
        }
    }
}