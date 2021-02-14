package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun BottomNavigationScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.BottomNavigation.capitalize(Locale.getDefault())
    ) {

    }
}