package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.AnimationNavRoutes

private const val Url = "animation/AnimatedVisibilityScreen.kt"

@Composable
fun AnimatedVisibilityScreen() {
    DefaultScaffold(
        title = AnimationNavRoutes.AnimatedVisibility,
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
private fun ColumnScope.AnimatedFloatingActionButton() {
    var expanded by remember { mutableStateOf(true) }
    val favorite = stringResource(id = R.string.favorite)
    FloatingActionButton(
        onClick = { expanded = !expanded },
        modifier = Modifier.align(Alignment.CenterHorizontally)
    ) {
        Row(Modifier.padding(start = 12.dp, end = 12.dp)) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = favorite,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            AnimatedVisibility(
                expanded,
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(modifier = Modifier.padding(start = 12.dp), text = favorite)
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
            stringResource(id = R.string.animated_visibility_content),
            Modifier
                .fillMaxWidth()
                .requiredHeight(75.dp)
                .clickable(
                    onClick = { visible = !visible },
                    onClickLabel = stringResource(id = R.string.clickable_text)
                )
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
            stringResource(id = R.string.animated_visibility_content),
            Modifier
                .fillMaxWidth()
                .requiredHeight(75.dp)
                .clickable(
                    onClick = { visible = !visible },
                    onClickLabel = stringResource(id = R.string.clickable_text)
                )
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
            stringResource(id = R.string.animated_visibility_content),
            Modifier
                .fillMaxWidth()
                .requiredHeight(75.dp)
                .clickable(
                    onClick = { visible = !visible },
                    onClickLabel = stringResource(id = R.string.clickable_text)
                )
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
