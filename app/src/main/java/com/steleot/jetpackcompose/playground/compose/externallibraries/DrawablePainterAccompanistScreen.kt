package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes

private const val Url = "externallibraries/DrawablePainterAccompanistScreen.kt"

@Composable
fun DrawablePainterAccompanistScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.DrawablePainterAccompanist,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
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
        AppCompatResources.getDrawable(LocalContext.current, R.drawable.ic_android)
            ?.apply {
                mutate()
                setTint(MaterialTheme.colors.onSurface.toArgb())
            }

    Image(
        painter = rememberDrawablePainter(drawable = drawable),
        contentDescription = stringResource(id = R.string.android),
    )
}