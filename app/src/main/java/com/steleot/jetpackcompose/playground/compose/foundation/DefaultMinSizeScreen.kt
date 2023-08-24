package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/DefaultMinSizeScreen.kt"

@Composable
fun DefaultMinSizeScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.DefaultMinSize,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultMinBox()
            DefaultMinBox(Modifier.requiredSizeIn(minWidth = 50.dp, minHeight = 50.dp))
        }
    }
}

@Composable
fun DefaultMinBox(modifier: Modifier = Modifier) {
    Box(
        modifier
            .defaultMinSize(minWidth = 100.dp, minHeight = 100.dp)
            .background(MaterialTheme.colors.primary)
    )
}