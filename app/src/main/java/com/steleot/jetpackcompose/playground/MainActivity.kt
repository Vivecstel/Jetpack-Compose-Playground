package com.steleot.jetpackcompose.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.android.gms.ads.MobileAds
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import com.steleot.jetpackcompose.playground.compose.MainScreen
import com.steleot.jetpackcompose.playground.compose.SearchScreen
import com.steleot.jetpackcompose.playground.compose.SettingsScreen
import com.steleot.jetpackcompose.playground.compose.activity.ActivityScreen
import com.steleot.jetpackcompose.playground.compose.activity.BackHandlerScreen
import com.steleot.jetpackcompose.playground.compose.activity.LauncherForActivityResultScreen
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
import com.steleot.jetpackcompose.playground.compose.runtime.*
import com.steleot.jetpackcompose.playground.compose.ui.*
import com.steleot.jetpackcompose.playground.compose.viewmodel.StateScreen
import com.steleot.jetpackcompose.playground.compose.viewmodel.ViewModelFlowScreen
import com.steleot.jetpackcompose.playground.compose.viewmodel.ViewModelLiveDataScreen
import com.steleot.jetpackcompose.playground.compose.viewmodel.ViewModelScreen
import com.steleot.jetpackcompose.playground.helpers.InAppReviewHelper
import com.steleot.jetpackcompose.playground.theme.JetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject
import com.steleot.jetpackcompose.playground.compose.ui.LayoutScreen as UiLayoutScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var inAppReviewHelper: InAppReviewHelper

    @Inject
    lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        MobileAds.initialize(this)
        setContent {
            JetpackComposeApp(inAppReviewHelper, firebaseAnalytics)
        }
    }
}

