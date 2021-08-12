package com.steleot.jetpackcompose.playground.compose.foundationlayout

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationLayoutNavRoutes

private const val Url = "foundationlayout/PaddingFromBaselineScreen.kt"

@Composable
fun PaddingFromBaselineScreen() {
    DefaultScaffold(
        title = FoundationLayoutNavRoutes.PaddingFromBaseline,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PaddingFromBaselineExample()
        }
    }
}

@Composable
private fun PaddingFromBaselineExample() {
    val distanceToFirstBaseline = 30.dp
    val distanceFromLastBaseline = 40.dp

    Box(modifier = Modifier.border(1.dp, MaterialTheme.colors.error)) {
        Text(
            text = "This line has the first baseline.\nThis line has the last baseline.",
            modifier = Modifier.paddingFromBaseline(distanceToFirstBaseline, distanceFromLastBaseline)
        )
    }
}