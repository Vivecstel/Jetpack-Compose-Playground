package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.navigation.graph.MainNavRoutes

val routes = listOf(
    FoundationNavRoutes.AbsolutePadding,
    FoundationNavRoutes.AnchoredDraggable,
    FoundationNavRoutes.AnimateItemPlacement,
    FoundationNavRoutes.AspectRatio,
    FoundationNavRoutes.Background,
    FoundationNavRoutes.BasicMarquee,
    FoundationNavRoutes.BasicTextField2,
    FoundationNavRoutes.BasicTextField,
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
    FoundationNavRoutes.Draggable2d,
    FoundationNavRoutes.Draggable,
    FoundationNavRoutes.DragGestureDetector,
    FoundationNavRoutes.Focusable,
    FoundationNavRoutes.HorizontalPager,
    FoundationNavRoutes.FlowColumn,
    FoundationNavRoutes.FlowRow,
    FoundationNavRoutes.Hoverable,
    FoundationNavRoutes.Image,
    FoundationNavRoutes.InteractionSource,
    FoundationNavRoutes.Intrinsic,
    FoundationNavRoutes.LazyColumn,
    FoundationNavRoutes.LazyHorizontalGrid,
    FoundationNavRoutes.LazyHorizontalStaggeredGrid,
    FoundationNavRoutes.LazyLayout,
    FoundationNavRoutes.LazyRow,
    FoundationNavRoutes.LazyVerticalGrid,
    FoundationNavRoutes.LazyVerticalStaggeredGrid,
    FoundationNavRoutes.LocalOverScrollConfiguration,
    FoundationNavRoutes.Magnifier,
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
    FoundationNavRoutes.SnapFlingBehavior,
    FoundationNavRoutes.Spacer,
    FoundationNavRoutes.StickyHeader,
    FoundationNavRoutes.Toggeable,
    FoundationNavRoutes.Transformable,
    FoundationNavRoutes.TransformGesture,
    FoundationNavRoutes.VerticalPager,
    FoundationNavRoutes.Weight,
)

@Composable
fun FoundationScreen() {
    MainScreen(
        title = MainNavRoutes.Foundation,
        list = routes,
    )
}
