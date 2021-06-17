package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.DismissDirection.*
import androidx.compose.material.DismissValue.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import com.steleot.jetpackcompose.playground.*
import com.steleot.jetpackcompose.playground.compose.reusable.*
import java.util.*

private const val Url = "material/SwipeToDismissScreen.kt"

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
        link = Url,
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
                        }
                    )
                    val alignment = when (direction) {
                        StartToEnd -> Alignment.CenterStart
                        EndToStart -> Alignment.CenterEnd
                    }
                    val icon = when (direction) {
                        StartToEnd -> Icons.Default.Done
                        EndToStart -> Icons.Default.Delete
                    }
                    val scale by animateFloatAsState(
                        if (dismissState.targetValue == Default) 0.75f else 1f
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
                            contentDescription = "Localized description",
                            modifier = Modifier.scale(scale)
                        )
                    }
                },
                dismissContent = {
                    Card(
                        elevation = animateDpAsState(
                            if (dismissState.dismissDirection != null) 4.dp else 0.dp
                        ).value
                    ) {
                        ListItem(
                            text = {
                                Text(item, fontWeight = if (unread) FontWeight.Bold else null)
                            },
                            secondaryText = { Text("Swipe me left or right!") }
                        )
                    }
                }
            )
        }
    }
}