package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.TableChart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes

private const val Url = "material/BottomNavigationScreen.kt"

@Composable
fun BottomNavigationScreen() {
    val selectedNavigationView = remember { mutableStateOf(0) }
    val selectedNavigationItem = remember { mutableStateOf(0) }
    DefaultScaffold(
        title = MaterialNavRoutes.BottomNavigation,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    selectedNavigationView.value =
                        if (selectedNavigationView.value == 2) 0 else selectedNavigationView.value + 1
                }
            ) {
                Text(text = "Switch to bottom navigation")
            }
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    selectedNavigationItem.value =
                        if (selectedNavigationItem.value == 4) 0 else selectedNavigationItem.value + 1
                }
            ) {
                Text(text = "Switch to bottom navigation item")
            }
            Spacer(modifier = Modifier.height(32.dp))
            HelperView(selectedNavigationView.value, selectedNavigationItem.value)
        }
    }
}

@Preview
@Composable
private fun HelperView(
    selectedNavigationView: Int = 0,
    selectedNavigationItem: Int = 0,
) {
    val selectedItem = remember { mutableStateOf(0) }
    Column {
        when (selectedNavigationView) {
            0 -> StandardBottomNavigation {
                HelperNavigationItems(selectedItem, selectedNavigationItem)
            }
            1 -> BackgroundColorBottomNavigation {
                HelperNavigationItems(selectedItem, selectedNavigationItem)
            }
            2 -> ElevationBottomNavigation {
                HelperNavigationItems(selectedItem, selectedNavigationItem)
            }
        }
    }
}

private const val Person = "Person"
private const val TableChart = "Table Chart"
private const val Settings = "Settings"

@Preview
@Composable
private fun RowScope.HelperNavigationItems(
    selectedItem: MutableState<Int> = mutableStateOf(0),
    selectedNavigationItem: Int = 0,
    items: List<Pair<String, ImageVector>> = listOf(
        Pair(Person, Icons.Filled.Person),
        Pair(TableChart, Icons.Filled.TableChart),
        Pair(Settings, Icons.Filled.Settings)
    ),
) {
    items.forEachIndexed { index, item ->
        val selected = selectedItem.value == index
        val onClick = { selectedItem.value = index }
        when (selectedNavigationItem) {
            0 -> DefaultBottomNavigationItem(item, selected, onClick)
            1 -> LabelBottomNavigationItem(item, selected, onClick)
            2 -> AlwaysShowLabelBottomNavigationItem(item, selected, onClick)
            3 -> SelectedColorBottomNavigationItem(item, selected, onClick)
            4 -> UnselectedColorBottomNavigationItem(item, selected, onClick)
        }
    }
}

@Preview
@Composable
private fun StandardBottomNavigation(
    content: @Composable RowScope.() -> Unit = {}
) {
    BottomNavigation {
        content()
    }
}

@Preview
@Composable
private fun BackgroundColorBottomNavigation(
    content: @Composable RowScope.() -> Unit = {}
) {
    BottomNavigation(
        backgroundColor = Color.Magenta
    ) {
        content()
    }
}

@Preview
@Composable
private fun ElevationBottomNavigation(
    content: @Composable RowScope.() -> Unit = {}
) {
    BottomNavigation(
        elevation = 12.dp
    ) {
        content()
    }
}

@Preview
@Composable
private fun RowScope.DefaultBottomNavigationItem(
    pair: Pair<String, ImageVector> = Pair(Person, Icons.Filled.Person),
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    BottomNavigationItem(
        icon = { Icon(imageVector = pair.second, contentDescription = "") },
        selected = selected,
        onClick = onClick,
    )
}

@Preview
@Composable
private fun RowScope.LabelBottomNavigationItem(
    pair: Pair<String, ImageVector> = Pair(Person, Icons.Filled.Person),
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    BottomNavigationItem(
        icon = { Icon(imageVector = pair.second, contentDescription = "") },
        label = { Text(text = pair.first) },
        selected = selected,
        onClick = onClick,
    )
}

@Preview
@Composable
private fun RowScope.AlwaysShowLabelBottomNavigationItem(
    pair: Pair<String, ImageVector> = Pair(Person, Icons.Filled.Person),
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    BottomNavigationItem(
        icon = { Icon(imageVector = pair.second, contentDescription = "") },
        label = { Text(text = pair.first) },
        alwaysShowLabel = false,
        selected = selected,
        onClick = onClick,
    )
}

@Preview
@Composable
private fun RowScope.SelectedColorBottomNavigationItem(
    pair: Pair<String, ImageVector> = Pair(Person, Icons.Filled.Person),
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    BottomNavigationItem(
        icon = { Icon(imageVector = pair.second, contentDescription = "") },
        selectedContentColor = Color.Red,
        selected = selected,
        onClick = onClick,
    )
}

@Preview
@Composable
private fun RowScope.UnselectedColorBottomNavigationItem(
    pair: Pair<String, ImageVector> = Pair(Person, Icons.Filled.Person),
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    BottomNavigationItem(
        icon = { Icon(imageVector = pair.second, contentDescription = "") },
        unselectedContentColor = Color.LightGray,
        selected = selected,
        onClick = onClick,
    )
}
