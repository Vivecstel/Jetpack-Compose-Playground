package com.steleot.jetpackcompose.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.android.gms.ads.MobileAds
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import com.steleot.jetpackcompose.playground.compose.activity.ActivityScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimationScreen
import com.steleot.jetpackcompose.playground.compose.constraintlayout.ConstraintLayoutScreen
import com.steleot.jetpackcompose.playground.compose.customexamples.CustomExamplesScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.ExternalLibrariesScreen
import com.steleot.jetpackcompose.playground.compose.foundation.FoundationScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.FoundationLayoutScreen
import com.steleot.jetpackcompose.playground.compose.material.MaterialScreen
import com.steleot.jetpackcompose.playground.compose.materialicons.MaterialIconsScreen
import com.steleot.jetpackcompose.playground.compose.materialiconsextended.MaterialIconsExtendedScreen
import com.steleot.jetpackcompose.playground.compose.navigation.NavigationScreen
import com.steleot.jetpackcompose.playground.compose.paging.PagingScreen
import com.steleot.jetpackcompose.playground.compose.rest.MainScreenWithDrawer
import com.steleot.jetpackcompose.playground.compose.rest.PopularScreen
import com.steleot.jetpackcompose.playground.compose.rest.SearchScreen
import com.steleot.jetpackcompose.playground.compose.rest.SettingsScreen
import com.steleot.jetpackcompose.playground.compose.runtime.RuntimeScreen
import com.steleot.jetpackcompose.playground.compose.ui.UiScreen
import com.steleot.jetpackcompose.playground.compose.viewmodel.ViewModelScreen
import com.steleot.jetpackcompose.playground.datastore.ProtoManager
import com.steleot.jetpackcompose.playground.helpers.InAppReviewHelper
import com.steleot.jetpackcompose.playground.navigation.*
import com.steleot.jetpackcompose.playground.theme.JetpackComposePlaygroundTheme
import com.steleot.jetpackcompose.playground.theme.ThemeState
import com.steleot.jetpackcompose.playground.theme.getMaterialColors
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var inAppReviewHelper: InAppReviewHelper

    @Inject
    lateinit var firebaseAnalytics: FirebaseAnalytics

    @Inject
    lateinit var protoManager: ProtoManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        MobileAds.initialize(this)
        setContent {
            JetpackComposeApp(inAppReviewHelper, firebaseAnalytics, protoManager)
        }
    }
}

private const val NavigationDuration = 600

