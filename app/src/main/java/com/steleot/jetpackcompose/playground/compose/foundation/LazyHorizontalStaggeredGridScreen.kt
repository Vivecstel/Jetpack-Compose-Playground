package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/LazyHorizontalStaggeredGridScreen.kt"

@Composable
fun LazyHorizontalStaggeredGridScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.LazyHorizontalStaggeredGrid,
        link = URL,
    ) {
        val itemsList = (0..50).toList()
        val itemsIndexedList = listOf("A", "B", "C", "D", "E", "F")
        val itemModifier = Modifier
            .padding(all =16.dp)
            .border(width = 1.dp, color = MaterialTheme.colors.primary)
            .padding(all = 16.dp)
            .wrapContentSize()

        LazyHorizontalStaggeredGrid(
            rows = StaggeredGridCells.Fixed(5),
            modifier = Modifier.padding(paddingValues = it),
        ) {
            items(itemsList) { item ->
                Text(stringResource(id = R.string.item, item), modifier = itemModifier)
            }

            item {
                Text(stringResource(id = R.string.single_item), modifier = itemModifier)
            }

            itemsIndexed(itemsIndexedList) { index, item ->
                Text(
                    stringResource(id = R.string.paging_list_text, index, item),
                    modifier = itemModifier
                )
            }
        }
    }
}