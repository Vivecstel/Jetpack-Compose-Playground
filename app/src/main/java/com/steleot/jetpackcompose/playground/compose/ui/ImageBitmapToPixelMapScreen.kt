package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "ui/ImageBitmapToPixelMapScreen.kt"

@Composable
fun ImageBitmapToPixelMapScreen() {
    DefaultScaffold(
        title = UiNavRoutes.ImageBitmapToPixelMap,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageBitmapToPixelMapExample()
        }
    }
}

@Composable
private fun ImageBitmapToPixelMapExample() {
    val imageBitmap = createImageBitmap()

    val pixelMap = imageBitmap.toPixelMap(
        startX = 48,
        startY = 49,
        width = 3,
        height = 2
    )

    val histogram = HashMap<Color, Int>()
    for (x in 0 until pixelMap.width) {
        for (y in 0 until pixelMap.height) {
            val color = pixelMap[x, y]
            val colorCount = histogram[color] ?: 0
            histogram[color] = (colorCount + 1)
        }
    }
    Column {
        Image(imageBitmap, contentDescription = null)
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = histogram.toString())
    }

}

private fun createImageBitmap(): ImageBitmap {
    val imageBitmap = ImageBitmap(100, 100)
    val canvas = Canvas(imageBitmap)
    val paint = Paint()

    paint.color = Color.Red
    canvas.drawRect(Rect(0.0f, 0.0f, 50.0f, 50.0f), paint)

    paint.color = Color.Blue
    canvas.drawRect(Rect(50.0f, 0.0f, 100.0f, 50.0f), paint)

    paint.color = Color.Green
    canvas.drawRect(Rect(0.0f, 50.0f, 50.0f, 100.0f), paint)

    paint.color = Color.Yellow
    canvas.drawRect(Rect(50.0f, 50.0f, 100.0f, 100.0f), paint)
    return imageBitmap
}