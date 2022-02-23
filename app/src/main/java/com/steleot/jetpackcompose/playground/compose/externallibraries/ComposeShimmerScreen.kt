package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import com.valentinilk.shimmer.shimmer

private const val Url = "externallibraries/ComposeShimmerScreen.kt"

@Composable
fun ComposeShimmerScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeShimmer,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ComposeShimmerExample()
        }
    }
}

@Composable
private fun ComposeShimmerExample() {
    Box(
        modifier = Modifier
            .size(128.dp)
            .background(Color.Blue)
            .shimmer(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(Color.Red)
        )
    }
}

