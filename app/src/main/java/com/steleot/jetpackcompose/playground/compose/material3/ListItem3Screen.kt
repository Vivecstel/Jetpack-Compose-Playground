package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.PedalBike
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "material3/ListItem3Screen.kt"

@Composable
fun ListItem3Screen() {
    DefaultScaffold(
        title = Material3NavRoutes.ListItem3,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultListItem()
            LeadingContentListItem()
            SupportingTextListItem()
            OverlineTextListItem()
            TrailingContentListItem()
            FullListItem()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun DefaultListItem() {
    ListItem(headlineText = { DefaultText() })
}

@Composable
private fun DefaultText() {
    Text(text = stringResource(id = R.string.app_name))
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun LeadingContentListItem() {
    ListItem(
        headlineText = { DefaultText() },
        leadingContent = {
            Icon(
                Icons.Filled.Palette,
                modifier = Modifier.size(36.dp),
                contentDescription = null,
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun SupportingTextListItem() {
    ListItem(
        headlineText = { DefaultText() },
        supportingText = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun OverlineTextListItem() {
    ListItem(
        headlineText = { DefaultText() },
        overlineText = { DefaultText() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun TrailingContentListItem() {
    ListItem(
        headlineText = { DefaultText() },
        trailingContent = {
            Icon(
                Icons.Filled.Palette,
                modifier = Modifier.size(36.dp),
                contentDescription = null,
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun FullListItem() {
    ListItem(
        headlineText = { DefaultText() },
        modifier = Modifier
            .padding(16.dp)
            .background(Color.Gray, RoundedCornerShape(8.dp))
            .padding(8.dp),
        leadingContent = {
            Icon(
                Icons.Filled.Palette,
                modifier = Modifier.size(36.dp),
                contentDescription = null,
            )
        },
        supportingText = { DefaultText() },
        overlineText = { DefaultText() },
        trailingContent = {
            Icon(
                Icons.Filled.PedalBike,
                modifier = Modifier.size(36.dp),
                contentDescription = null,
            )
        }
    )
}