import com.steleot.jetpackcompose.playground.plugins.AddBenchmarkBuildTypePlugin
import com.steleot.jetpackcompose.playground.plugins.ApplicationAndroidConfigurationPlugin
import com.steleot.jetpackcompose.playground.plugins.BaseAndroidConfigurationPlugin
import com.steleot.jetpackcompose.playground.plugins.ComposeConfigurationPlugin

plugins {
    id(BuildPlugins.androidApplication)
    kotlin(BuildPlugins.kotlinAndroid)
    kotlin(BuildPlugins.kapt)
    id(BuildPlugins.parcelize)
    id(BuildPlugins.googleServices)
    id(BuildPlugins.crashlytics)
    id(BuildPlugins.hilt)
    alias(gradleLibraries.plugins.protobuf)
    alias(gradleLibraries.plugins.playPublisher)
    alias(gradleLibraries.plugins.kotlinSerialization)
    id(BuildPlugins.secrets)
}

apply<AddBenchmarkBuildTypePlugin>()
apply<ApplicationAndroidConfigurationPlugin>()
apply<BaseAndroidConfigurationPlugin>()
apply<ComposeConfigurationPlugin>()

android {
    namespace = "com.steleot.jetpackcompose.playground"
    compileSdk = AndroidConfiguration.compileSdk

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn", "-Xjvm-default=all")
    }
}

dependencies {
    implementation(project(Modules.ThemeBase))
    implementation(project(Modules.ThemeMaterial))
    implementation(project(Modules.ThemeMaterial3))
    implementation(project(Modules.UtilsAndroidExtensions))
    implementation(project(Modules.UtilsExtensions))
    implementation(project(Modules.Navigation))
    implementation(project(Modules.Resources))

    implementation(platform(androidx.composeBom))
    implementation(androidx.composeAnimation)
    implementation(androidx.composeAnimationGraphics)
//    implementation(androidx.composeCompiler)
    implementation(androidx.composeFoundation)
    implementation(androidx.composeMaterial)
    implementation(androidx.composeMaterialIcons)
    implementation(androidx.composeMaterial3)
    implementation(androidx.composeMaterial3WindowSizeClass)
    implementation(androidx.composeRuntime)
    implementation(androidx.composeLiveData)
    implementation(androidx.composeUi)
    implementation(androidx.composeUiUtil)
    implementation(androidx.composeUiTooling)
    implementation(androidx.profileInstaller)
    implementation(androidx.composeNavigation)
    implementation(androidx.glance)
    implementation(androidx.composeConstraint)
    implementation(androidx.composePaging)
    implementation(androidx.composeActivity)
    implementation(androidx.appCompat)
    implementation(androidx.viewModel)
    implementation(platform(google.firebaseBom))
    implementation(google.bundles.firebase)
    implementation(google.hilt)
    implementation(androidx.hiltNavigation)
    implementation(androidx.startUp)
    implementation(rest.coroutines)
    implementation(rest.coroutinesAndroid)
    implementation(rest.coroutinesPlayServices)
    implementation(androidx.dataStore)
    implementation(google.protobufJavaLite)
    implementation(google.bundles.playCore)
    implementation(androidx.bundles.camerax)
    implementation(androidx.workManager)
    implementation(google.bundles.mapsCompose)
    implementation(rest.retrofit)
    implementation(platform(rest.okhttpBom))
    implementation(rest.okhttp)
    implementation(rest.okhttpLogging)
    implementation(rest.kotlinxSerializationConverter)
    implementation(rest.kotlinxSerialization)
    implementation(google.bundles.accompanist)
    implementation(rest.bundles.landscapist)
    implementation(rest.orchestraBalloon)
    implementation(rest.orchestraColorPicker)
//  implementation(rest.orchestraSpinner)
    implementation(rest.coil)
    implementation(rest.coilCompose)
    implementation(rest.glide)
    implementation(rest.fresco)
    implementation(rest.timber)
    implementation(rest.lottie)
    implementation(rest.ratingBar)
    implementation(rest.revealSwipe)
    implementation(rest.speedDial)
    implementation(rest.fontAwesome)
    implementation(rest.composeCharts)
    implementation(rest.composeNeumorphism)
    implementation(rest.composeMarkdown)
    implementation(rest.composeBarcodes)
    implementation(rest.composeRichtextUi)
    implementation(rest.composeRichtextUiMaterial)
    implementation(rest.composeRichtextPrinting)
//  implementation(rest.composeRichtextSlideshow)
    implementation(rest.stageStepBar)
    implementation(rest.plot)
    implementation(rest.composeTimelineView)
    implementation(rest.composeParticleSystem)
    implementation(rest.ssJetPackComposeProgressButton)
    implementation(rest.gap)
//  implementation(rest.permissionsUi)
    implementation(rest.htmlText)
    implementation(rest.snapper)
    implementation(rest.composeShimmer)
    implementation(rest.zoomableComposeImage)
    implementation(rest.composeTreeMap)
    implementation(rest.heartSwitch)
    implementation(google.adMob)
    implementation(google.playServicesAuth)
    implementation(rest.orbital)

    kapt(google.hiltCompiler)
    kapt(rest.glideCompiler)

    debugImplementation(androidx.composeUiManifest)
    debugImplementation(androidx.tracing)
    androidTestImplementation(platform(androidx.composeBom))
    androidTestImplementation(androidx.composeUiTest)
    androidTestImplementation(androidx.composeUiJunit)
    androidTestImplementation(androidx.navigationTest)
    androidTestImplementation(androidx.testCore)
}

protobuf {
    protoc {
        val dependency = google.protobufProtoc.get()
        val protobuf =
            "${dependency.module.group}:${dependency.module.name}:${dependency.versionConstraint.requiredVersion}"
        val suffix = if (osdetector.os == "osx") ":osx-x86_64" else ""
        artifact = protobuf + suffix
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

play {
    releaseName.set(AndroidConfiguration.releaseName)
    serviceAccountCredentials.set(file(AndroidConfiguration.serviceAccountCredentials))
    artifactDir.set(file(AndroidConfiguration.artifactFile))
    track.set(AndroidConfiguration.track)
    updatePriority.set(AndroidConfiguration.updatePriority)
}