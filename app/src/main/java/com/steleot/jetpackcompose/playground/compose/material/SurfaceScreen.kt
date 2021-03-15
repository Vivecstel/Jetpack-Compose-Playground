package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "material/SurfaceScreen.kt"

@Composable
fun SurfaceScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.Surface.capitalize(Locale.getDefault()),
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