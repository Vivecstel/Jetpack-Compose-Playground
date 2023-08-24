package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.navigation.graph.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "ui/LocalAutofillTreeScreen.kt"

@Composable
fun LocalAutofillTreeScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalAutofillTree,
        link = URL,
    ) {
        // todo
    }
}