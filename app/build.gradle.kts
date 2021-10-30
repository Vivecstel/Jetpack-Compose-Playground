import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc
import java.io.FileInputStream
import java.util.Properties

plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    kotlin(BuildPlugins.kapt)
    id(BuildPlugins.parcelize)
    id(BuildPlugins.googleServices)
    id(BuildPlugins.crashlytics)
    id(BuildPlugins.hilt)
    id(BuildPlugins.protobuf) version Versions.protobufPlugin
    id(BuildPlugins.playPublisher) version Versions.playPublisher
    kotlin(BuildPlugins.serialization) version Versions.kotlin
}

android {
    compileSdk = AndroidConfiguration.compileSdk
    buildToolsVersion = Versions.buildTools

    defaultConfig {
        applicationId = AndroidConfiguration.appId
        minSdk = AndroidConfiguration.minSdk
        targetSdk = AndroidConfiguration.targetSdk
        versionCode = AndroidConfiguration.versionCode
        versionName = AndroidConfiguration.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "BASE_URL", AndroidConfiguration.baseUrl)
    }

    val isReleasedEnabled = rootProject.file("signing/signing_info.properties").exists()

    signingConfigs {
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

    buildTypes {
        if (isReleasedEnabled) {
            getByName("release") {
                signingConfig = signingConfigs.getByName("release")
                isMinifyEnabled = true
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
            kotlinOptions.freeCompilerArgs = listOf(
                "-Xskip-prerelease-check",
                "-Xopt-in=kotlin.RequiresOptIn"
            )
        }
    }

    buildFeatures {
        compose = true
        viewBinding = true

        // Disable unused AGP features
        aidl = false
        renderScript = false
        resValues = false
        shaders = false
    }

    lint {
        isAbortOnError = true
    }

    packagingOptions {
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
    }
}

configurations.all {
    resolutionStrategy.eachDependency {
        if (requested.group.contains("org.jetbrains.compose")) {
            val groupName = requested.group.replace("org.jetbrains.compose", "androidx.compose")
            useTarget(
                mapOf("group" to groupName, "name" to requested.name, "version" to Versions.compose)
            )
        }
    }
}

dependencies {
    AppDependencies.project.forEach { implementation(project(it)) }
    AppDependencies.bom.forEach { implementation(platform(it)) }
    AppDependencies.implementation.forEach { implementation(it) }
    AppDependencies.kapt.forEach { kapt(it) }
    AppDependencies.debug.forEach { debugImplementation(it) }
    AppDependencies.androidTest.forEach { androidTestImplementation(it) }
}

protobuf {
    protoc {
        artifact = Libraries.protobufProtoc
    }

    generateProtoTasks {
        all().forEach { task ->
            task.plugins {
                create("java") {
                    option("lite")
                }
            }
        }
    }
}

play {
    releaseName.set(AndroidConfiguration.releaseName)
    serviceAccountCredentials.set(file(AndroidConfiguration.serviceAccountCredentials))
    artifactDir.set(file(AndroidConfiguration.artifactFile))
    track.set(AndroidConfiguration.track)
    updatePriority.set(AndroidConfiguration.updatePriority)
}