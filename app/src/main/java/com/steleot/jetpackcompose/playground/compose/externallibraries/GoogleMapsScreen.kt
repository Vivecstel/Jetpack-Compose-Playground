package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes

private const val Url = "externallibraries/GoogleMapsScreen.kt"

@Composable
fun GoogleMapsScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.GoogleMaps,
        link = Url,
    ) {
        GoogleMapsExample()
    }
}

@Composable
private fun GoogleMapsExample() {
    var isMapLoaded by remember { mutableStateOf(false) }
    Box(Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.matchParentSize(),
            onMapLoaded = {
                isMapLoaded = true
            },
            properties = MapProperties(
                mapType = MapType.NORMAL,
                maxZoomPreference = 10f,
            ),
            uiSettings = MapUiSettings(compassEnabled = false),
        )
        if (!isMapLoaded) {
            AnimatedVisibility(
                modifier = Modifier
                    .matchParentSize(),
                visible = !isMapLoaded,
                enter = EnterTransition.None,
                exit = fadeOut()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .wrapContentSize()
                )
            }
        }
    }
}