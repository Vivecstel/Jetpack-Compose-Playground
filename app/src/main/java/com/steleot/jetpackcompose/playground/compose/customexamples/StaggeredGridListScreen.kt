package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.theme.colors
import com.steleot.jetpackcompose.playground.utils.capitalizeFirstLetter
import kotlin.math.ceil

private const val Url = "customexamples/StaggeredGridListScreen.kt"

@Composable
fun StaggeredGridListScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.StaggeredGridList,
        link = Url,
    ) {
        StaggeredVerticalGrid(
            maxColumnWidth = 220.dp,
            modifier = Modifier
                .padding(4.dp)
                .verticalScroll(rememberScrollState())
        ) {
            routesList.forEachIndexed { index, route ->
                StaggeredCard(index, route)
            }
        }
    }
}

@Composable
private fun StaggeredVerticalGrid(
    modifier: Modifier = Modifier,
    maxColumnWidth: Dp,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        check(constraints.hasBoundedWidth) {
            "Unbounded width not supported"
        }
        val columns = ceil(constraints.maxWidth / maxColumnWidth.toPx()).toInt()
        val columnWidth = constraints.maxWidth / columns
        val itemConstraints = constraints.copy(maxWidth = columnWidth)
        val colHeights = IntArray(columns) { 0 }
        val placeables = measurables.map { measurable ->
            val column = shortestColumn(colHeights)
            val placeable = measurable.measure(itemConstraints)
            colHeights[column] += placeable.height
            placeable
        }

        val height = colHeights.maxOrNull()?.coerceIn(constraints.minHeight, constraints.maxHeight)
            ?: constraints.minHeight
        layout(
            width = constraints.maxWidth,
            height = height
        ) {
            val colY = IntArray(columns) { 0 }
            placeables.forEach { placeable ->
                val column = shortestColumn(colY)
                placeable.place(
                    x = columnWidth * column,
                    y = colY[column]
                )
                colY[column] += placeable.height
            }
        }
    }
}

private fun shortestColumn(colHeights: IntArray): Int {
    var minHeight = Int.MAX_VALUE
    var column = 0
    colHeights.forEachIndexed { index, height ->
        if (height < minHeight) {
            minHeight = height
            column = index
        }
    }
    return column
}

@Composable
private fun StaggeredCard(index: Int, route: String) {
    Column(modifier = Modifier.padding(4.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    when (index % 3) {
                        0 -> 64
                        1 -> 96
                        else -> 128
                    }.dp
                )
                .background(colors[index % colors.size])
        )
        Text(
            text = route.capitalizeFirstLetter(),
            style = TextStyle(
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}