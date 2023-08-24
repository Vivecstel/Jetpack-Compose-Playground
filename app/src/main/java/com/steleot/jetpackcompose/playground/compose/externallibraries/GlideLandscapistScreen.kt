package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.CircularProgressIndicator
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.animation.circular.CircularRevealPlugin
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.placeholder.placeholder.PlaceholderPlugin
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import com.steleot.jetpackcompose.playground.utils.randomSampleImageUrl

private const val URL = "externallibraries/GlideLandscapistScreen.kt"

@Composable
fun GlideLandscapistScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.GlideLandscapist,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GlideImage(
                imageModel = { randomSampleImageUrl() },
                modifier = Modifier.size(150.dp),
                component = rememberImageComponent {
                    +PlaceholderPlugin.Loading(Icons.Filled.Image)
                    +PlaceholderPlugin.Failure(Icons.Filled.Error)
                    +CircularRevealPlugin(
                        duration = 350
                    )
                },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                ),
            )
            GlideImage(
                imageModel = { randomSampleImageUrl() },
                modifier = Modifier.size(150.dp),
                loading = {
                    ConstraintLayout(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        val indicator = createRef()
                        CircularProgressIndicator(
                            modifier = Modifier.constrainAs(indicator) {
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                        )
                    }
                },
                failure = {
                    Text(text = stringResource(id = R.string.image_request))
                })
            GlideImage(
                imageModel = { randomSampleImageUrl() },
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape),
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                ),
                component = rememberImageComponent {
                    +PlaceholderPlugin.Loading(Icons.Filled.Image)
                    +PlaceholderPlugin.Failure(Icons.Filled.Error)
                    +CircularRevealPlugin(
                        duration = 350
                    )
                },
            )
        }
    }
}