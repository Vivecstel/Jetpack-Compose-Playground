package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.layout.LazyLayout
import androidx.compose.foundation.lazy.layout.LazyLayoutItemsProvider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "foundation/LazyLayoutScreen.kt"

// TODO stelios
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyLayoutScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.LazyLayout,
        link = Url,
    ) {
        val itemsList = (0..50).toList()

        val itemsProvider = itemProvider({ itemsList.size }) { index ->
            {
                Text(
                    stringResource(id = R.string.item, index),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }

        LazyLayout(itemsProvider = itemsProvider) {
            val constraints = Constraints.fixedHeight(250)
            val items = mutableListOf<Placeable>()
            repeat(itemsProvider.itemsCount) { index ->
                items.addAll(measure(index, constraints))
            }
            layout(250, 250) {
                items.forEach {
                    it.place(0, 0)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
private fun itemProvider(
    itemsCount: () -> Int,
    content: (Int) -> @Composable () -> Unit
): LazyLayoutItemsProvider {
    return object : LazyLayoutItemsProvider {
        override fun getContent(index: Int): @Composable () -> Unit {
            return content(index)
        }

        override val itemsCount: Int
            get() = itemsCount()

        override fun getKey(index: Int) = index
        override val keyToIndexMap: Map<Any, Int> = emptyMap()
        override fun getContentType(index: Int): Any? = null
    }
}