@Suppress("ControlFlowWithEmptyBody")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun JetpackComposeApp(
    inAppReviewHelper: InAppReviewHelper,
    firebaseAnalytics: FirebaseAnalytics,
    protoManager: ProtoManager,
) {
    val isDarkTheme = isSystemInDarkTheme()
    var isLoaded by rememberSaveable { mutableStateOf(false) }
    var themeState by rememberSaveable {
        mutableStateOf(ThemeState(isDarkTheme = isDarkTheme))
    }
    val systemUiController = rememberSystemUiController()
    SideEffect {
        if (isLoaded) {
            systemUiController.setSystemBarsColor(
                themeState.colorPalette.getMaterialColors(themeState.isDarkTheme).primaryVariant
            )
        }
    }
    val screenWidth = with(LocalDensity.current) {
        LocalConfiguration.current.screenWidthDp.dp.roundToPx()
    }
    LaunchedEffect(Unit) {
        if (!isLoaded) {
            protoManager.colorPalette.collect { colorPalette ->
                themeState = themeState.copy(colorPalette = colorPalette)
                delay(250L)
                isLoaded = true
            }
        }
    }
    if (isLoaded) {
        JetpackComposePlaygroundTheme(
            colorPalette = themeState.colorPalette
        ) {
            ProvideWindowInsets {
                CompositionLocalProvider(LocalInAppReviewer provides inAppReviewHelper) {
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
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = MainNavRoutes.Main,
                        enterTransition = { _, target ->
                            when (target.destination.route) {
                                MainNavRoutes.Popular,
                                MainNavRoutes.Search,
                                MainNavRoutes.Settings ->
                                    fadeIn(animationSpec = tween(NavigationDuration))
                                else -> slideInHorizontally(
                                    initialOffsetX = { screenWidth },
                                    animationSpec = tween(NavigationDuration)
                                )
                            }
                        },
                        exitTransition = { _, target ->
                            when (target.destination.route) {
                                MainNavRoutes.Popular,
                                MainNavRoutes.Search,
                                MainNavRoutes.Settings ->
                                    fadeOut(animationSpec = tween(NavigationDuration))
                                else ->
                                    slideOutHorizontally(
                                        targetOffsetX = { -screenWidth },
                                        animationSpec = tween(NavigationDuration)
                                    )
                            }
                        },
                        popEnterTransition = { initial, _ ->
                            when (initial.destination.route) {
                                MainNavRoutes.Popular,
                                MainNavRoutes.Search,
                                MainNavRoutes.Settings ->
                                    fadeIn(animationSpec = tween(NavigationDuration))
                                else ->
                                    slideInHorizontally(
                                        initialOffsetX = { -screenWidth },
                                        animationSpec = tween(NavigationDuration)
                                    )
                            }
                        },
                        popExitTransition = { initial, _ ->
                            when (initial.destination.route) {
                                MainNavRoutes.Popular,
                                MainNavRoutes.Search,
                                MainNavRoutes.Settings ->
                                    fadeOut(animationSpec = tween(NavigationDuration))
                                else ->
                                    slideOutHorizontally(
                                        targetOffsetX = { screenWidth },
                                        animationSpec = tween(NavigationDuration)
                                    )
                            }
                        }
                    ) {
                        /* main */
                        composable(route = MainNavRoutes.Main) {
                            MainScreenWithDrawer(
                                navController,
                            )
                        }
                        composable(route = MainNavRoutes.Search) { SearchScreen(navController) }
                        composable(route = MainNavRoutes.Activity) { ActivityScreen(navController) }
                        composable(route = MainNavRoutes.Animation) { AnimationScreen(navController) }
                        composable(route = MainNavRoutes.ConstraintLayout) {
                            ConstraintLayoutScreen(
                                navController
                            )
                        }
                        composable(route = MainNavRoutes.CustomExamples) {
                            CustomExamplesScreen(
                                navController
                            )
                        }
                        composable(route = MainNavRoutes.ExternalLibraries) {
                            ExternalLibrariesScreen(
                                navController
                            )
                        }
                        composable(route = MainNavRoutes.Foundation) {
                            FoundationScreen(
                                navController
                            )
                        }
                        composable(route = MainNavRoutes.FoundationLayout) {
                            FoundationLayoutScreen(
                                navController
                            )
                        }
                        composable(route = MainNavRoutes.Material) { MaterialScreen(navController) }
                        composable(route = MainNavRoutes.MaterialIcons) {
                            MaterialIconsScreen(
                                navController
                            )
                        }
                        composable(route = MainNavRoutes.MaterialIConsExtended) {
                            MaterialIconsExtendedScreen(
                                navController
                            )
                        }
                        composable(route = MainNavRoutes.Navigation) { NavigationScreen() }
                        composable(route = MainNavRoutes.Paging) { PagingScreen() }
                        composable(route = MainNavRoutes.Runtime) { RuntimeScreen(navController) }
                        composable(route = MainNavRoutes.Ui) { UiScreen(navController) }
                        composable(route = MainNavRoutes.ViewModel) { ViewModelScreen(navController) }
                        composable(route = MainNavRoutes.Settings) {
                            SettingsScreen(hiltViewModel(it), themeState) { newTheme ->
                                themeState = newTheme
                            }
                        }
                        composable(route = MainNavRoutes.Popular) {
                            PopularScreen(
                                hiltViewModel(it),
                                navController
                            )
                        }
                        /* activity */
                        addActivityRoutes(navController)
                        /* animation */
                        addAnimationRoutes()
                        /* constraint layout */
                        addConstraintLayoutRoutes()
                        /* foundation */
                        addFoundationRoutes()
                        /* foundation layout */
                        addFoundationLayoutRoutes()
                        /* material */
                        addMaterialRoutes()
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
                        addExternalLibraries(navController, systemUiController)
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

val LocalInAppReviewer = staticCompositionLocalOf<InAppReviewHelper> {
    error("CompositionLocal InAppReviewHelper not present")
}
