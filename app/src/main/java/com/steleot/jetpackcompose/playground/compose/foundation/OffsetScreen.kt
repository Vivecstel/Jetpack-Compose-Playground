package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "foundation/OffsetScreen.kt"

@Composable
fun OffsetScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Offset,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Offset()
            AbsoluteOffset()
            OffsetPx()
            AbsoluteOffsetPx()
        }
    }
}

@Preview
@Composable
private fun Offset() {
    Text(
        stringResource(id = R.string.layout_offset_modifier),
        Modifier
            .wrapContentSize(Alignment.Center)
            .offset(10.dp, 20.dp)
    )
}

@Preview
@Composable
private fun AbsoluteOffset() {
    Text(
        stringResource(id = R.string.layout_offset_modifier),
        Modifier
            .wrapContentSize(Alignment.Center)
            .absoluteOffset(10.dp, 20.dp)
    )
}

@Preview
@Composable
private fun OffsetPx() {
    var offset by remember { mutableIntStateOf(0) }
    Text(
        stringResource(id = R.string.layout_offset_modifier),
        Modifier
            .clickable { offset += 10 }
            .offset { IntOffset(offset, offset) }
    )
}

@Preview
@Composable
fun AbsoluteOffsetPx() {
    var offset by remember { mutableIntStateOf(0) }
    Text(
        stringResource(id = R.string.layout_offset_modifier),
        Modifier
            .clickable { offset += 10 }
            .absoluteOffset { IntOffset(offset, offset) }
    )
}
