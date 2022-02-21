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
        project.extensions.getByType(ApplicationAndroidComponentsExtension::class.java).apply {
            finalizeDsl { extension ->
                logger.debug("FinalizingDsl")
                extension.bundle {
                    language {
                        enableSplit = false
                    }
                }
                val rootProject = project.rootProject
                val isReleasedEnabled = rootProject.file("signing/signing_info.properties").exists()
                extension.signingConfigs {
                    if (isReleasedEnabled) {
                        val properties = Properties().apply {
                            load(FileInputStream(rootProject.file("signing/signing_info.properties")))
                        }
                        create("release") {
                            storeFile = rootProject.file(properties.getProperty("storeFile"))
                            storePassword = properties.getProperty("storePassword")
                            keyAlias = properties.getProperty("keyAlias")
                            keyPassword = properties.getProperty("keyPassword")
                        }
                    }
                }
                extension.buildTypes {
                    if (isReleasedEnabled) {
                        getByName("release") {
                            signingConfig = extension.signingConfigs.getByName("release")
                            isMinifyEnabled = true
                            proguardFiles(
                                extension.getDefaultProguardFile("proguard-android-optimize.txt"),
                                "../config/proguard-rules.pro"
                            )
                        }
                    }
                }
            }
            onVariants { variant ->
                logger.debug("Configuring variant: ${variant.name}")
                variant.buildConfigFields.apply {
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
                variant.manifestPlaceholders.apply {
                    put("appHost", AndroidConfiguration.appHost)
                    put("appScheme", AndroidConfiguration.appId)
                }
            }
        }
    }

    companion object {
        private const val BASE_URL = "BASE_URL"
        private const val DEEP_LINK_URI = "DEEP_LINK_URI"
        private const val STRING = "String"
    }
}