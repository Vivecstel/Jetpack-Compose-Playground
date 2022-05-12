package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.layout.LazyLayout
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
        val itemsList = (0..10).toList()

        val itemProvider = itemProvider({ itemsList.size }) { index ->
            Text(
                stringResource(id = R.string.item, index),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }

        LazyLayout(
            itemProvider = itemProvider,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) { constraints ->
            val items = mutableListOf<Placeable>()
            repeat(itemProvider.itemCount) { index ->
                items.addAll(measure(index, Constraints.fixedHeight(250)))
            }
            layout(constraints.maxWidth, constraints.maxHeight) {
                var yPosition = 0
                items.forEach { placeable ->
                    placeable.placeRelative(x = 0, y = yPosition)
                    yPosition += placeable.height
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
private fun itemProvider(
    itemCount: () -> Int,
    itemContent: @Composable (Int) -> Unit
): LazyLayoutItemProvider {
    return object : LazyLayoutItemProvider {

        @Composable
        override fun Item(index: Int) {
            itemContent(index)
        }

        override val itemCount: Int
            get() = itemCount()

        override fun getKey(index: Int) = index

        override val keyToIndexMap: Map<Any, Int> = emptyMap()

        override fun getContentType(index: Int): Any? = null
    }
}