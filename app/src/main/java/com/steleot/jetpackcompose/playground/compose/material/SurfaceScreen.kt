package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "material/SurfaceScreen.kt"

@Composable
fun SurfaceScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.Surface,
        link = Url,
    ) {
        Surface(
            color = MaterialTheme.colors.background,
            contentColor = MaterialTheme.colors.error
        ) {
            Text(
                stringResource(id = R.string.surface_msg)
            )
        }
    }
}