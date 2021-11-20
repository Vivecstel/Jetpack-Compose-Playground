package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Badge
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes

private const val Url = "material/BadgeScreen.kt"

@Composable
fun BadgeScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.Badge,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Badge { Text("8", fontSize = 20.sp) }
            Badge(
                backgroundColor = Color.Magenta
            ) {
                Text("8", fontSize = 22.sp)
            }
            Badge(
                contentColor = Color.Red
            ) {
                Text("8", fontSize = 24.sp)
            }
        }
    }
}