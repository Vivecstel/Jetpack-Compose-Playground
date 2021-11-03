package com.steleot.jetpackcompose.playground.utils

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.core.content.ContextCompat
import timber.log.Timber

val Context.isCameraPermissionGranted
    get() =
        ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED

fun Context.sendFeedback() {
    startActivitySafe {
        this.startActivity(Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(
                Intent.EXTRA_EMAIL,
                arrayOf("steleot@hotmail.com")
            )
            putExtra(
                Intent.EXTRA_SUBJECT,
                "Feedback on Jetpack Compose Playground"
            )
        })
    }
}

inline fun Context.startActivitySafe(
    startActivity: () -> Unit
) {
    try {
        startActivity()
    } catch (e: ActivityNotFoundException) {
        Timber.e(e)
        Toast.makeText(this, "Activity not found", Toast.LENGTH_SHORT).show()
    }
}

val Context.installer: String?
    get() {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            this.packageManager.getInstallSourceInfo(packageName).installingPackageName
        } else {
            @Suppress("DEPRECATION")
            this.packageManager.getInstallerPackageName(packageName)
        }
    }
