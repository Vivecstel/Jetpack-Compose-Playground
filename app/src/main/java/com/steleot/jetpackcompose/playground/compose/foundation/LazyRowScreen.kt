package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun LazyRowScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.LazyRow.capitalize(Locale.getDefault())
    ) {
        val itemsList = (0..50).toList()
        val itemsIndexedList = listOf("A", "B", "C", "D", "E", "F")

        LazyRow {
            items(itemsList) {
                Text("Item is $it", modifier = Modifier.padding(16.dp))
            }

            item {
                Text("Single item", modifier = Modifier.padding(16.dp))
            }

            itemsIndexed(itemsIndexedList) { index, item ->
                Text("Item at index $index is $item", modifier = Modifier.padding(16.dp))
            }
        }
    }
}