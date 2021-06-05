package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import hu.ma.charts.ChartShape
import hu.ma.charts.bars.HorizontalBarsChart
import hu.ma.charts.bars.data.HorizontalBarsData
import hu.ma.charts.bars.data.StackedBarData
import hu.ma.charts.bars.data.StackedBarEntry
import hu.ma.charts.pie.LegendPosition
import hu.ma.charts.pie.PieChart
import hu.ma.charts.pie.PieChartData
import hu.ma.charts.pie.PieChartEntry
import hu.ma.charts.table.TableChart
import hu.ma.charts.table.TableEntry
import java.util.*

private const val Url = "external/ComposeChartsScreen.kt"

@Composable
fun ComposeChartsScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeCharts,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TableChartExample()
            PieChartExample()
//            HorizontalBarsChartExample()
        }
    }
}

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

@Composable
private fun TableChartExample() {
    val data = (1..5).map {
        TableEntry(
            key = AnnotatedString(Categories[it]),
            value = AnnotatedString((it * Random(System.currentTimeMillis()).nextInt(123)).toString()),
            drawShape = ChartShape(
                size = 8.dp,
                shape = CircleShape,
                color = SimpleColors[it],
            )
        )
    }
    TableChart(data = data)
}

@Composable
private fun HorizontalBarsChartExample() {
    val data = HorizontalBarsData(
        bars = listOf(
            listOf(12f, 2f, 3f, 2f),
            listOf(3f, 2f, 4f, 5f),
            listOf(1f, 4f, 12f, 5f),
            listOf(1f, 20f, 2f, 1f),
        ).mapIndexed { idx, values ->
            StackedBarData(
                title = AnnotatedString("Bars $idx"),
                entries = values.mapIndexed { index, value ->
                    StackedBarEntry(
                        text = AnnotatedString(Categories[index]),
                        value = value,
                        color = SimpleColors[index]
                    )
                }
            )
        },
        colors = SimpleColors.reversed(),
    )
    HorizontalBarsChart(data = data)
}