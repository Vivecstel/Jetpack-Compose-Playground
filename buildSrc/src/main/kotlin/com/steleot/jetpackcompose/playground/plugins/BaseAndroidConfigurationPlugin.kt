package com.steleot.jetpackcompose.playground.plugins

import AndroidConfiguration
import com.android.build.api.dsl.*
import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.Logging

abstract class BaseAndroidConfigurationPlugin : Plugin<Project> {

    private val logger = Logging.getLogger(this::class.java)

    override fun apply(project: Project) {
        logger.debug("Applying Base Android Configuration Plugin")
        project.extensions.getByType(AndroidComponentsExtension::class.java)
            .finalizeDsl { extension ->
                with(extension) {
                    buildToolsVersion = BUILD_TOOLS
                    defaultConfig {
                        minSdk = AndroidConfiguration.minSdk
                        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                        when (extension) {
                            is ApplicationExtension -> {
                                with(this@defaultConfig as ApplicationDefaultConfig) {
                                    applicationId = AndroidConfiguration.appId
                                    targetSdk = AndroidConfiguration.targetSdk
                                    versionCode = AndroidConfiguration.versionCode
                                    versionName = AndroidConfiguration.versionName
                                }
                            }
                            is LibraryExtension -> {
                                with(this@defaultConfig as LibraryDefaultConfig) {
                                    targetSdk = AndroidConfiguration.targetSdk
                                }
                            }
                            is TestExtension -> {
                                with(this@defaultConfig as TestDefaultConfig) {
                                    targetSdk = AndroidConfiguration.targetSdk
                                }
                            }
                        }
                    }
                    compileOptions {
                        sourceCompatibility = JavaVersion.VERSION_11
                        targetCompatibility = JavaVersion.VERSION_11
                    }
                    lint {
                        abortOnError = true
                    }
                    buildFeatures {
                        buildConfig = extension is ApplicationExtension
                        aidl = false
                        renderScript = false
                        resValues = false
                        shaders = false
                    }
                    packagingOptions {
                        resources.excludes.apply {
                            add("**/attach_hotspot_windows.dll")
                            add("META-INF/licenses/**")
                            add("META-INF/AL2.0")
                            add("META-INF/LGPL2.1")
                            add("META-INF/versions/9/previous-compilation-data.bin")
                        }
                    }
                }
            }
    }

    companion object {
        private const val BUILD_TOOLS = "33.0.2"
    }
}