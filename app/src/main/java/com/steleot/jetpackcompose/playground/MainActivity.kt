package com.steleot.jetpackcompose.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.android.gms.ads.MobileAds
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import com.steleot.jetpackcompose.playground.helpers.InAppReviewHelper
import com.steleot.jetpackcompose.playground.navigation.JetpackComposePlaygroundNavHost
import com.steleot.jetpackcompose.playground.theme.JetpackComposeTheme
import com.steleot.jetpackcompose.playground.theme.ThemeState
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var inAppReviewHelper: InAppReviewHelper

    @Inject
    lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        MobileAds.initialize(this)
        setContent {
            JetpackComposeApp(inAppReviewHelper, firebaseAnalytics)
        }
    }
}

@Composable
fun JetpackComposeApp(
    inAppReviewHelper: InAppReviewHelper,
    firebaseAnalytics: FirebaseAnalytics,
) {
    val isDarkTheme = isSystemInDarkTheme()
    val (theme, setTheme) = remember { mutableStateOf(ThemeState(isDarkTheme = isDarkTheme)) }
    JetpackComposeTheme(
        colorPallete = theme.pallete
    ) {
        ProvideWindowInsets {
            CompositionLocalProvider(LocalInAppReviewer provides inAppReviewHelper) {
                val navController = rememberNavController()
                navController.addOnDestinationChangedListener { _, destination, _ ->
                    destination.route?.let { route ->
                        Timber.d("Route : $route")
                        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
                            param(FirebaseAnalytics.Param.SCREEN_NAME, route)
                        }
                    }
                }
                JetpackComposePlaygroundNavHost(navController, theme) { newTheme ->
                    setTheme(newTheme)
                }
            }
        }
    }
}

val LocalInAppReviewer = staticCompositionLocalOf<InAppReviewHelper> {
    error("CompositionLocal InAppReviewHelper not present")
}
