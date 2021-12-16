package com.steleot.jetpackcompose.playground.navigation

import androidx.compose.animation.*
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.steleot.jetpackcompose.playground.BuildConfig
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
import com.steleot.jetpackcompose.playground.compose.externallibraries.ComposeShimmerScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.ComposeTimelineViewScreen
import com.steleot.jetpackcompose.playground.compose.externallibraries.ComposeTreeMapScreen
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
import com.steleot.jetpackcompose.playground.compose.externallibraries.ZoomableComposeImageScreen
import com.steleot.jetpackcompose.playground.compose.foundation.AbsolutePaddingScreen
import com.steleot.jetpackcompose.playground.compose.foundation.AnimateItemPlacementScreen
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
import com.steleot.jetpackcompose.playground.compose.material.BadgeScreen
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
import com.steleot.jetpackcompose.playground.compose.material.LocalTextStyleScreen
import com.steleot.jetpackcompose.playground.compose.material.MaterialScreen
import com.steleot.jetpackcompose.playground.compose.material.MaterialThemeScreen
import com.steleot.jetpackcompose.playground.compose.material.ModalBottomSheetLayoutScreen
import com.steleot.jetpackcompose.playground.compose.material.ModalDrawerScreen
import com.steleot.jetpackcompose.playground.compose.material.NavigationRailScreen
import com.steleot.jetpackcompose.playground.compose.material.OutlinedButtonScreen
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
import com.steleot.jetpackcompose.playground.compose.material.TextButtonScreen
import com.steleot.jetpackcompose.playground.compose.material.TextFieldScreen
import com.steleot.jetpackcompose.playground.compose.material.TextScreen
import com.steleot.jetpackcompose.playground.compose.material.TopAppBarScreen
import com.steleot.jetpackcompose.playground.compose.material.TriStateCheckboxScreen
import com.steleot.jetpackcompose.playground.compose.material3.AlertDialog3Screen
import com.steleot.jetpackcompose.playground.compose.material3.Badge3Screen
import com.steleot.jetpackcompose.playground.compose.material3.BadgedBox3Screen
import com.steleot.jetpackcompose.playground.compose.material3.Button3Screen
import com.steleot.jetpackcompose.playground.compose.material3.CenterAlignedTopAppBarScreen
import com.steleot.jetpackcompose.playground.compose.material3.Checkbox3Screen
import com.steleot.jetpackcompose.playground.compose.material3.ElevatedButtonScreen
import com.steleot.jetpackcompose.playground.compose.material3.ExtendedFloatingActionButton3Screen
import com.steleot.jetpackcompose.playground.compose.material3.FilledTonalButtonScreen
import com.steleot.jetpackcompose.playground.compose.material3.FloatingActionButton3Screen
import com.steleot.jetpackcompose.playground.compose.material3.Icon3Screen
import com.steleot.jetpackcompose.playground.compose.material3.IconButton3Screen
import com.steleot.jetpackcompose.playground.compose.material3.IconToggleButton3Screen
import com.steleot.jetpackcompose.playground.compose.material3.LargeFloatingActionButtonScreen
import com.steleot.jetpackcompose.playground.compose.material3.LargeTopAppBarScreen
import com.steleot.jetpackcompose.playground.compose.material3.LocalAbsoluteTonalElevationScreen
import com.steleot.jetpackcompose.playground.compose.material3.LocalContentColor3Screen
import com.steleot.jetpackcompose.playground.compose.material3.LocalMinimumTouchTargetEnforcementScreen
import com.steleot.jetpackcompose.playground.compose.material3.LocalTextStyle3Screen
import com.steleot.jetpackcompose.playground.compose.material3.Material3Screen
import com.steleot.jetpackcompose.playground.compose.material3.MaterialTheme3Screen
import com.steleot.jetpackcompose.playground.compose.material3.MediumTopAppBarScreen
import com.steleot.jetpackcompose.playground.compose.material3.NavigationBarScreen
import com.steleot.jetpackcompose.playground.compose.material3.NavigationDrawerScreen
import com.steleot.jetpackcompose.playground.compose.material3.NavigationRail3Screen
import com.steleot.jetpackcompose.playground.compose.material3.OutlinedButton3Screen
import com.steleot.jetpackcompose.playground.compose.material3.RadioButton3Screen
import com.steleot.jetpackcompose.playground.compose.material3.Scaffold3Screen
import com.steleot.jetpackcompose.playground.compose.material3.SmallFloatingActionButtonScreen
import com.steleot.jetpackcompose.playground.compose.material3.SmallTopAppBarScreen
import com.steleot.jetpackcompose.playground.compose.material3.Surface3Screen
import com.steleot.jetpackcompose.playground.compose.material3.Text3Screen
import com.steleot.jetpackcompose.playground.compose.material3.TextButton3Screen
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
import com.steleot.jetpackcompose.playground.compose.rest.DiscoverScreen
import com.steleot.jetpackcompose.playground.compose.rest.FavoritesScreen
import com.steleot.jetpackcompose.playground.compose.rest.MainScreenWithDrawer
import com.steleot.jetpackcompose.playground.compose.rest.NewScreen
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
import com.steleot.jetpackcompose.playground.compose.ui.OnPlacedScreen
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

