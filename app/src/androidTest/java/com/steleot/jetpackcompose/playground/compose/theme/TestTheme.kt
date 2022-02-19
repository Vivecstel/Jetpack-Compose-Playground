@file:Suppress("TestFunctionName")

package com.steleot.jetpackcompose.playground.compose.theme

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.providers.TestProviders
import com.steleot.jetpackcompose.playground.theme.ThemeState
import com.steleot.jetpackcompose.playground.theme.material.JetpackComposePlaygroundTheme as Theme
import com.steleot.jetpackcompose.playground.theme.material3.JetpackComposePlaygroundTheme as Theme3

@Composable
fun TestTheme(
    themeState: ThemeState = ThemeState(),
    content: @Composable () -> Unit
) {
    Theme(
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
    Theme3(
        themeState
    ) {
        TestProviders(themeState, content)
    }
}