import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import io.gitlab.arturbosch.detekt.Detekt

buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.googleServices) apply false
    alias(libs.plugins.crashlytics) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.secrets)
    alias(libs.plugins.baselineProfile) apply false
    alias(libs.plugins.benManes)
    alias(libs.plugins.detekt)
    alias(libs.plugins.doctor)
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