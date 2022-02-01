package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes

private const val Url = "material/TabRowScreen.kt"

@Composable
fun TabRowScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.TabRow,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val tabs = listOf(
                stringResource(id = R.string.one),
                stringResource(id = R.string.two),
                stringResource(id = R.string.three),
            )
            DefaultTabRow(tabs)
            BackgroundColorTabRow(tabs)
            ContentColorTabRow(tabs)
            DividerTabRow(tabs)
            IndicatorTabRow(tabs)
        }
    }
}

@Composable
private fun DefaultTabRow(tabs: List<String>) {
    val selectedTab = remember { mutableStateOf(0) }
    TabRow(
        selectedTabIndex = selectedTab.value
    ) {
        tabs.forEachIndexed { index, text ->
            Tab(
                selected = selectedTab.value == index,
                onClick = {
                    selectedTab.value = index
                }) {
                Text(
                    text = text,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
private fun BackgroundColorTabRow(tabs: List<String>) {
    val selectedTab = remember { mutableStateOf(0) }
    TabRow(
        selectedTabIndex = selectedTab.value,
        backgroundColor = Color.Yellow
    ) {
        tabs.forEachIndexed { index, text ->
            Tab(
                selected = selectedTab.value == index,
                onClick = {
                    selectedTab.value = index
                }) {
                Text(
                    text = text,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
private fun ContentColorTabRow(tabs: List<String>) {
    val selectedTab = remember { mutableStateOf(0) }
    TabRow(
        selectedTabIndex = selectedTab.value,
        backgroundColor = Color.Red
    ) {
        tabs.forEachIndexed { index, text ->
            Tab(
                selected = selectedTab.value == index,
                onClick = {
                    selectedTab.value = index
                }) {
                Text(
                    text = text,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
private fun DividerTabRow(tabs: List<String>) {
    val selectedTab = remember { mutableStateOf(0) }
    TabRow(
        selectedTabIndex = selectedTab.value,
        divider = {
            Divider(
                modifier = Modifier
                    .requiredHeight(8.dp)
                    .fillMaxWidth()
                    .background(color = Color.Red)
            )
        }
    ) {
        tabs.forEachIndexed { index, text ->
            Tab(
                selected = selectedTab.value == index,
                onClick = {
                    selectedTab.value = index
                }
            ) {
                Text(
                    text = text,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
private fun IndicatorTabRow(tabs: List<String>) {
    val selectedTab = remember { mutableStateOf(0) }
    TabRow(
        selectedTabIndex = selectedTab.value,
        indicator = { tabPositions: List<TabPosition> ->
            val modifier = Modifier.tabIndicatorOffset(
                tabPositions[selectedTab.value]
            )
            Box(
                modifier
                    .fillMaxWidth()
                    .height(5.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    ),
            )
        }
    ) {
        tabs.forEachIndexed { index, text ->
            Tab(
                selected = selectedTab.value == index,
                onClick = {
                    selectedTab.value = index
                }) {
                Text(
                    text = text,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
