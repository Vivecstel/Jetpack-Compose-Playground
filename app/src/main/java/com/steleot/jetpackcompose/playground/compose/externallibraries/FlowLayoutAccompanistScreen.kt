package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowColumn
import com.google.accompanist.flowlayout.FlowRow
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "externallibraries/FlowLayoutAccompanistScreen.kt"

@Composable
fun FlowLayoutAccompanistScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.FlowLayoutAccompanist,
        link = Url,
    ) {
        Row {
            FlowColumn {
                SampleContent()
            }
            Spacer(modifier = Modifier.width(15.dp))
            FlowRow {
                SampleContent()
            }
        }

    }
}

@Composable
private fun SampleContent() {
    repeat(15) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(Color.Blue)
                .border(2.dp, Color.DarkGray),
            contentAlignment = Alignment.Center,
        ) {
            Text(it.toString())
        }
    }
}