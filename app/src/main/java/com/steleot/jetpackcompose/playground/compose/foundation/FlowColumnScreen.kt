package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/FlowColumnScreen.kt"

@Composable
fun FlowColumnScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.FlowColumn,
        link = URL,
    ) {
        FlowColumnExample()
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun FlowColumnExample() {
    FlowColumn(
        Modifier
            .fillMaxSize()
            .border(
                border = BorderStroke(
                    width = 2.dp,
                    color = MaterialTheme.colors.secondary
                )
            ),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.Center,
        maxItemsInEachColumn = 10
    ) {
        repeat(25) { index ->
            Box(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp)
                    .size(50.dp)
                    .background(color = MaterialTheme.colors.primary)
            ) {
                Text(
                    text = index.toString(),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(4.dp).align(Alignment.Center)
                )
            }
        }
    }
}