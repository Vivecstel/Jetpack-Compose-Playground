package com.steleot.jetpackcompose.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.steleot.jetpackcompose.playground.compose.MainScreen
import com.steleot.jetpackcompose.playground.compose.animation.*
import com.steleot.jetpackcompose.playground.compose.constraintlayout.ConstraintLayoutScreen
import com.steleot.jetpackcompose.playground.compose.foundation.*
import com.steleot.jetpackcompose.playground.compose.layout.*
import com.steleot.jetpackcompose.playground.compose.material.*
import com.steleot.jetpackcompose.playground.compose.materialicons.*
import com.steleot.jetpackcompose.playground.compose.materialiconsextended.*
import com.steleot.jetpackcompose.playground.compose.ui.*
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
                composable(route = MainNavRoutes.MaterialIConsExtended) { MaterialIconsExtendedScreen(navController) }
                composable(route = MainNavRoutes.Ui) { UiScreen(navController) }
                /* animation */
                composable(route = AnimationNavRoutes.AnimatedValues) { AnimatedValuesScreen() }
                composable(route = AnimationNavRoutes.CrossfadeAnimation) { CrossfadeAnimationScreen() }
                composable(route = AnimationNavRoutes.GestureAnimation) { GestureAnimationScreen() }
                composable(route = AnimationNavRoutes.GrowingShape) { GrowingShapeScreen() }
                composable(route = AnimationNavRoutes.InteractionAnimation) { InteractionAnimationScreen() }
                composable(route = AnimationNavRoutes.RotatingShape) { RotatingShapeScreen() }
                composable(route = AnimationNavRoutes.SingleValueColorAnimation) { SingleValueFloatAnimationScreen() }
                composable(route = AnimationNavRoutes.TransitionAnimation) { TransitionAnimationScreen() }
                /* foundation */
                composable(route = FoundationNavRoutes.Background) { BackgroundScreen() }
                composable(route = FoundationNavRoutes.Border) { BorderScreen() }
                composable(route = FoundationNavRoutes.Canvas) { CanvasScreen() }
                composable(route = FoundationNavRoutes.Clickable) { ClickableScreen() }
                composable(route = FoundationNavRoutes.Focusable) { FocusableScreen() }
                composable(route = FoundationNavRoutes.Image) { ImageScreen() }
                composable(route = FoundationNavRoutes.Scroll) { ScrollScreen() }
                composable(route = FoundationNavRoutes.Shape) { ShapeScreen() }
                composable(route = FoundationNavRoutes.Text) { TextScreen() }
                composable(route = FoundationNavRoutes.TextStyle) { TextStyleScreen() }
                /* layout */
                composable(route = FoundationLayoutNavRoutes.AspectRatio) { AspectRationScreen() }
                composable(route = FoundationLayoutNavRoutes.Box) { BoxScreen() }
                composable(route = FoundationLayoutNavRoutes.Column) { ColumnScreen() }
                composable(route = FoundationLayoutNavRoutes.Row) { RowScreen() }
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
