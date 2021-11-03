package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundation/SpacerScreen.kt"

@Composable
fun SpacerScreen() {
    val msgSplit = stringResource(id = R.string.spacer_msg).split(' ')
    val toIndex = if (msgSplit.size % 2 == 0) msgSplit.size / 2 else (msgSplit.size + 1) / 2
    val columnList = msgSplit.subList(0, toIndex)
    val rowList =msgSplit.subList(toIndex, msgSplit.size)

    DefaultScaffold(
        title = FoundationNavRoutes.Spacer,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {
            columnList.forEachIndexed { index, text ->
                Text(text = text)
                if (index < columnList.size) {
                    Spacer(modifier = Modifier.requiredHeight(16.dp))
                }
                Spacer(modifier = Modifier.requiredHeight(16.dp))
            }
            Row {
                rowList.forEachIndexed { index, text ->
                    Text(text = text)
                    if (index < rowList.size) {
                        Spacer(modifier = Modifier.requiredWidth(16.dp))
                    }
                }
            }
        }
    }
}