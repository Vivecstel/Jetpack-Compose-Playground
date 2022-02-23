package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import com.steleot.jetpackcompose.playground.navigation.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import com.steleot.jetpackcompose.playground.utils.randomSampleImageUrl

private const val Url = "customexamples/BottomRoundedArcShapeScreen.kt"

@Composable
fun BottomRoundedArcShapeScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.BottomRoundedArcShape,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BottomRoundedArcShapeExample()
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
private fun BottomRoundedArcShapeExample() {
    Image(
        painter = rememberAsyncImagePainter(randomSampleImageUrl()),
        contentDescription = null,
        modifier = Modifier
            .size(250.dp)
            .graphicsLayer {
                clip = true
                shape = BottomRoundedArcShape()
                shadowElevation = 12.dp.toPx()
            },
    )
}

private class BottomRoundedArcShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = Path().apply {
                reset()
                lineTo(size.width, 0f)
                lineTo(size.width, size.height)
                arcTo(
                    rect =
                    Rect(
                        Offset(0f, 0f),
                        Size(size.width, size.height)
                    ),
                    startAngleDegrees = 0f,
                    sweepAngleDegrees = 180f,
                    forceMoveTo = false
                )
                lineTo(0f, 0f)
                close()
            }
        )
    }
}