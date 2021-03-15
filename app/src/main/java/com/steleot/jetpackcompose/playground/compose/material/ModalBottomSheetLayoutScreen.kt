package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "material/ModalBottomSheetLayoutScreen.kt"

@Composable
fun ModalBottomSheetLayoutScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.ModalBottomSheetLayout.capitalize(Locale.getDefault()),
        link = Url,
    ) {

    }
}