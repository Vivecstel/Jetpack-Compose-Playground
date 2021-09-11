package com.steleot.jetpackcompose.playground.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.systemuicontroller.SystemUiController
import com.steleot.jetpackcompose.playground.compose.activity.ActivityScreen
import com.steleot.jetpackcompose.playground.compose.activity.BackHandlerScreen
import com.steleot.jetpackcompose.playground.compose.activity.LauncherForActivityResult1Screen
import com.steleot.jetpackcompose.playground.compose.activity.LauncherForActivityResult2Screen
import com.steleot.jetpackcompose.playground.compose.animation.*
import com.steleot.jetpackcompose.playground.compose.constraintlayout.*
import com.steleot.jetpackcompose.playground.compose.customexamples.*
import com.steleot.jetpackcompose.playground.compose.externallibraries.*
import com.steleot.jetpackcompose.playground.compose.foundation.*
import com.steleot.jetpackcompose.playground.compose.foundationlayout.*
import com.steleot.jetpackcompose.playground.compose.material.*
import com.steleot.jetpackcompose.playground.compose.materialicons.*
import com.steleot.jetpackcompose.playground.compose.materialiconsextended.*
import com.steleot.jetpackcompose.playground.compose.navigation.NavigationScreen
import com.steleot.jetpackcompose.playground.compose.paging.PagingScreen
import com.steleot.jetpackcompose.playground.compose.rest.MainScreenWithDrawer
import com.steleot.jetpackcompose.playground.compose.rest.PopularScreen
import com.steleot.jetpackcompose.playground.compose.rest.SearchScreen
import com.steleot.jetpackcompose.playground.compose.rest.SettingsScreen
import com.steleot.jetpackcompose.playground.compose.runtime.*
import com.steleot.jetpackcompose.playground.compose.ui.*
import com.steleot.jetpackcompose.playground.compose.viewmodel.StateScreen
import com.steleot.jetpackcompose.playground.compose.viewmodel.ViewModelFlowScreen
import com.steleot.jetpackcompose.playground.compose.viewmodel.ViewModelLiveDataScreen
import com.steleot.jetpackcompose.playground.compose.viewmodel.ViewModelScreen
import com.steleot.jetpackcompose.playground.theme.ThemeState

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addMainRoutes(
    navController: NavHostController,
    theme: ThemeState,
    setTheme: (ThemeState) -> Unit,
) {
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
        SettingsScreen(hiltViewModel(it), theme, setTheme)
    }
    composable(route = MainNavRoutes.Popular) {
        PopularScreen(
            hiltViewModel(it),
            navController
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addActivityRoutes(
    navController: NavHostController,
) {
    composable(route = ActivityNavRoutes.BackHandler) {
        BackHandlerScreen(
            navController
        )
    }
    composable(route = ActivityNavRoutes.LauncherForActivityResult1) { LauncherForActivityResult1Screen() }
    composable(route = ActivityNavRoutes.LauncherForActivityResult2) { LauncherForActivityResult2Screen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addAnimationRoutes() {
    composable(route = AnimationNavRoutes.Animatable) { AnimatableScreen() }
    composable(route = AnimationNavRoutes.AnimatedContent) { AnimatedContentScreen() }
    composable(route = AnimationNavRoutes.AnimatedValues) { AnimatedValuesScreen() }
    composable(route = AnimationNavRoutes.AnimatedVector) { AnimatedVectorScreen() }
    composable(route = AnimationNavRoutes.AnimatedVisibility) { AnimatedVisibilityScreen() }
    composable(route = AnimationNavRoutes.AnimateEnterExit) { AnimateEnterExitScreen() }
    composable(route = AnimationNavRoutes.AnimationModifier) { AnimationModifierScreen() }
    composable(route = AnimationNavRoutes.CrossfadeAnimation) { CrossfadeAnimationScreen() }
    composable(route = AnimationNavRoutes.DoubleTapToLike) { DoubleTapToLikeScreen() }
    composable(route = AnimationNavRoutes.ElevationAnimation) { ElevationAnimationScreen() }
    composable(route = AnimationNavRoutes.GestureAnimation) { GestureAnimationScreen() }
    composable(route = AnimationNavRoutes.InfiniteTransition) { InfiniteTransitionScreen() }
    composable(route = AnimationNavRoutes.RotateAnimation) { RotateAnimationScreen() }
    composable(route = AnimationNavRoutes.ScaleAnimation) { ScaleAnimationScreen() }
    composable(route = AnimationNavRoutes.SingleValueColorAnimation) { SingleValueColorAnimationScreen() }
    composable(route = AnimationNavRoutes.SingleValueFloatAnimation) { SingleValueFloatAnimationScreen() }
    composable(route = AnimationNavRoutes.SuspendAnimation) { SuspendAnimationScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addConstraintLayoutRoutes() {
    composable(route = ConstraintLayoutNavRoutes.Barrier) { BarrierScreen() }
    composable(route = ConstraintLayoutNavRoutes.Chain) { ChainScreen() }
    composable(route = ConstraintLayoutNavRoutes.Circular) { CircularScreen() }
    composable(route = ConstraintLayoutNavRoutes.ConstraintSet) { ConstraintSetScreen() }
    composable(route = ConstraintLayoutNavRoutes.CreateGuideline) { CreateGuidelineScreen() }
    composable(route = ConstraintLayoutNavRoutes.CreateRefs) { CreateRefsScreen() }
    composable(route = ConstraintLayoutNavRoutes.JsonConstraintSet) { JsonConstraintSetScreen() }
    composable(route = ConstraintLayoutNavRoutes.JsonConstraintSetWithVariables) { JsonConstraintSetWithVariablesScreen() }
    composable(route = ConstraintLayoutNavRoutes.MotionLayout1) { MotionLayout1Screen() }
    composable(route = ConstraintLayoutNavRoutes.MotionLayout2) { MotionLayout2Screen() }
    composable(route = ConstraintLayoutNavRoutes.MotionLayout3) { MotionLayout3Screen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addFoundationRoutes() {
    composable(route = FoundationNavRoutes.Background) { BackgroundScreen() }
    composable(route = FoundationNavRoutes.Border) { BorderScreen() }
    composable(route = FoundationNavRoutes.Canvas) { CanvasScreen() }
    composable(route = FoundationNavRoutes.Clickable) { ClickableScreen() }
    composable(route = FoundationNavRoutes.ClickableText) { ClickableTextScreen() }
    composable(route = FoundationNavRoutes.CombinedClickable) { CombinedClickableScreen() }
    composable(route = FoundationNavRoutes.Draggable) { DraggableScreen() }
    composable(route = FoundationNavRoutes.DragGestureDetector) { DragGestureDetectorScreen() }
    composable(route = FoundationNavRoutes.Focusable) { FocusableScreen() }
    composable(route = FoundationNavRoutes.Image) { ImageScreen() }
    composable(route = FoundationNavRoutes.InteractionSource) { InteractionSourceScreen() }
    composable(route = FoundationNavRoutes.LazyColumn) { LazyColumnScreen() }
    composable(route = FoundationNavRoutes.LazyGrid) { LazyGridScreen() }
    composable(route = FoundationNavRoutes.LazyRow) { LazyRowScreen() }
    composable(route = FoundationNavRoutes.LocalOverScrollConfiguration) { LocalOverScrollConfigurationScreen() }
    composable(route = FoundationNavRoutes.ProgressSemantics) { ProgressSemanticsScreen() }
    composable(route = FoundationNavRoutes.Scrollable) { ScrollableScreen() }
    composable(route = FoundationNavRoutes.Scroller) { ScrollerScreen() }
    composable(route = FoundationNavRoutes.SelectableGroup) { SelectableGroupScreen() }
    composable(route = FoundationNavRoutes.Selectable) { SelectableScreen() }
    composable(route = FoundationNavRoutes.SelectionContainer) { SelectionContainerScreen() }
    composable(route = FoundationNavRoutes.Shape) { ShapeScreen() }
    composable(route = FoundationNavRoutes.StickyHeader) { StickyHeaderScreen() }
    composable(route = FoundationNavRoutes.Toggeable) { ToggeableScreen() }
    composable(route = FoundationNavRoutes.Transformable) { TransformableScreen() }
    composable(route = FoundationNavRoutes.TransformGesture) { TransformGestureScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addFoundationLayoutRoutes() {
    composable(route = FoundationLayoutNavRoutes.AbsolutePadding) { AbsolutePaddingScreen() }
    composable(route = FoundationLayoutNavRoutes.AspectRatio) { AspectRationScreen() }
    composable(route = FoundationLayoutNavRoutes.Box) { BoxScreen() }
    composable(route = FoundationLayoutNavRoutes.BoxWithConstraints) { BoxWithConstraintsScreen() }
    composable(route = FoundationLayoutNavRoutes.Column) { ColumnScreen() }
    composable(route = FoundationLayoutNavRoutes.DefaultMinSize) { DefaultMinSizeScreen() }
    composable(route = FoundationLayoutNavRoutes.Intrinsic) { IntrinsicScreen() }
    composable(route = FoundationLayoutNavRoutes.MatchParentSize) { MatchParentSizeScreen() }
    composable(route = FoundationLayoutNavRoutes.Offset) { OffsetScreen() }
    composable(route = FoundationLayoutNavRoutes.PaddingFromBaseline) { PaddingFromBaselineScreen() }
    composable(route = FoundationLayoutNavRoutes.PaddingFrom) { PaddingFromScreen() }
    composable(route = FoundationLayoutNavRoutes.Padding) { PaddingScreen() }
    composable(route = FoundationLayoutNavRoutes.Row) { RowScreen() }
    composable(route = FoundationLayoutNavRoutes.Size) { SizeScreen() }
    composable(route = FoundationLayoutNavRoutes.Spacer) { SpacerScreen() }
    composable(route = FoundationLayoutNavRoutes.Weight) { WeightScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addMaterialRoutes() {
    composable(route = MaterialNavRoutes.AlertDialog) { AlertDialogScreen() }
    composable(route = MaterialNavRoutes.BackdropScaffold) { BackdropScaffoldScreen() }
    composable(route = MaterialNavRoutes.BadgedBox) { BadgedBoxScreen() }
    composable(route = MaterialNavRoutes.BottomAppBar) { BottomAppBarScreen() }
    composable(route = MaterialNavRoutes.BottomDrawer) { BottomDrawerScreen() }
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
    composable(route = MaterialNavRoutes.LocalAbsoluteElevation) { LocalAbsoluteElevationScreen() }
    composable(route = MaterialNavRoutes.LocalContentAlpha) { LocalContentAlphaScreen() }
    composable(route = MaterialNavRoutes.LocalContentColor) { LocalContentColorScreen() }
    composable(route = MaterialNavRoutes.MaterialTheme) { MaterialThemeScreen() }
    composable(route = MaterialNavRoutes.ModalBottomSheetLayout) { ModalBottomSheetLayoutScreen() }
    composable(route = MaterialNavRoutes.ModalDrawer) { ModalDrawerScreen() }
    composable(route = MaterialNavRoutes.NavigationRail) { NavigationRailScreen() }
    composable(route = MaterialNavRoutes.OutlinedTextField) { OutlinedTextFieldScreen() }
    composable(route = MaterialNavRoutes.Progress) { ProgressScreen() }
    composable(route = MaterialNavRoutes.RadioButton) { RadioButtonScreen() }
    composable(route = MaterialNavRoutes.RangeSlider) { RangeSliderScreen() }
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
    composable(route = MaterialNavRoutes.Text) { TextScreen() }
    composable(route = MaterialNavRoutes.TopAppBar) { TopAppBarScreen() }
    composable(route = MaterialNavRoutes.TriStateCheckbox) { TriStateCheckboxScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addMaterialIconsRoutes() {
    composable(route = MaterialIconsNavRoutes.Filled) { FilledScreen() }
    composable(route = MaterialIconsNavRoutes.Outlined) { OutlinedScreen() }
    composable(route = MaterialIconsNavRoutes.Rounded) { RoundedScreen() }
    composable(route = MaterialIconsNavRoutes.Sharp) { SharpScreen() }
    composable(route = MaterialIconsNavRoutes.TwoTone) { TwoToneScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addMaterialIconsExtended() {
    composable(route = MaterialIconsExtendedNavRoutes.ExtendedFilled) { ExtendedFilledScreen() }
    composable(route = MaterialIconsExtendedNavRoutes.ExtendedOutlined) { ExtendedOutlinedScreen() }
    composable(route = MaterialIconsExtendedNavRoutes.ExtendedRounded) { ExtendedRoundedScreen() }
    composable(route = MaterialIconsExtendedNavRoutes.ExtendedSharp) { ExtendedSharpScreen() }
    composable(route = MaterialIconsExtendedNavRoutes.ExtendedTwoTone) { ExtendedTwoToneScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addRuntimeRoutes() {
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
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addUiRoutes() {
    composable(route = UiNavRoutes.AlignmentLine) { AlignmentLineScreen() }
    composable(route = UiNavRoutes.Alpha) { AlphaScreen() }
    composable(route = UiNavRoutes.AndroidViewBinding) { AndroidViewBindingScreen() }
    composable(route = UiNavRoutes.AnnotatedString) { AnnotatedStringScreen() }
    composable(route = UiNavRoutes.Blur) { BlurScreen() }
    composable(route = UiNavRoutes.Brush) { BrushScreen() }
    composable(route = UiNavRoutes.Clip) { ClipScreen() }
    composable(route = UiNavRoutes.ClipToBounds) { ClipToBoundsScreen() }
    composable(route = UiNavRoutes.Color) { ColorScreen() }
    composable(route = UiNavRoutes.DebugInspectorInfo) { DebugInspectorInfoScreen() }
    composable(route = UiNavRoutes.Dialog) { DialogScreen() }
    composable(route = UiNavRoutes.Drawable) { DrawableScreen() }
    composable(route = UiNavRoutes.DrawBehind) { DrawBehindScreen() }
    composable(route = UiNavRoutes.DrawWithCache) { DrawWithCacheScreen() }
    composable(route = UiNavRoutes.DrawWithContent) { DrawWithContentScreen() }
    composable(route = UiNavRoutes.Font) { FontScreen() }
    composable(route = UiNavRoutes.GraphicsLayer) { GraphicsLayerScreen() }
    composable(route = UiNavRoutes.ImageBitmapToPixelMap) { ImageBitmapToPixelMapScreen() }
    composable(route = UiNavRoutes.Inspectable) { InspectableScreen() }
    composable(route = UiNavRoutes.LayoutId) { LayoutIdScreen() }
    composable(route = UiNavRoutes.Layout) { LayoutScreen() }
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
    composable(route = UiNavRoutes.LocalSoftwareKeyboardController) { LocalSoftwareKeyboardControllerScreen() }
    composable(route = UiNavRoutes.LocalTextInputService) { LocalTextInputServiceScreen() }
    composable(route = UiNavRoutes.LocalTextToolbar) { LocalTextToolbarScreen() }
    composable(route = UiNavRoutes.LocalUriHandler) { LocalUriHandlerScreen() }
    composable(route = UiNavRoutes.LocalViewConfiguration) { LocalViewConfigurationScreen() }
    composable(route = UiNavRoutes.LocalWindowInfo) { LocalWindowInfoScreen() }
    composable(route = UiNavRoutes.NestedScroll) { NestedScrollScreen() }
    composable(route = UiNavRoutes.OnGloballyPositioned) { OnGloballyPositionedScreen() }
    composable(route = UiNavRoutes.OnKeyEvent) { OnKeyEventScreen() }
    composable(route = UiNavRoutes.OnSizeChanged) { OnSizeChangedScreen() }
    composable(route = UiNavRoutes.Paint) { PaintScreen() }
    composable(route = UiNavRoutes.PathEffect) { PathEffectScreen() }
    composable(route = UiNavRoutes.PointerInput) { PointerInputScreen() }
    composable(route = UiNavRoutes.Popup) { PopupScreen() }
    composable(route = UiNavRoutes.Primitive) { PrimitiveScreen() }
    composable(route = UiNavRoutes.RelocationRequester) { RelocationRequesterScreen() }
    composable(route = UiNavRoutes.Rotate) { RotateScreen() }
    composable(route = UiNavRoutes.Scale) { ScaleScreen() }
    composable(route = UiNavRoutes.Shadow) { ShadowScreen() }
    composable(route = UiNavRoutes.SpanStyle) { SpanStyleScreen() }
    composable(route = UiNavRoutes.String) { StringScreen() }
    composable(route = UiNavRoutes.SubComposeLayout) { SubComposeLayoutScreen() }
    composable(route = UiNavRoutes.TestTag) { TestTagScreen() }
    composable(route = UiNavRoutes.TextDecoration) { TextDecorationScreen() }
    composable(route = UiNavRoutes.TextIndent) { TextIndentScreen() }
    composable(route = UiNavRoutes.VisualTransformation) { VisualTransformationScreen() }
    composable(route = UiNavRoutes.ZIndex) { ZIndexScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addViewModelRoutes() {
    composable(route = ViewModelNavRoutes.Flow) { ViewModelFlowScreen() }
    composable(route = ViewModelNavRoutes.LiveData) { ViewModelLiveDataScreen() }
    composable(route = ViewModelNavRoutes.State) { StateScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addCustomExamples() {
    composable(route = CustomExamplesNavRoutes.AdMobBanner) { AdMobBannerScreen() }
    composable(route = CustomExamplesNavRoutes.AnimatedDeleteList) { AnimatedDeleteListScreen() }
    composable(route = CustomExamplesNavRoutes.AnimatedExtendedFloatingActionButton) { AnimatedExtendedFloatingActionButtonScreen() }
    composable(route = CustomExamplesNavRoutes.AnimatedShowList) { AnimatedShowListScreen() }
    composable(route = CustomExamplesNavRoutes.AnimatedText) { AnimatedTextScreen() }
    composable(route = CustomExamplesNavRoutes.BarChart) { BarChartScreen() }
    composable(route = CustomExamplesNavRoutes.BottomRoundedArcShape) { BottomRoundedArcShapeScreen() }
    composable(route = CustomExamplesNavRoutes.CameraX) { CameraXScreen() }
    composable(route = CustomExamplesNavRoutes.CollapsingToolbar) { CollapsingToolbarScreen() }
    composable(route = CustomExamplesNavRoutes.ColorMatrix) { ColorMatrixScreen() }
    composable(route = CustomExamplesNavRoutes.CurvedScrollView) { CurvedScrollViewScreen() }
    composable(route = CustomExamplesNavRoutes.CurvedText) { CurvedTextScreen() }
    composable(route = CustomExamplesNavRoutes.FirstBaselineToTop) { FirstBaselineToTopScreen() }
    composable(route = CustomExamplesNavRoutes.MessageBubble) { MessageBubbleScreen() }
    composable(route = CustomExamplesNavRoutes.StaggeredGridList) { StaggeredGridListScreen() }
    composable(route = CustomExamplesNavRoutes.StyledText) { StyledTextScreen() }
    composable(route = CustomExamplesNavRoutes.TearDrop) { TearDropScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addExternalLibraries(
    navController: NavHostController,
    systemUiController: SystemUiController,
) {
    composable(route = ExternalLibrariesNavRoutes.Coil) { CoilScreen() }
    composable(route = ExternalLibrariesNavRoutes.CoilLandscapist) { CoilLandscapistScreen() }
    composable(route = ExternalLibrariesNavRoutes.ComposeBarcodes) { ComposeBarcodesScreen() }
    composable(route = ExternalLibrariesNavRoutes.ComposeCharts) { ComposeChartsScreen() }
    composable(route = ExternalLibrariesNavRoutes.ComposeMarkdown) { ComposeMarkdownScreen() }
    composable(route = ExternalLibrariesNavRoutes.ComposeNeumorphism) { ComposeNeumorphismScreen() }
    composable(route = ExternalLibrariesNavRoutes.ComposeRichTextPrinting) { ComposeRichTextPrintingScreen() }
    composable(route = ExternalLibrariesNavRoutes.ComposeRichTextSlideshow) { ComposeRichTextSlideshowScreen() }
    composable(route = ExternalLibrariesNavRoutes.ComposeRichTextUiMaterial) { ComposeRichTextUiMaterialScreen() }
    composable(route = ExternalLibrariesNavRoutes.ComposeRichTextUi) { ComposeRichTextUiScreen() }
    composable(route = ExternalLibrariesNavRoutes.ComposeZoomableImage) { ComposeZoomableImageScreen() }
    composable(route = ExternalLibrariesNavRoutes.DrawablePainterAccompanist) { DrawablePainterAccompanistScreen() }
    composable(route = ExternalLibrariesNavRoutes.FlowLayoutAccompanist) { FlowLayoutAccompanistScreen() }
    composable(route = ExternalLibrariesNavRoutes.FontAwesome) { FontAwesomeScreen() }
    composable(route = ExternalLibrariesNavRoutes.FrescoLandscapist) { FrescoLandscapistScreen() }
    composable(route = ExternalLibrariesNavRoutes.GlideLandscapist) { GlideLandscapistScreen() }
    composable(route = ExternalLibrariesNavRoutes.InsetsAccompanist) { InsetsAccompanistScreen() }
    composable(route = ExternalLibrariesNavRoutes.Lottie) { LottieScreen() }
    composable(route = ExternalLibrariesNavRoutes.NavigationAnimationAccompanist) { NavigationAnimationAccompanistScreen() }
    composable(route = ExternalLibrariesNavRoutes.NavigationMaterialAccompanist) { NavigationMaterialAccompanistScreen() }
    composable(route = ExternalLibrariesNavRoutes.OrchestraBalloon) { OrchestraBalloonScreen() }
    composable(route = ExternalLibrariesNavRoutes.OrchestraColorPicker) { OrchestraColorPickerScreen() }
    composable(route = ExternalLibrariesNavRoutes.OrchestraSpinner) { OrchestraSpinnerScreen() }
    composable(route = ExternalLibrariesNavRoutes.PagerAccompanist) { PagerAccompanistScreen() }
    composable(route = ExternalLibrariesNavRoutes.PaletteLandscapist) { PaletteLandscapistScreen() }
    composable(route = ExternalLibrariesNavRoutes.PermissionsAccompanist) { PermissionsAccompanistScreen() }
    composable(route = ExternalLibrariesNavRoutes.PlaceholderAccompanist) { PlaceholderAccompanistScreen() }
    composable(route = ExternalLibrariesNavRoutes.RatingBar) { RatingBarScreen() }
    composable(route = ExternalLibrariesNavRoutes.RevealSwipe) { RevealSwipeScreen() }
    composable(route = ExternalLibrariesNavRoutes.SpeedDialFloatingActionButton) { SpeedDialFloatingActionButtonScreen() }
    composable(route = ExternalLibrariesNavRoutes.StageStepBar) { StageStepBarScreen() }
    composable(route = ExternalLibrariesNavRoutes.SwipeRefreshAccompanist) { SwipeRefreshAccompanistScreen() }
    composable(route = ExternalLibrariesNavRoutes.SystemUiControllerAccompanist) {
        SystemUiControllerAccompanistScreen(
            navController,
            systemUiController
        )
    }
}