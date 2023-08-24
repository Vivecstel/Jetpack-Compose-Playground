package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/LazyHorizontalGridScreen.kt"

@Composable
fun LazyHorizontalGridScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.LazyHorizontalGrid,
        link = URL,
    ) {
        val itemsList = (0..50).toList()
        val itemsIndexedList = listOf("A", "B", "C", "D", "E", "F")

        LazyHorizontalGrid(
            GridCells.Adaptive(80.dp),
            modifier = Modifier.padding(paddingValues = it),
        ) {
            items(itemsList) { item ->
                Text(stringResource(id = R.string.item, item))
            }

            item {
                Text(stringResource(id = R.string.single_item))
            }

            itemsIndexed(itemsIndexedList) { index, item ->
                Text(stringResource(id = R.string.paging_list_text, index, item))
            }
        }
    }
}