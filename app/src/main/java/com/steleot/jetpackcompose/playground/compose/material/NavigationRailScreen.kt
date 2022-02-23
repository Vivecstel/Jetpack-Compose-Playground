package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "material/NavigationRailScreen.kt"

@Composable
fun NavigationRailScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.NavigationRail,
        link = Url,
    ) {
        NavigationRailExample()
    }
}

@Composable
private fun NavigationRailExample() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        stringResource(id = R.string.home),
        stringResource(id = R.string.search),
        stringResource(id = R.string.settings),
    )
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Settings)
    NavigationRail {
        items.forEachIndexed { index, item ->
            NavigationRailItem(
                icon = { Icon(icons[index], contentDescription = item) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                selectedContentColor = MaterialTheme.colors.secondary
            )
        }
    }
}