const val FavoritesRoute = "${MainNavRoutes.Favorites}/{userId}"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addMainRoutes(
    firebaseAuth: FirebaseAuth,
    googleSignInClient: GoogleSignInClient,
    theme: ThemeState,
    setTheme: (ThemeState) -> Unit,
    setUser: (FirebaseUser?) -> Unit,
) {
    deepLinkComposable(route = MainNavRoutes.Main) {
        MainScreenWithDrawer(firebaseAuth, googleSignInClient, setUser = setUser)
    }
    deepLinkComposable(route = MainNavRoutes.Search) { SearchScreen() }
    deepLinkComposable(route = MainNavRoutes.Activity) { ActivityScreen() }
    deepLinkComposable(route = MainNavRoutes.Animation) { AnimationScreen() }
    deepLinkComposable(route = MainNavRoutes.ConstraintLayout) { ConstraintLayoutScreen() }
    deepLinkComposable(route = MainNavRoutes.CustomExamples) { CustomExamplesScreen() }
    deepLinkComposable(route = MainNavRoutes.ExternalLibraries) { ExternalLibrariesScreen() }
    deepLinkComposable(route = MainNavRoutes.Foundation) { FoundationScreen() }
    deepLinkComposable(route = MainNavRoutes.Material) { MaterialScreen() }
    deepLinkComposable(route = MainNavRoutes.Material3) { Material3Screen() }
    deepLinkComposable(route = MainNavRoutes.MaterialIcons) { MaterialIconsScreen() }
    deepLinkComposable(route = MainNavRoutes.MaterialIConsExtended) { MaterialIconsExtendedScreen() }
    deepLinkComposable(route = MainNavRoutes.Navigation) { NavigationScreen() }
    deepLinkComposable(route = MainNavRoutes.Paging) { PagingScreen() }
    deepLinkComposable(route = MainNavRoutes.Runtime) { RuntimeScreen() }
    deepLinkComposable(route = MainNavRoutes.Ui) { UiScreen() }
    deepLinkComposable(route = MainNavRoutes.ViewModel) { ViewModelScreen() }
    deepLinkComposable(route = MainNavRoutes.Settings) {
        SettingsScreen(hiltViewModel(it), theme, setTheme)
    }
    deepLinkComposable(route = MainNavRoutes.Popular) { PopularScreen(hiltViewModel(it)) }
    deepLinkComposable(route = MainNavRoutes.ReleaseNotes) { ReleaseNotesScreen(hiltViewModel(it)) }
    deepLinkComposable(route = FavoritesRoute) { FavoritesScreen(hiltViewModel()) }
    deepLinkComposable(route = MainNavRoutes.Discover) { DiscoverScreen() }
    deepLinkComposable(route = MainNavRoutes.New) { NewScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addActivityRoutes() {
    deepLinkComposable(route = ActivityNavRoutes.BackHandler) { BackHandlerScreen() }
    deepLinkComposable(route = ActivityNavRoutes.LauncherForActivityResult1) { LauncherForActivityResult1Screen() }
    deepLinkComposable(route = ActivityNavRoutes.LauncherForActivityResult2) { LauncherForActivityResult2Screen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addAnimationRoutes() {
    deepLinkComposable(route = AnimationNavRoutes.Animatable) { AnimatableScreen() }
    deepLinkComposable(route = AnimationNavRoutes.AnimatedContent) { AnimatedContentScreen() }
    deepLinkComposable(route = AnimationNavRoutes.AnimatedValues) { AnimatedValuesScreen() }
    deepLinkComposable(route = AnimationNavRoutes.AnimatedVector) { AnimatedVectorScreen() }
    deepLinkComposable(route = AnimationNavRoutes.AnimatedVisibility) { AnimatedVisibilityScreen() }
    deepLinkComposable(route = AnimationNavRoutes.AnimateEnterExit) { AnimateEnterExitScreen() }
    deepLinkComposable(route = AnimationNavRoutes.AnimationModifier) { AnimationModifierScreen() }
    deepLinkComposable(route = AnimationNavRoutes.CrossfadeAnimation) { CrossfadeAnimationScreen() }
    deepLinkComposable(route = AnimationNavRoutes.DoubleTapToLike) { DoubleTapToLikeScreen() }
    deepLinkComposable(route = AnimationNavRoutes.ElevationAnimation) { ElevationAnimationScreen() }
    deepLinkComposable(route = AnimationNavRoutes.GestureAnimation) { GestureAnimationScreen() }
    deepLinkComposable(route = AnimationNavRoutes.InfiniteTransition) { InfiniteTransitionScreen() }
    deepLinkComposable(route = AnimationNavRoutes.RotateAnimation) { RotateAnimationScreen() }
    deepLinkComposable(route = AnimationNavRoutes.ScaleAnimation) { ScaleAnimationScreen() }
    deepLinkComposable(route = AnimationNavRoutes.SingleValueColorAnimation) { SingleValueColorAnimationScreen() }
    deepLinkComposable(route = AnimationNavRoutes.SingleValueFloatAnimation) { SingleValueFloatAnimationScreen() }
    deepLinkComposable(route = AnimationNavRoutes.SuspendAnimation) { SuspendAnimationScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addConstraintLayoutRoutes() {
    deepLinkComposable(route = ConstraintLayoutNavRoutes.Barrier) { BarrierScreen() }
    deepLinkComposable(route = ConstraintLayoutNavRoutes.Chain) { ChainScreen() }
    deepLinkComposable(route = ConstraintLayoutNavRoutes.Circular) { CircularScreen() }
    deepLinkComposable(route = ConstraintLayoutNavRoutes.ConstraintSet) { ConstraintSetScreen() }
    deepLinkComposable(route = ConstraintLayoutNavRoutes.CreateGuideline) { CreateGuidelineScreen() }
    deepLinkComposable(route = ConstraintLayoutNavRoutes.CreateRefs) { CreateRefsScreen() }
    deepLinkComposable(route = ConstraintLayoutNavRoutes.JsonConstraintSet) { JsonConstraintSetScreen() }
    deepLinkComposable(route = ConstraintLayoutNavRoutes.JsonConstraintSetWithVariables) {
        JsonConstraintSetWithVariablesScreen()
    }
    deepLinkComposable(route = ConstraintLayoutNavRoutes.MotionLayout1) { MotionLayout1Screen() }
    deepLinkComposable(route = ConstraintLayoutNavRoutes.MotionLayout2) { MotionLayout2Screen() }
    deepLinkComposable(route = ConstraintLayoutNavRoutes.MotionLayout3) { MotionLayout3Screen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addFoundationRoutes() {
    deepLinkComposable(route = FoundationNavRoutes.AbsolutePadding) { AbsolutePaddingScreen() }
    deepLinkComposable(route = FoundationNavRoutes.AnimateItemPlacement) { AnimateItemPlacementScreen() }
    deepLinkComposable(route = FoundationNavRoutes.AspectRatio) { AspectRationScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Background) { BackgroundScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Border) { BorderScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Box) { BoxScreen() }
    deepLinkComposable(route = FoundationNavRoutes.BoxWithConstraints) { BoxWithConstraintsScreen() }
    deepLinkComposable(route = FoundationNavRoutes.BringIntoViewRequester) { BringIntoViewRequesterScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Canvas) { CanvasScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Clickable) { ClickableScreen() }
    deepLinkComposable(route = FoundationNavRoutes.ClickableText) { ClickableTextScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Column) { ColumnScreen() }
    deepLinkComposable(route = FoundationNavRoutes.CombinedClickable) { CombinedClickableScreen() }
    deepLinkComposable(route = FoundationNavRoutes.DefaultMinSize) { DefaultMinSizeScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Draggable) { DraggableScreen() }
    deepLinkComposable(route = FoundationNavRoutes.DragGestureDetector) { DragGestureDetectorScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Focusable) { FocusableScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Image) { ImageScreen() }
    deepLinkComposable(route = FoundationNavRoutes.InteractionSource) { InteractionSourceScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Intrinsic) { IntrinsicScreen() }
    deepLinkComposable(route = FoundationNavRoutes.LazyColumn) { LazyColumnScreen() }
    deepLinkComposable(route = FoundationNavRoutes.LazyGrid) { LazyGridScreen() }
    deepLinkComposable(route = FoundationNavRoutes.LazyRow) { LazyRowScreen() }
    deepLinkComposable(route = FoundationNavRoutes.LocalOverScrollConfiguration) { LocalOverScrollConfigurationScreen() }
    deepLinkComposable(route = FoundationNavRoutes.MatchParentSize) { MatchParentSizeScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Offset) { OffsetScreen() }
    deepLinkComposable(route = FoundationNavRoutes.PaddingFromBaseline) { PaddingFromBaselineScreen() }
    deepLinkComposable(route = FoundationNavRoutes.PaddingFrom) { PaddingFromScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Padding) { PaddingScreen() }
    deepLinkComposable(route = FoundationNavRoutes.ProgressSemantics) { ProgressSemanticsScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Row) { RowScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Scrollable) { ScrollableScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Scroller) { ScrollerScreen() }
    deepLinkComposable(route = FoundationNavRoutes.SelectableGroup) { SelectableGroupScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Selectable) { SelectableScreen() }
    deepLinkComposable(route = FoundationNavRoutes.SelectionContainer) { SelectionContainerScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Shape) { ShapeScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Size) { SizeScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Spacer) { SpacerScreen() }
    deepLinkComposable(route = FoundationNavRoutes.StickyHeader) { StickyHeaderScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Toggeable) { ToggeableScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Transformable) { TransformableScreen() }
    deepLinkComposable(route = FoundationNavRoutes.TransformGesture) { TransformGestureScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Weight) { WeightScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addMaterialRoutes() {
    deepLinkComposable(route = MaterialNavRoutes.AlertDialog) { AlertDialogScreen() }
    deepLinkComposable(route = MaterialNavRoutes.BackdropScaffold) { BackdropScaffoldScreen() }
    deepLinkComposable(route = MaterialNavRoutes.BadgedBox) { BadgedBoxScreen() }
    deepLinkComposable(route = MaterialNavRoutes.Badge) { BadgeScreen() }
    deepLinkComposable(route = MaterialNavRoutes.BottomAppBar) { BottomAppBarScreen() }
    deepLinkComposable(route = MaterialNavRoutes.BottomDrawer) { BottomDrawerScreen() }
    deepLinkComposable(route = MaterialNavRoutes.BottomNavigation) { BottomNavigationScreen() }
    deepLinkComposable(route = MaterialNavRoutes.BottomSheetScaffold) { BottomSheetScaffoldScreen() }
    deepLinkComposable(route = MaterialNavRoutes.Button) { ButtonScreen() }
    deepLinkComposable(route = MaterialNavRoutes.Card) { CardScreen() }
    deepLinkComposable(route = MaterialNavRoutes.Checkbox) { CheckboxScreen() }
    deepLinkComposable(route = MaterialNavRoutes.Divider) { DividerScreen() }
    deepLinkComposable(route = MaterialNavRoutes.DropdownMenu) { DropdownMenuScreen() }
    deepLinkComposable(route = MaterialNavRoutes.ExtendedFloatingActionButton) { ExtendedFloatingActionButtonScreen() }
    deepLinkComposable(route = MaterialNavRoutes.Elevation) { ElevationScreen() }
    deepLinkComposable(route = MaterialNavRoutes.ExposedDropdownMenuBox) { ExposedDropdownMenuBoxScreen() }
    deepLinkComposable(route = MaterialNavRoutes.FloatingActionButton) { FloatingActionButtonScreen() }
    deepLinkComposable(route = MaterialNavRoutes.IconButton) { IconButtonScreen() }
    deepLinkComposable(route = MaterialNavRoutes.Icon) { IconScreen() }
    deepLinkComposable(route = MaterialNavRoutes.IconToggleButton) { IconToggleButtonScreen() }
    deepLinkComposable(route = MaterialNavRoutes.ListItem) { ListItemScreen() }
    deepLinkComposable(route = MaterialNavRoutes.LocalAbsoluteElevation) { LocalAbsoluteElevationScreen() }
    deepLinkComposable(route = MaterialNavRoutes.LocalContentAlpha) { LocalContentAlphaScreen() }
    deepLinkComposable(route = MaterialNavRoutes.LocalContentColor) { LocalContentColorScreen() }
    deepLinkComposable(route = MaterialNavRoutes.LocalTextStyle) { LocalTextStyleScreen() }
    deepLinkComposable(route = MaterialNavRoutes.MaterialTheme) { MaterialThemeScreen() }
    deepLinkComposable(route = MaterialNavRoutes.ModalBottomSheetLayout) { ModalBottomSheetLayoutScreen() }
    deepLinkComposable(route = MaterialNavRoutes.ModalDrawer) { ModalDrawerScreen() }
    deepLinkComposable(route = MaterialNavRoutes.NavigationRail) { NavigationRailScreen() }
    deepLinkComposable(route = MaterialNavRoutes.OutlinedButton) { OutlinedButtonScreen() }
    deepLinkComposable(route = MaterialNavRoutes.OutlinedTextField) { OutlinedTextFieldScreen() }
    deepLinkComposable(route = MaterialNavRoutes.Progress) { ProgressScreen() }
    deepLinkComposable(route = MaterialNavRoutes.RadioButton) { RadioButtonScreen() }
    deepLinkComposable(route = MaterialNavRoutes.RangeSlider) { RangeSliderScreen() }
    deepLinkComposable(route = MaterialNavRoutes.Scaffold) { ScaffoldScreen() }
    deepLinkComposable(route = MaterialNavRoutes.ScrollableTabRow) { ScrollableTabRowScreen() }
    deepLinkComposable(route = MaterialNavRoutes.Slider) { SliderScreen() }
    deepLinkComposable(route = MaterialNavRoutes.SnackBar) { SnackBarScreen() }
    deepLinkComposable(route = MaterialNavRoutes.Surface) { SurfaceScreen() }
    deepLinkComposable(route = MaterialNavRoutes.Swipeable) { SwipeableScreen() }
    deepLinkComposable(route = MaterialNavRoutes.SwipeToDismiss) { SwipeToDismissScreen() }
    deepLinkComposable(route = MaterialNavRoutes.Switch) { SwitchScreen() }
    deepLinkComposable(route = MaterialNavRoutes.TabRow) { TabRowScreen() }
    deepLinkComposable(route = MaterialNavRoutes.TextButton) { TextButtonScreen() }
    deepLinkComposable(route = MaterialNavRoutes.TextField) { TextFieldScreen() }
    deepLinkComposable(route = MaterialNavRoutes.Text) { TextScreen() }
    deepLinkComposable(route = MaterialNavRoutes.TopAppBar) { TopAppBarScreen() }
    deepLinkComposable(route = MaterialNavRoutes.TriStateCheckbox) { TriStateCheckboxScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addMaterial3Routes() {
    deepLinkComposable(route = Material3NavRoutes.AlertDialog3) { AlertDialog3Screen() }
    deepLinkComposable(route = Material3NavRoutes.BadgedBox3) { BadgedBox3Screen() }
    deepLinkComposable(route = Material3NavRoutes.Badge3) { Badge3Screen() }
    deepLinkComposable(route = Material3NavRoutes.Button3) { Button3Screen() }
    deepLinkComposable(route = Material3NavRoutes.CenterAlignedTopAppBar) { CenterAlignedTopAppBarScreen() }
    deepLinkComposable(route = Material3NavRoutes.Checkbox3) { Checkbox3Screen() }
    deepLinkComposable(route = Material3NavRoutes.ElevatedButton) { ElevatedButtonScreen() }
    deepLinkComposable(route = Material3NavRoutes.ExtendedFloatingActionButton3) { ExtendedFloatingActionButton3Screen() }
    deepLinkComposable(route = Material3NavRoutes.FilledTonalButton) { FilledTonalButtonScreen() }
    deepLinkComposable(route = Material3NavRoutes.FloatingActionButton3) { FloatingActionButton3Screen() }
    deepLinkComposable(route = Material3NavRoutes.IconButton3) { IconButton3Screen() }
    deepLinkComposable(route = Material3NavRoutes.Icon3) { Icon3Screen() }
    deepLinkComposable(route = Material3NavRoutes.IconToggleButton3) { IconToggleButton3Screen() }
    deepLinkComposable(route = Material3NavRoutes.LargeFloatingActionButton) { LargeFloatingActionButtonScreen() }
    deepLinkComposable(route = Material3NavRoutes.LargeTopAppBar) { LargeTopAppBarScreen() }
    deepLinkComposable(route = Material3NavRoutes.LocalAbsoluteTonalElevation) { LocalAbsoluteTonalElevationScreen() }
    deepLinkComposable(route = Material3NavRoutes.LocalContentColor3) { LocalContentColor3Screen() }
    deepLinkComposable(route = Material3NavRoutes.LocalMinimumTouchTargetEnforcement) {
        LocalMinimumTouchTargetEnforcementScreen()
    }
    deepLinkComposable(route = Material3NavRoutes.LocalTextStyle3) { LocalTextStyle3Screen() }
    deepLinkComposable(route = Material3NavRoutes.MaterialTheme3) { MaterialTheme3Screen() }
    deepLinkComposable(route = Material3NavRoutes.MediumTopAppBar) { MediumTopAppBarScreen() }
    deepLinkComposable(route = Material3NavRoutes.NavigationBar) { NavigationBarScreen() }
    deepLinkComposable(route = Material3NavRoutes.NavigationDrawer) { NavigationDrawerScreen() }
    deepLinkComposable(route = Material3NavRoutes.NavigationRail3) { NavigationRail3Screen() }
    deepLinkComposable(route = Material3NavRoutes.OutlinedButton3) { OutlinedButton3Screen() }
    deepLinkComposable(route = Material3NavRoutes.RadioButton3) { RadioButton3Screen() }
    deepLinkComposable(route = Material3NavRoutes.Scaffold3) { Scaffold3Screen() }
    deepLinkComposable(route = Material3NavRoutes.SmallFloatingActionButton) { SmallFloatingActionButtonScreen() }
    deepLinkComposable(route = Material3NavRoutes.SmallTopAppBar) { SmallTopAppBarScreen() }
    deepLinkComposable(route = Material3NavRoutes.Surface3) { Surface3Screen() }
    deepLinkComposable(route = Material3NavRoutes.TextButton3) { TextButton3Screen() }
    deepLinkComposable(route = Material3NavRoutes.Text3) { Text3Screen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addMaterialIconsRoutes() {
    deepLinkComposable(route = MaterialIconsNavRoutes.Filled) { FilledScreen() }
    deepLinkComposable(route = MaterialIconsNavRoutes.Outlined) { OutlinedScreen() }
    deepLinkComposable(route = MaterialIconsNavRoutes.Rounded) { RoundedScreen() }
    deepLinkComposable(route = MaterialIconsNavRoutes.Sharp) { SharpScreen() }
    deepLinkComposable(route = MaterialIconsNavRoutes.TwoTone) { TwoToneScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addMaterialIconsExtended() {
    deepLinkComposable(route = MaterialIconsExtendedNavRoutes.ExtendedFilled) { ExtendedFilledScreen() }
    deepLinkComposable(route = MaterialIconsExtendedNavRoutes.ExtendedOutlined) { ExtendedOutlinedScreen() }
    deepLinkComposable(route = MaterialIconsExtendedNavRoutes.ExtendedRounded) { ExtendedRoundedScreen() }
    deepLinkComposable(route = MaterialIconsExtendedNavRoutes.ExtendedSharp) { ExtendedSharpScreen() }
    deepLinkComposable(route = MaterialIconsExtendedNavRoutes.ExtendedTwoTone) { ExtendedTwoToneScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addRuntimeRoutes() {
    deepLinkComposable(route = RuntimeNavRoutes.CollectAsState) { CollectAsStateScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.CompositionLocal) { CompositionLocalScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.DerivedState) { DerivedStateScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.DisposableEffect) { DisposableEffectScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.Immutable) { ImmutableScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.Key) { KeyScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.LaunchedEffect) { LaunchedEffectScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.MutableStateList) { MutableStateListScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.MutableStateMap) { MutableStateMapScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.ProduceState) { ProduceStateScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.RememberCoroutineScope) { RememberCoroutineScopeScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.RememberSaveable) { RememberSaveableScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.RememberSaveableStateHolder) { RememberSaveableStateHolderScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.Remember) { RememberScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.Saver) { SaverScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.SideEffect) { SideEffectScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.SnapshotFlow) { SnapshotFlowScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addUiRoutes() {
    deepLinkComposable(route = UiNavRoutes.AlignmentLine) { AlignmentLineScreen() }
    deepLinkComposable(route = UiNavRoutes.Alpha) { AlphaScreen() }
    deepLinkComposable(route = UiNavRoutes.AndroidViewBinding) { AndroidViewBindingScreen() }
    deepLinkComposable(route = UiNavRoutes.AnnotatedString) { AnnotatedStringScreen() }
    deepLinkComposable(route = UiNavRoutes.Blur) { BlurScreen() }
    deepLinkComposable(route = UiNavRoutes.Brush) { BrushScreen() }
    deepLinkComposable(route = UiNavRoutes.Clip) { ClipScreen() }
    deepLinkComposable(route = UiNavRoutes.ClipToBounds) { ClipToBoundsScreen() }
    deepLinkComposable(route = UiNavRoutes.Color) { ColorScreen() }
    deepLinkComposable(route = UiNavRoutes.DebugInspectorInfo) { DebugInspectorInfoScreen() }
    deepLinkComposable(route = UiNavRoutes.Dialog) { DialogScreen() }
    deepLinkComposable(route = UiNavRoutes.Drawable) { DrawableScreen() }
    deepLinkComposable(route = UiNavRoutes.DrawBehind) { DrawBehindScreen() }
    deepLinkComposable(route = UiNavRoutes.DrawWithCache) { DrawWithCacheScreen() }
    deepLinkComposable(route = UiNavRoutes.DrawWithContent) { DrawWithContentScreen() }
    deepLinkComposable(route = UiNavRoutes.Font) { FontScreen() }
    deepLinkComposable(route = UiNavRoutes.GraphicsLayer) { GraphicsLayerScreen() }
    deepLinkComposable(route = UiNavRoutes.ImageBitmapToPixelMap) { ImageBitmapToPixelMapScreen() }
    deepLinkComposable(route = UiNavRoutes.Inspectable) { InspectableScreen() }
    deepLinkComposable(route = UiNavRoutes.LayoutId) { LayoutIdScreen() }
    deepLinkComposable(route = UiNavRoutes.Layout) { LayoutScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalAccessibilityManager) { LocalAccessibilityManagerScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalAutofill) { LocalAutofillScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalAutofillTree) { LocalAutofillTreeScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalClipboardManager) { LocalClipboardManagerScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalConfiguration) { LocalConfigurationScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalContext) { LocalContextScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalDensity) { LocalDensityScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalFocusManager) { LocalFocusManagerScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalFontLoader) { LocalFontLoaderScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalHapticFeedback) { LocalHapticFeedbackScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalLayoutDirection) { LocalLayoutDirectionScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalLifecycleOwner) { LocalLifecycleOwnerScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalSavedStateRegistryOwner) { LocalSavedStateRegistryOwnerScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalSoftwareKeyboardController) { LocalSoftwareKeyboardControllerScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalTextInputService) { LocalTextInputServiceScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalTextToolbar) { LocalTextToolbarScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalUriHandler) { LocalUriHandlerScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalViewConfiguration) { LocalViewConfigurationScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalWindowInfo) { LocalWindowInfoScreen() }
    deepLinkComposable(route = UiNavRoutes.ModifierLocal) { ModifierLocalScreen() }
    deepLinkComposable(route = UiNavRoutes.NestedScroll) { NestedScrollScreen() }
    deepLinkComposable(route = UiNavRoutes.OnGloballyPositioned) { OnGloballyPositionedScreen() }
    deepLinkComposable(route = UiNavRoutes.OnKeyEvent) { OnKeyEventScreen() }
    deepLinkComposable(route = UiNavRoutes.OnPlaced) { OnPlacedScreen() }
    deepLinkComposable(route = UiNavRoutes.OnSizeChanged) { OnSizeChangedScreen() }
    deepLinkComposable(route = UiNavRoutes.Paint) { PaintScreen() }
    deepLinkComposable(route = UiNavRoutes.PathEffect) { PathEffectScreen() }
    deepLinkComposable(route = UiNavRoutes.PointerInput) { PointerInputScreen() }
    deepLinkComposable(route = UiNavRoutes.Popup) { PopupScreen() }
    deepLinkComposable(route = UiNavRoutes.Primitive) { PrimitiveScreen() }
    deepLinkComposable(route = UiNavRoutes.Rotate) { RotateScreen() }
    deepLinkComposable(route = UiNavRoutes.Scale) { ScaleScreen() }
    deepLinkComposable(route = UiNavRoutes.Shadow) { ShadowScreen() }
    deepLinkComposable(route = UiNavRoutes.SpanStyle) { SpanStyleScreen() }
    deepLinkComposable(route = UiNavRoutes.String) { StringScreen() }
    deepLinkComposable(route = UiNavRoutes.SubComposeLayout) { SubComposeLayoutScreen() }
    deepLinkComposable(route = UiNavRoutes.TestTag) { TestTagScreen() }
    deepLinkComposable(route = UiNavRoutes.TextDecoration) { TextDecorationScreen() }
    deepLinkComposable(route = UiNavRoutes.TextIndent) { TextIndentScreen() }
    deepLinkComposable(route = UiNavRoutes.VisualTransformation) { VisualTransformationScreen() }
    deepLinkComposable(route = UiNavRoutes.ZIndex) { ZIndexScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addViewModelRoutes() {
    deepLinkComposable(route = ViewModelNavRoutes.Flow) { ViewModelFlowScreen() }
    deepLinkComposable(route = ViewModelNavRoutes.LiveData) { ViewModelLiveDataScreen() }
    deepLinkComposable(route = ViewModelNavRoutes.State) { StateScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addCustomExamples() {
    deepLinkComposable(route = CustomExamplesNavRoutes.AdMobBanner) { AdMobBannerScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.AnimatedDeleteList) { AnimatedDeleteListScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.AnimatedExtendedFloatingActionButton) {
        AnimatedExtendedFloatingActionButtonScreen()
    }
    deepLinkComposable(route = CustomExamplesNavRoutes.AnimatedShowList) { AnimatedShowListScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.AnimatedText) { AnimatedTextScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.BarChart) { BarChartScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.BottomRoundedArcShape) { BottomRoundedArcShapeScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.CameraX) { CameraXScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.CollapsingToolbar) { CollapsingToolbarScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.ColorMatrix) { ColorMatrixScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.CurvedScrollView) { CurvedScrollViewScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.CurvedText) { CurvedTextScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.FirstBaselineToTop) { FirstBaselineToTopScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.MessageBubble) { MessageBubbleScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.StaggeredGridList) { StaggeredGridListScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.StyledText) { StyledTextScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.TearDrop) { TearDropScreen() }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addExternalLibraries(
    systemUiController: SystemUiController,
) {
    deepLinkComposable(route = ExternalLibrariesNavRoutes.Coil) { CoilScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.CoilLandscapist) { CoilLandscapistScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ComposeBarcodes) { ComposeBarcodesScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ComposeCharts) { ComposeChartsScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ComposeMarkdown) { ComposeMarkdownScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ComposeNeumorphism) { ComposeNeumorphismScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ComposeParticleSystem) { ComposeParticleSystemScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ComposeRichTextPrinting) { ComposeRichTextPrintingScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ComposeRichTextSlideshow) { ComposeRichTextSlideshowScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ComposeRichTextUiMaterial) { ComposeRichTextUiMaterialScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ComposeRichTextUi) { ComposeRichTextUiScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ComposeShimmer) { ComposeShimmerScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ComposeTimelineView) { ComposeTimelineViewScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ComposeTreeMap) { ComposeTreeMapScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.DrawablePainterAccompanist) { DrawablePainterAccompanistScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.FlowLayoutAccompanist) { FlowLayoutAccompanistScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.FontAwesome) { FontAwesomeScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.FrescoLandscapist) { FrescoLandscapistScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.Gap) { GapScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.GlideLandscapist) { GlideLandscapistScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.HtmlText) { HtmlTextScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.InsetsAccompanist) { InsetsAccompanistScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.Lottie) { LottieScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.NavigationAnimationAccompanist) {
        NavigationAnimationAccompanistScreen()
    }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.NavigationMaterialAccompanist) {
        NavigationMaterialAccompanistScreen()
    }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.OrchestraBalloon) { OrchestraBalloonScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.OrchestraColorPicker) { OrchestraColorPickerScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.OrchestraSpinner) { OrchestraSpinnerScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.PagerAccompanist) { PagerAccompanistScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.PaletteLandscapist) { PaletteLandscapistScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.PermissionsAccompanist) { PermissionsAccompanistScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.PlaceholderAccompanist) { PlaceholderAccompanistScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.Plot) { PlotScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.RatingBar) { RatingBarScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.RevealSwipe) { RevealSwipeScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.Snapper) { SnapperScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.SpeedDialFloatingActionButton) {
        SpeedDialFloatingActionButtonScreen()
    }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.SSJetPackComposeProgressButton) {
        SSJetPackComposeProgressButtonScreen()
    }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.StageStepBar) { StageStepBarScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.SwipeRefreshAccompanist) { SwipeRefreshAccompanistScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.SystemUiControllerAccompanist) {
        SystemUiControllerAccompanistScreen(systemUiController)
    }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ZoomableComposeImage) {
        ZoomableComposeImageScreen()
    }
}

@OptIn(ExperimentalAnimationApi::class)
private fun NavGraphBuilder.deepLinkComposable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = listOf(navDeepLink { uriPattern = "${BuildConfig.DEEP_LINK_URI}/$route"}),
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route, arguments, deepLinks, content = content
    )
}