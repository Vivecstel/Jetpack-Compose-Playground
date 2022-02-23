package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.unit.dp
import com.madrapps.plot.line.DataPoint
import com.madrapps.plot.line.LineGraph
import com.madrapps.plot.line.LinePlot
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.theme.colors
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "externallibraries/PlotScreen.kt"

@Composable
fun PlotScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.Plot,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PlotExample()
        }
    }
}

private val dataPoints = listOf(
    DataPoint(0f, 0f),
    DataPoint(1f, 20f),
    DataPoint(2f, 50f),
    DataPoint(3f, 10f),
    DataPoint(4f, 0f),
    DataPoint(5f, -25f),
    DataPoint(6f, -75f),
    DataPoint(7f, -100f),
    DataPoint(8f, -80f),
    DataPoint(9f, -75f),
    DataPoint(10f, -55f),
    DataPoint(11f, -45f),
    DataPoint(12f, 50f),
    DataPoint(13f, 80f),
    DataPoint(14f, 70f),
    DataPoint(15f, 125f),
    DataPoint(16f, 200f),
    DataPoint(17f, 170f),
    DataPoint(18f, 135f),
    DataPoint(19f, 60f),
    DataPoint(20f, 20f),
    DataPoint(21f, 40f),
    DataPoint(22f, 75f),
    DataPoint(23f, 50f),
)

@Composable
private fun PlotExample(
    list: List<DataPoint> = dataPoints
) {
    LineGraph(
        plot = LinePlot(
            listOf(
                LinePlot.Line(
                    list,
                    LinePlot.Connection(Color(colors[0]), 2.dp),
                    LinePlot.Intersection(Color(colors[1]), 5.dp),
                    LinePlot.Highlight(Color(colors[2]), 5.dp),
                    LinePlot.AreaUnderLine(Color(colors[3]), 0.3f)
                ),
            ),
            selection = LinePlot.Selection(
                highlight = LinePlot.Connection(
                    Color(colors[4]),
                    strokeWidth = 2.dp,
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(40f, 20f))
                )
            ),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}