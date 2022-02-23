@file:Suppress("UnstableApiUsage")

dependencyResolutionManagement {
    versionCatalogs {
        create("androidx") { from(files("catalogs/androidx.versions.toml")) }
        create("google") { from(files("catalogs/google.versions.toml")) }
        create("gradleLibraries") { from(files("catalogs/gradle.versions.toml")) }
        create("rest") { from(files("catalogs/rest.versions.toml")) }
    }
}

include(
    "app",
    ":theme:base",
    ":theme:material",
    ":theme:material3",
    ":utils:extensions",
    ":utils:androidextensions",
    ":benchmark"
)
