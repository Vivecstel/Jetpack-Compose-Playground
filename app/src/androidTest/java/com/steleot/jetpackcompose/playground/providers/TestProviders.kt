package com.steleot.jetpackcompose.playground.providers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import com.steleot.jetpackcompose.playground.helpers.EmptyFavoriteHelperImpl
import com.steleot.jetpackcompose.playground.helpers.EmptyInAppReviewHelper
import com.steleot.jetpackcompose.playground.localproviders.LocalFavoriteHelper
import com.steleot.jetpackcompose.playground.localproviders.LocalInAppReviewer
import com.steleot.jetpackcompose.playground.localproviders.LocalIsDarkTheme
import com.steleot.jetpackcompose.playground.localproviders.LocalNavController
import com.steleot.jetpackcompose.playground.localproviders.LocalThemeState
import com.steleot.jetpackcompose.playground.localproviders.LocalUser
import com.steleot.jetpackcompose.playground.theme.ThemeState

@Composable
fun TestProviders(
    themeState: ThemeState,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalInAppReviewer provides EmptyInAppReviewHelper(),
        LocalFavoriteHelper provides EmptyFavoriteHelperImpl(),
        LocalNavController provides TestNavHostController(ApplicationProvider.getApplicationContext()),
        LocalIsDarkTheme provides false,
        LocalUser provides null,
        LocalThemeState provides themeState,
        content = content
    )
}