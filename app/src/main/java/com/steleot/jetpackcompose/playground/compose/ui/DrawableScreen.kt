package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.R as R2
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "ui/DrawableScreen.kt"

@Preview
@Composable
fun DrawableScreen() {
    DefaultScaffold(
        title = UiNavRoutes.Drawable,
        link = URL,
    ) {
        val colors = MaterialTheme.colors
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(
                    id = R2.drawable.ic_android
                ),
                contentDescription = stringResource(id = R.string.vector_painter),
                modifier = Modifier.size(32.dp),
                colorFilter = ColorFilter.tint(colors.primary)
            )
            Image(
                painter = painterResource(
                    id =
                    R.drawable.ic_baseline_alarm_24dp
                ),
                contentDescription = stringResource(id = R.string.drawable_painter),
                modifier = Modifier.size(48.dp),
                colorFilter = ColorFilter.tint(colors.primaryVariant)
            )
        }
    }
}
