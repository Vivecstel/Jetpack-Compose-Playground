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
    alias(libs.plugins.protobuf)
    alias(libs.plugins.playPublisher)
    alias(libs.plugins.kotlinSerialization)
    id(BuildPlugins.secrets)
    id(BuildPlugins.baselineProfile)
}

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

    implementation(platform(libs.composeBom))
    implementation(libs.composeAnimation)
    implementation(libs.composeAnimationGraphics)
    implementation(libs.composeFoundation)
    implementation(libs.composeMaterial)
    implementation(libs.composeMaterialIcons)
    implementation(libs.composeMaterial3)
    implementation(libs.composeMaterial3WindowSizeClass)
    implementation(libs.composeRuntime)
    implementation(libs.composeLiveData)
    implementation(libs.composeUi)
    implementation(libs.composeUiUtil)
    implementation(libs.composeUiTooling)
    implementation(libs.profileInstaller)
    implementation(libs.composeNavigation)
    implementation(libs.glance)
    implementation(libs.composeConstraint)
    implementation(libs.composePaging)
    implementation(libs.composeActivity)
    implementation(libs.appCompat)
    implementation(libs.viewModel)
    implementation(platform(libs.firebaseBom))
    implementation(libs.bundles.firebase)
    implementation(libs.hilt)
    implementation(libs.hiltNavigation)
    implementation(libs.startUp)
    implementation(libs.coroutines)
    implementation(libs.coroutinesAndroid)
    implementation(libs.coroutinesPlayServices)
    implementation(libs.dataStore)
    implementation(libs.protobufJavaLite)
    implementation(libs.bundles.playCore)
    implementation(libs.bundles.camerax)
    implementation(libs.workManager)
    implementation(libs.bundles.mapsCompose)
    implementation(libs.retrofit)
    implementation(platform(libs.okhttpBom))
    implementation(libs.okhttp)
    implementation(libs.okhttpLogging)
    implementation(libs.kotlinxSerializationConverter)
    implementation(libs.kotlinxSerialization)
    implementation(libs.bundles.accompanist)
    implementation(libs.bundles.landscapist)
    implementation(libs.orchestraBalloon)
    implementation(libs.orchestraColorPicker)
//  implementation(libs.orchestraSpinner)
    implementation(libs.coil)
    implementation(libs.coilCompose)
    implementation(libs.glide)
    implementation(libs.fresco)
    implementation(libs.timber)
    implementation(libs.lottie)
    implementation(libs.ratingBar)
    implementation(libs.revealSwipe)
    implementation(libs.speedDial)
    implementation(libs.fontAwesome)
    implementation(libs.composeCharts)
    implementation(libs.composeNeumorphism)
    implementation(libs.composeMarkdown)
    implementation(libs.composeBarcodes)
    implementation(libs.composeRichtextUi)
    implementation(libs.composeRichtextUiMaterial)
    implementation(libs.composeRichtextPrinting)
//  implementation(libs.composeRichtextSlideshow)
    implementation(libs.stageStepBar)
    implementation(libs.plot)
    implementation(libs.composeTimelineView)
    implementation(libs.composeParticleSystem)
    implementation(libs.ssJetPackComposeProgressButton)
    implementation(libs.gap)
//  implementation(libs.permissionsUi)
    implementation(libs.htmlText)
    implementation(libs.composeShimmer)
    implementation(libs.zoomableComposeImage)
    implementation(libs.composeTreeMap)
    implementation(libs.heartSwitch)
    implementation(libs.adMob)
    implementation(libs.playServicesAuth)
    implementation(libs.orbital)

    kapt(libs.hiltCompiler)
    kapt(libs.glideCompiler)

    debugImplementation(libs.composeUiManifest)
    debugImplementation(libs.tracing)
    androidTestImplementation(platform(libs.composeBom))
    androidTestImplementation(libs.composeUiTest)
    androidTestImplementation(libs.composeUiJunit)
    androidTestImplementation(libs.navigationTest)
    androidTestImplementation(libs.testCore)

    baselineProfile(project(":benchmark"))
}

protobuf {
    protoc {
        val dependency = libs.protobufProtoc.get()
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