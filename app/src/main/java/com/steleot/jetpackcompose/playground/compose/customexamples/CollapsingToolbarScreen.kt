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
import com.steleot.jetpackcompose.playground.navigation.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultTopAppBar

private const val Url = "customexamples/CollapsingToolbarScreen.kt"
private const val MinHeight = 56f
private const val MaxHeight = 168f

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
    val dynamicHeight = (MaxHeight - scrollState.value).coerceIn(MinHeight, MaxHeight)
    DefaultTopAppBar(
        title = CustomExamplesNavRoutes.CollapsingToolbar,
        link = Url,
        modifier = Modifier.heightIn(min = animateDpAsState(dynamicHeight.dp).value),
        showBackArrow = true
    )
}
