package com.steleot.jetpackcompose.playground.compose.foundationlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.FoundationLayoutNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun AspectRationScreen() {
    DefaultScaffold(
        title = FoundationLayoutNavRoutes.AspectRatio.capitalize(Locale.getDefault())
    ) {
        Column {
            Box(modifier = Modifier.height(50.dp).aspectRatio(0.25f).background(Color.Green))
            Box(modifier = Modifier.height(100.dp).aspectRatio(0.55f).background(Color.Magenta))
            Box(modifier = Modifier.height(200.dp).aspectRatio(0.75f).background(Color.Red))
        }
    }
}
