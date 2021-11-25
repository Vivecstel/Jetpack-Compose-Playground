package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

private const val Url = "externallibraries/SnapperScreen.kt"

@Composable
fun SnapperScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.Snapper,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SnapperExample()
        }
    }
}

@OptIn(ExperimentalSnapperApi::class)
@Composable
private fun SnapperExample() {
    val lazyListState = rememberLazyListState()
    val contentPadding = PaddingValues(16.dp)

    LazyColumn(
        state = lazyListState,
        flingBehavior = rememberSnapperFlingBehavior(
            lazyListState = lazyListState,
            endContentPadding = contentPadding.calculateBottomPadding(),
        ),
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxSize(),
    ) {
        items(20) { index ->
            LazyItem(
                text = "$index",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
    }
}

@Composable
private fun LazyItem(
    text: String,
    modifier: Modifier = Modifier,
) {
    Surface(modifier) {
        Box {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(randomSampleImageUrl(width = 400))
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Text(
                text = text,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
                    .background(MaterialTheme.colors.primary, CircleShape)
                    .sizeIn(minWidth = 40.dp, minHeight = 40.dp)
                    .padding(8.dp)
                    .wrapContentSize(Alignment.Center)
            )
        }
    }
}