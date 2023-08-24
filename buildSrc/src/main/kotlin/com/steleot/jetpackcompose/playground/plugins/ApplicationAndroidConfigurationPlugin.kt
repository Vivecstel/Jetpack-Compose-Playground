package com.steleot.jetpackcompose.playground.plugins

import AndroidConfiguration
import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.android.build.api.variant.BuildConfigField
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.Logging
import java.io.FileInputStream
import java.util.*

abstract class ApplicationAndroidConfigurationPlugin : Plugin<Project> {

    private val logger = Logging.getLogger(this::class.java)

    override fun apply(project: Project) {
        logger.debug("Applying Application Android Configuration Type")
        project.extensions.getByType(ApplicationAndroidComponentsExtension::class.java).apply {
            finalizeDsl { extension ->
                val rootProject = project.rootProject
                val isReleasedEnabled = rootProject.file("signing/signing_info.properties").exists()
                with(extension) {
                    bundle {
                        language {
                            enableSplit = false
                        }
                    }
                    signingConfigs {
                        if (isReleasedEnabled) {
                            val properties = Properties().apply {
                                load(FileInputStream(rootProject.file("signing/signing_info.properties")))
                            }
                            create(RELEASE) {
                                storeFile = rootProject.file(properties.getProperty("storeFile"))
                                storePassword = properties.getProperty("storePassword")
                                keyAlias = properties.getProperty("keyAlias")
                                keyPassword = properties.getProperty("keyPassword")
                            }
                        }
                    }
                    buildTypes {
                        getByName("debug") {
                            isMinifyEnabled = false
                            isShrinkResources = false
                        }
                        if (isReleasedEnabled) {
                            val release = getByName(RELEASE) {
                                signingConfig = extension.signingConfigs.getByName(RELEASE)
                                isDebuggable = false
                                isMinifyEnabled = true
                                isShrinkResources = true
                                proguardFiles(
                                    extension.getDefaultProguardFile("proguard-android-optimize.txt"),
                                    "../config/proguard-rules.pro"
                                )
                            }

                            create(BENCHMARK) {
                                initWith(release)
                                signingConfig = signingConfigs.getByName("debug")
                                matchingFallbacks.add("release")
                                proguardFiles("../config/benchmark-rules.pro")
                            }
                        }

                    }
                }
            }
            onVariants { variant ->
                logger.debug("Configuring variant: ${variant.name}")
                with(variant) {
                    buildConfigFields.apply {
                        put(
                            BASE_URL,
                            BuildConfigField(
                                STRING,
                                AndroidConfiguration.baseUrl,
                                ""
                            )
                        )
                        put(
                            DEEP_LINK_URI,
                            BuildConfigField(
                                STRING,
                                "\"${AndroidConfiguration.appHost}://${AndroidConfiguration.appId}\"",
                                "Deep Link Uri"
                            )
                        )
                    }
                    manifestPlaceholders.apply {
                        put("appHost", AndroidConfiguration.appHost)
                        put("appScheme", AndroidConfiguration.appId)
                    }
                }
            }
        }
    }

    companion object {
        private const val RELEASE = "release"
        private const val BENCHMARK = "benchmark"
        private const val BASE_URL = "BASE_URL"
        private const val DEEP_LINK_URI = "DEEP_LINK_URI"
        private const val STRING = "String"
    }
}