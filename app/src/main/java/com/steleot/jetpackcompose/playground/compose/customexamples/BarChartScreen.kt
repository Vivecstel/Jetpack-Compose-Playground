package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.CustomExamplesNavRoutes
import kotlin.math.min
import kotlin.random.Random

private const val Url = "customexamples/BarChartScreen.kt"

@Composable
fun BarChartScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.BarChart,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BarChartExample(
                generateRandomFloatList(),
                Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .border(1.dp, MaterialTheme.colors.error)
                    .padding(top = 4.dp)
            )
        }
    }
}

@Composable
private fun BarChartExample(
    yAxisValues: List<Float>,
    modifier: Modifier = Modifier,
    barWidth: Float = 15f
) {
    val x = remember { Animatable(0f) }
    val yValues = remember { yAxisValues }
    val xTarget = (yValues.size - 1).toFloat()
    LaunchedEffect(Unit) {
        x.animateTo(
            targetValue = xTarget,
            animationSpec = tween(
                durationMillis = 500,
                easing = LinearEasing
            ),
        )
    }

    val colors = listOf(MaterialTheme.colors.primary, MaterialTheme.colors.primaryVariant)

    Canvas(modifier = modifier.padding(horizontal = 8.dp)) {
        val xbounds = Pair(0f, xTarget)
        val ybounds = getBounds(yValues)
        val scaleX = size.width / (xbounds.second - xbounds.first)
        val scaleY = size.height / (ybounds.second - ybounds.first)
        val yMove = ybounds.first * scaleY

        (0..min(yValues.size - 1, x.value.toInt())).forEach { value ->
            val barX = value * scaleX
            val barY = size.height - (yValues[value] * scaleY) + yMove
            drawRect(
                topLeft = Offset(barX, barY),
                brush = Brush.linearGradient(colors),
                size = Size(barWidth, size.height - barY)
            )
        }
    }
}

private fun generateRandomFloatList(
    size: Int = 10
): List<Float> {
    val list = mutableListOf<Float>()
    (0..size).forEach { _ ->
        list.add(Random.nextFloat() * 10)
    }
    return list
}

private fun getBounds(list: List<Float>): Pair<Float, Float> {
    var min = Float.MAX_VALUE
    var max = -Float.MAX_VALUE
    list.forEach {
        min = min.coerceAtMost(it)
        max = max.coerceAtLeast(it)
    }
    return Pair(min, max)
}