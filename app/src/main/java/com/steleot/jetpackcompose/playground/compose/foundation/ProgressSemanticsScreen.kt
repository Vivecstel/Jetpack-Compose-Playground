package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundation/ProgressSemanticsScreen.kt"

@Composable
fun ProgressSemanticsScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.ProgressSemantics,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProgressSemanticsExample()
        }
    }
}

@Composable
private fun ProgressSemanticsExample() {
    var enabled by remember { mutableStateOf(false) }
    val progress by animateFloatAsState(
        targetValue = if (!enabled) 0f else 100f,
        animationSpec = tween(1_500)
    )
    LaunchedEffect(Unit) {
        enabled = true
    }
    Box(
        Modifier
            .progressSemantics(progress)
            .size((progress * 2.5).dp, 8.dp)
            .background(color = MaterialTheme.colors.primary)
    )
}