@file:Suppress("unused")

object TestLibraries {

    /* https://developer.android.com/jetpack/compose/testing */
    const val composeUi = "androidx.compose.ui:ui-test:${Versions.compose}"
    const val composeUiJunit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val composeUiManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"

    /* https://developer.android.com/jetpack/compose/navigation */
    const val navigation = "androidx.navigation:navigation-testing:${Versions.navigation}"

    /* https://developer.android.com/jetpack/androidx/releases/test */
    const val testCore = "androidx.test:core:${Versions.test}"
    const val junit = "androidx.test.ext:junit:${Versions.junit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    /* https://developer.android.com/training/testing/other-components/ui-automator */
    const val uiAutomator = "androidx.test.uiautomator:uiautomator:${Versions.uiAutomator}"

    /* https://developer.android.com/jetpack/androidx/releases/benchmark */
    const val benchmark = "androidx.benchmark:benchmark-macro-junit4:${Versions.benchmark}"
}