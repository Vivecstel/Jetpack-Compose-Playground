package com.steleot.jetpackcompose.playground.localproviders

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.LocalOverScrollConfiguration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseUser
import com.steleot.jetpackcompose.playground.helpers.FavoriteHelper
import com.steleot.jetpackcompose.playground.helpers.InAppReviewHelper
import com.steleot.jetpackcompose.playground.theme.ThemeState
import com.steleot.jetpackcompose.playground.theme.isDarkTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LocalProviders(
    inAppReviewHelper: InAppReviewHelper,
    favoriteHelper: FavoriteHelper,
    themeState: ThemeState,
    user: FirebaseUser?,
    navController: NavHostController,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalInAppReviewer provides inAppReviewHelper,
        LocalFavoriteHelper provides favoriteHelper,
        LocalOverScrollConfiguration provides null,
        LocalThemeState provides themeState,
        LocalIsDarkTheme provides isDarkTheme(
            themeState.darkThemeMode,
            themeState.isSystemInDarkTheme
        ),
        LocalUser provides user,
        LocalNavController provides navController,
        content = content
    )
}

val LocalInAppReviewer = staticCompositionLocalOf<InAppReviewHelper> {
    error("CompositionLocal InAppReviewHelper not present")
}

val LocalFavoriteHelper = staticCompositionLocalOf<FavoriteHelper> {
    error("CompositionLocal LocalFavorite not present")
}

val LocalThemeState = staticCompositionLocalOf<ThemeState> {
    error("CompositionLocal LocalThemeState not present")
}

val LocalIsDarkTheme = staticCompositionLocalOf<Boolean> {
    error("CompositionLocal IsDarkTheme not present")
}

val LocalUser = staticCompositionLocalOf<FirebaseUser?> {
    error("CompositionLocal User not present")
}

val LocalNavController = staticCompositionLocalOf<NavHostController> {
    error("CompositionLocal NavController not present")
}