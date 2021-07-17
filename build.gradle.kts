import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import io.gitlab.arturbosch.detekt.Detekt

plugins {
    kotlin(BuildPlugins.kotlinJvm) version Versions.kotlin
    id(BuildPlugins.benManes) version Versions.benManes
    id(BuildPlugins.detekt) version Versions.detekt
//    id(BuildPlugins.gradleDoctor) version Versions.doctor
}

buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath(GradleLibraries.androidPlugin)
        classpath(GradleLibraries.googleServices)
        classpath(GradleLibraries.crashlytics)
        classpath(GradleLibraries.hiltPlugin)
    }
}

allprojects {
    repositories {
        google()
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://kotlin.bintray.com/kotlinx")
        maven("https://jitpack.io")
        mavenCentral()
    }

    configurations.all {
        resolutionStrategy.force(
            Libraries.composeAnimation, Libraries.composeFoundation, Libraries.composeRuntime,
            Libraries.composeUi, Libraries.core, Libraries.coreKtx, Libraries.activity,
            Libraries.viewModel, Libraries.liveData
        )
    }
}

tasks.named<DependencyUpdatesTask>("dependencyUpdates").configure {
    checkForGradleUpdate = true
    outputDir = "${rootProject.buildDir}/dependencyUpdates"
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
        xml.enabled = false
        html {
            enabled = true
            destination = file("${rootProject.buildDir}/reports/detekt-report.html")
        }
        txt.enabled = false
    }
}