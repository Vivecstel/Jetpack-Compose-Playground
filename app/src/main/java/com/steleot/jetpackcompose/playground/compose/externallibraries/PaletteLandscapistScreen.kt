package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Image
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.animation.circular.CircularRevealPlugin
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.palette.PalettePlugin
import com.skydoves.landscapist.placeholder.placeholder.PlaceholderPlugin
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import com.steleot.jetpackcompose.playground.utils.randomSampleImageUrl

private const val URL = "externallibraries/PaletteLandscapistScreen.kt"

@Composable
fun PaletteLandscapistScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.PaletteLandscapist,
        link = URL,
    )
    {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PaletteLandscapistExample()
        }
    }
}

@Composable
private fun PaletteLandscapistExample() {
    var palette by remember { mutableStateOf<Palette?>(null) }

    GlideImage(
        imageModel = { randomSampleImageUrl(1) },
        modifier = Modifier.size(150.dp),
        imageOptions = ImageOptions(
            contentScale = ContentScale.Crop,
        ),
        component = rememberImageComponent {
            +PalettePlugin { palette = it }
            +PlaceholderPlugin.Loading(Icons.Filled.Image)
            +PlaceholderPlugin.Failure(Icons.Filled.Error)
            +CircularRevealPlugin(
                duration = 350
            )
        }
    )

    ColorPalettes(palette = palette)
}

@Composable
private fun ColorPalettes(palette: Palette?) {
    palette?.let {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            ColorPaletteBox(it.lightVibrantSwatch?.rgb ?: 0)
            ColorPaletteBox(it.lightMutedSwatch?.rgb ?: 0)
            ColorPaletteBox(it.vibrantSwatch?.rgb ?: 0)
            ColorPaletteBox(it.mutedSwatch?.rgb ?: 0)
            ColorPaletteBox(it.darkVibrantSwatch?.rgb ?: 0)
            ColorPaletteBox(it.darkMutedSwatch?.rgb ?: 0)
            ColorPaletteBox(it.dominantSwatch?.rgb ?: 0)
        }
    }
}

@Composable
private fun ColorPaletteBox(
    color: Int
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .size(45.dp)
            .background(color = Color(color), shape = MaterialTheme.shapes.small)
            .fillMaxSize()
    )
}