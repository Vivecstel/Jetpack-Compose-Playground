package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/ScrollableTabRowScreen.kt"

@Composable
fun ScrollableTabRowScreen() {
    val context = LocalContext.current
    val tabs = listOf(
        context.getString(R.string.one),
        context.getString(R.string.two),
        context.getString(R.string.three),
        context.getString(R.string.four),
        context.getString(R.string.five),
        context.getString(R.string.six),
        context.getString(R.string.seven),
        context.getString(R.string.eight),
    )
    DefaultScaffold(
        title = MaterialNavRoutes.ScrollableTabRow,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ScrollableTabRowExample(tabs)
            EdgePaddingTabRowExample(tabs)
            BackgroundColorScrollableTabRow(tabs)
            ContentColorScrollableTabRow(tabs)
            DividerScrollableTabRow(tabs)
            IndicatorScrollableTabRow(tabs)
        }
    }
}

@Composable
private fun ScrollableTabRowExample(
    tabs: List<String>
) {
    val selectedTab = remember { mutableIntStateOf(0) }
    ScrollableTabRow(
        selectedTabIndex = selectedTab.intValue
    ) {
        tabs.forEachIndexed { index, text ->
            Tab(
                selected = selectedTab.intValue == index,
                onClick = {
                    selectedTab.intValue = index
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
private fun EdgePaddingTabRowExample(tabs: List<String>) {
    val selectedTab = remember { mutableIntStateOf(0) }
    ScrollableTabRow(
        selectedTabIndex = selectedTab.intValue,
        edgePadding = 0.dp
    ) {
        tabs.forEachIndexed { index, text ->
            Tab(
                selected = selectedTab.intValue == index,
                onClick = {
                    selectedTab.intValue = index
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
private fun BackgroundColorScrollableTabRow(tabs: List<String>) {
    val selectedTab = remember { mutableIntStateOf(0) }
    ScrollableTabRow(
        selectedTabIndex = selectedTab.intValue,
        backgroundColor = Color.Yellow
    ) {
        tabs.forEachIndexed { index, text ->
            Tab(
                selected = selectedTab.intValue == index,
                onClick = {
                    selectedTab.intValue = index
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
private fun ContentColorScrollableTabRow(tabs: List<String>) {
    val selectedTab = remember { mutableIntStateOf(0) }
    ScrollableTabRow(
        selectedTabIndex = selectedTab.intValue,
        backgroundColor = Color.Red
    ) {
        tabs.forEachIndexed { index, text ->
            Tab(
                selected = selectedTab.intValue == index,
                onClick = {
                    selectedTab.intValue = index
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
private fun DividerScrollableTabRow(tabs: List<String>) {
    val selectedTab = remember { mutableIntStateOf(0) }
    ScrollableTabRow(
        selectedTabIndex = selectedTab.intValue,
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
                selected = selectedTab.intValue == index,
                onClick = {
                    selectedTab.intValue = index
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
private fun IndicatorScrollableTabRow(tabs: List<String>) {
    val selectedTab = remember { mutableIntStateOf(0) }
    ScrollableTabRow(
        selectedTabIndex = selectedTab.intValue,
        indicator = { tabPositions: List<TabPosition> ->
            val modifier = Modifier.tabIndicatorOffset(
                tabPositions[selectedTab.intValue]
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
                selected = selectedTab.intValue == index,
                onClick = {
                    selectedTab.intValue = index
                }) {
                Text(
                    text = text,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}