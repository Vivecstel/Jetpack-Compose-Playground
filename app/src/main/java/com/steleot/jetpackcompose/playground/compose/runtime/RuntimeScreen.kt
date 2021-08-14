package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.RuntimeNavRoutes

val routes = listOf(
    RuntimeNavRoutes.CollectAsState,
    RuntimeNavRoutes.CompositionLocal,
    RuntimeNavRoutes.DerivedState,
    RuntimeNavRoutes.DisposableEffect,
    RuntimeNavRoutes.Immutable,
    RuntimeNavRoutes.Key,
    RuntimeNavRoutes.LaunchedEffect,
    RuntimeNavRoutes.MutableStateList,
    RuntimeNavRoutes.MutableStateMap,
    RuntimeNavRoutes.ProduceState,
    RuntimeNavRoutes.RememberCoroutineScope,
    RuntimeNavRoutes.RememberSaveable,
    RuntimeNavRoutes.RememberSaveableStateHolder,
    RuntimeNavRoutes.Remember,
    RuntimeNavRoutes.Saver,
    RuntimeNavRoutes.SideEffect,
    RuntimeNavRoutes.SnapshotFlow,
)

@Composable
fun RuntimeScreen(navController: NavHostController) {
    MainScreen(
        navController = navController,
        title = MainNavRoutes.Runtime,
        list = routes,
    )
}