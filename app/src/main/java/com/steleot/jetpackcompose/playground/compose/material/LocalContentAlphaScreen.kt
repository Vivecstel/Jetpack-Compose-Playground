package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes

private const val Url = "material/LocalContentAlphaScreen.kt"

@Composable
fun LocalContentAlphaScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.LocalContentAlpha,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "No content alpha applied - uses the default content alpha set by MaterialTheme - " +
                        "87% alpha"
            )
            CompositionLocalProvider(LocalContentAlpha provides 1.00f) {
                Text("1.00f alpha applied - 100% alpha")
            }
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                Text("High content alpha applied - 87% alpha")
            }
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("Medium content alpha applied - 60% alpha")
            }
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
                Text("Disabled content alpha applied - 38% alpha")
            }
        }
    }
}