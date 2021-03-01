package com.steleot.jetpackcompose.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.steleot.jetpackcompose.playground.compose.MainScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimatableScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimatedValuesScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimatedVisibilityScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimationModifierScreen
import com.steleot.jetpackcompose.playground.compose.animation.AnimationScreen
import com.steleot.jetpackcompose.playground.compose.animation.CrossfadeAnimationScreen
import com.steleot.jetpackcompose.playground.compose.animation.GestureAnimationScreen
import com.steleot.jetpackcompose.playground.compose.animation.GrowingShapeScreen
import com.steleot.jetpackcompose.playground.compose.animation.InfiniteTransitionScreen
import com.steleot.jetpackcompose.playground.compose.animation.InteractionAnimationScreen
import com.steleot.jetpackcompose.playground.compose.animation.RotatingShapeScreen
import com.steleot.jetpackcompose.playground.compose.animation.SingleValueFloatAnimationScreen
import com.steleot.jetpackcompose.playground.compose.animation.TransitionScreen
import com.steleot.jetpackcompose.playground.compose.constraintlayout.ConstraintLayoutScreen
import com.steleot.jetpackcompose.playground.compose.foundation.BackgroundScreen
import com.steleot.jetpackcompose.playground.compose.foundation.BorderScreen
import com.steleot.jetpackcompose.playground.compose.foundation.CanvasScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ClickableScreen
import com.steleot.jetpackcompose.playground.compose.foundation.DraggableScreen
import com.steleot.jetpackcompose.playground.compose.foundation.FocusableScreen
import com.steleot.jetpackcompose.playground.compose.foundation.FoundationScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ImageScreen
import com.steleot.jetpackcompose.playground.compose.foundation.IndicationScreen
import com.steleot.jetpackcompose.playground.compose.foundation.LazyColumnScreen
import com.steleot.jetpackcompose.playground.compose.foundation.LazyGridScreen
import com.steleot.jetpackcompose.playground.compose.foundation.LazyRowScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ScrollScreen
import com.steleot.jetpackcompose.playground.compose.foundation.ShapeScreen
import com.steleot.jetpackcompose.playground.compose.foundation.SizeScreen
import com.steleot.jetpackcompose.playground.compose.foundation.TransformableScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.AspectRationScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.BoxScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.BoxWithConstraintsScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.ColumnScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.LayoutScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.OffsetScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.RowScreen
import com.steleot.jetpackcompose.playground.compose.foundationlayout.SpacerScreen
import com.steleot.jetpackcompose.playground.compose.material.AlertDialogScreen
import com.steleot.jetpackcompose.playground.compose.material.BottomAppBarScreen
import com.steleot.jetpackcompose.playground.compose.material.BottomDrawerLayoutScreen
import com.steleot.jetpackcompose.playground.compose.material.BottomNavigationScreen
import com.steleot.jetpackcompose.playground.compose.material.BottomSheetScaffoldScreen
import com.steleot.jetpackcompose.playground.compose.material.ButtonScreen
import com.steleot.jetpackcompose.playground.compose.material.CardScreen
import com.steleot.jetpackcompose.playground.compose.material.CheckboxScreen
import com.steleot.jetpackcompose.playground.compose.material.DividerScreen
import com.steleot.jetpackcompose.playground.compose.material.DropdownMenuScreen
import com.steleot.jetpackcompose.playground.compose.material.ExtendedFloatingActionButtonScreen
import com.steleot.jetpackcompose.playground.compose.material.FloatingActionButtonScreen
import com.steleot.jetpackcompose.playground.compose.material.IconButtonScreen
import com.steleot.jetpackcompose.playground.compose.material.IconScreen
import com.steleot.jetpackcompose.playground.compose.material.IconToggleButtonScreen
import com.steleot.jetpackcompose.playground.compose.material.ListItemScreen
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
import com.steleot.jetpackcompose.playground.compose.ui.ColorScreen
import com.steleot.jetpackcompose.playground.compose.ui.DrawableScreen
import com.steleot.jetpackcompose.playground.compose.ui.FontScreen
import com.steleot.jetpackcompose.playground.compose.ui.PrimitiveScreen
import com.steleot.jetpackcompose.playground.compose.ui.ShadowScreen
import com.steleot.jetpackcompose.playground.compose.ui.StringScreen
import com.steleot.jetpackcompose.playground.compose.ui.UiScreen
import com.steleot.jetpackcompose.playground.theme.PlaygroundTheme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                composable(route = MainNavRoutes.Main) { MainScreen(navController) }
                composable(route = MainNavRoutes.Animation) { AnimationScreen(navController) }
                composable(route = MainNavRoutes.ConstraintLayout) { ConstraintLayoutScreen() }
                composable(route = MainNavRoutes.Foundation) { FoundationScreen(navController) }
                composable(route = MainNavRoutes.FoundationLayout) { LayoutScreen(navController) }
                composable(route = MainNavRoutes.Material) { MaterialScreen(navController) }
                composable(route = MainNavRoutes.MaterialIcons) { MaterialIconsScreen(navController) }
                composable(route = MainNavRoutes.MaterialIConsExtended) {
                    MaterialIconsExtendedScreen(
                        navController
                    )
                }
                composable(route = MainNavRoutes.Ui) { UiScreen(navController) }
                /* animation */
                composable(route = AnimationNavRoutes.Animatable) { AnimatableScreen() }
                composable(route = AnimationNavRoutes.AnimatedValues) { AnimatedValuesScreen() }
                composable(route = AnimationNavRoutes.AnimatedVisibility) { AnimatedVisibilityScreen() }
                composable(route = AnimationNavRoutes.AnimationModifier) { AnimationModifierScreen() }
                composable(route = AnimationNavRoutes.CrossfadeAnimation) { CrossfadeAnimationScreen() }
                composable(route = AnimationNavRoutes.GestureAnimation) { GestureAnimationScreen() }
                composable(route = AnimationNavRoutes.GrowingShape) { GrowingShapeScreen() }
                composable(route = AnimationNavRoutes.InfiniteTransition) { InfiniteTransitionScreen() }
                composable(route = AnimationNavRoutes.InteractionAnimation) { InteractionAnimationScreen() }
                composable(route = AnimationNavRoutes.RotatingShape) { RotatingShapeScreen() }
                composable(route = AnimationNavRoutes.SingleValueColorAnimation) { SingleValueFloatAnimationScreen() }
                composable(route = AnimationNavRoutes.Transition) { TransitionScreen() }
                /* foundation */
                composable(route = FoundationNavRoutes.Background) { BackgroundScreen() }
                composable(route = FoundationNavRoutes.Border) { BorderScreen() }
                composable(route = FoundationNavRoutes.Canvas) { CanvasScreen() }
                composable(route = FoundationNavRoutes.Clickable) { ClickableScreen() }
                composable(route = FoundationNavRoutes.Draggable) { DraggableScreen() }
                composable(route = FoundationNavRoutes.Focusable) { FocusableScreen() }
                composable(route = FoundationNavRoutes.Image) { ImageScreen() }
                composable(route = FoundationNavRoutes.Indication) { IndicationScreen() }
                composable(route = FoundationNavRoutes.LazyColumn) { LazyColumnScreen() }
                composable(route = FoundationNavRoutes.LazyGrid) { LazyGridScreen() }
                composable(route = FoundationNavRoutes.LazyRow) { LazyRowScreen() }
                composable(route = FoundationNavRoutes.Scroll) { ScrollScreen() }
                composable(route = FoundationNavRoutes.Shape) { ShapeScreen() }
                composable(route = FoundationNavRoutes.Transformable) { TransformableScreen() }
                /* layout */
                composable(route = FoundationLayoutNavRoutes.AspectRatio) { AspectRationScreen() }
                composable(route = FoundationLayoutNavRoutes.Box) { BoxScreen() }
                composable(route = FoundationLayoutNavRoutes.BoxWithConstraints) { BoxWithConstraintsScreen() }
                composable(route = FoundationLayoutNavRoutes.Column) { ColumnScreen() }
                composable(route = FoundationLayoutNavRoutes.Offset) { OffsetScreen() }
                composable(route = FoundationLayoutNavRoutes.Row) { RowScreen() }
                composable(route = FoundationLayoutNavRoutes.Size) { SizeScreen() }
                composable(route = FoundationLayoutNavRoutes.Spacer) { SpacerScreen() }
                /* material */
                composable(route = MaterialNavRoutes.AlertDialog) { AlertDialogScreen() }
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
                composable(route = MaterialNavRoutes.FloatingActionButton) { FloatingActionButtonScreen() }
                composable(route = MaterialNavRoutes.IconButton) { IconButtonScreen() }
                composable(route = MaterialNavRoutes.Icon) { IconScreen() }
                composable(route = MaterialNavRoutes.IconToggleButton) { IconToggleButtonScreen() }
                composable(route = MaterialNavRoutes.ListItem) { ListItemScreen() }
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
                /* ui */
                composable(route = UiNavRoutes.Color) { ColorScreen() }
                composable(route = UiNavRoutes.Drawable) { DrawableScreen() }
                composable(route = UiNavRoutes.Font) { FontScreen() }
                composable(route = UiNavRoutes.Primitive) { PrimitiveScreen() }
                composable(route = UiNavRoutes.Shadow) { ShadowScreen() }
                composable(route = UiNavRoutes.String) { StringScreen() }
            }
        }
    }
}
