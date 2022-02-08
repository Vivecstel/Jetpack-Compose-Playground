package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundation/DefaultMinSizeScreen.kt"

@Composable
fun DefaultMinSizeScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.DefaultMinSize,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
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