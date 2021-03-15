package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "material/BottomDrawerLayoutScreen.kt"

@Composable
fun BottomDrawerLayoutScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.BottomDrawerLayout.capitalize(Locale.getDefault()),
        link = Url,
    ) {

    }
}