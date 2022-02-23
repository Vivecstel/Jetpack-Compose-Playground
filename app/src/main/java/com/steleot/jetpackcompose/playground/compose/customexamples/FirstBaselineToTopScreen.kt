package com.steleot.jetpackcompose.playground.compose.customexamples

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "customexamples/FirstBaselineToTopScreen.kt"

@Composable
fun FirstBaselineToTopScreen() {
    val paddingTop = 24.dp
    DefaultScaffold(
        title = CustomExamplesNavRoutes.FirstBaselineToTop,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.border(1.dp, MaterialTheme.colors.error)) {
                Text(
                    text = stringResource(id = R.string.first_baseline_padding),
                    modifier = Modifier.firstBaselineToTop(paddingTop)
                )
            }
            Box(modifier = Modifier.border(1.dp, MaterialTheme.colors.error)) {
                Text(
                    text = stringResource(id = R.string.normal_padding),
                    modifier = Modifier.padding(top = paddingTop)
                )
            }
        }
    }
}

@SuppressLint("ModifierFactoryUnreferencedReceiver")
@Suppress("unused")
private fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp
) = Modifier.layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
    val firstBaseline = placeable[FirstBaseline]

    val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
    val height = placeable.height + placeableY
    layout(placeable.width, height) {
        placeable.place(0, placeableY)
    }
}
