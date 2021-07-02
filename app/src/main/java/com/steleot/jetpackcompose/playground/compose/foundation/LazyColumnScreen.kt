package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundation/LazyColumnScreen.kt"

@Composable
fun LazyColumnScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.LazyColumn,
        link = Url,
    ) {
        val itemsList = (0..50).toList()
        val itemsIndexedList = listOf("A", "B", "C", "D", "E", "F")

        LazyColumn {
            items(itemsList) {
                Text(
                    "Item is $it", modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }

            item {
                Text(
                    "Single item", modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }

            itemsIndexed(itemsIndexedList) { index, item ->
                Text(
                    "Item at index $index is $item",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}