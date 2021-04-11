package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.Text
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
import com.steleot.jetpackcompose.playground.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.theme.colors
import java.util.Locale
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
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedListExample(
                (activityRoutes +
                        animationRoutes +
                        constraintLayoutRoutes +
                        customExamplesRoutes +
                        externalRoutes).sorted()
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class)
@Composable
private fun AnimatedListExample(routes: List<String>) {
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
                Card(
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .fillParentMaxWidth()
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
                                    text = route.toUpperCase(Locale.getDefault()).first()
                                        .toString(),
                                    fontSize = 20.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                        },
                        trailing = {
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
                    ) {
                        Text(
                            text = route.capitalize(Locale.getDefault()),
                            style = TextStyle(
                                fontSize = 16.sp,
                                textAlign = TextAlign.Start
                            )
                        )
                    }
                }
            }
        }
    }
}
