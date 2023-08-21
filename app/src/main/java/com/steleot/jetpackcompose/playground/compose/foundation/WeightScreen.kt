package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/WeightScreen.kt"

@Composable
fun WeightScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Weight,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.primary)
            )

            Row(modifier = Modifier.weight(2f)) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(MaterialTheme.colors.secondary)
                )

                Box(
                    modifier = Modifier
                        .weight(3f)
                        .fillMaxHeight()
                        .background(MaterialTheme.colors.secondaryVariant)
                )
            }
        }
    }
}