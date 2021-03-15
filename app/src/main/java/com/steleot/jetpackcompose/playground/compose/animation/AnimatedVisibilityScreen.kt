package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.AnimationNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "animation/AnimatedVisibilityScreen.kt"

@Composable
fun AnimatedVisibilityScreen() {
    DefaultScaffold(
        title = AnimationNavRoutes.AnimatedVisibility.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedFloatingActionButton()
            FadeTransition()
            ExpandShrinkVertically()
            ExpandInShrinkOut()
            ColumnAnimatedVisibility()
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun AnimatedFloatingActionButton() {
    var expanded by remember { mutableStateOf(true) }
    FloatingActionButton(
        onClick = { expanded = !expanded },
        modifier = with(ColumnScope) { Modifier.align(Alignment.CenterHorizontally) }
    ) {
        Row(Modifier.padding(start = 12.dp, end = 12.dp)) {
            Icon(
                Icons.Default.Favorite,
                contentDescription = "Favorite",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            AnimatedVisibility(
                expanded,
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(modifier = Modifier.padding(start = 12.dp), text = "Favorite")
            }
        }
    }
    Spacer(Modifier.requiredHeight(20.dp))
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun FadeTransition() {
    var visible by remember { mutableStateOf(true) }
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(
            initialAlpha = 0.4f
        ),
        exit = fadeOut(
            animationSpec = tween(durationMillis = 250)
        )
    ) {
        Text(
            "Content to appear/disappear",
            Modifier
                .fillMaxWidth()
                .requiredHeight(75.dp)
                .clickable(onClick = { visible = !visible }, onClickLabel = "Clickable Text")
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun ExpandShrinkVertically() {
    var visible by remember { mutableStateOf(true) }

    AnimatedVisibility(
        visible,
        enter = expandVertically(
            expandFrom = Alignment.Top,
            initialHeight = { 20 }
        ),
        exit = shrinkVertically(
            targetHeight = { fullHeight -> fullHeight / 2 },
            animationSpec = tween()
        )
    ) {
        Text(
            "Content to appear/disappear",
            Modifier
                .fillMaxWidth()
                .requiredHeight(75.dp)
                .clickable(onClick = { visible = !visible }, onClickLabel = "Clickable Text")
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun ExpandInShrinkOut() {
    var visible by remember { mutableStateOf(true) }

    AnimatedVisibility(
        visible,
        enter = expandIn(
            expandFrom = Alignment.BottomStart,
            initialSize = { IntSize(50, 50) },
            animationSpec = tween(500, easing = LinearOutSlowInEasing)
        ),
        exit = shrinkOut(
            shrinkTowards = Alignment.CenterStart,
            targetSize = { fullSize -> IntSize(fullSize.width / 10, fullSize.height / 5) },
            animationSpec = tween(500, easing = FastOutSlowInEasing)
        )
    ) {
        Text(
            "Content to appear/disappear",
            Modifier
                .fillMaxWidth()
                .requiredHeight(75.dp)
                .clickable(onClick = { visible = !visible }, onClickLabel = "Clickable Text")
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun ColumnAnimatedVisibility() {
    var itemIndex by remember { mutableStateOf(0) }
    val colors = listOf(Color.Red, Color.Green, Color.Blue)
    Column(
        Modifier
            .fillMaxWidth()
            .clickable {
                itemIndex = (itemIndex + 1) % colors.size
            }
    ) {
        colors.forEachIndexed { i, color ->
            AnimatedVisibility(i <= itemIndex) {
                Box(
                    Modifier
                        .requiredHeight(40.dp)
                        .fillMaxWidth()
                        .background(color)
                )
            }
        }
    }
}
