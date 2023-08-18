package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.DismissDirection.EndToStart
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.DismissDirection.StartToEnd
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.DismissValue.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/SwipeToDismissScreen.kt"

private val items = listOf(
    "Cupcake",
    "Donut",
    "Eclair",
    "Froyo",
    "Gingerbread",
    "Honeycomb",
    "Ice cream sandwich",
    "Jelly bean",
    "KitKat",
    "Lollipop",
    "Marshmallow",
    "Nougat",
    "Oreo",
    "Pie"
)

@Composable
fun SwipeToDismissScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.SwipeToDismiss,
        link = URL,
    ) {
        SwipeToDismissExample()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SwipeToDismissExample() {
    LazyColumn {
        items(items) { item ->
            var unread by remember { mutableStateOf(false) }
            val dismissState = rememberDismissState(
                confirmStateChange = {
                    if (it == DismissedToEnd) unread = !unread
                    it != DismissedToEnd
                }
            )
            SwipeToDismiss(
                state = dismissState,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                directions = setOf(StartToEnd, EndToStart),
                dismissThresholds = { direction ->
                    FractionalThreshold(if (direction == StartToEnd) 0.25f else 0.5f)
                },
                background = {
                    val direction = dismissState.dismissDirection ?: return@SwipeToDismiss
                    val color by animateColorAsState(
                        when (dismissState.targetValue) {
                            Default -> Color.LightGray
                            DismissedToEnd -> Color.Green
                            DismissedToStart -> Color.Red
                        },
                        label = "SwipeToDismissExampleColor",
                    )
                    val alignment = when (direction) {
                        StartToEnd -> Alignment.CenterStart
                        EndToStart -> Alignment.CenterEnd
                    }
                    val icon = when (direction) {
                        StartToEnd -> Icons.Filled.Done
                        EndToStart -> Icons.Filled.Delete
                    }
                    val scale by animateFloatAsState(
                        if (dismissState.targetValue == Default) 0.75f else 1f,
                        label = "SwipeToDismissExampleColorScale"
                    )

                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(color)
                            .padding(horizontal = 20.dp),
                        contentAlignment = alignment
                    ) {
                        Icon(
                            icon,
                            contentDescription = null,
                            modifier = Modifier.scale(scale)
                        )
                    }
                },
                dismissContent = {
                    Card(
                        elevation = animateDpAsState(
                            if (dismissState.dismissDirection != null) 4.dp else 0.dp,
                            label = "SwipeToDismissExampleColorElevation"
                        ).value
                    ) {
                        ListItem(
                            text = {
                                Text(item, fontWeight = if (unread) FontWeight.Bold else null)
                            },
                            secondaryText = { Text(stringResource(id = R.string.swipe_left_right)) }
                        )
                    }
                }
            )
        }
    }
}