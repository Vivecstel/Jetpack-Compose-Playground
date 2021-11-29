package com.steleot.jetpackcompose.playground

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
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
import com.steleot.jetpackcompose.playground.navigation.FavoritesRoute
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.addActivityRoutes
import com.steleot.jetpackcompose.playground.navigation.addAnimationRoutes
import com.steleot.jetpackcompose.playground.navigation.addConstraintLayoutRoutes
import com.steleot.jetpackcompose.playground.navigation.addCustomExamples
import com.steleot.jetpackcompose.playground.navigation.addExternalLibraries
import com.steleot.jetpackcompose.playground.navigation.addFoundationRoutes
import com.steleot.jetpackcompose.playground.navigation.addMainRoutes
import com.steleot.jetpackcompose.playground.navigation.addMaterial3Routes
import com.steleot.jetpackcompose.playground.navigation.addMaterialIconsExtended
import com.steleot.jetpackcompose.playground.navigation.addMaterialIconsRoutes
import com.steleot.jetpackcompose.playground.navigation.addMaterialRoutes
import com.steleot.jetpackcompose.playground.navigation.addRuntimeRoutes
import com.steleot.jetpackcompose.playground.navigation.addUiRoutes
import com.steleot.jetpackcompose.playground.navigation.addViewModelRoutes
import com.steleot.jetpackcompose.playground.theme.JetpackComposePlaygroundTheme
import com.steleot.jetpackcompose.playground.theme.ThemeState
import com.steleot.jetpackcompose.playground.theme.getMaterialColors
import com.steleot.jetpackcompose.playground.utils.installer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
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

    @Suppress("DEPRECATION")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        inAppUpdateHelper.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }
}

private const val NavigationDuration = 600

@Suppress("ControlFlowWithEmptyBody")
@OptIn(ExperimentalAnimationApi::class, ExperimentalFoundationApi::class)
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
            val navController = rememberAnimatedNavController()
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
            ProvideWindowInsets {
                LocalProviders(
                    inAppReviewHelper, favoriteHelper, themeState, user, navController
                ) {
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = MainNavRoutes.Main,
                        enterTransition = {
                            getEnterAnimation(targetState.destination.route, screenWidth)
                        },
                        exitTransition = {
                            getExitAnimation(targetState.destination.route, -screenWidth)
                        },
                        popEnterTransition = {
                            getEnterAnimation(initialState.destination.route, -screenWidth)
                        },
                        popExitTransition = {
                            getExitAnimation(initialState.destination.route, screenWidth)
                        }
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

private fun getEnterAnimation(
    route: String?,
    screenWidth: Int,
): EnterTransition {
    return when (route) {
        MainNavRoutes.Popular,
        MainNavRoutes.Search,
        MainNavRoutes.Settings,
        FavoritesRoute ->
            fadeIn(animationSpec = tween(NavigationDuration))
        else -> slideInHorizontally(
            initialOffsetX = { screenWidth },
            animationSpec = tween(NavigationDuration)
        ) + fadeIn(
            initialAlpha = 0.5f,
            animationSpec = tween(NavigationDuration)
        )
    }
}

private fun getExitAnimation(
    route: String?,
    screenWidth: Int,
): ExitTransition {
    return when (route) {
        MainNavRoutes.Popular,
        MainNavRoutes.Search,
        MainNavRoutes.Settings,
        FavoritesRoute ->
            fadeOut(animationSpec = tween(NavigationDuration))
        else ->
            slideOutHorizontally(
                targetOffsetX = { screenWidth },
                animationSpec = tween(NavigationDuration)
            ) + fadeOut(
                targetAlpha = 0.5f,
                animationSpec = tween(NavigationDuration)
            )
    }
}
