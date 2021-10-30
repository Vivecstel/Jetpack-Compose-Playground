package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes

private const val Url = "material/Surface3Screen.kt"

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
                "Background color is from material theme background and text color is from error"
            )
        }
    }
}