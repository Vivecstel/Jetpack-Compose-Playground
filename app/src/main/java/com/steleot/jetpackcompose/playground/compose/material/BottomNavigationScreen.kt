package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun BottomNavigationScreen() {
    val selectedNavigationView = remember { mutableStateOf(0) }
    val selectedNavigationItem = remember { mutableStateOf(0) }
    DefaultScaffold(
        title = MaterialNavRoutes.BottomNavigation.capitalize(Locale.getDefault())
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
            Spacer(modifier = Modifier.preferredHeight(32.dp))
            Button(
                onClick = {
                    selectedNavigationItem.value =
                        if (selectedNavigationItem.value == 4) 0 else selectedNavigationItem.value + 1
                }
            ) {
                Text(text = "Switch to bottom navigation item")
            }
            Spacer(modifier = Modifier.preferredHeight(32.dp))
            HelperView(selectedNavigationView.value, selectedNavigationItem.value)
        }
    }
}

@Preview
@Composable
fun HelperView(
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

@Preview
@Composable
fun RowScope.HelperNavigationItems(
    selectedItem: MutableState<Int> = mutableStateOf(0),
    selectedNavigationItem: Int = 0,
    items: List<Pair<String, ImageVector>> = listOf(
        Pair("Person", Icons.Filled.Person),
        Pair("Table Chart", Icons.Filled.TableChart),
        Pair("Settings", Icons.Filled.Settings)
    ),
) {
    items.forEachIndexed { index, item ->
        val selected = selectedItem.value == index
        val onClick = { selectedItem.value = index }
        when (selectedNavigationItem) {
            0 -> DefaultBottomNavigationItem(item, selected, onClick,)
            1 -> LabelBottomNavigationItem(item, selected, onClick,)
            2 -> AlwaysShowLabelBottomNavigationItem(item, selected, onClick,)
            3 -> SelectedColorBottomNavigationItem(item, selected, onClick,)
            4 -> UnselectedColorBottomNavigationItem(item, selected, onClick,)
        }
    }
}

@Preview
@Composable
fun StandardBottomNavigation(
    content: @Composable RowScope.() -> Unit = {}
) {
    BottomNavigation {
        content()
    }
}

@Preview
@Composable
fun BackgroundColorBottomNavigation(
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
fun ElevationBottomNavigation(
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
fun RowScope.DefaultBottomNavigationItem(
    pair: Pair<String, ImageVector> = Pair("Person", Icons.Filled.Person),
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
fun RowScope.LabelBottomNavigationItem(
    pair: Pair<String, ImageVector> = Pair("Person", Icons.Filled.Person),
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
fun RowScope.AlwaysShowLabelBottomNavigationItem(
    pair: Pair<String, ImageVector> = Pair("Person", Icons.Filled.Person),
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    BottomNavigationItem(
        icon = { Icon(imageVector = pair.second, contentDescription = "") },
        label = { Text(text = pair.first) },
        alwaysShowLabels = false,
        selected = selected,
        onClick = onClick,
    )
}

@Preview
@Composable
fun RowScope.SelectedColorBottomNavigationItem(
    pair: Pair<String, ImageVector> = Pair("Person", Icons.Filled.Person),
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
fun RowScope.UnselectedColorBottomNavigationItem(
    pair: Pair<String, ImageVector> = Pair("Person", Icons.Filled.Person),
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
