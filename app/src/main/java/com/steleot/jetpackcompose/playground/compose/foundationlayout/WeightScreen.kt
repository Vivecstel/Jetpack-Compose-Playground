package com.steleot.jetpackcompose.playground.compose.foundationlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationLayoutNavRoutes

private const val Url = "foundationlayout/WeightScreen.kt"

@Composable
fun WeightScreen() {
    DefaultScaffold(
        title = FoundationLayoutNavRoutes.Weight,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
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