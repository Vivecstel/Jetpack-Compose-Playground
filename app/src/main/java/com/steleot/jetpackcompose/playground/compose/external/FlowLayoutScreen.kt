package com.steleot.jetpackcompose.playground.compose.external

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowColumn
import com.google.accompanist.flowlayout.FlowRow
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "external/FlowLayoutScreen.kt"

@Composable
fun FlowLayoutScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.FlowLayout.capitalize(Locale.getDefault()),
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