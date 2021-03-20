package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen
import java.util.Locale

val routes = listOf(
    UiNavRoutes.AlignmentLine,
    UiNavRoutes.Alpha,
    UiNavRoutes.AndroidViewBinding,
    UiNavRoutes.AnimatedVector,
    UiNavRoutes.AnnotatedString,
    UiNavRoutes.Brush,
    UiNavRoutes.Color,
    UiNavRoutes.DebugInspectorInfo,
    UiNavRoutes.Drawable,
    UiNavRoutes.Font,
    UiNavRoutes.GraphicsLayer,
    UiNavRoutes.Layout,
//    UiNavRoutes.LocalAccessibilityManager,
//    UiNavRoutes.LocalAutofill,
//    UiNavRoutes.LocalAutofillTree,
    UiNavRoutes.LocalClipboardManager,
    UiNavRoutes.LocalConfiguration,
    UiNavRoutes.LocalContext,
    UiNavRoutes.LocalDensity,
//    UiNavRoutes.LocalFocusManager,
//    UiNavRoutes.LocalFontLoader,
//    UiNavRoutes.LocalHapticFeedback,
    UiNavRoutes.LocalLayoutDirection,
//    UiNavRoutes.LocalLifecycleOwner,
//    UiNavRoutes.LocalSavedStateRegistryOwner,
//    UiNavRoutes.LocalTextInputService,
//    UiNavRoutes.LocalTextToolbar,
    UiNavRoutes.LocalUriHandler,
    UiNavRoutes.LocalViewConfiguration,
    UiNavRoutes.LocalWindowInfo,
    UiNavRoutes.OnGloballyPositioned,
    UiNavRoutes.OnSizeChanged,
    UiNavRoutes.PathEffect,
    UiNavRoutes.Popup,
    UiNavRoutes.Primitive,
    UiNavRoutes.Rotate,
    UiNavRoutes.Scale,
    UiNavRoutes.Shadow,
    UiNavRoutes.SoftwareKeyboardController,
    UiNavRoutes.SpanStyle,
    UiNavRoutes.String,
    UiNavRoutes.SubComposeLayout,
    UiNavRoutes.TextDecoration,
    UiNavRoutes.TextIndent,
    UiNavRoutes.VisualTransformation,
    UiNavRoutes.ZIndex,
)

@Composable
fun UiScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.Ui.capitalize(Locale.getDefault()),
        list = routes,
        showBackArrow = true
    )
}
