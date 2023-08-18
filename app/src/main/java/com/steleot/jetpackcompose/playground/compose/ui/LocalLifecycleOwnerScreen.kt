package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "ui/LocalLifecycleOwnerScreen.kt"

@Composable
fun LocalLifecycleOwnerScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalLifecycleOwner,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LocalLifecycleOwnerExample()
        }
    }
}

@Composable
private fun LocalLifecycleOwnerExample() {
    val lifecycleOwner = LocalLifecycleOwner.current
    Text(
        text = stringResource(
            id = R.string.local_lifecycle_current_state,
            lifecycleOwner.lifecycle.currentState
        )
    )
}