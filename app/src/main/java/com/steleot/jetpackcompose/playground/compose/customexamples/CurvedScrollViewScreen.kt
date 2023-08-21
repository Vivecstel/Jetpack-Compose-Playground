package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultCardListItem
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlin.math.PI
import kotlin.math.cos

private const val URL = "customexamples/CurvedScrollViewScreen.kt"

@Composable
fun CurvedScrollViewScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.CurvedScrollView,
        link = URL,
    ) {
        CurvedScrollView(routes, modifier = Modifier.padding(paddingValues = it)) { route ->
            DefaultCardListItem(text = route)
        }
    }
}

@Composable
private fun <T> CurvedScrollView(
    items: List<T>,
    modifier: Modifier = Modifier,
    contentSpacing: Dp = 8.dp,
    reversed: Boolean = false,
    itemContent: @Composable (item: T) -> Unit
) {
    val scrollState = rememberScrollState()
    var size by remember { mutableStateOf(IntSize.Zero) }
    Box(modifier = modifier.onSizeChanged { size = it }) {
        Layout(
            modifier = Modifier.verticalScroll(scrollState),
            content = { repeat(items.size) { itemContent(items[it]) } }
        ) { measurables, constraints ->
            val itemSpacing = contentSpacing.roundToPx()
            var contentHeight = (items.size - 1) * itemSpacing
            val placeables = measurables.mapIndexed { index, measurable ->
                val placeable = measurable.measure(constraints)
                contentHeight += if (index == 0 || index == measurables.lastIndex) {
                    placeable.height / 2
                } else {
                    placeable.height
                }
                placeable
            }

            layout(constraints.maxWidth, size.height + contentHeight) {
                val startOffset = size.height / 2 - placeables[0].height / 2
                var yPosition = startOffset

                val scrollPercent = scrollState.value.toFloat() / scrollState.maxValue

                placeables.forEachIndexed { index, placeable ->
                    val elementRatio = index.toFloat() / placeables.lastIndex
                    val interpolatedValue = cos((scrollPercent - elementRatio) * PI)
                    val width = if (reversed) size.width else size.width / 2
                    val indent = (interpolatedValue * width).toInt()
                    val xPosition = if (reversed) constraints.maxWidth - indent else indent
                    placeable.placeRelative(x = xPosition, y = yPosition)
                    yPosition += placeable.height + itemSpacing
                }
            }
        }
    }
}