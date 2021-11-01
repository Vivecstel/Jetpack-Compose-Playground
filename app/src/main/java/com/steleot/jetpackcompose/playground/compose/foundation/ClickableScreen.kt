package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundation/ClickableScreen.kt"

@Composable
fun ClickableScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Clickable,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
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
