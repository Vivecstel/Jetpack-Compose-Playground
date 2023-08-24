package com.steleot.jetpackcompose.playground.compose.material


import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Surface
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/SurfaceScreen.kt"

@Composable
fun SurfaceScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.Surface,
        link = URL,
    ) {
        Surface(
            modifier = Modifier.padding(paddingValues = it),
            color = MaterialTheme.colors.background,
            contentColor = MaterialTheme.colors.error
        ) {
            Text(
                stringResource(id = R.string.surface_msg)
            )
        }
    }
}