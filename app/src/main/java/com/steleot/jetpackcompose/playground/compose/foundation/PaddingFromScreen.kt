package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundation/PaddingFromScreen.kt"

@Composable
fun PaddingFromScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.PaddingFrom,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PaddingFromExample()
        }
    }
}

@Composable
private fun PaddingFromExample() {
    val distanceToBaseline = 30.sp
    val distanceToBaselineDp = with(LocalDensity.current) { distanceToBaseline.toDp() }

    Box(modifier = Modifier.border(1.dp, MaterialTheme.colors.error)) {
        Text(
            text = "Jetpack Compose Playground",
            modifier = Modifier.paddingFrom(FirstBaseline, before = distanceToBaselineDp)
        )
    }
}