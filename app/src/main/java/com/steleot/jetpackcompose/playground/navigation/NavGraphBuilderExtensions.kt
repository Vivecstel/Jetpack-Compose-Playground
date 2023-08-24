package com.steleot.jetpackcompose.playground.navigation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.steleot.jetpackcompose.playground.BuildConfig
import com.steleot.jetpackcompose.playground.compose.activity.ActivityScreen
import com.steleot.jetpackcompose.playground.compose.activity.BackHandlerScreen
import com.steleot.jetpackcompose.playground.compose.activity.LauncherForActivityResult1Screen
import com.steleot.jetpackcompose.playground.compose.activity.LauncherForActivityResult2Screen
import com.steleot.jetpackcompose.playground.compose.animation.*
import com.steleot.jetpackcompose.playground.compose.constraintlayout.*
import com.steleot.jetpackcompose.playground.compose.customexamples.*
import com.steleot.jetpackcompose.playground.compose.externallibraries.*
import com.steleot.jetpackcompose.playground.compose.foundation.*
import com.steleot.jetpackcompose.playground.compose.material.*
import com.steleot.jetpackcompose.playground.compose.material3.*
import com.steleot.jetpackcompose.playground.compose.materialicons.*
import com.steleot.jetpackcompose.playground.compose.materialiconsextended.*
import com.steleot.jetpackcompose.playground.compose.navigation.NavigationScreen
import com.steleot.jetpackcompose.playground.compose.paging.PagingScreen
import com.steleot.jetpackcompose.playground.compose.rest.*
import com.steleot.jetpackcompose.playground.compose.runtime.*
import com.steleot.jetpackcompose.playground.compose.ui.*
import com.steleot.jetpackcompose.playground.compose.viewmodel.StateScreen
import com.steleot.jetpackcompose.playground.compose.viewmodel.ViewModelFlowScreen
import com.steleot.jetpackcompose.playground.compose.viewmodel.ViewModelLiveDataScreen
import com.steleot.jetpackcompose.playground.compose.viewmodel.ViewModelScreen
import com.steleot.jetpackcompose.playground.navigation.graph.*
import com.steleot.jetpackcompose.playground.theme.ThemeState

const val FavoritesRoute = "${MainNavRoutes.Favorites}/{userId}"

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

fun NavGraphBuilder.addActivityRoutes() {
    deepLinkComposable(route = ActivityNavRoutes.BackHandler) { BackHandlerScreen() }
    deepLinkComposable(route = ActivityNavRoutes.LauncherForActivityResult1) { LauncherForActivityResult1Screen() }
    deepLinkComposable(route = ActivityNavRoutes.LauncherForActivityResult2) { LauncherForActivityResult2Screen() }
}

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

