@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") { from(files("catalogs/libs.versions.toml")) }
    }
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

include(
    "app",
    ":theme:base",
    ":theme:material",
    ":theme:material3",
    ":utils:extensions",
    ":utils:androidextensions",
    ":navigation",
    ":resources",
    ":benchmark"
)
