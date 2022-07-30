package com.steleot.jetpackcompose.playground.plugins

import com.android.build.api.dsl.ComposeOptions
import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.logging.Logging
import org.gradle.kotlin.dsl.getByType

abstract class ComposeConfigurationPlugin : Plugin<Project> {

    private val logger = Logging.getLogger(this::class.java)

    override fun apply(project: Project) {
        logger.debug("Applying Compose Configuration Plugin")
        project.extensions.getByType(AndroidComponentsExtension::class.java)
            .finalizeDsl { extension ->
                with(extension) {
                    composeOptions.configure(project)
                    buildFeatures {
                        viewBinding = true
                        compose = true
                    }
                }
            }
    }

    @Suppress("UnstableApiUsage")
    private fun ComposeOptions.configure(project: Project) {
        val androidx = project.extensions.getByType<VersionCatalogsExtension>().named("androidx")
        kotlinCompilerExtensionVersion = androidx.findVersion("composeCompiler").get().requiredVersion
    }
}