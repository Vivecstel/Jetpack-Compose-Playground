package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.MainNavRoutes
import com.steleot.jetpackcompose.playground.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.MainScreen
import java.util.*

val routes = listOf(
    UiNavRoutes.Alpha,
    UiNavRoutes.AndroidViewBinding,
    UiNavRoutes.Brush,
    UiNavRoutes.Color,
    UiNavRoutes.Drawable,
    UiNavRoutes.Font,
    UiNavRoutes.Layout,
    UiNavRoutes.OnGloballyPositioned,
    UiNavRoutes.OnSizeChanged,
    UiNavRoutes.PathEffect,
    UiNavRoutes.Popup,
    UiNavRoutes.Primitive,
    UiNavRoutes.Rotate,
    UiNavRoutes.Scale,
    UiNavRoutes.Shadow,
    UiNavRoutes.String,
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
