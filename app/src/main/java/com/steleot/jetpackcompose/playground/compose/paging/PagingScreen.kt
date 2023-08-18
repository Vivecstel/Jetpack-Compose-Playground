package com.steleot.jetpackcompose.playground.compose.paging

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Card
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.CircularProgressIndicator
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.*
import androidx.paging.compose.collectAsLazyPagingItems
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.MainNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlinx.coroutines.delay
import java.util.*
import kotlin.math.ceil

private const val URL = "paging/PagingScreen.kt"

@Composable
fun PagingScreen() {
    DefaultScaffold(
        title = MainNavRoutes.Paging,
        link = URL,
    ) {
        PagingExample()
    }
}

@Composable
private fun PagingExample() {
    val myBackend = remember { FakeBackend() }

    val pager = remember {
        Pager(
            PagingConfig(
                pageSize = myBackend.dataBatchSize,
                enablePlaceholders = true,
                maxSize = 200
            )
        ) { myBackend.getAllData() }
    }

    val lazyPagingItems = pager.flow.collectAsLazyPagingItems()

    LazyColumn {
        if (lazyPagingItems.loadState.refresh == LoadState.Loading) {
            item {
                Text(
                    text = stringResource(id = R.string.paging_initial_load),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }

        items(
            count = lazyPagingItems.itemCount,
        ) { index ->
            val item = lazyPagingItems[index]
            Card(
                Modifier.padding(8.dp),
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Text(
                    stringResource(id = R.string.paging_list_text, index, item.toString()),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }

        if (lazyPagingItems.loadState.append == LoadState.Loading) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

class FakeBackend {

    private val backendDataList = (0..60).toList().map { UUID.randomUUID().toString() }
    val dataBatchSize = 10

    class DesiredLoadResultPageResponse(
        val data: List<String>
    )

    fun searchItemsByKey(key: Int): DesiredLoadResultPageResponse {
        val maxKey = ceil(backendDataList.size.toFloat() / dataBatchSize).toInt()

        if (key >= maxKey) {
            return DesiredLoadResultPageResponse(emptyList())
        }

        val from = key * dataBatchSize
        val to = minOf((key + 1) * dataBatchSize, backendDataList.size)
        val currentSublist = backendDataList.subList(from, to)

        return DesiredLoadResultPageResponse(currentSublist)
    }

    fun getAllData(): PagingSource<Int, String> {

        return object : PagingSource<Int, String>() {
            override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
                delay(2000)
                val pageNumber = params.key ?: 0

                val response = searchItemsByKey(pageNumber)
                val prevKey = if (pageNumber > 0) pageNumber - 1 else null
                val nextKey = if (response.data.isNotEmpty()) pageNumber + 1 else null

                return LoadResult.Page(
                    data = response.data,
                    prevKey = prevKey,
                    nextKey = nextKey
                )
            }

            override fun getRefreshKey(state: PagingState<Int, String>): Int? {
                return state.anchorPosition?.let {
                    state.closestPageToPosition(it)?.prevKey?.plus(1)
                        ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
                }
            }
        }
    }
}
