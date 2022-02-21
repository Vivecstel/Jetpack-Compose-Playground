import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc
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
    id(BuildPlugins.protobuf) version Versions.protobufPlugin
    id(BuildPlugins.playPublisher) version Versions.playPublisher
    kotlin(BuildPlugins.serialization) version Versions.kotlin
    id(BuildPlugins.secrets)
}

apply<AddBenchmarkBuildTypePlugin>()
apply<ApplicationAndroidConfigurationPlugin>()
apply<BaseAndroidConfigurationPlugin>()
apply<ComposeConfigurationPlugin>()

android {
    compileSdk = AndroidConfiguration.compileSdk

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
            kotlinOptions.freeCompilerArgs = listOf(
                "-Xopt-in=kotlin.RequiresOptIn",
            )
        }
    }
}

dependencies {
    AppDependencies.project.forEach { implementation(project(it)) }
    AppDependencies.bom.forEach { implementation(platform(it)) }
    AppDependencies.implementation.forEach { implementation(it) }
    AppDependencies.kapt.forEach { kapt(it) }
    AppDependencies.androidTest.forEach { androidTestImplementation(it) }
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

play {
    releaseName.set(AndroidConfiguration.releaseName)
    serviceAccountCredentials.set(file(AndroidConfiguration.serviceAccountCredentials))
    artifactDir.set(file(AndroidConfiguration.artifactFile))
    track.set(AndroidConfiguration.track)
    updatePriority.set(AndroidConfiguration.updatePriority)
}