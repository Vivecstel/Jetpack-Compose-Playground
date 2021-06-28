package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen

val routes = listOf(
    ExternalLibrariesNavRoutes.CoilAccompanist,
    ExternalLibrariesNavRoutes.CoilLandscapist,
//    ExternalLibrariesNavRoutes.ComposeCharts,
    ExternalLibrariesNavRoutes.ComposeMarkdown,
//    ExternalLibrariesNavRoutes.ComposeNeumorphism,
    ExternalLibrariesNavRoutes.FlowLayout,
    ExternalLibrariesNavRoutes.FontAwesome,
    ExternalLibrariesNavRoutes.FrescoLandscapist,
    ExternalLibrariesNavRoutes.GlideAccompanist,
    ExternalLibrariesNavRoutes.GlideLandscapist,
    ExternalLibrariesNavRoutes.Insets,
    ExternalLibrariesNavRoutes.Lottie,
    ExternalLibrariesNavRoutes.OrchestraBalloon,
    ExternalLibrariesNavRoutes.OrchestraColorPicker,
//    ExternalLibrariesNavRoutes.OrchestraSpinner,
    ExternalLibrariesNavRoutes.Pager,
    ExternalLibrariesNavRoutes.PermissionsAccompanist,
    ExternalLibrariesNavRoutes.PlaceholderAccompanist,
    ExternalLibrariesNavRoutes.RatingBar,
    ExternalLibrariesNavRoutes.RevealSwipe,
    ExternalLibrariesNavRoutes.SpeedDialFloatingActionButton,
    ExternalLibrariesNavRoutes.SwipeRefresh,
    ExternalLibrariesNavRoutes.SystemUiController,
)

@Composable
fun ExternalLibrariesScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.ExternalLibraries,
        list = routes,
        showBackArrow = true,
    )
}