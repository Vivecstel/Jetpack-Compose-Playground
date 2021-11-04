package com.steleot.jetpackcompose.playground.compose.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.steleot.jetpackcompose.playground.LocalInAppReviewer
import com.steleot.jetpackcompose.playground.helpers.EmptyInAppReviewHelper
import com.steleot.jetpackcompose.playground.theme.JetpackComposePlaygroundTheme
import com.steleot.jetpackcompose.playground.theme.ThemeState

@Composable
fun TestTheme(
    themeState: ThemeState = ThemeState(),
    content: @Composable () -> Unit
) {
    JetpackComposePlaygroundTheme(
        themeState
    ) {
        CompositionLocalProvider(LocalInAppReviewer provides EmptyInAppReviewHelper()) {
            content()
        }
    }
}