package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes

val routes = listOf(
    ExternalLibrariesNavRoutes.CoilLandscapist,
    ExternalLibrariesNavRoutes.Coil,
    ExternalLibrariesNavRoutes.ComposeBarcodes,
    ExternalLibrariesNavRoutes.ComposeCharts,
//    ExternalLibrariesNavRoutes.ComposeMarkdown,
    ExternalLibrariesNavRoutes.ComposeNeumorphism,
    ExternalLibrariesNavRoutes.ComposeParticleSystem,
    ExternalLibrariesNavRoutes.ComposeRichTextPrinting,
//    ExternalLibrariesNavRoutes.ComposeRichTextSlideshow,
    ExternalLibrariesNavRoutes.ComposeRichTextUiMaterial,
    ExternalLibrariesNavRoutes.ComposeRichTextUi,
    ExternalLibrariesNavRoutes.ComposeTimelineView,
//    ExternalLibrariesNavRoutes.ComposeZoomableImage,
    ExternalLibrariesNavRoutes.DrawablePainterAccompanist,
    ExternalLibrariesNavRoutes.FlowLayoutAccompanist,
    ExternalLibrariesNavRoutes.FontAwesome,
    ExternalLibrariesNavRoutes.FrescoLandscapist,
    ExternalLibrariesNavRoutes.GlideLandscapist,
    ExternalLibrariesNavRoutes.InsetsAccompanist,
    ExternalLibrariesNavRoutes.Lottie,
    ExternalLibrariesNavRoutes.NavigationAnimationAccompanist,
    ExternalLibrariesNavRoutes.NavigationMaterialAccompanist,
    ExternalLibrariesNavRoutes.OrchestraBalloon,
    ExternalLibrariesNavRoutes.OrchestraColorPicker,
//    ExternalLibrariesNavRoutes.OrchestraSpinner,
    ExternalLibrariesNavRoutes.PagerAccompanist,
    ExternalLibrariesNavRoutes.PaletteLandscapist,
    ExternalLibrariesNavRoutes.PermissionsAccompanist,
    ExternalLibrariesNavRoutes.PlaceholderAccompanist,
    ExternalLibrariesNavRoutes.Plot,
    ExternalLibrariesNavRoutes.RatingBar,
    ExternalLibrariesNavRoutes.RevealSwipe,
    ExternalLibrariesNavRoutes.SpeedDialFloatingActionButton,
    ExternalLibrariesNavRoutes.SSJetPackComposeProgressButton,
    ExternalLibrariesNavRoutes.StageStepBar,
    ExternalLibrariesNavRoutes.SwipeRefreshAccompanist,
    ExternalLibrariesNavRoutes.SystemUiControllerAccompanist,
)

@Composable
fun ExternalLibrariesScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.ExternalLibraries,
        list = routes,
    )
}