@file:Suppress("MemberVisibilityCanBePrivate")

object AndroidConfiguration {

    const val minSdk = 23
    const val compileSdk = 31
    const val targetSdk = compileSdk

    const val appId = "com.steleot.jetpackcompose.playground"
    const val versionCode = 50
    const val versionName = "4.2.0"

    private const val branch = "master"
    const val baseUrl = "\"https://github.com/Vivecstel/Jetpack-Compose-Playground/blob/$branch/" +
            "app/src/main/java/com/steleot/jetpackcompose/playground/compose/\""

    const val releaseName = "$versionCode ($versionName)"
    const val serviceAccountCredentials = "jetpack-compose-playground-play-publishing.json"
    const val artifactFile = "build/outputs/bundle/release/app-release.aab"
    const val track = "production"
    const val updatePriority = 2
}
