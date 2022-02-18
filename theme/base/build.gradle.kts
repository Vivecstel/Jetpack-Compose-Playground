plugins {
    id(BuildPlugins.androidLibrary)
    kotlin(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.parcelize)
}

android {
    compileSdk = AndroidConfiguration.compileSdk
    buildToolsVersion = Versions.buildTools

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
    implementation(Libraries.composeUi)
}