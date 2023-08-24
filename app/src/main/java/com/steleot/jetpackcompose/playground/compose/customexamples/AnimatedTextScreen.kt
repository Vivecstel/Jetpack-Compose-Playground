package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "customexamples/AnimatedTextScreen.kt"

@Composable
fun AnimatedTextScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.AnimatedText,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedTextExample()
        }
    }
}

@Composable
private fun AnimatedTextExample() {
    val text = buildAnnotatedString {
        append(stringResource(id = R.string.jetpack))
        append(' ')
        appendInlineContent("rotatingIconComponent", "rotating icon")
        appendInlineContent("colorChangingTextComponent", "color changing text")
        appendInlineContent("sizeChangingTextComponent", "size changing text")
    }
    val inlineContent = mapOf(
        "rotatingIconComponent" to InlineTextContent(
            placeholder = Placeholder(
                width = 2.em,
                height = 1.em,
                placeholderVerticalAlign = PlaceholderVerticalAlign.AboveBaseline
            ),
            children = {
                RotatingIconComponent()
            }
        ),
        "colorChangingTextComponent" to InlineTextContent(
            placeholder = Placeholder(
                width = 6.em,
                height = 20.sp,
                placeholderVerticalAlign = PlaceholderVerticalAlign.TextBottom
            ),
            children = {
                ColorChangingTextComponent()
            }
        ),
        "sizeChangingTextComponent" to InlineTextContent(
            placeholder = Placeholder(
                width = 10.em,
                height = 20.sp,
                placeholderVerticalAlign = PlaceholderVerticalAlign.AboveBaseline
            ),
            children = {
                SizeChangingTextComponent()
            }
        )
    )
    Text(
        text = text,
        style = TextStyle(
            fontFamily = FontFamily.Serif,
            fontSize = 16.sp
        ),
        inlineContent = inlineContent,
    )
}

@Composable
private fun RotatingIconComponent() {
    val context = LocalContext.current
    val colors = MaterialTheme.colors
    val infiniteTransition = rememberInfiniteTransition(
        label = "RotatingIconComponentInfiniteTransition"
    )
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing)
        ), label = "RotatingIconComponentRotation",
    )
    Canvas(modifier = Modifier.size(18.dp)) {
        rotate(rotation) {
            drawImage(
                ImageBitmap.imageResource(
                    context.resources,
                    R.drawable.ic_baseline_alarm_24dp
                ),
                colorFilter = ColorFilter.tint(colors.primaryVariant)
            )
        }
    }
}

@Composable
private fun ColorChangingTextComponent() {
    val infiniteTransition = rememberInfiniteTransition(
        label = "ColorChangingTextComponentInfiniteTransition"
    )
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(
            keyframes {
                durationMillis = 2000
                Color.Red at 0
                Color.Green at 500
                Color.Yellow at 1_000
                Color.Magenta at 1_500
            }
        ), label = "ColorChangingTextComponentColor",
    )
    Text(
        text = stringResource(id = R.string.compose),
        color = color,
        style = TextStyle(
            fontFamily = FontFamily.Serif,
            fontSize = 19.sp
        )
    )
}

@Composable
private fun SizeChangingTextComponent() {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val size by infiniteTransition.animateFloat(
        initialValue = 10f,
        targetValue = 19f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing)
        ), label = ""
    )
    Text(
        text = stringResource(id = R.string.playground),
        style = TextStyle(
            fontFamily = FontFamily.Serif,
            fontSize = size.sp
        )
    )
}
