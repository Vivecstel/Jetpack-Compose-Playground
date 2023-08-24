package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/ClickableScreen.kt"

@Composable
fun ClickableScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Clickable,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ClickableTextExample()
        }
    }
}

@Preview
@Composable
private fun ClickableTextExample() {
    val clickableText = stringResource(id = R.string.clickable_text)
    Text(
        text = clickableText,
        modifier = Modifier
            .clickable(onClick = {}, onClickLabel = clickableText)
            .padding(32.dp)

    )
}
