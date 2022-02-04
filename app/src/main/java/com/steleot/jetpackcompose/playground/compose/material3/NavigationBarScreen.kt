package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.TableChart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold3
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes

private const val Url = "material3/NavigationBarScreen.kt"

@Composable
fun NavigationBarScreen() {
    val selectedNavigationBar = remember { mutableStateOf(0) }
    val selectedNavigationBarItem = remember { mutableStateOf(0) }
    DefaultScaffold3(
        title = Material3NavRoutes.NavigationBar,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        selectedNavigationBar.value =
                            if (selectedNavigationBar.value == 2) 0 else selectedNavigationBar.value + 1
                    }
                ) {
                    Text(
                        text = stringResource(
                            id = R.string.switch_args,
                            stringResource(id = R.string.bottom_navigation)
                        )
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = {
                        selectedNavigationBarItem.value =
                            if (selectedNavigationBarItem.value == 4) 0 else selectedNavigationBarItem.value + 1
                    }
                ) {
                    Text(
                        text = stringResource(
                            id = R.string.switch_args,
                            stringResource(id = R.string.bottom_navigation_item)
                        )
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                HelperView(
                    selectedNavigationBar.value,
                    selectedNavigationBarItem.value
                )
            }
        }
    }
}

@Composable
private fun HelperView(
    selectedNavigationBar: Int = 0,
    selectedNavigationBarItem: Int = 0,
) {
    val selectedItem = remember { mutableStateOf(0) }
    Column {
        when (selectedNavigationBar) {
            0 -> StandardNavigationBar {
                HelperNavigationBarItems(selectedItem, selectedNavigationBarItem)
            }
            1 -> ContainerColorNavigationBar {
                HelperNavigationBarItems(selectedItem, selectedNavigationBarItem)
            }
            2 -> TonalElevationNavigationBar {
                HelperNavigationBarItems(selectedItem, selectedNavigationBarItem)
            }
        }
    }
}

@Composable
private fun RowScope.HelperNavigationBarItems(
    selectedItem: MutableState<Int> = mutableStateOf(0),
    selectedNavigationItem: Int = 0,
    items: List<Pair<String, ImageVector>> = listOf(
        Pair(stringResource(id = R.string.person), Icons.Filled.Person),
        Pair(stringResource(id = R.string.table_chart), Icons.Filled.TableChart),
        Pair(stringResource(id = R.string.settings), Icons.Filled.Settings)
    ),
) {
    items.forEachIndexed { index, item ->
        val selected = selectedItem.value == index
        val onClick = { selectedItem.value = index }
        when (selectedNavigationItem) {
            0 -> DefaultNavigationBarItem(item, selected, onClick)
            1 -> LabelNavigationBarItem(item, selected, onClick)
            2 -> AlwaysShowLabelNavigationBarItem(item, selected, onClick)
            3 -> SelectedIconColorNavigationBarItem(item, selected, onClick)
            4 -> UnselectedIconColorNavigationBarItem(item, selected, onClick)
        }
    }
}

@Composable
private fun StandardNavigationBar(
    content: @Composable RowScope.() -> Unit = {}
) {
    NavigationBar {
        content()
    }
}

@Composable
private fun ContainerColorNavigationBar(
    content: @Composable RowScope.() -> Unit = {}
) {
    NavigationBar(
        containerColor = Color.Magenta
    ) {
        content()
    }
}

@Preview
@Composable
private fun TonalElevationNavigationBar(
    content: @Composable RowScope.() -> Unit = {}
) {
    NavigationBar(
        tonalElevation = 12.dp
    ) {
        content()
    }
}

@Composable
private fun RowScope.DefaultNavigationBarItem(
    pair: Pair<String, ImageVector>,
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    NavigationBarItem(
        icon = { Icon(imageVector = pair.second, contentDescription = null) },
        selected = selected,
        onClick = onClick,
    )
}

@Composable
private fun RowScope.LabelNavigationBarItem(
    pair: Pair<String, ImageVector>,
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    NavigationBarItem(
        icon = { Icon(imageVector = pair.second, contentDescription = null) },
        label = { Text(text = pair.first) },
        selected = selected,
        onClick = onClick,
    )
}

@Composable
private fun RowScope.AlwaysShowLabelNavigationBarItem(
    pair: Pair<String, ImageVector>,
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    NavigationBarItem(
        icon = { Icon(imageVector = pair.second, contentDescription = null) },
        label = { Text(text = pair.first) },
        alwaysShowLabel = false,
        selected = selected,
        onClick = onClick,
    )
}

@Composable
private fun RowScope.SelectedIconColorNavigationBarItem(
    pair: Pair<String, ImageVector>,
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    NavigationBarItem(
        icon = { Icon(imageVector = pair.second, contentDescription = null) },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Red
        ),
        selected = selected,
        onClick = onClick,
    )
}

@Composable
private fun RowScope.UnselectedIconColorNavigationBarItem(
    pair: Pair<String, ImageVector>,
    selected: Boolean = false,
    onClick: () -> Unit = {},
) {
    NavigationBarItem(
        icon = { Icon(imageVector = pair.second, contentDescription = null) },
        colors = NavigationBarItemDefaults.colors(
            unselectedIconColor = Color.LightGray
        ),
        selected = selected,
        onClick = onClick,
    )
}

