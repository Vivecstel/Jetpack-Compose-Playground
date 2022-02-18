package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.RuntimeNavRoutes

private const val Url = "runtime/MovableContentOfScreen.kt"

@Composable
fun MovableContentOfScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.MovableContentOf,
        link = Url,
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            MovableContentOfExample(
                (1..25).toList()
            )
        }

    }
}

@Composable
private fun BoxScope.MovableContentOfExample(
    items: List<Int>
) {
    val itemMap = remember {
        mutableMapOf<Int, @Composable () -> Unit>()
    }
    val movableItems =
        items.map { item ->
            itemMap.getOrPut(item) {
                movableContentOf {
                    Text(
                        item.toString(),
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    val itemsPerColumn = 5
    val columns = items.size / itemsPerColumn + (if (items.size % itemsPerColumn == 0) 0 else 1)
    Row(
        modifier = Modifier.align(Alignment.Center)
    ) {
        repeat(columns) { column ->
            Column {
                val base = column * itemsPerColumn
                val end = minOf(base + itemsPerColumn, items.size)
                for (index in base until end) {
                    movableItems[index]()
                }
            }
        }
    }
}
