package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import com.steleot.jetpackcompose.playground.compose.externallibraries.randomSampleImageUrl
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.CustomExamplesNavRoutes

private const val Url = "customexamples/ColorMatrixScreen.kt"

@Composable
fun ColorMatrixScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.ColorMatrix,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ColorMatrixExample()
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
private fun ColorMatrixExample() {
    val matrix = ColorMatrix().apply {
        setToSaturation(0f)
    }

    Image(
        painter = rememberAsyncImagePainter(randomSampleImageUrl()),
        contentDescription = null,
        modifier = Modifier.size(200.dp),
        colorFilter = ColorFilter.colorMatrix(matrix)
    )
}