package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/BoxWithConstraintsScreen.kt"

@Composable
fun BoxWithConstraintsScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.BoxWithConstraints,
        link = URL,
    ) {
        BoxWithConstraints(
            modifier = Modifier.padding(paddingValues = it)
        ) {
            val rectangleHeight = 100.dp
            if (maxHeight < rectangleHeight * 2) {
                Box(
                    Modifier
                        .requiredSize(50.dp, rectangleHeight)
                        .background(Color.Blue)
                )
            } else {
                Column {
                    Box(
                        Modifier
                            .requiredSize(50.dp, rectangleHeight)
                            .background(Color.Blue)
                    )
                    Box(
                        Modifier
                            .requiredSize(50.dp, rectangleHeight)
                            .background(Color.Gray)
                    )
                }
            }
        }
    }
}