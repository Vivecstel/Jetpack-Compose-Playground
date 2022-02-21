package com.steleot.jetpackcompose.playground.plugins

import AndroidConfiguration
import Versions
import com.android.build.api.dsl.BaseFlavor
import com.android.build.api.dsl.BuildFeatures
import com.android.build.api.dsl.CompileOptions
import com.android.build.api.dsl.Lint
import com.android.build.api.variant.AndroidComponentsExtension
import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.android.build.api.variant.LibraryAndroidComponentsExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.Logging

abstract class BaseAndroidConfigurationPlugin : Plugin<Project> {

    private val logger = Logging.getLogger(this::class.java)

    override fun apply(project: Project) {
        when (val androidExtension =
            project.extensions.getByType(AndroidComponentsExtension::class.java)) {
            is ApplicationAndroidComponentsExtension -> {
                logger.debug("Found Application Android")
                androidExtension.finalizeDsl { extension ->
                    with(extension) {
                        buildToolsVersion = Versions.buildTools
                        defaultConfig {
                            applicationId = AndroidConfiguration.appId
                            targetSdk = AndroidConfiguration.targetSdk
                            versionCode = AndroidConfiguration.versionCode
                            versionName = AndroidConfiguration.versionName
                            configureBase()
                        }
                        compileOptions.configure()
                        lint.configure()
                        buildFeatures.configure()
                        packagingOptions {
                            resources.excludes.apply {
                                add("**/attach_hotspot_windows.dll")
                                add("META-INF/licenses/**")
                                add("META-INF/AL2.0")
                                add("META-INF/LGPL2.1")
                            }
                        }
                    }
                }
            }
            is LibraryAndroidComponentsExtension -> {
                logger.debug("Found Library Android")
                androidExtension.finalizeDsl { extension ->
                    with(extension) {
                        defaultConfig {
                            targetSdk = AndroidConfiguration.targetSdk
                            configureBase()
                        }
                        compileOptions.configure()
                        lint.configure()
                        buildFeatures.configure()
                    }
                }
            }
            else -> {
                logger.debug("Not handled from plugin ${androidExtension.javaClass.simpleName}")
            }
        }
    }

    private fun BaseFlavor.configureBase() {
        minSdk = AndroidConfiguration.minSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    private fun CompileOptions.configure() {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    private fun Lint.configure() {
        abortOnError = true
    }

    private fun BuildFeatures.configure() {
        aidl = false
        renderScript = false
        resValues = false
        shaders = false
    }
}