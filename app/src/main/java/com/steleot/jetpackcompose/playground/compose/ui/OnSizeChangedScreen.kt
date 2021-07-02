package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes
import timber.log.Timber

private const val Url = "ui/OnSizeChangedScreen.kt"

@Composable
fun OnSizeChangedScreen() {
    DefaultScaffold(
        title = UiNavRoutes.OnSizeChanged,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OnSizeChangedExample(name = "Jetpack Compose")
            OnSizeChangedExample(name = "Example")
        }
    }
}

@Composable
private fun OnSizeChangedExample(
    name: String
) {
    Text(
        "Hello $name",
        Modifier.onSizeChanged { size ->
            Timber.d("The size of the Text in pixels is $size")
        }
    )
}