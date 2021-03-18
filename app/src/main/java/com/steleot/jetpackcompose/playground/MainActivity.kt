package com.steleot.jetpackcompose.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.android.gms.ads.MobileAds
import com.steleot.jetpackcompose.playground.compose.MainScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimatableScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimatedValuesScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimatedVisibilityScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimationModifierScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimationScreen
import com.steleot.jetpackcompose.playground.compose.animation.CrossfadeAnimationScreen
import com.steleot.jetpackcompose.playground.compose.animation.GestureAnimationScreen
import com.steleot.jetpackcompose.playground.compose.animation.InfiniteTransitionScreen
import com.steleot.jetpackcompose.playground.compose.animation.RotatingShapeScreen
import com.steleot.jetpackcompose.playground.compose.animation.SingleValueColorAnimationScreen
import com.steleot.jetpackcompose.playground.compose.animation.SingleValueFloatAnimationScreen
import com.steleot.jetpackcompose.playground.compose.animation.SuspendAnimationScreen
import com.steleot.jetpackcompose.playground.compose.constraintlayout.ConstraintLayoutScreen
import com.steleot.jetpackcompose.playground.compose.external.CoilScreen
import com.steleot.jetpackcompose.playground.compose.external.ExternalLibrariesScreen
import com.steleot.jetpackcompose.playground.compose.external.FlowScreen
import com.steleot.jetpackcompose.playground.compose.external.GlideScreen
import com.steleot.jetpackcompose.playground.compose.external.LottieScreen
import com.steleot.jetpackcompose.playground.compose.external.PicassoScreen
import com.steleot.jetpackcompose.playground.compose.foundation.BackgroundScreen
import com.steleot.jetpackcompose.playground.compose.foundation.BorderScreen
import com.steleot.jetpackcompose.playground.compose.foundation.CanvasScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ClickableScreen
import com.steleot.jetpackcompose.playground.compose.foundation.DragGestureDetectorScreen
import com.steleot.jetpackcompose.playground.compose.foundation.DraggableScreen
import com.steleot.jetpackcompose.playground.compose.foundation.FocusableScreen
import com.steleot.jetpackcompose.playground.compose.foundation.FoundationScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ImageScreen
import com.steleot.jetpackcompose.playground.compose.foundation.InteractionSourceScreen
import com.steleot.jetpackcompose.playground.compose.foundation.LazyColumnScreen
import com.steleot.jetpackcompose.playground.compose.foundation.LazyGridScreen
import com.steleot.jetpackcompose.playground.compose.foundation.LazyRowScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ScrollableScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ScrollerScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ShapeScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ToggeableScreen
import com.steleot.jetpackcompose.playground.compose.foundation.TransformGestureScreen
import com.steleot.jetpackcompose.playground.compose.foundation.TransformableScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.AspectRationScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.BoxScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.BoxWithConstraintsScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.ColumnScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.FoundationLayoutScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.IntrinsicScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.OffsetScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.PaddingScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.RowScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.SizeScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.SpacerScreen
import com.steleot.jetpackcompose.playground.compose.material.AlertDialogScreen
import com.steleot.jetpackcompose.playground.compose.material.BackdropScaffoldScreen
import com.steleot.jetpackcompose.playground.compose.material.BottomAppBarScreen
import com.steleot.jetpackcompose.playground.compose.material.BottomDrawerLayoutScreen
import com.steleot.jetpackcompose.playground.compose.material.BottomNavigationScreen
import com.steleot.jetpackcompose.playground.compose.material.BottomSheetScaffoldScreen
import com.steleot.jetpackcompose.playground.compose.material.ButtonScreen
import com.steleot.jetpackcompose.playground.compose.material.CardScreen
import com.steleot.jetpackcompose.playground.compose.material.CheckboxScreen
import com.steleot.jetpackcompose.playground.compose.material.LocalContentAlphaScreen
import com.steleot.jetpackcompose.playground.compose.material.DividerScreen
import com.steleot.jetpackcompose.playground.compose.material.DropdownMenuScreen
import com.steleot.jetpackcompose.playground.compose.material.ElevationScreen
import com.steleot.jetpackcompose.playground.compose.material.ExtendedFloatingActionButtonScreen
import com.steleot.jetpackcompose.playground.compose.material.FloatingActionButtonScreen
import com.steleot.jetpackcompose.playground.compose.material.IconButtonScreen
import com.steleot.jetpackcompose.playground.compose.material.IconScreen
import com.steleot.jetpackcompose.playground.compose.material.IconToggleButtonScreen
import com.steleot.jetpackcompose.playground.compose.material.ListItemScreen
import com.steleot.jetpackcompose.playground.compose.material.LocalContentColorScreen
import com.steleot.jetpackcompose.playground.compose.material.MaterialScreen
import com.steleot.jetpackcompose.playground.compose.material.ModalBottomSheetLayoutScreen
import com.steleot.jetpackcompose.playground.compose.material.ModalDrawerLayoutScreen
import com.steleot.jetpackcompose.playground.compose.material.OutlinedTextFieldScreen
import com.steleot.jetpackcompose.playground.compose.material.ProgressScreen
import com.steleot.jetpackcompose.playground.compose.material.RadioButtonScreen
import com.steleot.jetpackcompose.playground.compose.material.ScaffoldScreen
import com.steleot.jetpackcompose.playground.compose.material.ScrollableTabRowScreen
import com.steleot.jetpackcompose.playground.compose.material.SliderScreen
import com.steleot.jetpackcompose.playground.compose.material.SnackBarScreen
import com.steleot.jetpackcompose.playground.compose.material.SurfaceScreen
import com.steleot.jetpackcompose.playground.compose.material.SwipeToDismissScreen
import com.steleot.jetpackcompose.playground.compose.material.SwipeableScreen
import com.steleot.jetpackcompose.playground.compose.material.SwitchScreen
import com.steleot.jetpackcompose.playground.compose.material.TabRowScreen
import com.steleot.jetpackcompose.playground.compose.material.TextFieldScreen
import com.steleot.jetpackcompose.playground.compose.material.TopAppBarScreen
import com.steleot.jetpackcompose.playground.compose.material.TriStateCheckboxScreen
import com.steleot.jetpackcompose.playground.compose.materialicons.FilledScreen
import com.steleot.jetpackcompose.playground.compose.materialicons.MaterialIconsScreen
import com.steleot.jetpackcompose.playground.compose.materialicons.OutlinedScreen
import com.steleot.jetpackcompose.playground.compose.materialicons.RoundedScreen
import com.steleot.jetpackcompose.playground.compose.materialicons.SharpScreen
import com.steleot.jetpackcompose.playground.compose.materialicons.TwoToneScreen
import com.steleot.jetpackcompose.playground.compose.materialiconsextended.ExtendedFilledScreen
import com.steleot.jetpackcompose.playground.compose.materialiconsextended.ExtendedOutlinedScreen
import com.steleot.jetpackcompose.playground.compose.materialiconsextended.ExtendedRoundedScreen
import com.steleot.jetpackcompose.playground.compose.materialiconsextended.ExtendedSharpScreen
import com.steleot.jetpackcompose.playground.compose.materialiconsextended.ExtendedTwoToneScreen
import com.steleot.jetpackcompose.playground.compose.materialiconsextended.MaterialIconsExtendedScreen
import com.steleot.jetpackcompose.playground.compose.runtime.CollectAsStateScreen
import com.steleot.jetpackcompose.playground.compose.runtime.CompositionLocalScreen
import com.steleot.jetpackcompose.playground.compose.runtime.DerivedStateScreen
import com.steleot.jetpackcompose.playground.compose.runtime.DisposableEffectScreen
import com.steleot.jetpackcompose.playground.compose.runtime.ImmutableScreen
import com.steleot.jetpackcompose.playground.compose.runtime.KeyScreen
import com.steleot.jetpackcompose.playground.compose.runtime.LaunchedEffectScreen
import com.steleot.jetpackcompose.playground.compose.runtime.MutableStateListScreen
import com.steleot.jetpackcompose.playground.compose.runtime.MutableStateMapScreen
import com.steleot.jetpackcompose.playground.compose.runtime.ProduceStateScreen
import com.steleot.jetpackcompose.playground.compose.runtime.RememberCoroutineScopeScreen
import com.steleot.jetpackcompose.playground.compose.runtime.RememberSaveableScreen
import com.steleot.jetpackcompose.playground.compose.runtime.RememberSaveableStateHolderScreen
import com.steleot.jetpackcompose.playground.compose.runtime.RememberScreen
import com.steleot.jetpackcompose.playground.compose.runtime.RuntimeScreen
import com.steleot.jetpackcompose.playground.compose.runtime.SaverScreen
import com.steleot.jetpackcompose.playground.compose.runtime.SideEffectScreen
import com.steleot.jetpackcompose.playground.compose.runtime.SnapshotFlowScreen
import com.steleot.jetpackcompose.playground.compose.ui.AlignmentLineScreen
import com.steleot.jetpackcompose.playground.compose.ui.AlphaScreen
import com.steleot.jetpackcompose.playground.compose.ui.AndroidViewBindingScreen
import com.steleot.jetpackcompose.playground.compose.ui.AnimatedVectorScreen
import com.steleot.jetpackcompose.playground.compose.ui.AnnotatedStringScreen
import com.steleot.jetpackcompose.playground.compose.ui.BrushScreen
import com.steleot.jetpackcompose.playground.compose.ui.ColorScreen
import com.steleot.jetpackcompose.playground.compose.ui.DebugInspectorInfoScreen
import com.steleot.jetpackcompose.playground.compose.ui.DrawableScreen
import com.steleot.jetpackcompose.playground.compose.ui.FontScreen
import com.steleot.jetpackcompose.playground.compose.ui.GraphicsLayerScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalAccessibilityManagerScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalAutofillScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalAutofillTreeScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalClipboardManagerScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalConfigurationScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalContextScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalDensityScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalFocusManagerScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalFontLoaderScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalHapticFeedbackScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalLayoutDirectionScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalLifecycleOwnerScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalSavedStateRegistryOwnerScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalTextInputServiceScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalTextToolbarScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalUriHandlerScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalViewConfigurationScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalWindowInfoScreen
import com.steleot.jetpackcompose.playground.compose.ui.OnGloballyPositionedScreen
import com.steleot.jetpackcompose.playground.compose.ui.OnSizeChangedScreen
import com.steleot.jetpackcompose.playground.compose.ui.PathEffectScreen
import com.steleot.jetpackcompose.playground.compose.ui.PopupScreen
import com.steleot.jetpackcompose.playground.compose.ui.PrimitiveScreen
import com.steleot.jetpackcompose.playground.compose.ui.RotateScreen
import com.steleot.jetpackcompose.playground.compose.ui.ScaleScreen
import com.steleot.jetpackcompose.playground.compose.ui.ShadowScreen
import com.steleot.jetpackcompose.playground.compose.ui.SoftwareKeyboardControllerScreen
import com.steleot.jetpackcompose.playground.compose.ui.SpanStyleScreen
import com.steleot.jetpackcompose.playground.compose.ui.StringScreen
import com.steleot.jetpackcompose.playground.compose.ui.SubComposeLayoutScreen
import com.steleot.jetpackcompose.playground.compose.ui.TextDecorationScreen
import com.steleot.jetpackcompose.playground.compose.ui.TextIndentScreen
import com.steleot.jetpackcompose.playground.compose.ui.UiScreen
import com.steleot.jetpackcompose.playground.compose.ui.VisualTransformationScreen
import com.steleot.jetpackcompose.playground.compose.ui.ZIndexScreen
import com.steleot.jetpackcompose.playground.compose.viewmodel.ViewModelFlowScreen
import com.steleot.jetpackcompose.playground.compose.viewmodel.ViewModelLiveDataScreen
import com.steleot.jetpackcompose.playground.compose.viewmodel.StateScreen
import com.steleot.jetpackcompose.playground.compose.viewmodel.ViewModelScreen
import com.steleot.jetpackcompose.playground.theme.PlaygroundTheme
import com.steleot.jetpackcompose.playground.compose.ui.LayoutScreen as UiLayoutScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MobileAds.initialize(this)
        setContent {
            PlaygroundApp()
        }
    }
}

