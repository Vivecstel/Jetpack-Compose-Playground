package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.palette.BitmapPalette
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes

private const val Url = "externallibraries/PaletteLandscapistScreen.kt"

@Composable
fun PaletteLandscapistScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.PaletteLandscapist,
        link = Url,
    )
    {
        Column(
            modifier = Modifier.fillMaxSize(),
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
        imageModel = randomSampleImageUrl(1),
        modifier = Modifier.size(150.dp),
        contentScale = ContentScale.Crop,
        circularReveal = CircularReveal(duration = 300),
        placeHolder = Icons.Filled.Image,
        error = Icons.Filled.Error,
        bitmapPalette = BitmapPalette {
            palette = it
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