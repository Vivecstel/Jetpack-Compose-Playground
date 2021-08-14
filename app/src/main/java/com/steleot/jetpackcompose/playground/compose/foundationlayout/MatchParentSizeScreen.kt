package com.steleot.jetpackcompose.playground.compose.foundationlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationLayoutNavRoutes

private const val Url = "foundationlayout/MatchParentSizeScreen.kt"

@Composable
fun MatchParentSizeScreen() {
    DefaultScaffold(
        title = FoundationLayoutNavRoutes.MatchParentSize,
        link = Url,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
                .padding(32.dp)
        ) {
            Box(modifier = Modifier
                .matchParentSize()
                .background(MaterialTheme.colors.secondary))
        }
    }
}