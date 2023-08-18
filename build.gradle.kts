import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import io.gitlab.arturbosch.detekt.Detekt

plugins {
    alias(gradleLibraries.plugins.kotlinJvm)
    alias(gradleLibraries.plugins.benManes)
    alias(gradleLibraries.plugins.detekt)
    alias(gradleLibraries.plugins.doctor)
}

buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath(gradleLibraries.kotlinGradle)
        classpath(gradleLibraries.androidPlugin)
        classpath(gradleLibraries.googleServices)
        classpath(gradleLibraries.crashlytics)
        classpath(gradleLibraries.hiltPlugin)
        classpath(gradleLibraries.secrets)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }

    // todo stelios revisit
//    configurations.all {
//        resolutionStrategy.force(
//            androidx.composeAnimation,
//            androidx.composeFoundation,
//            androidx.composeRuntime,
//            androidx.composeUi,
//            androidx.core,
//            androidx.coreKtx,
//            androidx.activity,
//            androidx.viewModel,
//            androidx.liveData
//        )
//    }
}

doctor {
    warnWhenNotUsingParallelGC.set(false)
    javaHome {
        failOnError.set(false)
    }
}

tasks.named<DependencyUpdatesTask>("dependencyUpdates").configure {
    checkForGradleUpdate = true
    outputDir = "${rootProject.layout.buildDirectory.file("dependencyUpdates").get()}"
}

val detektAll by tasks.registering(Detekt::class) {
    description = "Runs over whole code base without the starting overhead for each module."
    parallel = true
    buildUponDefaultConfig = true
    setSource(files(projectDir))
    config.from(files(project.rootDir.resolve("config/detekt-config.yml")))
    include("**/*.kt", "**/*.kts")
    exclude("**/resources/**", "**/build/**")
    baseline.set(project.rootDir.resolve("config/detekt-baseline.xml"))
    reports {
        xml.required.set(false)
        html {
            required.set(true)
            outputLocation.set(rootProject.layout.buildDirectory.file("reports/detekt-report.html"))
        }
        txt.required.set(false)
    }
}