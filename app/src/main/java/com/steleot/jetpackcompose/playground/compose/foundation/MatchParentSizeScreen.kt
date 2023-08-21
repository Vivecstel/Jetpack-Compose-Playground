package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/MatchParentSizeScreen.kt"

@Composable
fun MatchParentSizeScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.MatchParentSize,
        link = URL,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .background(Color.Red)
                .padding(32.dp)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(MaterialTheme.colors.secondary)
            )
        }
    }
}