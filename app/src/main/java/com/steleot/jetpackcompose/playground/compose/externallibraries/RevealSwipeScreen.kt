package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Card
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ExperimentalMaterialApi
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import de.charlex.compose.RevealDirection
import de.charlex.compose.RevealSwipe

private const val URL = "externallibraries/RevealSwipeScreen.kt"

private val pairs = listOf(
    Pair("item1", Color.Blue),
    Pair("item2", Color.Red),
    Pair("item3", Color.Green),
    Pair("item4", Color.Blue),
    Pair("item5", Color.Yellow),
    Pair("item6", Color.Magenta),
)

@Composable
fun RevealSwipeScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.RevealSwipe,
        link = URL,
    ) {
        LazyColumn(
            contentPadding = it
        ) {
            items(pairs) { pair ->
                RevealSwipeExample(pair)
            }
        }
    }
}

@Suppress("DEPRECATION")
@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun RevealSwipeExample(
    pair: Pair<String, Color>
) {
    RevealSwipe(
        modifier = Modifier.padding(vertical = 5.dp),
        directions = setOf(
            RevealDirection.StartToEnd,
            RevealDirection.EndToStart
        ),
        hiddenContentStart = {
            Icon(
                modifier = Modifier.padding(horizontal = 25.dp),
                imageVector = Icons.Outlined.Star,
                contentDescription = stringResource(id = R.string.star),
                tint = Color.White
            )
        },
        hiddenContentEnd = {
            Icon(
                modifier = Modifier.padding(horizontal = 25.dp),
                imageVector = Icons.Outlined.Delete,
                contentDescription = stringResource(id = R.string.delete)
            )
        }
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .requiredHeight(80.dp),
            backgroundColor = pair.second,
            shape = it,
        ) {
            Text(
                modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                text = pair.first
            )
        }
    }
}