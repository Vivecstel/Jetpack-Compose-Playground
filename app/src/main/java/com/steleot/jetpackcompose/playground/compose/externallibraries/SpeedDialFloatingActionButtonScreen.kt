package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import de.charlex.compose.SpeedDialData
import de.charlex.compose.SpeedDialFloatingActionButton
import timber.log.Timber

private const val Url = "externallibraries/SpeedDialFloatingActionButtonScreen.kt"

@OptIn(ExperimentalMaterialApi::class)
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
                        Timber.d("Speed dial data: ${data.label}")
                    } ?: Timber.d("Speed dial null")
                },
                speedDialData = listOf(
                    SpeedDialData(
                        label = stringResource(id = R.string.test_with_args, 1),
                        painter = painterResource(R.drawable.ic_baseline_alarm_24dp)
                    ) { /* empty */ },
                    SpeedDialData(
                        label = stringResource(id = R.string.test_with_args, 2),
                        painter = painterResource(
                            id =
                            R.drawable.ic_android
                        )
                    ) { /* empty */ },
                    SpeedDialData(
                        label = stringResource(id = R.string.test_with_args, 3),
                        painterResource = R.drawable.ic_baseline_alarm_24dp
                    ) { /* empty */ },
                    SpeedDialData(
                        label = stringResource(id = R.string.test_with_args, 4),
                        painterResource = R.drawable.ic_android
                    ) { /* empty */ },
                )
            )
        }
    }
}