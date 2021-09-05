package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.LocalOverScrollConfiguration
import androidx.compose.foundation.gestures.OverScrollConfiguration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultCardListItem
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundation/LocalOverScrollConfigurationScreen.kt"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LocalOverScrollConfigurationScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.LocalOverScrollConfiguration,
        link = Url,
    ) {
        CompositionLocalProvider(
            LocalOverScrollConfiguration provides OverScrollConfiguration(
                MaterialTheme.colors.primaryVariant
            )
        ) {
            LazyColumn {
                items(routes) { route ->
                    DefaultCardListItem(route)
                }
            }
        }
    }
}