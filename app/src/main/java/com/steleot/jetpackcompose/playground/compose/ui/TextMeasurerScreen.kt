package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.theme.colors
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.withIndex
import kotlin.math.roundToLong
import kotlin.system.measureNanoTime

private const val Url = "ui/TextIndentScreen.kt"

@Composable
fun TextMeasurerScreen() {
    DefaultScaffold(
        title = UiNavRoutes.TextIndent,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            TextMeasurerExample()
        }
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
private fun TextMeasurerExample() {
    val textMeasurer = rememberTextMeasurer()
    var textLayoutResult by remember { mutableStateOf<TextLayoutResult?>(null) }
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(tween(3000), RepeatMode.Reverse)
    )

    var skipCache by remember { mutableStateOf(false) }
    val layoutMeasurer = remember(skipCache) { AverageDurationMeasurer() }
    val drawMeasurer = remember(skipCache) { AverageDurationMeasurer() }

    val averageLayoutDuration by layoutMeasurer.averageDurationFlow.collectAsState(0L)
    val averageDrawDuration by drawMeasurer.averageDurationFlow.collectAsState(0L)

    Column {
        Text("Average layout duration: $averageLayoutDuration ns")
        Text("Average draw duration: $averageDrawDuration ns")
        Text("Average total duration: ${averageLayoutDuration + averageDrawDuration} ns")
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = skipCache, onCheckedChange = { skipCache = it })
            Text(text = "Skip Cache")
        }
        val helloWorld = stringResource(id = R.string.hello_world)
        Canvas(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                .layout { measurable, constraints ->
                    val placeable = measurable.measure(constraints)
                    val duration = measureNanoTime {
                        textLayoutResult = textMeasurer.measure(
                            AnnotatedString(helloWorld),
                            style = TextStyle(fontSize = 20.sp),
                            skipCache = skipCache
                        )
                    }
                    layoutMeasurer.addMeasure(duration)
                    layout(placeable.width, placeable.height) {
                        placeable.placeRelative(0, 0)
                    }
                }) {
            drawRect(brush = Brush.linearGradient(colors.map { Color(it) }))
            val padding = 16.dp.toPx()

            textLayoutResult?.let {
                val duration = measureNanoTime {
                    drawText(it, topLeft = Offset(padding, padding), color = color)
                }
                drawMeasurer.addMeasure(duration)
            }
        }
    }
}

class AverageDurationMeasurer(private val capacity: Int = 600) {

    private val values = mutableStateListOf<Long>()

    fun addMeasure(duration: Long) {
        values.add(duration)
        while (values.size > capacity) {
            values.removeFirst()
        }
    }

    val current = derivedStateOf {
        if (values.isEmpty()) 0L else values.average().roundToLong()
    }

    val averageDurationFlow = snapshotFlow { current.value }.withIndex().map { (index, value) ->
        if (index % 60 == 0) value else null
    }.filterNotNull()
}