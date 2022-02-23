import com.steleot.jetpackcompose.playground.plugins.AddBenchmarkBuildTypePlugin
import com.steleot.jetpackcompose.playground.plugins.BaseAndroidConfigurationPlugin
import com.steleot.jetpackcompose.playground.plugins.ComposeConfigurationPlugin

plugins {
    id(BuildPlugins.androidLibrary)
    kotlin(BuildPlugins.kotlinAndroid)
}

apply<AddBenchmarkBuildTypePlugin>()
apply<BaseAndroidConfigurationPlugin>()
apply<ComposeConfigurationPlugin>()

android {
    compileSdk = AndroidConfiguration.compileSdk

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    api(project(Modules.ThemeBase))
    implementation(androidx.composeUi)
    implementation(androidx.composeMaterial3)
}