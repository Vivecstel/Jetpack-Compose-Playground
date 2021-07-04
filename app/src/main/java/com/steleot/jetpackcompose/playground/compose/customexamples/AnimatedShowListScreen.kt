package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.CustomExamplesNavRoutes

private const val Url = "customexamples/AnimatedShowListScreen.kt"

@Composable
fun AnimatedShowListScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.AnimatedShowList,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedShowListExample(routesList)
        }
    }
}

@Composable
private fun AnimatedShowListExample(routes: List<String>) {
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        itemsIndexed(routes) { index, route ->
            val animatedProgress = remember { Animatable(initialValue = 0.8f) }
            LaunchedEffect(Unit) {
                animatedProgress.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(300, easing = LinearEasing)
                )
            }
            val modifier = Modifier
                .fillParentMaxWidth()
                .padding(8.dp)
                .graphicsLayer(scaleY = animatedProgress.value, scaleX = animatedProgress.value)

            CardExample(index, route, modifier.fillMaxWidth())
        }
    }
}