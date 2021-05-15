package com.steleot.jetpackcompose.playground.compose

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.systemBarsPadding
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultTopAppBar

@Composable
fun SettingsScreen() {
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            DefaultTopAppBar(
                title = MainNavRoutes.Settings,
                showBackArrow = true
            )
        }
    ) {

    }
}