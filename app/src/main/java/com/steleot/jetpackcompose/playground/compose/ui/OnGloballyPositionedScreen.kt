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
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "ui/OnGloballyPositionedScreen.kt"

@Composable
fun OnGloballyPositionedScreen() {
    DefaultScaffold(
        title = UiNavRoutes.OnGloballyPositioned,
        link = Url,
    ) {
        Column(
            Modifier.onGloballyPositioned { coordinates ->
                // This will be the size of the Column.
                coordinates.size
                // The position of the Column relative to the application window.
                coordinates.positionInWindow()
                // The position of the Column relative to the Compose root.
                coordinates.positionInRoot()
                // These will be the alignment lines provided to the layout (empty here for Column).
                coordinates.providedAlignmentLines
                // This will a LayoutCoordinates instance corresponding to the parent of Column.
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