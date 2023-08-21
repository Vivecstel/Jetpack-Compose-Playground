@file:Suppress("UnstableApiUsage")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") { from(files("catalogs/libs.versions.toml")) }
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
