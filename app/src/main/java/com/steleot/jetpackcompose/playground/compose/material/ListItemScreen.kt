package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun ListItemScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.ListItem.capitalize(Locale.getDefault())
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
        Text(text = "Jetpack Compose Playground")
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun IconListItem() {
    ListItem(
        icon = {
            Icon(
                Icons.Default.Palette,
                modifier = Modifier.size(36.dp),
                contentDescription = "List Item Icon",
            )
        }
    ) {
        Text(text = "Jetpack Compose Playground")
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun SecondaryTextListItem() {
    ListItem(
        secondaryText = {
            Text(text = "Jetpack Compose Playground Secondary text")
        }
    ) {
        Text(text = "Jetpack Compose Playground")
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun OverlineTextListItem() {
    ListItem(
        overlineText = {
            Text(text = "Jetpack Compose Playground Overline text")
        }
    ) {
        Text(text = "Jetpack Compose Playground")
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun TrailingListItem() {
    ListItem(
        trailing = {
            Icon(
                Icons.Default.Palette,
                modifier = Modifier.size(36.dp),
                contentDescription = "List Item Trailing",
            )
        }
    ) {
        Text(text = "Jetpack Compose Playground")
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
                Icons.Default.Palette,
                modifier = Modifier.size(36.dp),
                contentDescription = "List Item Icon",
            )
        },
        secondaryText = {
            Text(text = "Jetpack Compose Playground Secondary text")
        },
        overlineText = {
            Text(text = "Jetpack Compose Playground Overline text")
        },
        trailing = {
            Icon(
                Icons.Default.PedalBike,
                modifier = Modifier.size(36.dp),
                contentDescription = "List Item Trailing",
            )
        }
    ) {
        Text(text = "Jetpack Compose Playground")
    }
}