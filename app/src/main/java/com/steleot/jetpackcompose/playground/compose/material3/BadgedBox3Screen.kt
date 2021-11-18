package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold3
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes

private const val Url = "material3/BadgedBox3Screen.kt"

@Composable
fun BadgedBox3Screen() {
    DefaultScaffold3(
        title = Material3NavRoutes.BadgedBox3,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}