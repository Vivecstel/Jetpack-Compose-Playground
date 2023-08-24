package com.steleot.jetpackcompose.playground.benchmark

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class BaselineProfileGeneratorScaffold {

    @get:Rule
    val rule = BaselineProfileRule()

    /**
     * Generate a baseline profile in this function.
     */
    abstract fun MacrobenchmarkScope.profileBlock()

    @Test
    fun profileGenerator() {
        rule.collect(
            packageName = TARGET_PACKAGE,
            maxIterations = 10
        ) {
            profileBlock()
        }
    }

    companion object {
        const val TARGET_PACKAGE = "com.steleot.jetpackcompose.playground"
    }
}