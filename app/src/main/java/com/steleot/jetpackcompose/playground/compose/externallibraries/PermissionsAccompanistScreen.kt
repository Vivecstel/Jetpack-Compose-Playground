package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "externallibraries/PermissionsAccompanistScreen.kt"

@Composable
fun PermissionsAccompanistScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.PermissionsAccompanist,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PermissionsAccompanistExample {
                Text(stringResource(id = R.string.camera_already_granted))
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionsAccompanistExample(
    successContent: @Composable () -> Unit,
) {
    val cameraPermissionState = rememberPermissionState(
        android.Manifest.permission.CAMERA
    )

    when (cameraPermissionState.status) {
        PermissionStatus.Granted -> {
            successContent()
        }
        is PermissionStatus.Denied -> {
            val deniedStatus = cameraPermissionState.status as PermissionStatus.Denied
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val textToShow = stringResource(
                    id = if (deniedStatus.shouldShowRationale) {
                        R.string.camera_rationale
                    } else {
                        R.string.camera_permission_msg
                    }
                )
                Text(textToShow)
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { cameraPermissionState.launchPermissionRequest() }) {
                    Text(stringResource(id = R.string.request_permission))
                }
            }
        }
    }
}