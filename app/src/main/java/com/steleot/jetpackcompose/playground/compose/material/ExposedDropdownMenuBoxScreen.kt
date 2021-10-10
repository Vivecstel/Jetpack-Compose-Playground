package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes

private const val Url = "material/ExposedDropdownMenuBoxScreen.kt"

@Composable
fun ExposedDropdownMenuBoxScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.ExposedDropdownMenuBox,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ExposedDropdownMenuBoxExample()
        }
    }
}

@Composable
private fun ExposedDropdownMenuBoxExample() {

}