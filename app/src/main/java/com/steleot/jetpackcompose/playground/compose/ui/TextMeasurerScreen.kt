package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.theme.colors
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "ui/TextIndentScreen.kt"

@Composable
fun TextMeasurerScreen() {
    DefaultScaffold(
        title = UiNavRoutes.TextMeasurer,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            TextMeasurerExample()
        }
    }
}

@Composable
private fun TextMeasurerExample() {
    val textMeasurer = rememberTextMeasurer()
    var textLayoutResult by remember { mutableStateOf<TextLayoutResult?>(null) }
    val primaryColor = MaterialTheme.colors.primary

    Column {
        val helloWorld = stringResource(id = R.string.hello_world)
        Canvas(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                .layout { measurable, constraints ->
                    val placeable = measurable.measure(constraints)
                    textLayoutResult = textMeasurer.measure(
                        AnnotatedString(helloWorld),
                        style = TextStyle(fontSize = 20.sp),
                    )
                    layout(placeable.width, placeable.height) {
                        placeable.placeRelative(0, 0)
                    }
                }) {
            drawRect(brush = Brush.linearGradient(colors.map { Color(it) }))
            val padding = 16.dp.toPx()

            textLayoutResult?.let {
                drawText(it, topLeft = Offset(padding, padding), color = primaryColor)
            }
        }
    }
}