@Composable
fun PlaygroundApp() {
    ProvideWindowInsets {
        PlaygroundTheme {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = MainNavRoutes.Main) {
                /* main */
                composable(route = MainNavRoutes.Main) { MainScreen(navController, showAd = true) }
                composable(route = MainNavRoutes.Animation) { AnimationScreen(navController) }
                composable(route = MainNavRoutes.ConstraintLayout) { ConstraintLayoutScreen() }
                composable(route = MainNavRoutes.Foundation) { FoundationScreen(navController) }
                composable(route = MainNavRoutes.FoundationLayout) { FoundationLayoutScreen(navController) }
                composable(route = MainNavRoutes.Material) { MaterialScreen(navController) }
                composable(route = MainNavRoutes.MaterialIcons) { MaterialIconsScreen(navController) }
                composable(route = MainNavRoutes.MaterialIConsExtended) {
                    MaterialIconsExtendedScreen(
                        navController
                    )
                }
                composable(route = MainNavRoutes.Runtime) { RuntimeScreen(navController) }
                composable(route = MainNavRoutes.Ui) { UiScreen(navController) }
                composable(route = MainNavRoutes.ViewModel) { ViewModelScreen(navController) }
                composable(route = MainNavRoutes.ExternalLibraries) {
                    ExternalLibrariesScreen(
                        navController
                    )
                }
                /* animation */
                composable(route = AnimationNavRoutes.Animatable) { AnimatableScreen() }
                composable(route = AnimationNavRoutes.AnimatedValues) { AnimatedValuesScreen() }
                composable(route = AnimationNavRoutes.AnimatedVisibility) { AnimatedVisibilityScreen() }
                composable(route = AnimationNavRoutes.AnimationModifier) { AnimationModifierScreen() }
                composable(route = AnimationNavRoutes.CrossfadeAnimation) { CrossfadeAnimationScreen() }
                composable(route = AnimationNavRoutes.GestureAnimation) { GestureAnimationScreen() }
                composable(route = AnimationNavRoutes.InfiniteTransition) { InfiniteTransitionScreen() }
                composable(route = AnimationNavRoutes.RotatingShape) { RotatingShapeScreen() }
                composable(route = AnimationNavRoutes.SingleValueColorAnimation) { SingleValueColorAnimationScreen() }
                composable(route = AnimationNavRoutes.SingleValueFloatAnimation) { SingleValueFloatAnimationScreen() }
                composable(route = AnimationNavRoutes.SuspendAnimation) { SuspendAnimationScreen() }
                /* foundation */
                composable(route = FoundationNavRoutes.Background) { BackgroundScreen() }
                composable(route = FoundationNavRoutes.Border) { BorderScreen() }
                composable(route = FoundationNavRoutes.Canvas) { CanvasScreen() }
                composable(route = FoundationNavRoutes.Clickable) { ClickableScreen() }
                composable(route = FoundationNavRoutes.Draggable) { DraggableScreen() }
                composable(route = FoundationNavRoutes.DragGestureDetector) { DragGestureDetectorScreen() }
                composable(route = FoundationNavRoutes.Focusable) { FocusableScreen() }
                composable(route = FoundationNavRoutes.Image) { ImageScreen() }
                composable(route = FoundationNavRoutes.InteractionSource) { InteractionSourceScreen() }
                composable(route = FoundationNavRoutes.LazyColumn) { LazyColumnScreen() }
                composable(route = FoundationNavRoutes.LazyGrid) { LazyGridScreen() }
                composable(route = FoundationNavRoutes.LazyRow) { LazyRowScreen() }
                composable(route = FoundationNavRoutes.Scrollable) { ScrollableScreen() }
                composable(route = FoundationNavRoutes.Scroller) { ScrollerScreen() }
                composable(route = FoundationNavRoutes.Shape) { ShapeScreen() }
                composable(route = FoundationNavRoutes.Toggeable) { ToggeableScreen() }
                composable(route = FoundationNavRoutes.Transformable) { TransformableScreen() }
                composable(route = FoundationNavRoutes.TransformGesture) { TransformGestureScreen() }
                /* layout */
                composable(route = FoundationLayoutNavRoutes.AspectRatio) { AspectRationScreen() }
                composable(route = FoundationLayoutNavRoutes.Box) { BoxScreen() }
                composable(route = FoundationLayoutNavRoutes.BoxWithConstraints) { BoxWithConstraintsScreen() }
                composable(route = FoundationLayoutNavRoutes.Column) { ColumnScreen() }
                composable(route = FoundationLayoutNavRoutes.Intrinsic) { IntrinsicScreen() }
                composable(route = FoundationLayoutNavRoutes.Offset) { OffsetScreen() }
                composable(route = FoundationLayoutNavRoutes.Padding) { PaddingScreen() }
                composable(route = FoundationLayoutNavRoutes.Row) { RowScreen() }
                composable(route = FoundationLayoutNavRoutes.Size) { SizeScreen() }
                composable(route = FoundationLayoutNavRoutes.Spacer) { SpacerScreen() }
                /* material */
                composable(route = MaterialNavRoutes.AlertDialog) { AlertDialogScreen() }
                composable(route = MaterialNavRoutes.BackdropScaffold) { BackdropScaffoldScreen() }
                composable(route = MaterialNavRoutes.BottomAppBar) { BottomAppBarScreen() }
                composable(route = MaterialNavRoutes.BottomDrawerLayout) { BottomDrawerLayoutScreen() }
                composable(route = MaterialNavRoutes.BottomNavigation) { BottomNavigationScreen() }
                composable(route = MaterialNavRoutes.BottomSheetScaffold) { BottomSheetScaffoldScreen() }
                composable(route = MaterialNavRoutes.Button) { ButtonScreen() }
                composable(route = MaterialNavRoutes.Card) { CardScreen() }
                composable(route = MaterialNavRoutes.Checkbox) { CheckboxScreen() }
                composable(route = MaterialNavRoutes.Divider) { DividerScreen() }
                composable(route = MaterialNavRoutes.DropdownMenu) { DropdownMenuScreen() }
                composable(route = MaterialNavRoutes.ExtendedFloatingActionButton) { ExtendedFloatingActionButtonScreen() }
                composable(route = MaterialNavRoutes.Elevation) { ElevationScreen() }
                composable(route = MaterialNavRoutes.FloatingActionButton) { FloatingActionButtonScreen() }
                composable(route = MaterialNavRoutes.IconButton) { IconButtonScreen() }
                composable(route = MaterialNavRoutes.Icon) { IconScreen() }
                composable(route = MaterialNavRoutes.IconToggleButton) { IconToggleButtonScreen() }
                composable(route = MaterialNavRoutes.ListItem) { ListItemScreen() }
                composable(route = MaterialNavRoutes.LocalContentAlpha) { LocalContentAlphaScreen() }
                composable(route = MaterialNavRoutes.LocalContentColor) { LocalContentColorScreen() }
                composable(route = MaterialNavRoutes.ModalBottomSheetLayout) { ModalBottomSheetLayoutScreen() }
                composable(route = MaterialNavRoutes.ModalDrawerLayout) { ModalDrawerLayoutScreen() }
                composable(route = MaterialNavRoutes.OutlinedTextField) { OutlinedTextFieldScreen() }
                composable(route = MaterialNavRoutes.Progress) { ProgressScreen() }
                composable(route = MaterialNavRoutes.RadioButton) { RadioButtonScreen() }
                composable(route = MaterialNavRoutes.Scaffold) { ScaffoldScreen() }
                composable(route = MaterialNavRoutes.ScrollableTabRow) { ScrollableTabRowScreen() }
                composable(route = MaterialNavRoutes.Slider) { SliderScreen() }
                composable(route = MaterialNavRoutes.SnackBar) { SnackBarScreen() }
                composable(route = MaterialNavRoutes.Surface) { SurfaceScreen() }
                composable(route = MaterialNavRoutes.Swipeable) { SwipeableScreen() }
                composable(route = MaterialNavRoutes.SwipeToDismiss) { SwipeToDismissScreen() }
                composable(route = MaterialNavRoutes.Switch) { SwitchScreen() }
                composable(route = MaterialNavRoutes.TabRow) { TabRowScreen() }
                composable(route = MaterialNavRoutes.TextField) { TextFieldScreen() }
                composable(route = MaterialNavRoutes.TopAppBar) { TopAppBarScreen() }
                composable(route = MaterialNavRoutes.TriStateCheckbox) { TriStateCheckboxScreen() }
                /* material icons */
                composable(route = MaterialIconsNavRoutes.Filled) { FilledScreen() }
                composable(route = MaterialIconsNavRoutes.Outlined) { OutlinedScreen() }
                composable(route = MaterialIconsNavRoutes.Rounded) { RoundedScreen() }
                composable(route = MaterialIconsNavRoutes.Sharp) { SharpScreen() }
                composable(route = MaterialIconsNavRoutes.TwoTone) { TwoToneScreen() }
                /* material icons extended */
                composable(route = MaterialIconsExtendedNavRoutes.ExtendedFilled) { ExtendedFilledScreen() }
                composable(route = MaterialIconsExtendedNavRoutes.ExtendedOutlined) { ExtendedOutlinedScreen() }
                composable(route = MaterialIconsExtendedNavRoutes.ExtendedRounded) { ExtendedRoundedScreen() }
                composable(route = MaterialIconsExtendedNavRoutes.ExtendedSharp) { ExtendedSharpScreen() }
                composable(route = MaterialIconsExtendedNavRoutes.ExtendedTwoTone) { ExtendedTwoToneScreen() }
                /* runtime */
                composable(route = RuntimeNavRoutes.CollectAsState) { CollectAsStateScreen() }
                composable(route = RuntimeNavRoutes.CompositionLocal) { CompositionLocalScreen() }
                composable(route = RuntimeNavRoutes.DerivedState) { DerivedStateScreen() }
                composable(route = RuntimeNavRoutes.DisposableEffect) { DisposableEffectScreen() }
                composable(route = RuntimeNavRoutes.Immutable) { ImmutableScreen() }
                composable(route = RuntimeNavRoutes.Key) { KeyScreen() }
                composable(route = RuntimeNavRoutes.LaunchedEffect) { LaunchedEffectScreen() }
                composable(route = RuntimeNavRoutes.MutableStateList) { MutableStateListScreen() }
                composable(route = RuntimeNavRoutes.MutableStateMap) { MutableStateMapScreen() }
                composable(route = RuntimeNavRoutes.ProduceState) { ProduceStateScreen() }
                composable(route = RuntimeNavRoutes.RememberCoroutineScope) { RememberCoroutineScopeScreen() }
                composable(route = RuntimeNavRoutes.RememberSaveable) { RememberSaveableScreen() }
                composable(route = RuntimeNavRoutes.RememberSaveableStateHolder) { RememberSaveableStateHolderScreen() }
                composable(route = RuntimeNavRoutes.Remember) { RememberScreen() }
                composable(route = RuntimeNavRoutes.Saver) { SaverScreen() }
                composable(route = RuntimeNavRoutes.SideEffect) { SideEffectScreen() }
                composable(route = RuntimeNavRoutes.SnapshotFlow) { SnapshotFlowScreen() }
                /* ui */
                composable(route = UiNavRoutes.AlignmentLine) { AlignmentLineScreen() }
                composable(route = UiNavRoutes.Alpha) { AlphaScreen() }
                composable(route = UiNavRoutes.AndroidViewBinding) { AndroidViewBindingScreen() }
                composable(route = UiNavRoutes.AnimatedVector) { AnimatedVectorScreen() }
                composable(route = UiNavRoutes.AnnotatedString) { AnnotatedStringScreen() }
                composable(route = UiNavRoutes.Brush) { BrushScreen() }
                composable(route = UiNavRoutes.Color) { ColorScreen() }
                composable(route = UiNavRoutes.DebugInspectorInfo) { DebugInspectorInfoScreen() }
                composable(route = UiNavRoutes.Drawable) { DrawableScreen() }
                composable(route = UiNavRoutes.Font) { FontScreen() }
                composable(route = UiNavRoutes.GraphicsLayer) { GraphicsLayerScreen() }
                composable(route = UiNavRoutes.Layout) { UiLayoutScreen() }
                composable(route = UiNavRoutes.LocalAccessibilityManager) { LocalAccessibilityManagerScreen() }
                composable(route = UiNavRoutes.LocalAutofill) { LocalAutofillScreen() }
                composable(route = UiNavRoutes.LocalAutofillTree) { LocalAutofillTreeScreen() }
                composable(route = UiNavRoutes.LocalClipboardManager) { LocalClipboardManagerScreen() }
                composable(route = UiNavRoutes.LocalConfiguration) { LocalConfigurationScreen() }
                composable(route = UiNavRoutes.LocalContext) { LocalContextScreen() }
                composable(route = UiNavRoutes.LocalDensity) { LocalDensityScreen() }
                composable(route = UiNavRoutes.LocalFocusManager) { LocalFocusManagerScreen() }
                composable(route = UiNavRoutes.LocalFontLoader) { LocalFontLoaderScreen() }
                composable(route = UiNavRoutes.LocalHapticFeedback) { LocalHapticFeedbackScreen() }
                composable(route = UiNavRoutes.LocalLayoutDirection) { LocalLayoutDirectionScreen() }
                composable(route = UiNavRoutes.LocalLifecycleOwner) { LocalLifecycleOwnerScreen() }
                composable(route = UiNavRoutes.LocalSavedStateRegistryOwner) { LocalSavedStateRegistryOwnerScreen() }
                composable(route = UiNavRoutes.LocalTextInputService) { LocalTextInputServiceScreen() }
                composable(route = UiNavRoutes.LocalTextToolbar) { LocalTextToolbarScreen() }
                composable(route = UiNavRoutes.LocalUriHandler) { LocalUriHandlerScreen() }
                composable(route = UiNavRoutes.LocalViewConfiguration) { LocalViewConfigurationScreen() }
                composable(route = UiNavRoutes.LocalWindowInfo) { LocalWindowInfoScreen() }
                composable(route = UiNavRoutes.OnGloballyPositioned) { OnGloballyPositionedScreen() }
                composable(route = UiNavRoutes.OnSizeChanged) { OnSizeChangedScreen() }
                composable(route = UiNavRoutes.PathEffect) { PathEffectScreen() }
                composable(route = UiNavRoutes.Popup) { PopupScreen() }
                composable(route = UiNavRoutes.Primitive) { PrimitiveScreen() }
                composable(route = UiNavRoutes.Rotate) { RotateScreen() }
                composable(route = UiNavRoutes.Scale) { ScaleScreen() }
                composable(route = UiNavRoutes.Shadow) { ShadowScreen() }
                composable(route = UiNavRoutes.SoftwareKeyboardController) { SoftwareKeyboardControllerScreen() }
                composable(route = UiNavRoutes.SpanStyle) { SpanStyleScreen() }
                composable(route = UiNavRoutes.String) { StringScreen() }
                composable(route = UiNavRoutes.SubComposeLayout) { SubComposeLayoutScreen() }
                composable(route = UiNavRoutes.TextDecoration) { TextDecorationScreen() }
                composable(route = UiNavRoutes.TextIndent) { TextIndentScreen() }
                composable(route = UiNavRoutes.VisualTransformation) { VisualTransformationScreen() }
                composable(route = UiNavRoutes.ZIndex) { ZIndexScreen() }
                /* view model */
                composable(route = ViewModelNavRoutes.Flow) { ViewModelFlowScreen() }
                composable(route = ViewModelNavRoutes.LiveData) { ViewModelLiveDataScreen() }
                composable(route = ViewModelNavRoutes.State) { StateScreen() }
                /* external */
                composable(route = ExternalLibrariesNavRoutes.Coil) { CoilScreen() }
                composable(route = ExternalLibrariesNavRoutes.Flow) { FlowScreen() }
                composable(route = ExternalLibrariesNavRoutes.Glide) { GlideScreen() }
                composable(route = ExternalLibrariesNavRoutes.Lottie) { LottieScreen() }
                composable(route = ExternalLibrariesNavRoutes.Picasso) { PicassoScreen() }
            }
        }
    }
}
