package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.theme.colors
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import kotlinx.coroutines.launch

private const val URL = "foundation/ScrollerScreen.kt"

@Composable
fun ScrollerScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Scroller,
        link = URL,
    ) {
        ControlledScrollableRowExample(
            paddingValues = it
        )
    }
}

@Composable
private fun ControlledScrollableRowExample(
    paddingValues: PaddingValues,
) {
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {
        Row(Modifier.horizontalScroll(scrollState)) {
            repeat(1000) { index ->
                Square(index)
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(stringResource(id = R.string.scroll))
            Button(
                onClick = {
                    scope.launch { scrollState.scrollTo(scrollState.value - 1000) }
                }
            ) {
                Text("<-")
            }
            Button(
                onClick = {
                    scope.launch { scrollState.scrollBy(10000f) }
                }
            ) {
                Text("--->")
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(stringResource(id = R.string.smooth_scroll))
            Button(
                onClick = {
                    scope.launch { scrollState.animateScrollTo(scrollState.value - 1000) }
                }
            ) {
                Text("<-")
            }
            Button(
                onClick = {
                    scope.launch { scrollState.animateScrollBy(10000f) }
                }
            ) {
                Text("--->")
            }
        }
    }
}

@Composable
private fun Square(index: Int) {
    Box(
        Modifier
            .size(75.dp, 200.dp)
            .background(Color(colors[index % colors.size])),
        contentAlignment = Alignment.Center
    ) {
        Text(index.toString())
    }
}
