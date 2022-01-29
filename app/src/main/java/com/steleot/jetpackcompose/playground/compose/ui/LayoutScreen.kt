package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

private const val Url = "ui/LayoutScreen.kt"

@Composable
fun LayoutScreen() {
    DefaultScaffold(
        title = UiNavRoutes.Layout,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LayoutExample {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Blue)
                )
                Box(
                    modifier = Modifier
                        .size(25.dp)
                        .background(Color.Green)
                )
            }
            LayoutTagChildrenExample(
                {
                    Box(
                        modifier = Modifier
                            .size(75.dp)
                            .background(Color.Blue)
                    )
                }
            ) {
                Box(
                    modifier = Modifier
                        .size(25.dp)
                        .background(Color.Green)
                )
            }
            LayoutModifierExample()
        }
    }
}

@Composable
private fun LayoutExample(content: @Composable () -> Unit) {
    Layout(content) { measurables, constraints ->
        val childConstraints = Constraints(
            minWidth = constraints.minWidth / 2,
            minHeight = constraints.minHeight / 2,
            maxWidth = constraints.maxWidth / 2,
            maxHeight = constraints.maxHeight / 2
        )
        val placeables = measurables.map { it.measure(childConstraints) }
        val layoutWidth = (placeables.maxByOrNull { it.width }?.width ?: 0) * 2
        val layoutHeight = (placeables.maxByOrNull { it.height }?.height ?: 0) * 2
        layout(layoutWidth, layoutHeight) {
            placeables.forEach {
                it.placeRelative(layoutWidth - it.width, layoutHeight - it.height)
            }
        }
    }
}

@Composable
private fun LayoutTagChildrenExample(
    header: @Composable () -> Unit,
    footer: @Composable () -> Unit
) {
    Layout({
        Box(Modifier.layoutId("header")) { header() }
        Box(Modifier.layoutId("footer")) { footer() }
    }) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            when (measurable.layoutId) {
                // You should use appropriate constraints. Here we measure fake constraints.
                "header" -> measurable.measure(Constraints.fixed(100, 100))
                "footer" -> measurable.measure(constraints)
                else -> error("Unexpected tag")
            }
        }
        layout(100, 100) {
            placeables.forEach { it.placeRelative(0, 0) }
        }
    }
}

@Composable
private fun LayoutModifierExample() {
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .layout { measurable, constraints ->
                val padding = 50
                val placeable = measurable.measure(constraints.offset(vertical = -padding))
                this.layout(placeable.width, placeable.height + padding) {
                    placeable.placeRelative(0, padding)
                }
            }
    ) {
        Box(
            Modifier
                .size(50.dp)
                .background(Color.DarkGray)
        )
    }
}
