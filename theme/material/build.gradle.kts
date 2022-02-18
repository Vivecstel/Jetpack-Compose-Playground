plugins {
    id(BuildPlugins.androidLibrary)
    kotlin(BuildPlugins.kotlinAndroid)
}

android {
    compileSdk = AndroidConfiguration.compileSdk

    defaultConfig {
        minSdk = AndroidConfiguration.minSdk
        targetSdk = AndroidConfiguration.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildTypes {
        create("benchmark")
    }
}

dependencies {
    implementation(project(Modules.ThemeBase))
    implementation(Libraries.composeUi)
    implementation(Libraries.composeMaterial)
}