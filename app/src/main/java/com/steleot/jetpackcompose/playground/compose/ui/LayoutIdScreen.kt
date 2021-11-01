package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Constraints
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

private const val Url = "ui/LayoutIdScreen.kt"

@Composable
fun LayoutIdScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LayoutId,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LayoutIdExample()
        }
    }
}

@Composable
private fun LayoutIdExample() {
    Layout({
        Box(Modifier.layoutId("header")) { Text(stringResource(id = R.string.header_text)) }
        Box(Modifier.layoutId("footer")) { Text(stringResource(id = R.string.footer_text)) }
    }) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            when (measurable.layoutId) {
                "header" -> measurable.measure(Constraints.fixed(100, 100))
                "footer" -> measurable.measure(constraints)
                else -> error("Unexpected tag")
            }
        }
        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables[0].placeRelative(constraints.maxWidth / 2, 0)
            placeables[1].placeRelative(constraints.maxWidth / 2, constraints.maxHeight / 2)
        }
    }
}