package com.steleot.jetpackcompose.playground.benchmark

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class JetpackComposePlaygroundBaselineProfileGenerator : BaselineProfileGeneratorScaffold() {

    override fun MacrobenchmarkScope.profileBlock() {
        allowNotifications()
        pressHome()
        startActivityAndWait()
        allowNotifications()
        device.waitForIdle()

    }
}