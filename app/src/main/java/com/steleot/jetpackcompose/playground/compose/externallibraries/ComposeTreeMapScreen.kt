package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import by.overpass.treemapchart.android.TreemapChart
import by.overpass.treemapchart.core.measure.squarified.SquarifiedMeasurer
import by.overpass.treemapchart.core.tree.tree
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "externallibraries/ComposeTreeMapScreen.kt"

@Composable
fun ComposeTreeMapScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeTreeMap,
        link = URL,
    ) {
        ComposeShimmerExample(paddingValues = it)
    }
}

private val simpleTreeData = tree(10) {
    node(6) {
        node(4)
        node(2) {
            node(1)
            node(1)
        }
    }
    node(3) {
        node(2)
        node(1)
    }
    node(1)
}

@Composable
private fun ComposeShimmerExample(paddingValues: PaddingValues) {
    TreemapChart(
        data = simpleTreeData,
        evaluateItem = { it.toDouble() },
        treemapChartMeasurer = remember { SquarifiedMeasurer() },
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues),
    ) { item ->
        TreemapItem(item = item)
    }
}

@Composable
private fun TreemapItem(item: Int, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.border(1.dp, MaterialTheme.colors.onBackground),
    ) {
        Text(
            text = item.toString(),
            textAlign = TextAlign.Center,
        )
    }
}