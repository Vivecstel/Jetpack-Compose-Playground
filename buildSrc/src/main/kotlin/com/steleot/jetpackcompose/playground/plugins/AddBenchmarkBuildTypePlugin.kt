package com.steleot.jetpackcompose.playground.plugins

import com.android.build.api.dsl.ApplicationBuildType
import com.android.build.api.dsl.TestBuildType
import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.Logging

abstract class AddBenchmarkBuildTypePlugin : Plugin<Project> {

    private val logger = Logging.getLogger(this::class.java)

    override fun apply(project: Project) {
        logger.debug("Applying Add Benchmark Build Type")
        project.extensions.getByType(AndroidComponentsExtension::class.java)
            .finalizeDsl { extension ->
                extension.buildTypes.create(BENCHMARK) {
                    when (this) {
                        is ApplicationBuildType -> {
                            signingConfig = extension.signingConfigs.getByName(DEBUG)
                            isDebuggable = false
                        }
                        is TestBuildType -> {
                            signingConfig = extension.signingConfigs.getByName(DEBUG)
                            isMinifyEnabled = true
                            isDebuggable = true
                            proguardFiles("..config/benchmark-rules.pro")
                        }
                    }
                }
            }
    }

    companion object {
        private const val DEBUG = "debug"
        private const val BENCHMARK = "benchmark"
    }
}