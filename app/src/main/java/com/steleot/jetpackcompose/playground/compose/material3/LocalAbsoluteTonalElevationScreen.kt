package com.steleot.jetpackcompose.playground.compose.material3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.Material3NavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material3.DefaultScaffold

private const val URL = "material3/LocalAbsoluteTonalElevationScreen.kt"

@Composable
fun LocalAbsoluteTonalElevationScreen() {
    DefaultScaffold(
        title = Material3NavRoutes.LocalAbsoluteTonalElevation,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.Blue),
                tonalElevation = 4.dp
            ) {
                Surface(
                    tonalElevation = 2.dp
                ) {
                    Surface(
                        tonalElevation = 4.dp
                    ) {
                        val elevation = LocalAbsoluteTonalElevation.current
                        Text(
                            text = stringResource(
                                id = R.string.local_absolute_tonal_elevation,
                                elevation
                            ),
                        )
                    }
                }
            }
        }
    }
}