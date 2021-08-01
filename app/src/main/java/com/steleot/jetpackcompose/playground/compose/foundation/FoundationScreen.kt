package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.compose.MainScreen
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes

val routes = listOf(
    FoundationNavRoutes.Background,
    FoundationNavRoutes.Border,
    FoundationNavRoutes.Canvas,
    FoundationNavRoutes.Clickable,
    FoundationNavRoutes.ClickableText,
    FoundationNavRoutes.CombinedClickable,
    FoundationNavRoutes.Draggable,
    FoundationNavRoutes.DragGestureDetector,
    FoundationNavRoutes.Focusable,
    FoundationNavRoutes.Image,
    FoundationNavRoutes.InteractionSource,
    FoundationNavRoutes.LazyColumn,
    FoundationNavRoutes.LazyGrid,
    FoundationNavRoutes.LazyRow,
    FoundationNavRoutes.Scrollable,
    FoundationNavRoutes.Scroller,
    FoundationNavRoutes.SelectableGroup,
    FoundationNavRoutes.Selectable,
    FoundationNavRoutes.SelectionContainer,
    FoundationNavRoutes.Shape,
    FoundationNavRoutes.StickyHeader,
    FoundationNavRoutes.Toggeable,
    FoundationNavRoutes.Transformable,
    FoundationNavRoutes.TransformGesture,
)

@Composable
fun FoundationScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.Foundation,
        list = routes,
        showBackArrow = true
    )
}
