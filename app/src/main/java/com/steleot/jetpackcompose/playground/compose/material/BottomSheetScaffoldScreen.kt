package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun BottomSheetScaffoldScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.BottomSheetScaffold.capitalize(Locale.getDefault())
    ) {

    }
}