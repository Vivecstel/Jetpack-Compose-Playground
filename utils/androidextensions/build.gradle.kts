import com.steleot.jetpackcompose.playground.plugins.BaseAndroidConfigurationPlugin

plugins {
    id(BuildPlugins.androidLibrary)
    kotlin(BuildPlugins.kotlinAndroid)
}

apply<BaseAndroidConfigurationPlugin>()

android {
    namespace = "com.steleot.jetpackcompose.playground.utils"
    compileSdk = AndroidConfiguration.compileSdk

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    implementation(libs.coreKtx)
}