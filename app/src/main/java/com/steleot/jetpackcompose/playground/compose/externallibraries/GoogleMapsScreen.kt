package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.CircularProgressIndicator
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "externallibraries/GoogleMapsScreen.kt"

@Composable
fun GoogleMapsScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.GoogleMaps,
        link = URL,
    ) {
        GoogleMapsExample()
    }
}

@Composable
private fun GoogleMapsExample() {
    var isMapLoaded by remember { mutableStateOf(false) }
    val athens = LatLng(37.983810, 23.727539)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(athens, 8f)
    }
    Box(Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.matchParentSize(),
            cameraPositionState = cameraPositionState,
            onMapLoaded = {
                isMapLoaded = true
            },
            properties = MapProperties(
                mapType = MapType.NORMAL,
            ),
            uiSettings = MapUiSettings(compassEnabled = false),
        ) {
            Marker(state = rememberMarkerState(position = athens), title = "Athens")
            Marker(
                state = rememberMarkerState(position = LatLng(40.629269, 22.947412)),
                title = "Thessaloniki"
            )
        }
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