package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

private const val Url = "ui/LocalSavedStateRegistryOwnerScreen.kt"

@Composable
fun LocalSavedStateRegistryOwnerScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalSavedStateRegistryOwner,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LocalSavedStateRegistryOwnerExample()
        }
    }
}

@Composable
private fun LocalSavedStateRegistryOwnerExample() {
    val savedStateRegistryOwner = LocalSavedStateRegistryOwner.current
    Text(
        text = stringResource(
            id = R.string.local_saved_state_registry_msg,
            savedStateRegistryOwner.savedStateRegistry.isRestored
        )
    )
}