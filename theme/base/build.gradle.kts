import com.steleot.jetpackcompose.playground.plugins.BaseAndroidConfigurationPlugin

plugins {
    id(BuildPlugins.androidLibrary)
    kotlin(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.parcelize)
}

apply<BaseAndroidConfigurationPlugin>()

android {
    namespace = "com.steleot.jetpackcompose.playground.theme"
    compileSdk = AndroidConfiguration.compileSdk

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}
