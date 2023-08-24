package com.steleot.jetpackcompose.playground.benchmark

import android.Manifest
import android.os.Build
import androidx.benchmark.macro.MacrobenchmarkScope

fun MacrobenchmarkScope.allowNotifications() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val command = "pm grant $packageName ${Manifest.permission.POST_NOTIFICATIONS}"
        device.executeShellCommand(command)
    }
}