package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "ui/OnGloballyPositionedScreen.kt"

@Composable
fun OnGloballyPositionedScreen() {
    DefaultScaffold(
        title = UiNavRoutes.OnGloballyPositioned,
        link = URL,
    ) {
        Column(
            Modifier.onGloballyPositioned { coordinates ->
                coordinates.size
                coordinates.positionInWindow()
                coordinates.positionInRoot()
                coordinates.providedAlignmentLines
                coordinates.parentLayoutCoordinates
            }
        ) {
            Box(
                Modifier
                    .size(20.dp)
                    .background(Color.Green)
            )
            Box(
                Modifier
                    .size(20.dp)
                    .background(Color.Blue)
            )
        }
    }
}