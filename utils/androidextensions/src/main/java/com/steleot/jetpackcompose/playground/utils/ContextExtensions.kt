package com.steleot.jetpackcompose.playground.utils

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

val Context.isCameraPermissionGranted
    get() =
        ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED

fun Context.sendFeedback(
    emails: Array<String>,
    subject: String,
    activityNotFoundAction: (ActivityNotFoundException) -> Unit,
) {
    startActivitySafe(
        startActivity = {
            this.startActivity(Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, emails)
                putExtra(Intent.EXTRA_SUBJECT, subject)
            })
        },
        activityNotFoundAction = activityNotFoundAction
    )
}

inline fun startActivitySafe(
    startActivity: () -> Unit,
    activityNotFoundAction: (ActivityNotFoundException) -> Unit,
) {
    try {
        startActivity()
    } catch (e: ActivityNotFoundException) {
        activityNotFoundAction(e)
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

fun Context.shortToast(
    @StringRes resId: Int
) {
    Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
}

fun Context.shortToast(
    message: String
) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}