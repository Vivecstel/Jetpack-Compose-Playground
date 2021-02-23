package com.steleot.jetpackcompose.playground.compose.foundationlayout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.FoundationLayoutNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun OffsetScreen() {
    DefaultScaffold(
        title = FoundationLayoutNavRoutes.Box.capitalize(Locale.getDefault())
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
        "Layout offset modifier",
        Modifier.wrapContentSize(Alignment.Center)
            .offset(10.dp, 20.dp)
    )
}

@Preview
@Composable
private fun AbsoluteOffset() {
    Text(
        "Layout offset modifier",
        Modifier.wrapContentSize(Alignment.Center)
            .absoluteOffset(10.dp, 20.dp)
    )
}

@Preview
@Composable
private fun OffsetPx() {
    var offset by remember { mutableStateOf(0) }
    Text(
        "Layout offset modifier",
        Modifier
            .clickable { offset += 10 }
            .offset { IntOffset(offset, offset) }
    )
}

@Preview
@Composable
fun AbsoluteOffsetPx() {
    var offset by remember { mutableStateOf(0) }
    Text(
        "Layout offset modifier",
        Modifier
            .clickable { offset += 10 }
            .absoluteOffset { IntOffset(offset, offset) }
    )
}