fun NavGraphBuilder.addConstraintLayoutRoutes() {
    deepLinkComposable(route = ConstraintLayoutNavRoutes.Barrier) { BarrierScreen() }
    deepLinkComposable(route = ConstraintLayoutNavRoutes.Chain) { ChainScreen() }
    deepLinkComposable(route = ConstraintLayoutNavRoutes.Circular) { CircularScreen() }
    deepLinkComposable(route = ConstraintLayoutNavRoutes.ConstraintGridDsl) { ConstraintGridDslScreen() }
    deepLinkComposable(route = ConstraintLayoutNavRoutes.ConstraintHorizontalFlow) { ConstraintHorizontalFlowScreen() }
    deepLinkComposable(route = ConstraintLayoutNavRoutes.ConstraintSet) { ConstraintSetScreen() }
    deepLinkComposable(route = ConstraintLayoutNavRoutes.ConstraintVerticalFlow) { ConstraintVerticalFlowScreen() }
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

fun NavGraphBuilder.addFoundationRoutes() {
    deepLinkComposable(route = FoundationNavRoutes.AbsolutePadding) { AbsolutePaddingScreen() }
    deepLinkComposable(route = FoundationNavRoutes.AnchoredDraggable) { AnchoredDraggableScreen() }
    deepLinkComposable(route = FoundationNavRoutes.AnimateItemPlacement) { AnimateItemPlacementScreen() }
    deepLinkComposable(route = FoundationNavRoutes.AspectRatio) { AspectRationScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Background) { BackgroundScreen() }
    deepLinkComposable(route = FoundationNavRoutes.BasicMarquee) { BasicMarqueeScreen() }
    deepLinkComposable(route = FoundationNavRoutes.BasicTextField2) { BasicTextField2Screen() }
    deepLinkComposable(route = FoundationNavRoutes.BasicTextField) { BasicTextFieldScreen() }
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
    deepLinkComposable(route = FoundationNavRoutes.HorizontalPager) { HorizontalPagerScreen() }
    deepLinkComposable(route = FoundationNavRoutes.FlowColumn) { FlowColumnScreen() }
    deepLinkComposable(route = FoundationNavRoutes.FlowRow) { FlowRowScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Hoverable) { HoverableScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Image) { ImageScreen() }
    deepLinkComposable(route = FoundationNavRoutes.InteractionSource) { InteractionSourceScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Intrinsic) { IntrinsicScreen() }
    deepLinkComposable(route = FoundationNavRoutes.LazyColumn) { LazyColumnScreen() }
    deepLinkComposable(route = FoundationNavRoutes.LazyHorizontalGrid) { LazyHorizontalGridScreen() }
    deepLinkComposable(route = FoundationNavRoutes.LazyHorizontalStaggeredGrid) { LazyHorizontalStaggeredGridScreen() }
    deepLinkComposable(route = FoundationNavRoutes.LazyLayout) { LazyLayoutScreen() }
    deepLinkComposable(route = FoundationNavRoutes.LazyRow) { LazyRowScreen() }
    deepLinkComposable(route = FoundationNavRoutes.LazyVerticalGrid) { LazyVerticalGridScreen() }
    deepLinkComposable(route = FoundationNavRoutes.LazyVerticalStaggeredGrid) { LazyVerticalStaggeredGridScreen() }
    deepLinkComposable(route = FoundationNavRoutes.LocalOverScrollConfiguration) {
        LocalOverScrollConfigurationScreen()
    }
    deepLinkComposable(route = FoundationNavRoutes.Magnifier) { MagnifierScreen() }
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
    deepLinkComposable(route = FoundationNavRoutes.SnapFlingBehavior) { SnapFlingBehaviorScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Spacer) { SpacerScreen() }
    deepLinkComposable(route = FoundationNavRoutes.StickyHeader) { StickyHeaderScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Toggeable) { ToggeableScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Transformable) { TransformableScreen() }
    deepLinkComposable(route = FoundationNavRoutes.TransformGesture) { TransformGestureScreen() }
    deepLinkComposable(route = FoundationNavRoutes.VerticalPager) { VerticalPagerScreen() }
    deepLinkComposable(route = FoundationNavRoutes.Weight) { WeightScreen() }
}

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
    deepLinkComposable(route = MaterialNavRoutes.Chip) { ChipScreen() }
    deepLinkComposable(route = MaterialNavRoutes.Divider) { DividerScreen() }
    deepLinkComposable(route = MaterialNavRoutes.DropdownMenu) { DropdownMenuScreen() }
    deepLinkComposable(route = MaterialNavRoutes.ExtendedFloatingActionButton) { ExtendedFloatingActionButtonScreen() }
    deepLinkComposable(route = MaterialNavRoutes.FilterChip) { FilterChipScreen() }
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
    deepLinkComposable(route = MaterialNavRoutes.LocalMinimumInteractiveComponentEnforcement) { LocalMinimumInteractiveComponentEnforcementScreen() }
    deepLinkComposable(route = MaterialNavRoutes.LocalTextStyle) { LocalTextStyleScreen() }
    deepLinkComposable(route = MaterialNavRoutes.MaterialTheme) { MaterialThemeScreen() }
    deepLinkComposable(route = MaterialNavRoutes.ModalBottomSheetLayout) { ModalBottomSheetLayoutScreen() }
    deepLinkComposable(route = MaterialNavRoutes.ModalDrawer) { ModalDrawerScreen() }
    deepLinkComposable(route = MaterialNavRoutes.NavigationRail) { NavigationRailScreen() }
    deepLinkComposable(route = MaterialNavRoutes.OutlinedButton) { OutlinedButtonScreen() }
    deepLinkComposable(route = MaterialNavRoutes.OutlinedTextField) { OutlinedTextFieldScreen() }
    deepLinkComposable(route = MaterialNavRoutes.ProgressIndicator) { ProgressIndicatorScreen() }
    deepLinkComposable(route = MaterialNavRoutes.PullRefresh) { PullRefreshScreen() }
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

fun NavGraphBuilder.addMaterial3Routes() {
    deepLinkComposable(route = Material3NavRoutes.AlertDialog3) { AlertDialog3Screen() }
    deepLinkComposable(route = Material3NavRoutes.AssistChip) { AssistChipScreen() }
    deepLinkComposable(route = Material3NavRoutes.BadgedBox3) { BadgedBox3Screen() }
    deepLinkComposable(route = Material3NavRoutes.Badge3) { Badge3Screen() }
    deepLinkComposable(route = Material3NavRoutes.Button3) { Button3Screen() }
    deepLinkComposable(route = Material3NavRoutes.Card3) { Card3Screen() }
    deepLinkComposable(route = Material3NavRoutes.CenterAlignedTopAppBar) { CenterAlignedTopAppBarScreen() }
    deepLinkComposable(route = Material3NavRoutes.Checkbox3) { Checkbox3Screen() }
    deepLinkComposable(route = Material3NavRoutes.DatePicker) { DatePickerScreen() }
    deepLinkComposable(route = Material3NavRoutes.HorizontalDivider) { HorizontalDividerScreen() }
    deepLinkComposable(route = Material3NavRoutes.DropdownMenu3) { DropdownMenu3Screen() }
    deepLinkComposable(route = Material3NavRoutes.ElevatedButton) { ElevatedButtonScreen() }
    deepLinkComposable(route = Material3NavRoutes.ElevatedCard) { ElevatedCardScreen() }
    deepLinkComposable(route = Material3NavRoutes.ExtendedFloatingActionButton3) {
        ExtendedFloatingActionButton3Screen()
    }
    deepLinkComposable(route = Material3NavRoutes.FilledIconButton) { FilledIconButtonScreen() }
    deepLinkComposable(route = Material3NavRoutes.FilledTonalButton) { FilledTonalButtonScreen() }
    deepLinkComposable(route = Material3NavRoutes.FilledTonalIconButton) { FilledTonalIconButtonScreen() }
    deepLinkComposable(route = Material3NavRoutes.FilterChip3) { FilterChip3Screen() }
    deepLinkComposable(route = Material3NavRoutes.FloatingActionButton3) { FloatingActionButton3Screen() }
    deepLinkComposable(route = Material3NavRoutes.IconButton3) { IconButton3Screen() }
    deepLinkComposable(route = Material3NavRoutes.Icon3) { Icon3Screen() }
    deepLinkComposable(route = Material3NavRoutes.IconToggleButton3) { IconToggleButton3Screen() }
    deepLinkComposable(route = Material3NavRoutes.InputChip) { InputChipScreen() }
    deepLinkComposable(route = Material3NavRoutes.LargeFloatingActionButton) { LargeFloatingActionButtonScreen() }
    deepLinkComposable(route = Material3NavRoutes.LargeTopAppBar) { LargeTopAppBarScreen() }
    deepLinkComposable(route = Material3NavRoutes.ListItem3) { ListItem3Screen() }
    deepLinkComposable(route = Material3NavRoutes.LocalAbsoluteTonalElevation) { LocalAbsoluteTonalElevationScreen() }
    deepLinkComposable(route = Material3NavRoutes.LocalContentColor3) { LocalContentColor3Screen() }
    deepLinkComposable(route = Material3NavRoutes.LocalMinimumInteractiveComponentEnforcement3) {
        LocalMinimumInteractiveComponentEnforcement3Screen()
    }
    deepLinkComposable(route = Material3NavRoutes.LocalTextStyle3) { LocalTextStyle3Screen() }
    deepLinkComposable(route = Material3NavRoutes.MaterialTheme3) { MaterialTheme3Screen() }
    deepLinkComposable(route = Material3NavRoutes.MediumTopAppBar) { MediumTopAppBarScreen() }
    deepLinkComposable(route = Material3NavRoutes.ModalNavigationDrawer) { ModalNavigationDrawerScreen() }
    deepLinkComposable(route = Material3NavRoutes.MultiChoiceSegmentedButtonRow) { MultiChoiceSegmentedButtonRowScreen() }
    deepLinkComposable(route = Material3NavRoutes.NavigationBar) { NavigationBarScreen() }
    deepLinkComposable(route = Material3NavRoutes.NavigationRail3) { NavigationRail3Screen() }
    deepLinkComposable(route = Material3NavRoutes.OutlinedButton3) { OutlinedButton3Screen() }
    deepLinkComposable(route = Material3NavRoutes.OutlinedCard) { OutlinedCardScreen() }
    deepLinkComposable(route = Material3NavRoutes.OutlinedIconButton) { OutlinedIconButtonScreen() }
    deepLinkComposable(route = Material3NavRoutes.OutlinedTextField3) { OutlinedTextField3Screen() }
    deepLinkComposable(route = Material3NavRoutes.PlainTooltipBox) { PlainTooltipBoxScreen() }
    deepLinkComposable(route = Material3NavRoutes.ProgressIndicator3) { ProgressIndicator3Screen() }
    deepLinkComposable(route = Material3NavRoutes.RadioButton3) { RadioButton3Screen() }
    deepLinkComposable(route = Material3NavRoutes.RangeSlider3) { RangeSlider3Screen() }
    deepLinkComposable(route = Material3NavRoutes.RichTooltipBox) { RichTooltipBoxScreen() }
    deepLinkComposable(route = Material3NavRoutes.Scaffold3) { Scaffold3Screen() }
    deepLinkComposable(route = Material3NavRoutes.SearchBar) { SearchBarScreen() }
    deepLinkComposable(route = Material3NavRoutes.SingleChoiceSegmentedButtonRow) { SingleChoiceSegmentedButtonRowScreen() }
    deepLinkComposable(route = Material3NavRoutes.Slider3) { Slider3Screen() }
    deepLinkComposable(route = Material3NavRoutes.SmallFloatingActionButton) { SmallFloatingActionButtonScreen() }
    deepLinkComposable(route = Material3NavRoutes.SnackBar3) { Snackbar3Screen() }
    deepLinkComposable(route = Material3NavRoutes.SuggestionChip) { SuggestionChipScreen() }
    deepLinkComposable(route = Material3NavRoutes.Surface3) { Surface3Screen() }
    deepLinkComposable(route = Material3NavRoutes.Switch3) { Switch3Screen() }
    deepLinkComposable(route = Material3NavRoutes.TabRow3) { TabRow3Screen() }
    deepLinkComposable(route = Material3NavRoutes.TextButton3) { TextButton3Screen() }
    deepLinkComposable(route = Material3NavRoutes.Text3) { Text3Screen() }
    deepLinkComposable(route = Material3NavRoutes.TextField3) { TextField3Screen() }
    deepLinkComposable(route = Material3NavRoutes.TimePicker) { TimePickerScreen() }
    deepLinkComposable(route = Material3NavRoutes.TopAppBar3) { TopAppBar3Screen() }
    deepLinkComposable(route = Material3NavRoutes.VerticalDivider) { VerticalDividerScreen() }
    deepLinkComposable(route = Material3NavRoutes.WindowWidthSizeClass) { WindowWidthSizeClassScreen() }
}

fun NavGraphBuilder.addMaterialIconsRoutes() {
    deepLinkComposable(route = MaterialIconsNavRoutes.Filled) { FilledScreen() }
    deepLinkComposable(route = MaterialIconsNavRoutes.Outlined) { OutlinedScreen() }
    deepLinkComposable(route = MaterialIconsNavRoutes.Rounded) { RoundedScreen() }
    deepLinkComposable(route = MaterialIconsNavRoutes.Sharp) { SharpScreen() }
    deepLinkComposable(route = MaterialIconsNavRoutes.TwoTone) { TwoToneScreen() }
}

fun NavGraphBuilder.addMaterialIconsExtended() {
    deepLinkComposable(route = MaterialIconsExtendedNavRoutes.ExtendedFilled) { ExtendedFilledScreen() }
    deepLinkComposable(route = MaterialIconsExtendedNavRoutes.ExtendedOutlined) { ExtendedOutlinedScreen() }
    deepLinkComposable(route = MaterialIconsExtendedNavRoutes.ExtendedRounded) { ExtendedRoundedScreen() }
    deepLinkComposable(route = MaterialIconsExtendedNavRoutes.ExtendedSharp) { ExtendedSharpScreen() }
    deepLinkComposable(route = MaterialIconsExtendedNavRoutes.ExtendedTwoTone) { ExtendedTwoToneScreen() }
}

fun NavGraphBuilder.addRuntimeRoutes() {
    deepLinkComposable(route = RuntimeNavRoutes.CollectAsState) { CollectAsStateScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.CompositionLocal) { CompositionLocalScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.DerivedState) { DerivedStateScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.DisposableEffect) { DisposableEffectScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.Immutable) { ImmutableScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.Key) { KeyScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.LaunchedEffect) { LaunchedEffectScreen() }
    deepLinkComposable(route = RuntimeNavRoutes.MovableContentOf) { MovableContentOfScreen() }
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
    deepLinkComposable(route = UiNavRoutes.LocalFontFamilyResolver) { LocalFontFamilyResolverScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalHapticFeedback) { LocalHapticFeedbackScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalLayoutDirection) { LocalLayoutDirectionScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalLifecycleOwner) { LocalLifecycleOwnerScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalSavedStateRegistryOwner) { LocalSavedStateRegistryOwnerScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalSoftwareKeyboardController) { LocalSoftwareKeyboardControllerScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalTextToolbar) { LocalTextToolbarScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalUriHandler) { LocalUriHandlerScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalViewConfiguration) { LocalViewConfigurationScreen() }
    deepLinkComposable(route = UiNavRoutes.LocalWindowInfo) { LocalWindowInfoScreen() }
    deepLinkComposable(route = UiNavRoutes.LookaheadScope) { LookaheadScopeScreen() }
    deepLinkComposable(route = UiNavRoutes.ModifierLocal) { ModifierLocalScreen() }
    deepLinkComposable(route = UiNavRoutes.NestedScroll) { NestedScrollScreen() }
    deepLinkComposable(route = UiNavRoutes.OnGloballyPositioned) { OnGloballyPositionedScreen() }
    deepLinkComposable(route = UiNavRoutes.OnKeyEvent) { OnKeyEventScreen() }
    deepLinkComposable(route = UiNavRoutes.OnPlaced) { OnPlacedScreen() }
    deepLinkComposable(route = UiNavRoutes.OnSizeChanged) { OnSizeChangedScreen() }
    deepLinkComposable(route = UiNavRoutes.Paint) { PaintScreen() }
    deepLinkComposable(route = UiNavRoutes.PathEffect) { PathEffectScreen() }
    deepLinkComposable(route = UiNavRoutes.PluralString) { PluralStringScreen() }
    deepLinkComposable(route = UiNavRoutes.PointerHoverIcon) { PointerHoverIconScreen() }
    deepLinkComposable(route = UiNavRoutes.PointerInput) { PointerInputScreen() }
    deepLinkComposable(route = UiNavRoutes.Popup) { PopupScreen() }
    deepLinkComposable(route = UiNavRoutes.Primitive) { PrimitiveScreen() }
    deepLinkComposable(route = UiNavRoutes.Rotate) { RotateScreen() }
    deepLinkComposable(route = UiNavRoutes.Scale) { ScaleScreen() }
    deepLinkComposable(route = UiNavRoutes.Semantics) { SemanticsScreen() }
    deepLinkComposable(route = UiNavRoutes.Shadow) { ShadowScreen() }
    deepLinkComposable(route = UiNavRoutes.SpanStyle) { SpanStyleScreen() }
    deepLinkComposable(route = UiNavRoutes.String) { StringScreen() }
    deepLinkComposable(route = UiNavRoutes.SubComposeLayout) { SubComposeLayoutScreen() }
    deepLinkComposable(route = UiNavRoutes.TestTag) { TestTagScreen() }
    deepLinkComposable(route = UiNavRoutes.TextDecoration) { TextDecorationScreen() }
    deepLinkComposable(route = UiNavRoutes.TextIndent) { TextIndentScreen() }
    deepLinkComposable(route = UiNavRoutes.TextMeasurer) { TextMeasurerScreen() }
    deepLinkComposable(route = UiNavRoutes.TextMotion) { TextMotionScreen() }
    deepLinkComposable(route = UiNavRoutes.VisualTransformation) { VisualTransformationScreen() }
    deepLinkComposable(route = UiNavRoutes.ZIndex) { ZIndexScreen() }
}

fun NavGraphBuilder.addViewModelRoutes() {
    deepLinkComposable(route = ViewModelNavRoutes.Flow) { ViewModelFlowScreen() }
    deepLinkComposable(route = ViewModelNavRoutes.LiveData) { ViewModelLiveDataScreen() }
    deepLinkComposable(route = ViewModelNavRoutes.State) { StateScreen() }
}

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
    deepLinkComposable(route = CustomExamplesNavRoutes.CircleModifier) { CircleModifierScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.CollapsingToolbar) { CollapsingToolbarScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.ColorMatrix) { ColorMatrixScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.CurvedScrollView) { CurvedScrollViewScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.CurvedText) { CurvedTextScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.FirstBaselineToTop) { FirstBaselineToTopScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.LogSizeModifier) { LogSizeModifierScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.MessageBubble) { MessageBubbleScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.StaggeredGridList) { StaggeredGridListScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.StyledText) { StyledTextScreen() }
    deepLinkComposable(route = CustomExamplesNavRoutes.TearDrop) { TearDropScreen() }
}

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
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ComposeRichTextUiMaterial) {
        ComposeRichTextUiMaterialScreen()
    }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ComposeRichTextUi) { ComposeRichTextUiScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ComposeShimmer) { ComposeShimmerScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ComposeTimelineView) { ComposeTimelineViewScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ComposeTreeMap) { ComposeTreeMapScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.DrawablePainterAccompanist) {
        DrawablePainterAccompanistScreen()
    }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.FontAwesome) { FontAwesomeScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.FrescoLandscapist) { FrescoLandscapistScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.Gap) { GapScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.GlideLandscapist) { GlideLandscapistScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.GoogleMaps) { GoogleMapsScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.HeartSwitch) { HeartSwitchScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.HtmlText) { HtmlTextScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.Lottie) { LottieScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.NavigationMaterialAccompanist) {
        NavigationMaterialAccompanistScreen()
    }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.Orbital) { OrbitalScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.OrchestraBalloon) { OrchestraBalloonScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.OrchestraColorPicker) { OrchestraColorPickerScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.OrchestraSpinner) { OrchestraSpinnerScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.PaletteLandscapist) { PaletteLandscapistScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.PermissionsAccompanist) { PermissionsAccompanistScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.PlaceholderAccompanist) { PlaceholderAccompanistScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.Plot) { PlotScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.RatingBar) { RatingBarScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.RevealSwipe) { RevealSwipeScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.SpeedDialFloatingActionButton) {
        SpeedDialFloatingActionButtonScreen()
    }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.SSJetPackComposeProgressButton) {
        SSJetPackComposeProgressButtonScreen()
    }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.StageStepBar) { StageStepBarScreen() }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.SystemUiControllerAccompanist) {
        SystemUiControllerAccompanistScreen(systemUiController)
    }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.WebViewAccompanist) {
        WebViewAccompanistScreen()
    }
    deepLinkComposable(route = ExternalLibrariesNavRoutes.ZoomableComposeImage) {
        ZoomableComposeImageScreen()
    }
}

private fun NavGraphBuilder.deepLinkComposable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = listOf(navDeepLink {
        uriPattern = "${BuildConfig.DEEP_LINK_URI}/$route"
    }),
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route, arguments, deepLinks, content = content
    )
}