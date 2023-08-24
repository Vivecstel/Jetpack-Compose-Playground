package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.OverscrollConfiguration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultCardListItem
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/LocalOverScrollConfigurationScreen.kt"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LocalOverScrollConfigurationScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.LocalOverScrollConfiguration,
        link = URL,
    ) {
        CompositionLocalProvider(
            LocalOverscrollConfiguration provides OverscrollConfiguration(
                MaterialTheme.colors.primaryVariant
            )
        ) {
            LazyColumn(contentPadding = it) {
                items(routes) { route ->
                    DefaultCardListItem(route)
                }
            }
        }
    }
}