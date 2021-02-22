package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun ImageScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Image.capitalize(Locale.getDefault())
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultImage()
            ColorPainterImage()
            BitmapImage()
            VectorImage()
        }
    }
}

@Preview
@Composable
private fun DefaultImage() {
    Image(
        painter = painterResource(R.drawable.ic_baseline_alarm_24dp),
        contentDescription = "Default",
        colorFilter = ColorFilter.tint(Color.Blue),
    )
}

@Preview
@Composable
private fun ColorPainterImage() {
    Image(
        painter = ColorPainter(Color.Magenta),
        contentDescription = "Color",
        modifier = Modifier.preferredSize(64.dp)
    )
}

@Preview
@Composable
private fun BitmapImage() {
    val context = LocalContext.current
    Image(
        bitmap = imageFromResource(context.resources, R.drawable.ic_baseline_alarm_24dp),
        contentDescription = "Bitmap",
        colorFilter = ColorFilter.tint(Color.Blue),
        modifier = Modifier.preferredSize(64.dp),
    )
}

@Preview
@Composable
private fun VectorImage() {
    Image(
        imageVector = Icons.Filled.Build,
        contentDescription = "Vector"
    )
}