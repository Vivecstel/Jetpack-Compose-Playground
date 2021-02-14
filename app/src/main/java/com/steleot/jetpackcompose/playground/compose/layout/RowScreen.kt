package com.steleot.jetpackcompose.playground.compose.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.FoundationLayoutNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun RowScreen() {
    DefaultScaffold(
        title = FoundationLayoutNavRoutes.Row.capitalize(Locale.getDefault())
    ) {
        DefaultRow()
    }
}

@Composable
fun DefaultRow() {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "One",
            modifier = Modifier.padding(16.dp).background(Color.Blue)
        )
        Text(
            text = "Two",
            modifier = Modifier.background(Color.Red).padding(16.dp)
        )
        Text(
            text = "Three",
            modifier = Modifier.padding(16.dp).fillMaxHeight().background(Color.Green)
        )
        Text(
            text = "Four",
            modifier = Modifier.background(Color.Yellow).fillMaxHeight(0.6f).padding(16.dp)
        )
    }
}
