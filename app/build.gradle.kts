plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    kotlin(BuildPlugins.kapt)
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
    implementation(Libraries.composeConstraint)
    implementation(Libraries.appCompat)
    implementation(Libraries.viewModel)
    implementation(Libraries.startUp)
    implementation(Libraries.coroutines)
    implementation(Libraries.coroutinesAndroid)
    implementation(Libraries.accompanistCoil)
    implementation(Libraries.accompanistGlide)
    implementation(Libraries.accompanistPicasso)
    implementation(Libraries.accompanistInsets)
    implementation(Libraries.coil)
    implementation(Libraries.glide)
    kapt(Libraries.glideCompiler)
    implementation(Libraries.picasso)
    implementation(Libraries.timber)
    implementation(Libraries.lottie)

    androidTestImplementation(TestLibraries.composeUi)
    androidTestImplementation(TestLibraries.composeUiJunit)
}