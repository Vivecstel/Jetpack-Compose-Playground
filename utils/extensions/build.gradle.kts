plugins {
    id(BuildPlugins.javaLibrary)
    kotlin(BuildPlugins.kotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}