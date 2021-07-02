package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StampedPathEffectStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

private const val Url = "ui/PathEffectScreen.kt"

@Composable
fun PathEffectScreen() {
    val size = 20f
    val square = Path().apply {
        lineTo(size, 0f)
        lineTo(size, size)
        lineTo(0f, size)
        close()
    }
    DefaultScaffold(
        title = UiNavRoutes.PathEffect,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val canvasModifier = Modifier
                .requiredSize(80.dp)
                .align(Alignment.CenterHorizontally)

            Canvas(modifier = canvasModifier) {
                drawCircle(color = Color.Blue)
                drawCircle(
                    color = Color.Red,
                    style = Stroke(
                        pathEffect = PathEffect.stampedPathEffect(
                            shape = square,
                            style = StampedPathEffectStyle.Morph,
                            phase = 0f,
                            advance = 30f
                        )
                    )
                )
            }

            Canvas(modifier = canvasModifier) {
                drawCircle(color = Color.Blue)
                drawCircle(
                    color = Color.Red,
                    style = Stroke(
                        pathEffect = PathEffect.stampedPathEffect(
                            shape = square,
                            style = StampedPathEffectStyle.Rotate,
                            phase = 0f,
                            advance = 30f
                        )
                    )
                )
            }

            Canvas(modifier = canvasModifier) {
                drawCircle(color = Color.Blue)
                drawCircle(
                    color = Color.Red,
                    style = Stroke(
                        pathEffect = PathEffect.stampedPathEffect(
                            shape = square,
                            style = StampedPathEffectStyle.Translate,
                            phase = 0f,
                            advance = 30f
                        )
                    )
                )
            }
        }
    }
}
