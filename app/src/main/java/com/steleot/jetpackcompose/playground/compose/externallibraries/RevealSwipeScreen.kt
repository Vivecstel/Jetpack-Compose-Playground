package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import de.charlex.compose.RevealDirection
import de.charlex.compose.RevealSwipe

private const val Url = "external/RevealSwipeScreen.kt"

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
        link = Url,
    ) {
        LazyColumn(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            items(pairs) { pair ->
                RevealSwipeExample(pair)
            }
        }
    }
}

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
                contentDescription = null,
                tint = Color.White
            )
        },
        hiddenContentEnd = {
            Icon(
                modifier = Modifier.padding(horizontal = 25.dp),
                imageVector = Icons.Outlined.Delete,
                contentDescription = null
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