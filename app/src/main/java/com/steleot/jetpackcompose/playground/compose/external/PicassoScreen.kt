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
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import dev.chrisbanes.accompanist.picasso.PicassoImage
import java.util.*

@Composable
fun PicassoScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.Picasso.capitalize(Locale.getDefault())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PicassoImage(
                data = "https://picsum.photos/300/300",
                contentDescription = "Content description"
            )
            PicassoImage(
                data = "https://picsum.photos/300/300",
                contentDescription = "Content description",
                requestBuilder = {
                    rotate(180f)
                }
            )
            PicassoImage(
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