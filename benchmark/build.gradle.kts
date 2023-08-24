@file:Suppress("UnstableApiUsage")

import com.steleot.jetpackcompose.playground.plugins.BaseAndroidConfigurationPlugin

plugins {
    kotlin(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.androidTest)
    id(BuildPlugins.baselineProfile)
}

apply<BaseAndroidConfigurationPlugin>()

android {
    namespace = "com.steleot.jetpackcompose.playground.benchmark"
    compileSdk = AndroidConfiguration.compileSdk

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    testOptions.managedDevices.devices {
        create<com.android.build.api.dsl.ManagedVirtualDevice>("pixel6Api31") {
            device = "Pixel 6"
            apiLevel = 31
            systemImageSource = "aosp"
        }
    }

    targetProjectPath = ":app"
    @Suppress("UnstableApiUsage")
    experimentalProperties["android.experimental.self-instrumenting"] = true
}

baselineProfile {
    managedDevices += "pixel6Api31"
    useConnectedDevices = false
}

dependencies {
    implementation(libs.junit)
    implementation(libs.espressoCore)
    implementation(libs.uiAutomator)
    implementation(libs.benchmark)
}
