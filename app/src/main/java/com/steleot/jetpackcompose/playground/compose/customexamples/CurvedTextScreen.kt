package com.steleot.jetpackcompose.playground.compose.customexamples

import android.graphics.Paint
import android.graphics.Path
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.graph.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "customexamples/CurvedTextScreen.kt"

@Composable
fun CurvedTextScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.ColorMatrix,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CurvedTextExample()
        }
    }
}

@Composable
private fun CurvedTextExample() {
    val colorPrimary = MaterialTheme.colors.primary
    val appName = stringResource(id = R.string.app_name)
    Canvas(
        modifier = Modifier
            .size(250.dp)
            .border(1.dp, colorPrimary)
    ) {
        drawIntoCanvas {
            val topPadding = 90.dp.toPx()
            val arcSize = 250.dp.toPx()
            val path = Path().apply {
                addArc(0f, topPadding, arcSize, arcSize, 180f, 180f)
            }
            it.nativeCanvas.drawTextOnPath(
                appName,
                path,
                0f,
                0f,
                Paint().apply {
                    color = colorPrimary.toArgb()
                    textSize = 16.sp.toPx()
                    textAlign = Paint.Align.CENTER
                }
            )
        }
    }
}