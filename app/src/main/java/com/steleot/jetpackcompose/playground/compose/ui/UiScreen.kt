package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

val routes = listOf(
    UiNavRoutes.AlignmentLine,
    UiNavRoutes.Alpha,
    UiNavRoutes.AndroidViewBinding,
    UiNavRoutes.AnnotatedString,
    UiNavRoutes.Brush,
    UiNavRoutes.Clip,
//    UiNavRoutes.ClipToBounds,
    UiNavRoutes.Color,
    UiNavRoutes.DebugInspectorInfo,
    UiNavRoutes.Dialog,
    UiNavRoutes.Drawable,
    UiNavRoutes.DrawBehind,
    UiNavRoutes.DrawWithCache,
//    UiNavRoutes.DrawWithContent,
    UiNavRoutes.Font,
    UiNavRoutes.GraphicsLayer,
    UiNavRoutes.ImageBitmapToPixelMap,
    UiNavRoutes.LayoutId,
    UiNavRoutes.Layout,
//    UiNavRoutes.LocalAccessibilityManager,
//    UiNavRoutes.LocalAutofill,
//    UiNavRoutes.LocalAutofillTree,
    UiNavRoutes.LocalClipboardManager,
    UiNavRoutes.LocalConfiguration,
    UiNavRoutes.LocalContext,
    UiNavRoutes.LocalDensity,
    UiNavRoutes.LocalFocusManager,
    UiNavRoutes.LocalFontLoader,
    UiNavRoutes.LocalHapticFeedback,
    UiNavRoutes.LocalLayoutDirection,
    UiNavRoutes.LocalLifecycleOwner,
    UiNavRoutes.LocalSavedStateRegistryOwner,
    UiNavRoutes.LocalSoftwareKeyboardController,
    UiNavRoutes.LocalTextInputService,
    UiNavRoutes.LocalTextToolbar,
    UiNavRoutes.LocalUriHandler,
    UiNavRoutes.LocalViewConfiguration,
    UiNavRoutes.LocalWindowInfo,
    UiNavRoutes.NestedScroll,
    UiNavRoutes.OnGloballyPositioned,
//    UiNavRoutes.OnKeyEvent,
    UiNavRoutes.OnSizeChanged,
    UiNavRoutes.Paint,
    UiNavRoutes.PathEffect,
    UiNavRoutes.Popup,
    UiNavRoutes.Primitive,
    UiNavRoutes.RelocationRequester,
    UiNavRoutes.Rotate,
    UiNavRoutes.Scale,
    UiNavRoutes.Shadow,
    UiNavRoutes.SpanStyle,
    UiNavRoutes.String,
    UiNavRoutes.SubComposeLayout,
    UiNavRoutes.TestTag,
    UiNavRoutes.TextDecoration,
    UiNavRoutes.TextIndent,
    UiNavRoutes.VisualTransformation,
    UiNavRoutes.ZIndex,
)

@Composable
fun UiScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.Ui,
        list = routes,
    )
}
