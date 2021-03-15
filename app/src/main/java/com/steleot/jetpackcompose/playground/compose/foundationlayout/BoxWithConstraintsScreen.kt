package com.steleot.jetpackcompose.playground.compose.foundationlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.FoundationLayoutNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "foundationlayout/BoxWithConstraintsScreen.kt"

@Composable
fun BoxWithConstraintsScreen() {
    DefaultScaffold(
        title = FoundationLayoutNavRoutes.Box.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        BoxWithConstraints {
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