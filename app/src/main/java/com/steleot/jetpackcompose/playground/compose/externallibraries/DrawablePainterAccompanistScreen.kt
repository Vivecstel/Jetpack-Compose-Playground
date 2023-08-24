package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.R as R2
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "externallibraries/DrawablePainterAccompanistScreen.kt"

@Composable
fun DrawablePainterAccompanistScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.DrawablePainterAccompanist,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DrawablePainterExample()
        }
    }
}

@Composable
private fun DrawablePainterExample() {
    val drawable =
        AppCompatResources.getDrawable(LocalContext.current, R2.drawable.ic_android)
            ?.apply {
                mutate()
                setTint(MaterialTheme.colors.onSurface.toArgb())
            }

    Image(
        painter = rememberDrawablePainter(drawable = drawable),
        contentDescription = stringResource(id = R.string.android),
    )
}