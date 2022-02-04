package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundation/PaddingFromBaselineScreen.kt"

@Composable
fun PaddingFromBaselineScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.PaddingFromBaseline,
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
            text = stringResource(id = R.string.first_last_baseline),
            modifier = Modifier.paddingFromBaseline(
                distanceToFirstBaseline,
                distanceFromLastBaseline
            )
        )
    }
}