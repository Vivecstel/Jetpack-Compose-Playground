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
        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
    }
}

dependencies {
    implementation(project(Modules.ThemeMaterial3))
    implementation(project(Modules.UtilsExtensions))
    implementation(project(Modules.Resources))
    implementation(androidx.composeMaterial3)
    implementation(androidx.composeUi)
    implementation(androidx.composeActivity)
    implementation(google.accompanistInsets)
}