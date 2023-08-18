package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/ImageScreen.kt"

@Composable
fun ImageScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Image,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultImage()
            ColorPainterImage()
            BitmapImage()
            VectorImage()
            CustomImage()
        }
    }
}

@Preview
@Composable
private fun DefaultImage() {
    Image(
        painter = painterResource(R.drawable.ic_baseline_alarm_24dp),
        contentDescription = null,
        colorFilter = ColorFilter.tint(Color.Blue),
    )
}

@Preview
@Composable
private fun ColorPainterImage() {
    Image(
        painter = ColorPainter(Color.Magenta),
        contentDescription = null,
        modifier = Modifier.size(64.dp)
    )
}

@Preview
@Composable
private fun BitmapImage() {
    Image(
        bitmap = ImageBitmap.imageResource(R.drawable.ic_baseline_alarm_24dp),
        contentDescription = null,
        colorFilter = ColorFilter.tint(Color.Blue),
        modifier = Modifier.size(64.dp),
    )
}

@Preview
@Composable
private fun VectorImage() {
    Image(
        imageVector = Icons.Filled.Build,
        contentDescription = null,
    )
}

@Preview
@Composable
private fun CustomImage() {
    val customPainter = remember {
        object : Painter() {

            override val intrinsicSize: Size
                get() = Size(100.0f, 100.0f)

            override fun DrawScope.onDraw() {
                drawRect(color = Color.Cyan)
            }
        }
    }
    Image(
        painter = customPainter,
        contentDescription = null,
    )
}