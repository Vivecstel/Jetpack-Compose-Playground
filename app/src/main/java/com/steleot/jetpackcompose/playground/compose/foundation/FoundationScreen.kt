package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.navigation.graph.MainNavRoutes

val routes = listOf(
    FoundationNavRoutes.AbsolutePadding,
    FoundationNavRoutes.AnimateItemPlacement,
    FoundationNavRoutes.AspectRatio,
    FoundationNavRoutes.Background,
    FoundationNavRoutes.Border,
    FoundationNavRoutes.Box,
    FoundationNavRoutes.BoxWithConstraints,
    FoundationNavRoutes.BringIntoViewRequester,
    FoundationNavRoutes.Canvas,
    FoundationNavRoutes.Clickable,
    FoundationNavRoutes.ClickableText,
    FoundationNavRoutes.Column,
    FoundationNavRoutes.CombinedClickable,
    FoundationNavRoutes.DefaultMinSize,
    FoundationNavRoutes.Draggable,
    FoundationNavRoutes.DragGestureDetector,
    FoundationNavRoutes.Focusable,
    FoundationNavRoutes.Image,
    FoundationNavRoutes.InteractionSource,
    FoundationNavRoutes.Intrinsic,
    FoundationNavRoutes.LazyColumn,
    FoundationNavRoutes.LazyGrid,
    FoundationNavRoutes.LazyRow,
    FoundationNavRoutes.LocalOverScrollConfiguration,
    FoundationNavRoutes.MatchParentSize,
    FoundationNavRoutes.Offset,
    FoundationNavRoutes.PaddingFromBaseline,
    FoundationNavRoutes.PaddingFrom,
    FoundationNavRoutes.Padding,
    FoundationNavRoutes.ProgressSemantics,
    FoundationNavRoutes.Row,
    FoundationNavRoutes.Scrollable,
    FoundationNavRoutes.Scroller,
    FoundationNavRoutes.SelectableGroup,
    FoundationNavRoutes.Selectable,
    FoundationNavRoutes.SelectionContainer,
    FoundationNavRoutes.Shape,
    FoundationNavRoutes.Size,
    FoundationNavRoutes.Spacer,
    FoundationNavRoutes.StickyHeader,
    FoundationNavRoutes.Toggeable,
    FoundationNavRoutes.Transformable,
    FoundationNavRoutes.TransformGesture,
    FoundationNavRoutes.Weight,
)

@Composable
fun FoundationScreen() {
    MainScreen(
        title = MainNavRoutes.Foundation,
        list = routes,
    )
}
