package com.steleot.jetpackcompose.playground

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.messaging.FirebaseMessaging
import com.steleot.jetpackcompose.playground.datastore.ProtoManager
import com.steleot.jetpackcompose.playground.helpers.FavoriteHelper
import com.steleot.jetpackcompose.playground.helpers.InAppReviewHelper
import com.steleot.jetpackcompose.playground.helpers.InAppUpdateHelper
import com.steleot.jetpackcompose.playground.localproviders.LocalProviders
import com.steleot.jetpackcompose.playground.navigation.*
import com.steleot.jetpackcompose.playground.navigation.graph.MainNavRoutes
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.theme.ThemeState
import com.steleot.jetpackcompose.playground.theme.material.JetpackComposePlaygroundTheme
import com.steleot.jetpackcompose.playground.theme.material.getMaterialColors
import com.steleot.jetpackcompose.playground.utils.installer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var firebaseAuth: FirebaseAuth

    @Inject
    lateinit var firebaseAnalytics: FirebaseAnalytics

    @Inject
    lateinit var firebaseCrashlytics: FirebaseCrashlytics

    @Inject
    lateinit var firebaseMessaging: FirebaseMessaging

    @Inject
    lateinit var firebaseInstallations: FirebaseInstallations

    @Inject
    lateinit var protoManager: ProtoManager

    @Inject
    lateinit var inAppReviewHelper: InAppReviewHelper

    @Inject
    lateinit var favoriteHelper: FavoriteHelper

    @Inject
    lateinit var inAppUpdateHelper: InAppUpdateHelper

    @Inject
    lateinit var googleSignInClient: GoogleSignInClient

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init(savedInstanceState)
        MobileAds.initialize(this)
        setContent {
            JetpackComposeApp(
                firebaseAuth,
                firebaseAnalytics,
                protoManager,
                inAppReviewHelper,
                favoriteHelper,
                googleSignInClient
            )
        }
    }

    @Suppress("DEPRECATION")
    private fun init(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        if (savedInstanceState == null) {
            firebaseCrashlytics.log("Locale: ${resources.configuration.locale}")
            lifecycleScope.launchWhenCreated {
                val id = try {
                    firebaseInstallations.id.await()
                } catch (e: Exception) {
                    Timber.e(e)
                    null
                }
                Timber.d("Id retrieved: $id")
                firebaseAnalytics.setUserId(id)
                firebaseAnalytics.setUserProperty("installer", installer)
            }
            lifecycleScope.launchWhenCreated {
                val token = try {
                    firebaseMessaging.token.await()
                } catch (e: Exception) {
                    Timber.e(e)
                    null
                }
                Timber.d("Token retrieved: $token")
            }
        }
    }

    @Deprecated("Deprecated in Java")
    @Suppress("DEPRECATION")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        inAppUpdateHelper.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }
}

@Composable
fun JetpackComposeApp(
    firebaseAuth: FirebaseAuth,
    firebaseAnalytics: FirebaseAnalytics,
    protoManager: ProtoManager,
    inAppReviewHelper: InAppReviewHelper,
    favoriteHelper: FavoriteHelper,
    googleSignInClient: GoogleSignInClient
) {
    val isSystemInDarkTheme = isSystemInDarkTheme()
    var isLoaded by rememberSaveable { mutableStateOf(false) }
    var themeState by rememberSaveable {
        mutableStateOf(ThemeState())
    }
    var user by remember { mutableStateOf(firebaseAuth.currentUser) }
    val systemUiController = rememberSystemUiController()

    SideEffect {
        if (isLoaded) {
            systemUiController.setSystemBarsColor(
                themeState.colorPalette.getMaterialColors(
                    themeState.darkThemeMode,
                    themeState.isSystemInDarkTheme
                ).primaryVariant
            )
        }
    }

    val screenWidth = with(LocalDensity.current) {
        LocalConfiguration.current.screenWidthDp.dp.roundToPx()
    }
    LaunchedEffect(Unit) {
        if (themeState.isSystemInDarkTheme != isSystemInDarkTheme) {
            themeState = themeState.copy(isSystemInDarkTheme = isSystemInDarkTheme)
        }
        if (!isLoaded) {
            protoManager.themeState.collect {
                themeState = themeState.copy(
                    colorPalette = it.colorPalette,
                    darkThemeMode = it.darkThemeMode
                )
                delay(250L)
                isLoaded = true
            }
        }
    }
    if (isLoaded) {
        JetpackComposePlaygroundTheme(
            themeState = themeState,
        ) {
            val navController = rememberNavController()
            DisposableEffect(Unit) {
                val listener =
                    NavController.OnDestinationChangedListener { _, destination, _ ->
                        destination.route?.let { route ->
                            Timber.d("Route : $route")
                            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
                                param(FirebaseAnalytics.Param.SCREEN_NAME, route)
                            }
                        }
                    }
                navController.addOnDestinationChangedListener(listener)
                onDispose {
                    navController.removeOnDestinationChangedListener(listener)
                }
            }
            LocalProviders(
                inAppReviewHelper, favoriteHelper, themeState, user, navController
            ) {
                NavHost(
                    navController = navController,
                    startDestination = MainNavRoutes.Main,
                    enterTransition = { getEnterTransition(screenWidth) },
                    exitTransition = { getExitTransition(-screenWidth) },
                    popEnterTransition = { getEnterTransition(-screenWidth, true) },
                    popExitTransition = { getExitTransition(screenWidth, true) }
                ) {
                    /* main */
                    addMainRoutes(
                        firebaseAuth,
                        googleSignInClient,
                        themeState,
                        setTheme = { newThemeState ->
                            themeState = newThemeState
                        }
                    ) { newUser ->
                        firebaseAnalytics.logEvent(
                            if (user != null) FirebaseAnalytics.Event.LOGIN else "logout",
                            Bundle().apply {
                                if (user != null) putString(
                                    FirebaseAnalytics.Param.METHOD,
                                    "google"
                                )
                            })
                        user = newUser
                    }
                    /* activity */
                    addActivityRoutes()
                    /* animation */
                    addAnimationRoutes()
                    /* constraint layout */
                    addConstraintLayoutRoutes()
                    /* foundation */
                    addFoundationRoutes()
                    /* material */
                    addMaterialRoutes()
                    /* material 3 */
                    addMaterial3Routes()
                    /* material icons */
                    addMaterialIconsRoutes()
                    /* material icons extended */
                    addMaterialIconsExtended()
                    /* runtime */
                    addRuntimeRoutes()
                    /* ui */
                    addUiRoutes()
                    /* view model */
                    addViewModelRoutes()
                    /* custom examples */
                    addCustomExamples()
                    /* external */
                    addExternalLibraries(systemUiController)
                }
            }
        }
    } else {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}