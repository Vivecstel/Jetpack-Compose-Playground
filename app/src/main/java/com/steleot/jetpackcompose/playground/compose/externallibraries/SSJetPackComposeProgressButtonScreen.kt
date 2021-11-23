package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSButtonState
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSButtonType
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSJetPackComposeProgressButton
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val Url = "externallibraries/SSJetPackComposeProgressButtonScreen.kt"

@Composable
fun SSJetPackComposeProgressButtonScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.SSJetPackComposeProgressButton,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SSJetPackComposeProgressButtonExample()
        }
    }
}

@Composable
private fun SSJetPackComposeProgressButtonExample() {
    val scope = rememberCoroutineScope()
    var submitButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    SSJetPackComposeProgressButton(
        type = SSButtonType.CLOCK,
        width = 300.dp,
        height = 50.dp,
        onClick = {
            submitButtonState = SSButtonState.LOADING
            scope.launch {
                delay(1_000L)
                submitButtonState = SSButtonState.SUCCESS
            }
        },
        assetColor = MaterialTheme.colors.onPrimary,
        buttonState = submitButtonState,
        text = stringResource(id = R.string.press_me)
    )
}