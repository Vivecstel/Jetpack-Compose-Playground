package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.PedalBike
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "material/ListItemScreen.kt"

@Composable
fun ListItemScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.ListItem,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultListItem()
            IconListItem()
            SecondaryTextListItem()
            OverlineTextListItem()
            TrailingListItem()
            FullListItem()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun DefaultListItem() {
    ListItem {
        DefaultText()
    }
}

@Composable
private fun DefaultText() {
    Text(text = stringResource(id = R.string.app_name))
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun IconListItem() {
    ListItem(
        icon = {
            Icon(
                Icons.Filled.Palette,
                modifier = Modifier.size(36.dp),
                contentDescription = null,
            )
        }
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun SecondaryTextListItem() {
    ListItem(
        secondaryText = {
            DefaultText()
        }
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun OverlineTextListItem() {
    ListItem(
        overlineText = {
            DefaultText()
        }
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun TrailingListItem() {
    ListItem(
        trailing = {
            Icon(
                Icons.Filled.Palette,
                modifier = Modifier.size(36.dp),
                contentDescription = null,
            )
        }
    ) {
        DefaultText()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun FullListItem() {
    ListItem(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.Gray, RoundedCornerShape(8.dp))
            .padding(8.dp),
        icon = {
            Icon(
                Icons.Filled.Palette,
                modifier = Modifier.size(36.dp),
                contentDescription = null,
            )
        },
        secondaryText = {
            DefaultText()
        },
        overlineText = {
            DefaultText()
        },
        trailing = {
            Icon(
                Icons.Filled.PedalBike,
                modifier = Modifier.size(36.dp),
                contentDescription = null,
            )
        }
    ) {
        DefaultText()
    }
}