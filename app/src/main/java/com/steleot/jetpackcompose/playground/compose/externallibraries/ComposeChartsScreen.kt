package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
/*import hu.ma.charts.pie.LegendPosition
import hu.ma.charts.pie.PieChart
import hu.ma.charts.pie.PieChartData
import hu.ma.charts.pie.PieChartEntry*/

private const val Url = "external/ComposeChartsScreen.kt"

@Composable
fun ComposeChartsScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeCharts,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            PieChartExample()
        }
    }
}

/*
private val Categories = listOf(
    "Teams",
    "Locations",
    "Devices",
    "People",
    "Laptops",
    "Titles",
)

private val SimpleColors = listOf(
    Color.Black,
    Color.Blue,
    Color.Yellow,
    Color.Red,
    Color.LightGray,
    Color.Magenta,
)

@Composable
private fun PieChartExample() {
    val data = PieChartData(
        entries = listOf(430f, 240f, 140f, 60f, 50f).mapIndexed { idx, value ->
            PieChartEntry(
                value = value,
                label = AnnotatedString(Categories[idx])
            )
        },
        colors = SimpleColors,
        legendPosition = LegendPosition.Bottom,
        legendShape = CircleShape,
    )
    PieChart(data = data)
}
*/
