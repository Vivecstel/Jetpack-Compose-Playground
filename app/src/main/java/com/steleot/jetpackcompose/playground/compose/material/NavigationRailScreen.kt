package com.steleot.jetpackcompose.playground.compose.material


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/NavigationRailScreen.kt"

@Composable
fun NavigationRailScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.NavigationRail,
        link = URL,
    ) {
        NavigationRailExample(paddingValues = it)
    }
}

@Composable
private fun NavigationRailExample(paddingValues: PaddingValues) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf(
        stringResource(id = R.string.home),
        stringResource(id = R.string.search),
        stringResource(id = R.string.settings),
    )
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Settings)
    NavigationRail(
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {
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