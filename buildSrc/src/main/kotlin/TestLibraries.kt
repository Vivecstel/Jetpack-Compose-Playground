@file:Suppress("unused")

object TestLibraries {

    /* https://developer.android.com/jetpack/compose/testing */
    const val composeUi = "androidx.compose.ui:ui-test:${Versions.compose}"
    const val composeUiJunit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val composeUiManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"

    /* https://developer.android.com/jetpack/androidx/releases/test */
    const val testCore = "androidx.test:core:${Versions.test}"
}