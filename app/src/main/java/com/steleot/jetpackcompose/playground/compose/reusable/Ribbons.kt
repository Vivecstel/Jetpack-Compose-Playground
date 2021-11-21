package com.steleot.jetpackcompose.playground.compose.reusable

import androidx.compose.ui.graphics.Path
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.Material3NavRoutes
import com.steleot.jetpackcompose.playground.navigation.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

fun getRibbonPath(
    width: Float,
    height: Float,
) = Path().apply {
    lineTo(0f, height)
    lineTo(width / 2, height / 2)
    lineTo(width, height)
    lineTo(width, 0f)
    close()
}

val ribbonRoutes = setOf(
    /* 4.0.0 */
    MainNavRoutes.Foundation,
    FoundationNavRoutes.AnimateItemPlacement,
    FoundationNavRoutes.BringIntoViewRequester,
    MainNavRoutes.ExternalLibraries,
    ExternalLibrariesNavRoutes.Gap,
    ExternalLibrariesNavRoutes.HtmlText,
    ExternalLibrariesNavRoutes.Snapper,
    MainNavRoutes.Material,
    MaterialNavRoutes.Badge,
    MaterialNavRoutes.OutlinedButton,
    MaterialNavRoutes.TextButton,
    MainNavRoutes.Material3,
    Material3NavRoutes.AlertDialog3,
    Material3NavRoutes.Badge3,
    Material3NavRoutes.BadgedBox3,
    Material3NavRoutes.Button3,
    Material3NavRoutes.CenterAlignedTopAppBar,
    Material3NavRoutes.ElevatedButton,
    Material3NavRoutes.ExtendedFloatingActionButton3,
    Material3NavRoutes.FilledTonalButton,
    Material3NavRoutes.FloatingActionButton3,
    Material3NavRoutes.Icon3,
    Material3NavRoutes.IconButton3,
    Material3NavRoutes.IconToggleButton3,
    Material3NavRoutes.LargeFloatingActionButton,
    Material3NavRoutes.LargeTopAppBar,
    Material3NavRoutes.LocalAbsoluteTonalElevation,
    Material3NavRoutes.LocalContentColor3,
    Material3NavRoutes.LocalMinimumTouchTargetEnforcement,
    Material3NavRoutes.LocalTextStyle3,
    Material3NavRoutes.MaterialTheme3,
    Material3NavRoutes.MediumTopAppBar,
    Material3NavRoutes.NavigationBar,
    Material3NavRoutes.NavigationDrawer,
    Material3NavRoutes.NavigationRail3,
    Material3NavRoutes.OutlinedButton3,
    Material3NavRoutes.Scaffold3,
    Material3NavRoutes.SmallFloatingActionButton,
    Material3NavRoutes.SmallTopAppBar,
    Material3NavRoutes.Surface3,
    Material3NavRoutes.Text3,
    Material3NavRoutes.TextButton3,
    MainNavRoutes.Ui,
    UiNavRoutes.OnPlaced,
    /* 3.3.0 */
    MainNavRoutes.Material,
    MaterialNavRoutes.ExposedDropdownMenuBox,
    /* 3.2.0 */
    MainNavRoutes.ExternalLibraries,
    ExternalLibrariesNavRoutes.ComposeParticleSystem,
    ExternalLibrariesNavRoutes.SSJetPackComposeProgressButton,
    MainNavRoutes.Ui,
    UiNavRoutes.ModifierLocal,
)
