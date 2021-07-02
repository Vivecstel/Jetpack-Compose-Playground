package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.theme.colors
import com.steleot.jetpackcompose.playground.utils.capitalizeFirstLetter
import kotlin.collections.plus
import kotlin.collections.sorted
import com.steleot.jetpackcompose.playground.compose.activity.routes as activityRoutes
import com.steleot.jetpackcompose.playground.compose.animation.routes as animationRoutes
import com.steleot.jetpackcompose.playground.compose.constraintlayout.routes as constraintLayoutRoutes
import com.steleot.jetpackcompose.playground.compose.customexamples.routes as customExamplesRoutes
import com.steleot.jetpackcompose.playground.compose.externallibraries.routes as externalRoutes

private const val Url = "customexamples/AnimatedDeleteListScreen.kt"

@Composable
fun AnimatedDeleteListScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.AnimatedDeleteList,
        link = Url,
    ) {
        AnimatedDeleteListExample(routesList)
    }
}

internal val routesList
    get(): List<String> = (activityRoutes +
            animationRoutes +
            constraintLayoutRoutes +
            customExamplesRoutes +
            externalRoutes).sorted()

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class)
@Composable
private fun AnimatedDeleteListExample(routes: List<String>) {
    val deletedRouteList = remember { mutableStateListOf<String>() }
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        itemsIndexed(routes) { index, route ->
            AnimatedVisibility(
                visible = !deletedRouteList.contains(route),
                enter = expandVertically(),
                exit = shrinkVertically(
                    animationSpec = tween(
                        durationMillis = 1000,
                    )
                )
            ) {
                CardExample(index, route, Modifier.fillParentMaxWidth()) {
                    IconButton(
                        onClick = {
                            deletedRouteList.add(route)
                        }
                    ) {
                        Icon(
                            Icons.Filled.Delete,
                            contentDescription = "Delete route",
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun CardExample(
    index: Int,
    route: String,
    modifier: Modifier = Modifier,
    trailing: @Composable (() -> Unit)? = null,
) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
            .padding(vertical = 8.dp)
    ) {
        ListItem(
            icon = {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(colors[index % colors.size])
                ) {
                    Text(
                        text = route.first().uppercaseChar().toString(),
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            },
            trailing = trailing
        ) {
            Text(
                text = route.capitalizeFirstLetter(),
                style = TextStyle(
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start
                )
            )
        }
    }
}
