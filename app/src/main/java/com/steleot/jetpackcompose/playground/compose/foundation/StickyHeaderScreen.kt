package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "foundation/StickyHeaderScreen.kt"

private val routesGrouped = routes.groupBy { it.first().toString() }

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StickyHeaderScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.StickyHeader.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        LazyColumn {
            routesGrouped.forEach { (initial, routes) ->
                stickyHeader {
                    Text(
                        initial,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Gray)
                            .padding(16.dp)
                    )
                }

                items(routes) { route ->
                    Text(
                        route,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}