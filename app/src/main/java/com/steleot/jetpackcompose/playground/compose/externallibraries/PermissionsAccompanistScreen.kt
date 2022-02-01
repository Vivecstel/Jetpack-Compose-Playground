package com.steleot.jetpackcompose.playground.compose.externallibraries

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.steleot.jetpackcompose.playground.BuildConfig
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes

private const val Url = "externallibraries/PermissionsAccompanistScreen.kt"

@Composable
fun PermissionsAccompanistScreen() {
    val context = LocalContext.current
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.PermissionsAccompanist,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PermissionsAccompanistExample(
                navigateToSettingsScreen = {
                    context.startActivity(
                        Intent(
                            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                            Uri.fromParts("package", BuildConfig.APPLICATION_ID, null)
                        )
                    )
                }
            ) {
                Text(stringResource(id = R.string.camera_already_granted))
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionsAccompanistExample(
    navigateToSettingsScreen: () -> Unit,
    successContent: @Composable () -> Unit,
) {
    val cameraPermissionState = rememberPermissionState(
        android.Manifest.permission.CAMERA
    )

    var launchPermissionRequest by rememberSaveable { mutableStateOf(false) }
    var doNotShowRationale by rememberSaveable { mutableStateOf(false) }

    when {
        cameraPermissionState.hasPermission -> {
            successContent()
        }
        cameraPermissionState.shouldShowRationale -> {
            if (doNotShowRationale) {
                Text(stringResource(id = R.string.feature_not_available))
            } else {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(stringResource(id = R.string.camera_rationale))
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = { cameraPermissionState.launchPermissionRequest() }) {
                        Text(stringResource(id = R.string.request_permission))
                    }
                    Spacer(Modifier.height(8.dp))
                    Button(onClick = { doNotShowRationale = true }) {
                        Text(stringResource(id = R.string.hide_rationale))
                    }
                }
            }
        }
        !cameraPermissionState.permissionRequested -> {
            launchPermissionRequest = true
        }
        else -> {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(stringResource(id = R.string.camera_permission_denied))
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = navigateToSettingsScreen) {
                    Text(stringResource(id = R.string.open_settings))
                }
            }
        }
    }
    if (launchPermissionRequest) {
        LaunchedEffect(cameraPermissionState) {
            cameraPermissionState.launchPermissionRequest()
            launchPermissionRequest = false
        }
    }
}