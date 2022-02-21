package com.steleot.jetpackcompose.playground.plugins

import com.android.build.api.variant.AndroidComponentsExtension
import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.android.build.api.variant.LibraryAndroidComponentsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.Logging

abstract class AddBenchmarkBuildTypePlugin : Plugin<Project> {

    private val logger = Logging.getLogger(this::class.java)

    override fun apply(project: Project) {
        when (val androidExtension =
            project.extensions.getByType(AndroidComponentsExtension::class.java)) {
            is ApplicationAndroidComponentsExtension -> {
                logger.debug("Found Application Android")
                androidExtension.finalizeDsl { extension ->
                    extension.buildTypes.create("benchmark") {
                        signingConfig = extension.signingConfigs.getByName("debug")
                        isDebuggable = false
                    }
                }
            }
            is LibraryAndroidComponentsExtension -> {
                logger.debug("Found Library Android")
                androidExtension.finalizeDsl { extension ->
                    extension.buildTypes.create("benchmark")
                }
            }
            else -> {
                logger.debug("Not handled from plugin ${androidExtension.javaClass.simpleName}")
            }
        }
    }
}