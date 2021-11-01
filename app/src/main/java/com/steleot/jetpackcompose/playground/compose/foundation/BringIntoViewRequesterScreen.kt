package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes
import kotlinx.coroutines.launch

private const val Url = "foundation/BringIntoViewRequesterScreen.kt"

@Composable
fun BringIntoViewRequesterScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.BringIntoViewRequester,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BringIntoViewRequesterExample()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun BringIntoViewRequesterExample() {
    with(LocalDensity.current) {
        val requester = remember { BringIntoViewRequester() }
        val coroutineScope = rememberCoroutineScope()
        Column {
            Box(
                Modifier
                    .border(2.dp, MaterialTheme.colors.primary)
                    .size(500f.toDp())
                    .horizontalScroll(rememberScrollState())
            ) {
                Canvas(
                    Modifier
                        .size(1500f.toDp(), 500f.toDp())
                        .bringIntoViewRequester(requester)
                ) {
                    drawCircle(color = Color.Red, radius = 250f, center = Offset(750f, 250f))
                }
            }
            Button(
                onClick = {
                    val circleCoordinates = Rect(500f, 0f, 1000f, 500f)
                    coroutineScope.launch {
                        requester.bringIntoView(circleCoordinates)
                    }
                }
            ) {
                Text(stringResource(id = R.string.bring_circle_into_view))
            }
        }
    }
}