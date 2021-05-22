package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import de.charlex.compose.SpeedDialData
import de.charlex.compose.SpeedDialFloatingActionButton
import timber.log.Timber

private const val Url = "external/SpeedDialFloatingActionButtonScreen.kt"

@Composable
fun SpeedDialFloatingActionButtonScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.SpeedDialFloatingActionButton,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpeedDialFloatingActionButton(
                onClick = { data ->
                    data?.let {
                        Timber.d("Speed dial data: ${data.name}")
                    } ?: Timber.d("Speed dial null")
                },
                speedDialData = listOf(
                    SpeedDialData(
                        name = "test1",
                        label = "Test 1",
                        painter = painterResource(R.drawable.ic_baseline_alarm_24dp)
                    ),
                    SpeedDialData(
                        name = "Test 2",
                        painter = painterResource(
                            id =
                            R.drawable.ic_android_black_24dp
                        )
                    ),
                    SpeedDialData(
                        name = "Test 3",
                        painterResource = R.drawable.ic_baseline_alarm_24dp
                    ),
                    SpeedDialData(
                        name = "Test 4",
                        painterResource = R.drawable.ic_android_black_24dp
                    )
                )
            )
        }
    }
}