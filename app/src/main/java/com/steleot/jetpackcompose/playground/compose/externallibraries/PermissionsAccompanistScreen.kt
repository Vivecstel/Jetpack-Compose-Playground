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
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.steleot.jetpackcompose.playground.BuildConfig
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
            PermissionsAccompanistExample {
                context.startActivity(
                    Intent(
                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.fromParts("package", BuildConfig.APPLICATION_ID, null)
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun PermissionsAccompanistExample(
    navigateToSettingsScreen: () -> Unit
) {
    val cameraPermissionState = rememberPermissionState(
        android.Manifest.permission.CAMERA
    )

    var launchPermissionRequest by rememberSaveable { mutableStateOf(false) }
    var doNotShowRationale by rememberSaveable { mutableStateOf(false) }

    when {
        cameraPermissionState.hasPermission -> {
            Text("Camera permission Granted")
        }
        cameraPermissionState.shouldShowRationale -> {
            if (doNotShowRationale) {
                Text("Feature not available")
            } else {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text("The camera is important for this app. Please grant the permission.")
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = { cameraPermissionState.launchPermissionRequest() }) {
                        Text("Request permission")
                    }
                    Spacer(Modifier.height(8.dp))
                    Button(onClick = { doNotShowRationale = true }) {
                        Text("Don't show rationale again")
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
                Text(
                    "Camera permission denied. See this FAQ with information about why we " +
                            "need this permission. Please, grant us access on the Settings screen."
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = navigateToSettingsScreen) {
                    Text("Open Settings")
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