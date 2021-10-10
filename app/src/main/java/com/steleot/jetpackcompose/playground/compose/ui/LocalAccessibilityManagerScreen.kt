package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

private const val Url = "ui/LocalAccessibilityManagerScreen.kt"

@Composable
fun LocalAccessibilityManagerScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalAccessibilityManager,
        link = Url,
    ) {

    }
}