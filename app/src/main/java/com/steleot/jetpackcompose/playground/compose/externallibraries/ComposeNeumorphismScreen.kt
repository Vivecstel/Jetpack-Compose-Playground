package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import me.nikhilchaudhari.library.neumorphic
import me.nikhilchaudhari.library.shapes.Punched

private const val Url = "external/ComposeNeumorphismScreen.kt"

@Composable
fun ComposeNeumorphismScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeNeumorphism,
        link = Url,
    ) {
        NeumorphicExample()
    }
}

@Composable
private fun NeumorphicExample() {
    Card(
        backgroundColor = Color(236, 234, 235),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(16.dp)
            .size(300.dp, 100.dp)
            .neumorphic(
                LocalContext.current,
                neuShape = Punched.Rounded(radius = 8.dp),
            )
    ) {
        Text(text = "Press me")
    }
}