package com.steleot.jetpackcompose.playground.compose.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.steleot.jetpackcompose.playground.LocalInAppReviewer
import com.steleot.jetpackcompose.playground.LocalIsDarkTheme
import com.steleot.jetpackcompose.playground.LocalThemeState
import com.steleot.jetpackcompose.playground.helpers.EmptyInAppReviewHelper
import com.steleot.jetpackcompose.playground.theme.JetpackComposePlaygroundTheme
import com.steleot.jetpackcompose.playground.theme.JetpackComposePlaygroundTheme3
import com.steleot.jetpackcompose.playground.theme.ThemeState

@Composable
fun TestTheme(
    themeState: ThemeState = ThemeState(),
    content: @Composable () -> Unit
) {
    JetpackComposePlaygroundTheme(
        themeState
    ) {
        CompositionLocalProvider(
            LocalInAppReviewer provides EmptyInAppReviewHelper(),
            LocalIsDarkTheme provides false,
        ) {
            content()
        }
    }
}

@Composable
fun TestTheme3(
    themeState: ThemeState = ThemeState(),
    content: @Composable () -> Unit
) {
    JetpackComposePlaygroundTheme3(
        themeState
    ) {
        CompositionLocalProvider(
            LocalThemeState provides themeState,
            LocalInAppReviewer provides EmptyInAppReviewHelper(),
            LocalIsDarkTheme provides false,
        ) {
            content()
        }
    }
}