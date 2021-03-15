package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import com.steleot.jetpackcompose.playground.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "ui/AlignmentLineScreen.kt"

@Composable
fun AlignmentLineScreen() {
    DefaultScaffold(
        title = UiNavRoutes.AlignmentLine.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        val exampleLine = remember { FirstBaseline }

        @Composable
        fun LineProviderLayout(exampleLinePosition: Int) {
            val size = 50
            Layout({}, modifier = Modifier.background(Color.Blue)) { _, _ ->
                layout(size, size, mapOf(exampleLine to exampleLinePosition)) {}
            }
        }

        Layout({
            LineProviderLayout(exampleLinePosition = 5)
            LineProviderLayout(exampleLinePosition = 10)
        }, modifier = Modifier.background(Color.Red)) { measurables, constraints ->
            val placeables = measurables.map { it.measure(constraints) }
            layout(constraints.maxWidth, constraints.maxHeight) {
                placeables[0].place(0, 50)
                placeables[1].place(constraints.maxWidth / 2, 0)
            }
        }
    }
}