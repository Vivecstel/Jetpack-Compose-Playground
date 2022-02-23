package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "foundation/LazyRowScreen.kt"

@Composable
fun LazyRowScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.LazyRow,
        link = Url,
    ) {
        val itemsList = (0..50).toList()
        val itemsIndexedList = listOf("A", "B", "C", "D", "E", "F")

        LazyRow {
            items(itemsList) {
                Text(stringResource(id = R.string.item, it), modifier = Modifier.padding(16.dp))
            }

            item {
                Text(stringResource(id = R.string.single_item), modifier = Modifier.padding(16.dp))
            }

            itemsIndexed(itemsIndexedList) { index, item ->
                Text(
                    stringResource(id = R.string.paging_list_text, index, item),
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}