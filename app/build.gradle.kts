plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
}

android {
    compileSdkVersion(AndroidConfiguration.compileSdk)
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId("com.steleot.jetpackcompose.playground")
        minSdkVersion(AndroidConfiguration.minSdk)
        targetSdkVersion(AndroidConfiguration.targetSdk)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
            kotlinOptions.freeCompilerArgs = listOf(
                "-Xallow-jvm-ir-dependencies",
                "-Xskip-prerelease-check",
                "-Xopt-in=kotlin.RequiresOptIn"
            )
            useIR = true
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

    lintOptions {
        isAbortOnError = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }

    packagingOptions {
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
    }
}

dependencies {

    // core / lifecycle runtime
    implementation(Libraries.composeAnimation)
    implementation(Libraries.composeCompiler)
    implementation(Libraries.composeFoundation)
    implementation(Libraries.composeMaterial)
    implementation(Libraries.composeMaterialIcons)
    implementation(Libraries.composeRuntime)
    implementation(Libraries.composeUi)
    implementation(Libraries.composeUiTooling)
    implementation(Libraries.composeNavigation)
    implementation(Libraries.composeLifecycle)
    implementation(Libraries.composeActivity)
    implementation(Libraries.appCompat)
    implementation(Libraries.viewModel)
    implementation(Libraries.startUp)
    implementation(Libraries.coroutines)
    implementation(Libraries.coroutinesAndroid)
    implementation(Libraries.accompanistCoil)
    implementation(Libraries.accompanistInsets)
    implementation(Libraries.coil)
    implementation(Libraries.timber)

    androidTestImplementation(TestLibraries.composeUi)
    androidTestImplementation(TestLibraries.composeUiJunit)
}