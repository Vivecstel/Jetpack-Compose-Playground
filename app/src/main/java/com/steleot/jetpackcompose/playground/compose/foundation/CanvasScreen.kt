package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/CanvasScreen.kt"

@Composable
fun CanvasScreen() {
    val context = LocalContext.current
    DefaultScaffold(
        title = FoundationNavRoutes.Canvas,
        link = URL,
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize(),
        ) {
            drawRect(
                Color.Red,
                topLeft = Offset(15f, 15f),
                size = Size(this.size.width / 2, 75f)
            )
            drawCircle(
                Color.Blue,
                40f,
                Offset(50f, 200f),
            )
            drawLine(
                Color.Green, Offset(20f, 75f),
                Offset(200f, 200f), strokeWidth = 5f
            )
            drawArc(
                Color.Green,
                0f,
                60f,
                useCenter = true,
                size = Size(300f, 300f),
                topLeft = Offset(60f, 60f)
            )
            drawImage(
                ImageBitmap.imageResource(context.resources, R.drawable.ic_baseline_alarm_24dp),
                Offset(90f, 10f)
            )
            drawRoundRect(
                Color.Magenta,
                Offset(120f, 50f),
                Size(50f, 50f),
                CornerRadius.Zero.copy(12f, 12f)
            )
            drawOval(
                Color.Cyan,
                Offset(50f, 200f),
                Size(75f, 75f),
            )
            drawPoints(
                listOf(Offset(150f, 50f), Offset(50f, 250f)),
                PointMode.Lines,
                Color.DarkGray
            )
        }
    }
}