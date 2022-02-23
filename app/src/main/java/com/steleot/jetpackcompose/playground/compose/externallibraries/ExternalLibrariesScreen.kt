package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.navigation.graph.MainNavRoutes

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
    ExternalLibrariesNavRoutes.ComposeShimmer,
//    ExternalLibrariesNavRoutes.ComposeTimelineView,
    ExternalLibrariesNavRoutes.ComposeTreeMap,
    ExternalLibrariesNavRoutes.DrawablePainterAccompanist,
    ExternalLibrariesNavRoutes.FlowLayoutAccompanist,
    ExternalLibrariesNavRoutes.FontAwesome,
    ExternalLibrariesNavRoutes.FrescoLandscapist,
    ExternalLibrariesNavRoutes.Gap,
    ExternalLibrariesNavRoutes.GlideLandscapist,
    ExternalLibrariesNavRoutes.GoogleMaps,
    ExternalLibrariesNavRoutes.HtmlText,
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
    ExternalLibrariesNavRoutes.Snapper,
    ExternalLibrariesNavRoutes.SpeedDialFloatingActionButton,
    ExternalLibrariesNavRoutes.SSJetPackComposeProgressButton,
    ExternalLibrariesNavRoutes.StageStepBar,
    ExternalLibrariesNavRoutes.SwipeRefreshAccompanist,
    ExternalLibrariesNavRoutes.SystemUiControllerAccompanist,
    ExternalLibrariesNavRoutes.WebViewAccompanist,
    ExternalLibrariesNavRoutes.ZoomableComposeImage,
)

@Composable
fun ExternalLibrariesScreen() {
    MainScreen(
        title = MainNavRoutes.ExternalLibraries,
        list = routes,
    )
}