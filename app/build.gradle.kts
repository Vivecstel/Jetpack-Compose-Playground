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

dependencies {
    implementation(project(":base"))
    debugImplementation(Libraries.kotlinReflect)
    implementation(Libraries.composeAnimation)
    implementation(Libraries.composeCompiler)
    implementation(Libraries.composeFoundation)
    implementation(Libraries.composeMaterial)
    implementation(Libraries.composeMaterialIcons)
    implementation(Libraries.composeRuntime)
    implementation(Libraries.composeLiveData)
    implementation(Libraries.composeUi)
    implementation(Libraries.composeUiUtil)
    implementation(Libraries.composeUiTooling)
    implementation(Libraries.composeNavigation)
    implementation(Libraries.composeConstraint)
    implementation(Libraries.composePaging)
    implementation(Libraries.composeActivity)
    implementation(Libraries.appCompat)
    implementation(Libraries.viewModel)
    implementation(platform(Libraries.firebaseBom))
    implementation(Libraries.firebaseAnalytics)
    implementation(Libraries.firebaseCrashlytics)
    implementation(Libraries.hilt)
    kapt(Libraries.hiltCompiler)
    implementation(Libraries.hiltNavigation)
    implementation(Libraries.startUp)
    implementation(Libraries.coroutines)
    implementation(Libraries.coroutinesAndroid)
    implementation(Libraries.dataStore)
    implementation(Libraries.protobufJavaLite)
    implementation(Libraries.playCore)
    implementation(Libraries.playCoreKtx)
    implementation(Libraries.cameraxCore)
    implementation(Libraries.camerax2)
    implementation(Libraries.cameraxLifecycle)
    implementation(Libraries.cameraxView)
    implementation(Libraries.accompanistInsets)
    implementation(Libraries.accompanistFlow)
    implementation(Libraries.accompanistPager)
    implementation(Libraries.accompanistPagerIndicators)
    implementation(Libraries.accompanistSystemuicontroller)
    implementation(Libraries.accompanistSwipeRefresh)
    implementation(Libraries.accompanistPermissions)
    implementation(Libraries.accompanistPlaceholderMaterial)
    implementation(Libraries.landscapistCoil)
    implementation(Libraries.landscapistGlide)
    implementation(Libraries.landscapistFresco)
    implementation(Libraries.orchestraBalloon)
    implementation(Libraries.orchestraColorPicker)
//    implementation(Libraries.orchestraSpinner)
    implementation(Libraries.coil)
    implementation(Libraries.coilCompose)
    implementation(Libraries.glide)
    kapt(Libraries.glideCompiler)
    implementation(Libraries.fresco)
    implementation(Libraries.timber)
    implementation(Libraries.lottie)
    implementation(Libraries.ratingBar)
    implementation(Libraries.revealSwipe)
    implementation(Libraries.speedDial)
    implementation(Libraries.fontAwesome)
//    implementation(Libraries.composeCharts)
//    implementation(Libraries.composeNeumorphism)
    implementation(Libraries.composeMarkdown)
    implementation(Libraries.adMob)

    androidTestImplementation(TestLibraries.composeUi)
    androidTestImplementation(TestLibraries.composeUiJunit)
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