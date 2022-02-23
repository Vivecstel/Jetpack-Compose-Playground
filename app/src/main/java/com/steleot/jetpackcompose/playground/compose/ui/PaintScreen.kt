package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "ui/PaintScreen.kt"

@Composable
fun PaintScreen() {
    DefaultScaffold(
        title = UiNavRoutes.Paint,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier =
                Modifier
                    .background(color = Color.Gray)
                    .padding(30.dp)
                    .background(color = Color.Yellow)
                    .paint(CustomPainter())
            )
        }
    }
}

class CustomPainter : Painter() {

    override val intrinsicSize: Size
        get() = Size(300.0f, 300.0f)

    override fun DrawScope.onDraw() {
        drawCircle(
            center = center,
            radius = size.minDimension / 2.0f,
            color = Color.Red
        )
    }
}