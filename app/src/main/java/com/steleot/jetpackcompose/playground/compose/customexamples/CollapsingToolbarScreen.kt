package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultTopAppBar

private const val URL = "customexamples/CollapsingToolbarScreen.kt"
private const val MIN_HEIGHT = 56f
private const val MAX_HEIGHT = 168f

@Composable
fun CollapsingToolbarScreen() {
    val scrollState = rememberScrollState(0)
    DefaultScaffold(
        topBar = {
            TopScrollingContent(scrollState)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .verticalScroll(scrollState)
        ) {
            routesList.forEachIndexed { index, route ->
                CardExample(index, route, Modifier.padding(horizontal = 8.dp))
            }
        }
    }
}

@Composable
private fun TopScrollingContent(
    scrollState: ScrollState
) {
    val dynamicHeight = (MAX_HEIGHT - scrollState.value).coerceIn(MIN_HEIGHT, MAX_HEIGHT)
    DefaultTopAppBar(
        title = CustomExamplesNavRoutes.CollapsingToolbar,
        link = URL,
        modifier = Modifier.heightIn(
            min = animateDpAsState(dynamicHeight.dp, label = "TopScrollingContent").value
        ),
    )
}
