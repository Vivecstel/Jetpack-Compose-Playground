@file:Suppress("MemberVisibilityCanBePrivate")

object AndroidConfiguration {

    const val minSdk = 23
    const val minWearSdk = 25
    const val compileSdk = 31
    const val targetSdk = compileSdk

    const val appId = "com.steleot.jetpackcompose.playground"
    const val versionCode = 36
    const val versionName = "2.9.1"

    private const val branch = "develop"
    const val baseUrl = "\"https://github.com/Vivecstel/Jetpack-Compose-Playground/blob/$branch/" +
            "app/src/main/java/com/steleot/jetpackcompose/playground/compose/\""
}
