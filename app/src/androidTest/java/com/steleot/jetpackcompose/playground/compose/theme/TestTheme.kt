@file:Suppress("TestFunctionName")

package com.steleot.jetpackcompose.playground.compose.theme

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.providers.TestProviders
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
        TestProviders(themeState, content)
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
        TestProviders(themeState, content)
    }
}