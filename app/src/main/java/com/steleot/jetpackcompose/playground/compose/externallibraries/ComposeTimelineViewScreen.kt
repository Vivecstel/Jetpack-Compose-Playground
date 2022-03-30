package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import me.sungbin.timelineview.TimeLine
import me.sungbin.timelineview.TimeLineItem
import me.sungbin.timelineview.TimeLineOption

private const val Url = "externallibraries/ComposeTimelineViewScreen.kt"

@Composable
fun ComposeTimelineViewScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeTimelineView,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ComposeTimelineViewExample()
        }
    }
}

@Composable
private fun ComposeTimelineViewExample() {
    TimeLine(
        items = listOf(
            ExampleItem(1),
            ExampleItem(1),
            ExampleItem(1),
            ExampleItem(2),
            ExampleItem(2),
            ExampleItem(2),
            ExampleItem(2),
            ExampleItem(3),
            ExampleItem(4),
            ExampleItem(4),
            ExampleItem(4),
            ExampleItem(4),
            ExampleItem(5),
        ),
        timeLineOption = TimeLineOption(
            contentHeight = 45.dp,
            lineColor = MaterialTheme.colors.primary
        ),
        modifier = Modifier.background(Color.White),
        header = { key ->
            Text(
                text = stringResource(id = R.string.index_header_args, key),
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
            )
        },
        content = { item ->
            Text(
                text = stringResource(id = R.string.index_header_args, item.key),
            )
        }
    )
}

private data class ExampleItem(
    override val key: Int
) : TimeLineItem<Int>