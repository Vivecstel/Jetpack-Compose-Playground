package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clipScrollableContainer
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.layout.LazyLayout
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
import androidx.compose.foundation.rememberScrollState
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/LazyLayoutScreen.kt"

// TODO stelios
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyLayoutScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.LazyLayout,
        link = URL,
    ) {
        val itemsList = (0..20).toList()

        val itemProvider = itemProvider({ itemsList.size }) { index ->
            Text(
                stringResource(id = R.string.item, index),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(height = 50.dp)
            )
        }

        val scrollState = rememberScrollState()

        LazyLayout(
            itemProvider = { itemProvider },
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .clipScrollableContainer(Orientation.Vertical)
                .scrollable(
                    orientation = Orientation.Vertical,
                    reverseDirection = true,
                    interactionSource = null,
                    flingBehavior = ScrollableDefaults.flingBehavior(),
                    state = scrollState,
                    overscrollEffect = ScrollableDefaults.overscrollEffect(),
                    enabled = true
                )
        ) { constraints ->
            val items = mutableListOf<Placeable>()
            repeat(itemProvider.itemCount) { index ->
                items.add(measure(index, constraints)[0])
            }
            var yPosition = -scrollState.value
            layout(constraints.maxWidth, constraints.maxHeight) {
                items.forEach { placeable ->
                    placeable.placeRelative(x = 0, y = yPosition)
                    yPosition += placeable.measuredHeight
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
        override fun Item(index: Int, key: Any) {
            itemContent(index)
        }

        override val itemCount: Int
            get() = itemCount()

        override fun getKey(index: Int) = index

        override fun getContentType(index: Int): Any? = null
    }
}