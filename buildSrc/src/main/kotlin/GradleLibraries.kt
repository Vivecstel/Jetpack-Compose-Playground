object GradleLibraries {

    /* https://developer.android.com/studio/releases/gradle-plugin */
    const val androidPlugin = "com.android.tools.build:gradle:${Versions.androidPlugin}"

    /* https://developer.android.com/training/dependency-injection/hilt-android */
    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    /* https://developers.google.com/android/guides/google-services-plugin */
    const val googleServices = "com.google.gms:google-services:${Versions.googleServices}"

    /* https://firebase.google.com/docs/crashlytics/get-started?platform=android */
    const val crashlytics =
        "com.google.firebase:firebase-crashlytics-gradle:${Versions.crashlytics}"
}