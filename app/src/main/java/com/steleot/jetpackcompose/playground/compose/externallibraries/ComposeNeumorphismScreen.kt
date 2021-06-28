package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

/*import me.nikhilchaudhari.library.neumorphic
import me.nikhilchaudhari.library.shapes.Punched*/

private const val Url = "external/ComposeNeumorphismScreen.kt"

@Composable
fun ComposeNeumorphismScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeNeumorphism,
        link = Url,
    ) {
//        NeumorphicExample()
    }
}

/*
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
}*/
