package com.steleot.jetpackcompose.playground.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.steleot.jetpackcompose.playground.compose.activity.ActivityScreen
import com.steleot.jetpackcompose.playground.compose.activity.BackHandlerScreen
import com.steleot.jetpackcompose.playground.compose.activity.LauncherForActivityResult1Screen
import com.steleot.jetpackcompose.playground.compose.activity.LauncherForActivityResult2Screen
import com.steleot.jetpackcompose.playground.compose.animation.AnimatableScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimateEnterExitScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimatedContentScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimatedValuesScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimatedVectorScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimatedVisibilityScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimationModifierScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimationScreen
import com.steleot.jetpackcompose.playground.compose.animation.CrossfadeAnimationScreen
import com.steleot.jetpackcompose.playground.compose.animation.DoubleTapToLikeScreen
import com.steleot.jetpackcompose.playground.compose.animation.ElevationAnimationScreen
import com.steleot.jetpackcompose.playground.compose.animation.GestureAnimationScreen
import com.steleot.jetpackcompose.playground.compose.animation.InfiniteTransitionScreen
import com.steleot.jetpackcompose.playground.compose.animation.RotateAnimationScreen
import com.steleot.jetpackcompose.playground.compose.animation.ScaleAnimationScreen
import com.steleot.jetpackcompose.playground.compose.animation.SingleValueColorAnimationScreen
import com.steleot.jetpackcompose.playground.compose.animation.SingleValueFloatAnimationScreen
import com.steleot.jetpackcompose.playground.compose.animation.SuspendAnimationScreen
import com.steleot.jetpackcompose.playground.compose.constraintlayout.BarrierScreen
import com.steleot.jetpackcompose.playground.compose.constraintlayout.ChainScreen
import com.steleot.jetpackcompose.playground.compose.constraintlayout.CircularScreen
import com.steleot.jetpackcompose.playground.compose.constraintlayout.ConstraintLayoutScreen
import com.steleot.jetpackcompose.playground.compose.constraintlayout.ConstraintSetScreen
import com.steleot.jetpackcompose.playground.compose.constraintlayout.CreateGuidelineScreen
import com.steleot.jetpackcompose.playground.compose.constraintlayout.CreateRefsScreen
import com.steleot.jetpackcompose.playground.compose.constraintlayout.JsonConstraintSetScreen
import com.steleot.jetpackcompose.playground.compose.constraintlayout.JsonConstraintSetWithVariablesScreen
import com.steleot.jetpackcompose.playground.compose.constraintlayout.MotionLayout1Screen
import com.steleot.jetpackcompose.playground.compose.constraintlayout.MotionLayout2Screen
import com.steleot.jetpackcompose.playground.compose.constraintlayout.MotionLayout3Screen
import com.steleot.jetpackcompose.playground.compose.customexamples.AdMobBannerScreen
import com.steleot.jetpackcompose.playground.compose.customexamples.AnimatedDeleteListScreen
import com.steleot.jetpackcompose.playground.compose.customexamples.AnimatedExtendedFloatingActionButtonScreen
import com.steleot.jetpackcompose.playground.compose.customexamples.AnimatedShowListScreen
import com.steleot.jetpackcompose.playground.compose.customexamples.AnimatedTextScreen
import com.steleot.jetpackcompose.playground.compose.customexamples.BarChartScreen
import com.steleot.jetpackcompose.playground.compose.customexamples.BottomRoundedArcShapeScreen
import com.steleot.jetpackcompose.playground.compose.customexamples.CameraXScreen
import com.steleot.jetpackcompose.playground.compose.customexamples.CollapsingToolbarScreen
import com.steleot.jetpackcompose.playground.compose.customexamples.ColorMatrixScreen
import com.steleot.jetpackcompose.playground.compose.customexamples.CurvedScrollViewScreen
import com.steleot.jetpackcompose.playground.compose.customexamples.CurvedTextScreen
import com.steleot.jetpackcompose.playground.compose.customexamples.CustomExamplesScreen
import com.steleot.jetpackcompose.playground.compose.customexamples.FirstBaselineToTopScreen
import com.steleot.jetpackcompose.playground.compose.customexamples.MessageBubbleScreen
import com.steleot.jetpackcompose.playground.compose.customexamples.StaggeredGridListScreen
import com.steleot.jetpackcompose.playground.compose.customexamples.StyledTextScreen
import com.steleot.jetpackcompose.playground.compose.customexamples.TearDropScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.CoilLandscapistScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.CoilScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.ComposeBarcodesScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.ComposeChartsScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.ComposeMarkdownScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.ComposeNeumorphismScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.ComposeParticleSystemScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.ComposeRichTextPrintingScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.ComposeRichTextSlideshowScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.ComposeRichTextUiMaterialScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.ComposeRichTextUiScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.ComposeTimelineViewScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.ComposeZoomableImageScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.DrawablePainterAccompanistScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.ExternalLibrariesScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.FlowLayoutAccompanistScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.FontAwesomeScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.FrescoLandscapistScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.GapScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.GlideLandscapistScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.HtmlTextScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.InsetsAccompanistScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.LottieScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.NavigationAnimationAccompanistScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.NavigationMaterialAccompanistScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.OrchestraBalloonScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.OrchestraColorPickerScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.OrchestraSpinnerScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.PagerAccompanistScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.PaletteLandscapistScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.PermissionsAccompanistScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.PlaceholderAccompanistScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.PlotScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.RatingBarScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.RevealSwipeScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.SSJetPackComposeProgressButtonScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.SnapperScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.SpeedDialFloatingActionButtonScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.StageStepBarScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.SwipeRefreshAccompanistScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.SystemUiControllerAccompanistScreen
import com.steleot.jetpackcompose.playground.compose.foundation.AbsolutePaddingScreen
import com.steleot.jetpackcompose.playground.compose.foundation.AspectRationScreen
import com.steleot.jetpackcompose.playground.compose.foundation.BackgroundScreen
import com.steleot.jetpackcompose.playground.compose.foundation.BorderScreen
import com.steleot.jetpackcompose.playground.compose.foundation.BoxScreen
import com.steleot.jetpackcompose.playground.compose.foundation.BoxWithConstraintsScreen
import com.steleot.jetpackcompose.playground.compose.foundation.BringIntoViewRequesterScreen
import com.steleot.jetpackcompose.playground.compose.foundation.CanvasScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ClickableScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ClickableTextScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ColumnScreen
import com.steleot.jetpackcompose.playground.compose.foundation.CombinedClickableScreen
import com.steleot.jetpackcompose.playground.compose.foundation.DefaultMinSizeScreen
import com.steleot.jetpackcompose.playground.compose.foundation.DragGestureDetectorScreen
import com.steleot.jetpackcompose.playground.compose.foundation.DraggableScreen
import com.steleot.jetpackcompose.playground.compose.foundation.FocusableScreen
import com.steleot.jetpackcompose.playground.compose.foundation.FoundationScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ImageScreen
import com.steleot.jetpackcompose.playground.compose.foundation.InteractionSourceScreen
import com.steleot.jetpackcompose.playground.compose.foundation.IntrinsicScreen
import com.steleot.jetpackcompose.playground.compose.foundation.LazyColumnScreen
import com.steleot.jetpackcompose.playground.compose.foundation.LazyGridScreen
import com.steleot.jetpackcompose.playground.compose.foundation.LazyRowScreen
import com.steleot.jetpackcompose.playground.compose.foundation.LocalOverScrollConfigurationScreen
import com.steleot.jetpackcompose.playground.compose.foundation.MatchParentSizeScreen
import com.steleot.jetpackcompose.playground.compose.foundation.OffsetScreen
import com.steleot.jetpackcompose.playground.compose.foundation.PaddingFromBaselineScreen
import com.steleot.jetpackcompose.playground.compose.foundation.PaddingFromScreen
import com.steleot.jetpackcompose.playground.compose.foundation.PaddingScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ProgressSemanticsScreen
import com.steleot.jetpackcompose.playground.compose.foundation.RowScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ScrollableScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ScrollerScreen
import com.steleot.jetpackcompose.playground.compose.foundation.SelectableGroupScreen
import com.steleot.jetpackcompose.playground.compose.foundation.SelectableScreen
import com.steleot.jetpackcompose.playground.compose.foundation.SelectionContainerScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ShapeScreen
import com.steleot.jetpackcompose.playground.compose.foundation.SizeScreen
import com.steleot.jetpackcompose.playground.compose.foundation.SpacerScreen
import com.steleot.jetpackcompose.playground.compose.foundation.StickyHeaderScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ToggeableScreen
import com.steleot.jetpackcompose.playground.compose.foundation.TransformGestureScreen
import com.steleot.jetpackcompose.playground.compose.foundation.TransformableScreen
import com.steleot.jetpackcompose.playground.compose.foundation.WeightScreen
import com.steleot.jetpackcompose.playground.compose.material.AlertDialogScreen
import com.steleot.jetpackcompose.playground.compose.material.BackdropScaffoldScreen
import com.steleot.jetpackcompose.playground.compose.material.BadgedBoxScreen
import com.steleot.jetpackcompose.playground.compose.material.BottomAppBarScreen
import com.steleot.jetpackcompose.playground.compose.material.BottomDrawerScreen
import com.steleot.jetpackcompose.playground.compose.material.BottomNavigationScreen
import com.steleot.jetpackcompose.playground.compose.material.BottomSheetScaffoldScreen
import com.steleot.jetpackcompose.playground.compose.material.ButtonScreen
import com.steleot.jetpackcompose.playground.compose.material.CardScreen
import com.steleot.jetpackcompose.playground.compose.material.CheckboxScreen
import com.steleot.jetpackcompose.playground.compose.material.DividerScreen
import com.steleot.jetpackcompose.playground.compose.material.DropdownMenuScreen
import com.steleot.jetpackcompose.playground.compose.material.ElevationScreen
import com.steleot.jetpackcompose.playground.compose.material.ExposedDropdownMenuBoxScreen
import com.steleot.jetpackcompose.playground.compose.material.ExtendedFloatingActionButtonScreen
import com.steleot.jetpackcompose.playground.compose.material.FloatingActionButtonScreen
import com.steleot.jetpackcompose.playground.compose.material.IconButtonScreen
import com.steleot.jetpackcompose.playground.compose.material.IconScreen
import com.steleot.jetpackcompose.playground.compose.material.IconToggleButtonScreen
import com.steleot.jetpackcompose.playground.compose.material.ListItemScreen
import com.steleot.jetpackcompose.playground.compose.material.LocalAbsoluteElevationScreen
import com.steleot.jetpackcompose.playground.compose.material.LocalContentAlphaScreen
import com.steleot.jetpackcompose.playground.compose.material.LocalContentColorScreen
import com.steleot.jetpackcompose.playground.compose.material.MaterialScreen
import com.steleot.jetpackcompose.playground.compose.material.MaterialThemeScreen
import com.steleot.jetpackcompose.playground.compose.material.ModalBottomSheetLayoutScreen
import com.steleot.jetpackcompose.playground.compose.material.ModalDrawerScreen
import com.steleot.jetpackcompose.playground.compose.material.NavigationRailScreen
import com.steleot.jetpackcompose.playground.compose.material.OutlinedTextFieldScreen
import com.steleot.jetpackcompose.playground.compose.material.ProgressScreen
import com.steleot.jetpackcompose.playground.compose.material.RadioButtonScreen
import com.steleot.jetpackcompose.playground.compose.material.RangeSliderScreen
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
import com.steleot.jetpackcompose.playground.compose.material.TextScreen
import com.steleot.jetpackcompose.playground.compose.material.TopAppBarScreen
import com.steleot.jetpackcompose.playground.compose.material.TriStateCheckboxScreen
import com.steleot.jetpackcompose.playground.compose.material3.AlertDialog3Screen
import com.steleot.jetpackcompose.playground.compose.material3.BadgeScreen
import com.steleot.jetpackcompose.playground.compose.material3.BadgedBox3Screen
import com.steleot.jetpackcompose.playground.compose.material3.Button3Screen
import com.steleot.jetpackcompose.playground.compose.material3.CenterAlignedTopAppBarScreen
import com.steleot.jetpackcompose.playground.compose.material3.ElevatedButtonScreen
import com.steleot.jetpackcompose.playground.compose.material3.ExtendedFloatingActionButton3Screen
import com.steleot.jetpackcompose.playground.compose.material3.FilledTonalButtonScreen
import com.steleot.jetpackcompose.playground.compose.material3.FloatingActionButton3Screen
import com.steleot.jetpackcompose.playground.compose.material3.Icon3Screen
import com.steleot.jetpackcompose.playground.compose.material3.IconButton3Screen
import com.steleot.jetpackcompose.playground.compose.material3.IconToggleButton3Screen
import com.steleot.jetpackcompose.playground.compose.material3.LargeFloatingActionButtonScreen
import com.steleot.jetpackcompose.playground.compose.material3.LargeTopAppBarScreen
import com.steleot.jetpackcompose.playground.compose.material3.LocalContentColor3Screen
import com.steleot.jetpackcompose.playground.compose.material3.LocalMinimumTouchTargetEnforcementScreen
import com.steleot.jetpackcompose.playground.compose.material3.LocalTextStyleScreen
import com.steleot.jetpackcompose.playground.compose.material3.Material3Screen
import com.steleot.jetpackcompose.playground.compose.material3.MaterialTheme3Screen
import com.steleot.jetpackcompose.playground.compose.material3.MediumTopAppBarScreen
import com.steleot.jetpackcompose.playground.compose.material3.NavigationBarScreen
import com.steleot.jetpackcompose.playground.compose.material3.NavigationDrawerScreen
import com.steleot.jetpackcompose.playground.compose.material3.NavigationRail3Screen
import com.steleot.jetpackcompose.playground.compose.material3.OutlinedButtonScreen
import com.steleot.jetpackcompose.playground.compose.material3.Scaffold3Screen
import com.steleot.jetpackcompose.playground.compose.material3.SmallFloatingActionButtonScreen
import com.steleot.jetpackcompose.playground.compose.material3.SmallTopAppBarScreen
import com.steleot.jetpackcompose.playground.compose.material3.Surface3Screen
import com.steleot.jetpackcompose.playground.compose.material3.Text3Screen
import com.steleot.jetpackcompose.playground.compose.material3.TextButtonScreen
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
import com.steleot.jetpackcompose.playground.compose.navigation.NavigationScreen
import com.steleot.jetpackcompose.playground.compose.paging.PagingScreen
import com.steleot.jetpackcompose.playground.compose.rest.MainScreenWithDrawer
import com.steleot.jetpackcompose.playground.compose.rest.PopularScreen
import com.steleot.jetpackcompose.playground.compose.rest.ReleaseNotesScreen
import com.steleot.jetpackcompose.playground.compose.rest.SearchScreen
import com.steleot.jetpackcompose.playground.compose.rest.SettingsScreen
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
import com.steleot.jetpackcompose.playground.compose.ui.AnnotatedStringScreen
import com.steleot.jetpackcompose.playground.compose.ui.BlurScreen
import com.steleot.jetpackcompose.playground.compose.ui.BrushScreen
import com.steleot.jetpackcompose.playground.compose.ui.ClipScreen
import com.steleot.jetpackcompose.playground.compose.ui.ClipToBoundsScreen
import com.steleot.jetpackcompose.playground.compose.ui.ColorScreen
import com.steleot.jetpackcompose.playground.compose.ui.DebugInspectorInfoScreen
import com.steleot.jetpackcompose.playground.compose.ui.DialogScreen
import com.steleot.jetpackcompose.playground.compose.ui.DrawBehindScreen
import com.steleot.jetpackcompose.playground.compose.ui.DrawWithCacheScreen
import com.steleot.jetpackcompose.playground.compose.ui.DrawWithContentScreen
import com.steleot.jetpackcompose.playground.compose.ui.DrawableScreen
import com.steleot.jetpackcompose.playground.compose.ui.FontScreen
import com.steleot.jetpackcompose.playground.compose.ui.GraphicsLayerScreen
import com.steleot.jetpackcompose.playground.compose.ui.ImageBitmapToPixelMapScreen
import com.steleot.jetpackcompose.playground.compose.ui.InspectableScreen
import com.steleot.jetpackcompose.playground.compose.ui.LayoutIdScreen
import com.steleot.jetpackcompose.playground.compose.ui.LayoutScreen
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
import com.steleot.jetpackcompose.playground.compose.ui.LocalSoftwareKeyboardControllerScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalTextInputServiceScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalTextToolbarScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalUriHandlerScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalViewConfigurationScreen
import com.steleot.jetpackcompose.playground.compose.ui.LocalWindowInfoScreen
import com.steleot.jetpackcompose.playground.compose.ui.ModifierLocalScreen
import com.steleot.jetpackcompose.playground.compose.ui.NestedScrollScreen
import com.steleot.jetpackcompose.playground.compose.ui.OnGloballyPositionedScreen
import com.steleot.jetpackcompose.playground.compose.ui.OnKeyEventScreen
import com.steleot.jetpackcompose.playground.compose.ui.OnSizeChangedScreen
import com.steleot.jetpackcompose.playground.compose.ui.PaintScreen
import com.steleot.jetpackcompose.playground.compose.ui.PathEffectScreen
import com.steleot.jetpackcompose.playground.compose.ui.PointerInputScreen
import com.steleot.jetpackcompose.playground.compose.ui.PopupScreen
import com.steleot.jetpackcompose.playground.compose.ui.PrimitiveScreen
import com.steleot.jetpackcompose.playground.compose.ui.RotateScreen
import com.steleot.jetpackcompose.playground.compose.ui.ScaleScreen
import com.steleot.jetpackcompose.playground.compose.ui.ShadowScreen
import com.steleot.jetpackcompose.playground.compose.ui.SpanStyleScreen
import com.steleot.jetpackcompose.playground.compose.ui.StringScreen
import com.steleot.jetpackcompose.playground.compose.ui.SubComposeLayoutScreen
import com.steleot.jetpackcompose.playground.compose.ui.TestTagScreen
import com.steleot.jetpackcompose.playground.compose.ui.TextDecorationScreen
import com.steleot.jetpackcompose.playground.compose.ui.TextIndentScreen
import com.steleot.jetpackcompose.playground.compose.ui.UiScreen
import com.steleot.jetpackcompose.playground.compose.ui.VisualTransformationScreen
import com.steleot.jetpackcompose.playground.compose.ui.ZIndexScreen
import com.steleot.jetpackcompose.playground.compose.viewmodel.StateScreen
import com.steleot.jetpackcompose.playground.compose.viewmodel.ViewModelFlowScreen
import com.steleot.jetpackcompose.playground.compose.viewmodel.ViewModelLiveDataScreen
import com.steleot.jetpackcompose.playground.compose.viewmodel.ViewModelScreen
import com.steleot.jetpackcompose.playground.theme.ThemeState

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addMainRoutes(
    navController: NavHostController,
    firebaseAuth: FirebaseAuth,
    googleSignInClient: GoogleSignInClient,
    theme: ThemeState,
    setTheme: (ThemeState) -> Unit,
    setUser: (FirebaseUser?) -> Unit,
) {
    composable(route = MainNavRoutes.Main) {
        MainScreenWithDrawer(
            navController, firebaseAuth, googleSignInClient, setUser = setUser
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
    composable(route = MainNavRoutes.Material) { MaterialScreen(navController) }
    composable(route = MainNavRoutes.Material3) { Material3Screen(navController) }
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
    composable(route = MainNavRoutes.ReleaseNotes) {
        ReleaseNotesScreen(
            hiltViewModel(it),
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
    composable(route = ConstraintLayoutNavRoutes.JsonConstraintSetWithVariables) {
        JsonConstraintSetWithVariablesScreen()
    }
    composable(route = ConstraintLayoutNavRoutes.MotionLayout1) { MotionLayout1Screen() }
    composable(route = ConstraintLayoutNavRoutes.MotionLayout2) { MotionLayout2Screen() }
    composable(route = ConstraintLayoutNavRoutes.MotionLayout3) { MotionLayout3Screen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addFoundationRoutes() {
    composable(route = FoundationNavRoutes.AbsolutePadding) { AbsolutePaddingScreen() }
    composable(route = FoundationNavRoutes.AspectRatio) { AspectRationScreen() }
    composable(route = FoundationNavRoutes.Background) { BackgroundScreen() }
    composable(route = FoundationNavRoutes.Border) { BorderScreen() }
    composable(route = FoundationNavRoutes.Box) { BoxScreen() }
    composable(route = FoundationNavRoutes.BoxWithConstraints) { BoxWithConstraintsScreen() }
    composable(route = FoundationNavRoutes.BringIntoViewRequester) { BringIntoViewRequesterScreen() }
    composable(route = FoundationNavRoutes.Canvas) { CanvasScreen() }
    composable(route = FoundationNavRoutes.Clickable) { ClickableScreen() }
    composable(route = FoundationNavRoutes.ClickableText) { ClickableTextScreen() }
    composable(route = FoundationNavRoutes.Column) { ColumnScreen() }
    composable(route = FoundationNavRoutes.CombinedClickable) { CombinedClickableScreen() }
    composable(route = FoundationNavRoutes.DefaultMinSize) { DefaultMinSizeScreen() }
    composable(route = FoundationNavRoutes.Draggable) { DraggableScreen() }
    composable(route = FoundationNavRoutes.DragGestureDetector) { DragGestureDetectorScreen() }
    composable(route = FoundationNavRoutes.Focusable) { FocusableScreen() }
    composable(route = FoundationNavRoutes.Image) { ImageScreen() }
    composable(route = FoundationNavRoutes.InteractionSource) { InteractionSourceScreen() }
    composable(route = FoundationNavRoutes.Intrinsic) { IntrinsicScreen() }
    composable(route = FoundationNavRoutes.LazyColumn) { LazyColumnScreen() }
    composable(route = FoundationNavRoutes.LazyGrid) { LazyGridScreen() }
    composable(route = FoundationNavRoutes.LazyRow) { LazyRowScreen() }
    composable(route = FoundationNavRoutes.LocalOverScrollConfiguration) { LocalOverScrollConfigurationScreen() }
    composable(route = FoundationNavRoutes.MatchParentSize) { MatchParentSizeScreen() }
    composable(route = FoundationNavRoutes.Offset) { OffsetScreen() }
    composable(route = FoundationNavRoutes.PaddingFromBaseline) { PaddingFromBaselineScreen() }
    composable(route = FoundationNavRoutes.PaddingFrom) { PaddingFromScreen() }
    composable(route = FoundationNavRoutes.Padding) { PaddingScreen() }
    composable(route = FoundationNavRoutes.ProgressSemantics) { ProgressSemanticsScreen() }
    composable(route = FoundationNavRoutes.Row) { RowScreen() }
    composable(route = FoundationNavRoutes.Scrollable) { ScrollableScreen() }
    composable(route = FoundationNavRoutes.Scroller) { ScrollerScreen() }
    composable(route = FoundationNavRoutes.SelectableGroup) { SelectableGroupScreen() }
    composable(route = FoundationNavRoutes.Selectable) { SelectableScreen() }
    composable(route = FoundationNavRoutes.SelectionContainer) { SelectionContainerScreen() }
    composable(route = FoundationNavRoutes.Shape) { ShapeScreen() }
    composable(route = FoundationNavRoutes.Size) { SizeScreen() }
    composable(route = FoundationNavRoutes.Spacer) { SpacerScreen() }
    composable(route = FoundationNavRoutes.StickyHeader) { StickyHeaderScreen() }
    composable(route = FoundationNavRoutes.Toggeable) { ToggeableScreen() }
    composable(route = FoundationNavRoutes.Transformable) { TransformableScreen() }
    composable(route = FoundationNavRoutes.TransformGesture) { TransformGestureScreen() }
    composable(route = FoundationNavRoutes.Weight) { WeightScreen() }
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
    composable(route = MaterialNavRoutes.ExposedDropdownMenuBox) { ExposedDropdownMenuBoxScreen() }
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
fun NavGraphBuilder.addMaterial3Routes() {
    composable(route = Material3NavRoutes.AlertDialog3) { AlertDialog3Screen() }
    composable(route = Material3NavRoutes.BadgedBox3) { BadgedBox3Screen() }
    composable(route = Material3NavRoutes.Badge) { BadgeScreen() }
    composable(route = Material3NavRoutes.Button3) { Button3Screen() }
    composable(route = Material3NavRoutes.CenterAlignedTopAppBar) { CenterAlignedTopAppBarScreen() }
    composable(route = Material3NavRoutes.ElevatedButton) { ElevatedButtonScreen() }
    composable(route = Material3NavRoutes.ExtendedFloatingActionButton3) { ExtendedFloatingActionButton3Screen() }
    composable(route = Material3NavRoutes.FilledTonalButton) { FilledTonalButtonScreen() }
    composable(route = Material3NavRoutes.FloatingActionButton3) { FloatingActionButton3Screen() }
    composable(route = Material3NavRoutes.IconButton3) { IconButton3Screen() }
    composable(route = Material3NavRoutes.Icon3) { Icon3Screen() }
    composable(route = Material3NavRoutes.IconToggleButton) { IconToggleButton3Screen() }
    composable(route = Material3NavRoutes.LargeFloatingActionButton) { LargeFloatingActionButtonScreen() }
    composable(route = Material3NavRoutes.LargeTopAppBar) { LargeTopAppBarScreen() }
    composable(route = Material3NavRoutes.LocalAbsoluteTonalElevation) { LocalAbsoluteElevationScreen() }
    composable(route = Material3NavRoutes.LocalContentColor3) { LocalContentColor3Screen() }
    composable(route = Material3NavRoutes.LocalMinimumTouchTargetEnforcement) {
        LocalMinimumTouchTargetEnforcementScreen()
    }
    composable(route = Material3NavRoutes.LocalTextStyle) { LocalTextStyleScreen() }
    composable(route = Material3NavRoutes.MaterialTheme3) { MaterialTheme3Screen() }
    composable(route = Material3NavRoutes.MediumTopAppBar) { MediumTopAppBarScreen() }
    composable(route = Material3NavRoutes.NavigationBar) { NavigationBarScreen() }
    composable(route = Material3NavRoutes.NavigationDrawer) { NavigationDrawerScreen() }
    composable(route = Material3NavRoutes.NavigationRail3) { NavigationRail3Screen() }
    composable(route = Material3NavRoutes.OutlinedButton) { OutlinedButtonScreen() }
    composable(route = Material3NavRoutes.Scaffold3) { Scaffold3Screen() }
    composable(route = Material3NavRoutes.SmallFloatingActionButton) { SmallFloatingActionButtonScreen() }
    composable(route = Material3NavRoutes.SmallTopAppBar) { SmallTopAppBarScreen() }
    composable(route = Material3NavRoutes.Surface3) { Surface3Screen() }
    composable(route = Material3NavRoutes.TextButton) { TextButtonScreen() }
    composable(route = Material3NavRoutes.Text3) { Text3Screen() }
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
    composable(route = UiNavRoutes.ModifierLocal) { ModifierLocalScreen() }
    composable(route = UiNavRoutes.NestedScroll) { NestedScrollScreen() }
    composable(route = UiNavRoutes.OnGloballyPositioned) { OnGloballyPositionedScreen() }
    composable(route = UiNavRoutes.OnKeyEvent) { OnKeyEventScreen() }
    composable(route = UiNavRoutes.OnSizeChanged) { OnSizeChangedScreen() }
    composable(route = UiNavRoutes.Paint) { PaintScreen() }
    composable(route = UiNavRoutes.PathEffect) { PathEffectScreen() }
    composable(route = UiNavRoutes.PointerInput) { PointerInputScreen() }
    composable(route = UiNavRoutes.Popup) { PopupScreen() }
    composable(route = UiNavRoutes.Primitive) { PrimitiveScreen() }
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
    composable(route = CustomExamplesNavRoutes.AnimatedExtendedFloatingActionButton) {
        AnimatedExtendedFloatingActionButtonScreen()
    }
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
    composable(route = ExternalLibrariesNavRoutes.ComposeParticleSystem) { ComposeParticleSystemScreen() }
    composable(route = ExternalLibrariesNavRoutes.ComposeRichTextPrinting) { ComposeRichTextPrintingScreen() }
    composable(route = ExternalLibrariesNavRoutes.ComposeRichTextSlideshow) { ComposeRichTextSlideshowScreen() }
    composable(route = ExternalLibrariesNavRoutes.ComposeRichTextUiMaterial) { ComposeRichTextUiMaterialScreen() }
    composable(route = ExternalLibrariesNavRoutes.ComposeRichTextUi) { ComposeRichTextUiScreen() }
    composable(route = ExternalLibrariesNavRoutes.ComposeTimelineView) { ComposeTimelineViewScreen() }
    composable(route = ExternalLibrariesNavRoutes.ComposeZoomableImage) { ComposeZoomableImageScreen() }
    composable(route = ExternalLibrariesNavRoutes.DrawablePainterAccompanist) { DrawablePainterAccompanistScreen() }
    composable(route = ExternalLibrariesNavRoutes.FlowLayoutAccompanist) { FlowLayoutAccompanistScreen() }
    composable(route = ExternalLibrariesNavRoutes.FontAwesome) { FontAwesomeScreen() }
    composable(route = ExternalLibrariesNavRoutes.FrescoLandscapist) { FrescoLandscapistScreen() }
    composable(route = ExternalLibrariesNavRoutes.Gap) { GapScreen() }
    composable(route = ExternalLibrariesNavRoutes.GlideLandscapist) { GlideLandscapistScreen() }
    composable(route = ExternalLibrariesNavRoutes.HtmlText) { HtmlTextScreen() }
    composable(route = ExternalLibrariesNavRoutes.InsetsAccompanist) { InsetsAccompanistScreen() }
    composable(route = ExternalLibrariesNavRoutes.Lottie) { LottieScreen() }
    composable(route = ExternalLibrariesNavRoutes.NavigationAnimationAccompanist) {
        NavigationAnimationAccompanistScreen()
    }
    composable(route = ExternalLibrariesNavRoutes.NavigationMaterialAccompanist) {
        NavigationMaterialAccompanistScreen()
    }
    composable(route = ExternalLibrariesNavRoutes.OrchestraBalloon) { OrchestraBalloonScreen() }
    composable(route = ExternalLibrariesNavRoutes.OrchestraColorPicker) { OrchestraColorPickerScreen() }
    composable(route = ExternalLibrariesNavRoutes.OrchestraSpinner) { OrchestraSpinnerScreen() }
    composable(route = ExternalLibrariesNavRoutes.PagerAccompanist) { PagerAccompanistScreen() }
    composable(route = ExternalLibrariesNavRoutes.PaletteLandscapist) { PaletteLandscapistScreen() }
    composable(route = ExternalLibrariesNavRoutes.PermissionsAccompanist) { PermissionsAccompanistScreen() }
    composable(route = ExternalLibrariesNavRoutes.PlaceholderAccompanist) { PlaceholderAccompanistScreen() }
    composable(route = ExternalLibrariesNavRoutes.Plot) { PlotScreen() }
    composable(route = ExternalLibrariesNavRoutes.RatingBar) { RatingBarScreen() }
    composable(route = ExternalLibrariesNavRoutes.RevealSwipe) { RevealSwipeScreen() }
    composable(route = ExternalLibrariesNavRoutes.Snapper) { SnapperScreen() }
    composable(route = ExternalLibrariesNavRoutes.SpeedDialFloatingActionButton) {
        SpeedDialFloatingActionButtonScreen()
    }
    composable(route = ExternalLibrariesNavRoutes.SSJetPackComposeProgressButton) {
        SSJetPackComposeProgressButtonScreen()
    }
    composable(route = ExternalLibrariesNavRoutes.StageStepBar) { StageStepBarScreen() }
    composable(route = ExternalLibrariesNavRoutes.SwipeRefreshAccompanist) { SwipeRefreshAccompanistScreen() }
    composable(route = ExternalLibrariesNavRoutes.SystemUiControllerAccompanist) {
        SystemUiControllerAccompanistScreen(
            navController,
            systemUiController
        )
    }
}