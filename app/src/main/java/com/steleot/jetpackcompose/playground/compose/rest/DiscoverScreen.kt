package com.steleot.jetpackcompose.playground.compose.rest

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.localproviders.LocalNavController
import com.steleot.jetpackcompose.playground.navigation.graph.MainNavRoutes
import com.steleot.jetpackcompose.playground.compose.activity.routes as activityRoutes
import com.steleot.jetpackcompose.playground.compose.animation.routes as animationRoutes
import com.steleot.jetpackcompose.playground.compose.constraintlayout.routes as constraintLayoutRoutes
import com.steleot.jetpackcompose.playground.compose.customexamples.routes as customExamplesRoutes
import com.steleot.jetpackcompose.playground.compose.externallibraries.routes as externalLibrariesRoutes
import com.steleot.jetpackcompose.playground.compose.foundation.routes as foundationRoutes
import com.steleot.jetpackcompose.playground.compose.material.routes as materialRoutes
import com.steleot.jetpackcompose.playground.compose.material3.routes as material3Routes
import com.steleot.jetpackcompose.playground.compose.materialicons.routes as materialIconsRoutes
import com.steleot.jetpackcompose.playground.compose.materialiconsextended.routes as materialIconsExtendedRoutes
import com.steleot.jetpackcompose.playground.compose.runtime.routes as runtimeRoutes
import com.steleot.jetpackcompose.playground.compose.ui.routes as uiRoutes
import com.steleot.jetpackcompose.playground.compose.viewmodel.routes as viewModelRoutes

private val discoverRoutes =
    activityRoutes +
            animationRoutes +
            constraintLayoutRoutes +
            foundationRoutes +
            materialRoutes +
            material3Routes +
            materialIconsRoutes +
            materialIconsExtendedRoutes +
            listOf(MainNavRoutes.Navigation) +
            listOf(MainNavRoutes.Paging) +
            runtimeRoutes +
            uiRoutes +
            viewModelRoutes +
            customExamplesRoutes +
            externalLibrariesRoutes

@Composable
fun DiscoverScreen() {
    LocalNavController.current.navigate(discoverRoutes.random()) {
        popUpTo(MainNavRoutes.Discover) {
            inclusive = true
        }
    }
}