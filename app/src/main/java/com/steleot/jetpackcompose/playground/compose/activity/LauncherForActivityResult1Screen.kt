package com.steleot.jetpackcompose.playground.compose.activity

import android.Manifest
import android.graphics.Bitmap
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ActivityNavRoutes
import com.steleot.jetpackcompose.playground.utils.isCameraPermissionGranted
import com.steleot.jetpackcompose.playground.utils.startActivitySafe

private const val Url = "activity/LauncherForActivityResult1Screen.kt"

@Composable
fun LauncherForActivityResult1Screen() {
    DefaultScaffold(
        title = ActivityNavRoutes.LauncherForActivityResult1,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LauncherForActivityResultExample()
        }
    }
}

@Composable
private fun LauncherForActivityResultExample() {
    val context = LocalContext.current
    val result = rememberSaveable { mutableStateOf<Bitmap?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) {
        result.value = it
    }
    val permissionLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                context.startActivitySafe {
                    launcher.launch()
                }
            } else {
                Toast.makeText(context, R.string.permission_not_granted, Toast.LENGTH_SHORT).show()
            }
        }

    Button(
        onClick = {
            if (context.isCameraPermissionGranted) {
                launcher.launch()
            } else {
                permissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    ) {
        Text(text = stringResource(id = R.string.take_picture))
    }

    result.value?.let { image ->
        Image(
            image.asImageBitmap(),
            null,
            modifier = Modifier
                .size(250.dp)
        )
    }
}