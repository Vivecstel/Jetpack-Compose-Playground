package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import me.nikhilchaudhari.library.neumorphic
import me.nikhilchaudhari.library.shapes.Punched

private const val Url = "externallibraries/ComposeNeumorphismScreen.kt"

@Composable
fun ComposeNeumorphismScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeNeumorphism,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NeumorphicExample()
        }
    }
}

@Composable
private fun NeumorphicExample() {
    Button(
        onClick = { },
        modifier = Modifier
            .padding(12.dp)
            .neumorphic(
                neuShape = Punched.Rounded(radius = 8.dp)
            )
    ) {
        Text(text = stringResource(id = R.string.press_me))
    }
}
