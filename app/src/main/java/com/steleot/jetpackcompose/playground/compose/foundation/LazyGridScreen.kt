package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyGridScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.LazyGrid.capitalize(Locale.getDefault())
    ) {
        val itemsList = (0..50).toList()
        val itemsIndexedList = listOf("A", "B", "C", "D", "E", "F")

        LazyVerticalGrid(GridCells.Adaptive(80.dp)) {
            items(itemsList) {
                Text("Item is $it")
            }

            item {
                Text("Single item")
            }

            itemsIndexed(itemsIndexedList) { index, item ->
                Text("Item at index $index is $item")
            }
        }
    }
}