@Composable
fun JetpackComposeApp(
    inAppReviewHelper: InAppReviewHelper,
    firebaseAnalytics: FirebaseAnalytics,
) {
    JetpackComposeTheme {
        ProvideWindowInsets {
            CompositionLocalProvider(LocalInAppReviewer provides inAppReviewHelper) {
                val navController = rememberNavController()
                navController.addOnDestinationChangedListener { _, destination, _ ->
                    destination.route?.let { route ->
                        Timber.d("Route : $route")
                        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
                            param(FirebaseAnalytics.Param.SCREEN_NAME, route)
                        }
                    }
                }
                NavHost(navController = navController, startDestination = MainNavRoutes.Main) {
                    /* main */
                    composable(route = MainNavRoutes.Main) {
                        MainScreen(
                            navController,
                            showSettings = true
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
                    composable(route = MainNavRoutes.Foundation) { FoundationScreen(navController) }
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
                        SettingsScreen(hiltViewModel(it))
                    }
                    /* activity */
                    composable(route = ActivityNavRoutes.BackHandler) {
                        BackHandlerScreen(
                            navController
                        )
                    }
                    composable(route = ActivityNavRoutes.LauncherForActivityResult) { LauncherForActivityResultScreen() }
                    /* animation */
                    composable(route = AnimationNavRoutes.Animatable) { AnimatableScreen() }
                    composable(route = AnimationNavRoutes.AnimatedValues) { AnimatedValuesScreen() }
                    composable(route = AnimationNavRoutes.AnimatedVisibility) { AnimatedVisibilityScreen() }
                    composable(route = AnimationNavRoutes.AnimationModifier) { AnimationModifierScreen() }
                    composable(route = AnimationNavRoutes.CrossfadeAnimation) { CrossfadeAnimationScreen() }
                    composable(route = AnimationNavRoutes.DoubleTapToLike) { DoubleTapToLikeScreen() }
                    composable(route = AnimationNavRoutes.GestureAnimation) { GestureAnimationScreen() }
                    composable(route = AnimationNavRoutes.InfiniteTransition) { InfiniteTransitionScreen() }
                    composable(route = AnimationNavRoutes.RotatingShape) { RotatingShapeScreen() }
                    composable(route = AnimationNavRoutes.SingleValueColorAnimation) { SingleValueColorAnimationScreen() }
                    composable(route = AnimationNavRoutes.SingleValueFloatAnimation) { SingleValueFloatAnimationScreen() }
                    composable(route = AnimationNavRoutes.SuspendAnimation) { SuspendAnimationScreen() }
                    /* constraint layout */
                    composable(route = ConstraintLayoutNavRoutes.Barrier) { BarrierScreen() }
                    composable(route = ConstraintLayoutNavRoutes.Chain) { ChainScreen() }
                    composable(route = ConstraintLayoutNavRoutes.ConstraintSet) { ConstraintSetScreen() }
                    composable(route = ConstraintLayoutNavRoutes.CreateRefs) { CreateRefsScreen() }
                    /* foundation */
                    composable(route = FoundationNavRoutes.Background) { BackgroundScreen() }
                    composable(route = FoundationNavRoutes.Border) { BorderScreen() }
                    composable(route = FoundationNavRoutes.Canvas) { CanvasScreen() }
                    composable(route = FoundationNavRoutes.Clickable) { ClickableScreen() }
                    composable(route = FoundationNavRoutes.ClickableText) { ClickableTextScreen() }
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
                    composable(route = FoundationNavRoutes.SelectionContainer) { SelectionContainerScreen() }
                    composable(route = FoundationNavRoutes.Shape) { ShapeScreen() }
                    composable(route = FoundationNavRoutes.StickyHeader) { StickyHeaderScreen() }
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
                    composable(route = MaterialNavRoutes.LocalContentAlpha) { LocalContentAlphaScreen() }
                    composable(route = MaterialNavRoutes.LocalContentColor) { LocalContentColorScreen() }
                    composable(route = MaterialNavRoutes.ModalBottomSheetLayout) { ModalBottomSheetLayoutScreen() }
                    composable(route = MaterialNavRoutes.ModalDrawer) { ModalDrawerScreen() }
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
                    composable(route = MaterialNavRoutes.Text) { TextScreen() }
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
                    composable(route = UiNavRoutes.Clip) { ClipScreen() }
                    composable(route = UiNavRoutes.Color) { ColorScreen() }
                    composable(route = UiNavRoutes.DebugInspectorInfo) { DebugInspectorInfoScreen() }
                    composable(route = UiNavRoutes.Dialog) { DialogScreen() }
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
                    composable(route = UiNavRoutes.LocalSoftwareKeyboardController) { LocalSoftwareKeyboardControllerScreen() }
                    composable(route = UiNavRoutes.LocalTextInputService) { LocalTextInputServiceScreen() }
                    composable(route = UiNavRoutes.LocalTextToolbar) { LocalTextToolbarScreen() }
                    composable(route = UiNavRoutes.LocalUriHandler) { LocalUriHandlerScreen() }
                    composable(route = UiNavRoutes.LocalViewConfiguration) { LocalViewConfigurationScreen() }
                    composable(route = UiNavRoutes.LocalWindowInfo) { LocalWindowInfoScreen() }
                    composable(route = UiNavRoutes.NestedScroll) { NestedScrollScreen() }
                    composable(route = UiNavRoutes.OnGloballyPositioned) { OnGloballyPositionedScreen() }
                    composable(route = UiNavRoutes.OnSizeChanged) { OnSizeChangedScreen() }
                    composable(route = UiNavRoutes.PathEffect) { PathEffectScreen() }
                    composable(route = UiNavRoutes.Popup) { PopupScreen() }
                    composable(route = UiNavRoutes.Primitive) { PrimitiveScreen() }
                    composable(route = UiNavRoutes.Rotate) { RotateScreen() }
                    composable(route = UiNavRoutes.Scale) { ScaleScreen() }
                    composable(route = UiNavRoutes.Shadow) { ShadowScreen() }
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
                    /* custom examples */
                    composable(route = CustomExamplesNavRoutes.AdMobBanner) { AdMobBannerScreen() }
                    composable(route = CustomExamplesNavRoutes.AnimatedDeleteList) { AnimatedDeleteListScreen() }
                    composable(route = CustomExamplesNavRoutes.AnimatedExtendedFloatingActionButton) { AnimatedExtendedFloatingActionButtonScreen() }
                    composable(route = CustomExamplesNavRoutes.AnimatedShowList) { AnimatedShowListScreen() }
                    composable(route = CustomExamplesNavRoutes.AnimatedText) { AnimatedTextScreen() }
                    composable(route = CustomExamplesNavRoutes.CameraX) { CameraXScreen() }
                    composable(route = CustomExamplesNavRoutes.CollapsingToolbar) { CollapsingToolbarScreen() }
                    composable(route = CustomExamplesNavRoutes.FirstBaselineToTop) { FirstBaselineToTopScreen() }
                    composable(route = CustomExamplesNavRoutes.StaggeredGridList) { StaggeredGridListScreen() }
                    /* external */
                    composable(route = ExternalLibrariesNavRoutes.CoilAccompanist) { CoilAccompanistScreen() }
                    composable(route = ExternalLibrariesNavRoutes.CoilLandscapist) { CoilLandscapistScreen() }
                    composable(route = ExternalLibrariesNavRoutes.FlowLayout) { FlowLayoutScreen() }
                    composable(route = ExternalLibrariesNavRoutes.FrescoLandscapist) { FrescoLandscapistScreen() }
                    composable(route = ExternalLibrariesNavRoutes.GlideAccompanist) { GlideAccompanistScreen() }
                    composable(route = ExternalLibrariesNavRoutes.GlideLandscapist) { GlideLandscapistScreen() }
                    composable(route = ExternalLibrariesNavRoutes.Insets) { InsetsScreen() }
                    composable(route = ExternalLibrariesNavRoutes.Lottie) { LottieScreen() }
                    composable(route = ExternalLibrariesNavRoutes.OrchestraBalloon) { OrchestraBalloonScreen() }
                    composable(route = ExternalLibrariesNavRoutes.OrchestraColorPicker) { OrchestraColorPickerScreen() }
                    composable(route = ExternalLibrariesNavRoutes.OrchestraSpinner) { OrchestraSpinnerScreen() }
                    composable(route = ExternalLibrariesNavRoutes.Pager) { PagerScreen() }
                    composable(route = ExternalLibrariesNavRoutes.RatingBar) { RatingBarScreen() }
                    composable(route = ExternalLibrariesNavRoutes.RevealSwipe) { RevealSwipeScreen() }
                    composable(route = ExternalLibrariesNavRoutes.SpeedDialFloatingActionButton) { SpeedDialFloatingActionButtonScreen() }
                    composable(route = ExternalLibrariesNavRoutes.SwipeRefresh) { SwipeRefreshScreen() }
                    composable(route = ExternalLibrariesNavRoutes.SystemUiController) {
                        SystemUiControllerScreen(
                            navController
                        )
                    }
                }
            }
        }
    }
}

val LocalInAppReviewer = staticCompositionLocalOf<InAppReviewHelper> {
    error("CompositionLocal InAppReviewHelper not present")
}
