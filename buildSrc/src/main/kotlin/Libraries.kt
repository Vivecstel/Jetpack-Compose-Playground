object Libraries {

    /* https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-reflect */
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"

    /* https://developer.android.com/jetpack/androidx/releases/compose-animation */
    const val composeAnimation = "androidx.compose.animation:animation:${Versions.compose}"

    /* https://developer.android.com/jetpack/androidx/releases/compose-compiler */
    const val composeCompiler = "androidx.compose.compiler:compiler:${Versions.compose}"

    /* https://developer.android.com/jetpack/androidx/releases/compose-foundation */
    const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.compose}"

    /* https://developer.android.com/jetpack/androidx/releases/compose-material */
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeMaterialIcons =
        "androidx.compose.material:material-icons-extended:${Versions.compose}"

    /* https://developer.android.com/jetpack/androidx/releases/compose-runtime */
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val composeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"

    /* https://developer.android.com/jetpack/androidx/releases/compose-ui */
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiUtil = "androidx.compose.ui:ui-util:${Versions.compose}"

    /* https://developer.android.com/jetpack/androidx/releases/ui */
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"

    /* https://developer.android.com/jetpack/compose/navigation */
    const val composeNavigation =
        "androidx.navigation:navigation-compose:${Versions.composeNavigation}"

    /* https://developer.android.com/jetpack/androidx/releases/activity */
    const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"

    /* https://developer.android.com/jetpack/compose/layout */
    const val composeConstraint =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraint}"

    /* https://developer.android.com/jetpack/androidx/releases/paging */
    const val composePaging = "androidx.paging:paging-compose:${Versions.composePaging}"

    /* https://developer.android.com/jetpack/androidx/releases/appcompat */
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"

    /* https://developer.android.com/jetpack/androidx/releases/lifecycle */
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    /* https://firebase.google.com/docs/android/learn-more */
    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebase}"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx"

    /* https://developer.android.com/training/dependency-injection/hilt-android */
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.hiltCompose}"

    /* https://developer.android.com/jetpack/androidx/releases/startup */
    const val startUp = "androidx.startup:startup-runtime:${Versions.startUp}"

    /* https://github.com/Kotlin/kotlinx.coroutines */
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    /* https://developer.android.com/topic/libraries/architecture/datastore */
    const val dataStore = "androidx.datastore:datastore:${Versions.dataStore}"

    /* https://github.com/protocolbuffers/protobuf */
    const val protobufProtoc = "com.google.protobuf:protoc:${Versions.protobuf}"
    const val protobufJavaLite = "com.google.protobuf:protobuf-javalite:${Versions.protobuf}"

    /* https://developer.android.com/guide/playcore */
    const val playCore = "com.google.android.play:core:${Versions.playCore}"
    const val playCoreKtx = "com.google.android.play:core-ktx:${Versions.playCoreKtx}"

    /* https://developer.android.com/jetpack/androidx/releases/camera */
    const val cameraxCore = "androidx.camera:camera-core:${Versions.cameraX}"
    const val camerax2 = "androidx.camera:camera-camera2:${Versions.cameraX}"
    const val cameraxLifecycle = "androidx.camera:camera-lifecycle:${Versions.cameraX}"
    const val cameraxView = "androidx.camera:camera-view:${Versions.cameraView}"

    /* https://github.com/chrisbanes/accompanist */
    const val accompanistCoil =
        "com.google.accompanist:accompanist-coil:${Versions.accompanist}"
    const val accompanistGlide =
        "com.google.accompanist:accompanist-glide:${Versions.accompanist}"
    const val accompanistInsets =
        "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
    const val accompanistFlow =
        "com.google.accompanist:accompanist-flowlayout:${Versions.accompanist}"
    const val accompanistPager =
        "com.google.accompanist:accompanist-pager:${Versions.accompanist}"
    const val accompanistPagerIndicators =
        "com.google.accompanist:accompanist-pager-indicators:${Versions.accompanist}"
    const val accompanistSystemuicontroller =
        "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}"
    const val accompanistSwipeRefresh =
        "com.google.accompanist:accompanist-swiperefresh:${Versions.accompanist}"

    /* https://github.com/skydoves/Landscapist */
    const val landscapistCoil = "com.github.skydoves:landscapist-coil:${Versions.landscapist}"
    const val landscapistGlide = "com.github.skydoves:landscapist-glide:${Versions.landscapist}"
    const val landscapistFresco = "com.github.skydoves:landscapist-fresco:${Versions.landscapist}"

    /* https://github.com/skydoves/Orchestra */
    const val orchestraBalloon = "com.github.skydoves:orchestra-balloon:${Versions.orchestra}"
    const val orchestraColorPicker =
        "com.github.skydoves:orchestra-colorpicker:${Versions.orchestra}"
    const val orchestraSpinner = "com.github.skydoves:orchestra-spinner:${Versions.orchestra}"

    /* https://github.com/coil-kt/coil/ */
    const val coil = "io.coil-kt:coil:${Versions.coil}"

    /* https://github.com/bumptech/glide */
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    /* https://github.com/facebook/fresco */
    const val fresco = "com.facebook.fresco:fresco:${Versions.fresco}"

    /* https://github.com/JakeWharton/timber */
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    /* https://github.com/kazemihabib/compose-shimmer */
    const val lottie = "com.airbnb.android:lottie-compose:${Versions.lottie}"

    /* https://github.com/a914-gowtham/compose-ratingbar */
    const val ratingBar = "com.github.a914-gowtham:compose-ratingbar:${Versions.ratingBar}"

    /* https://github.com/ch4rl3x/RevealSwipe */
    const val revealSwipe = "de.charlex.compose:revealswipe:${Versions.revealSwipe}"

    /* https://github.com/ch4rl3x/SpeedDialFloatingActionButton */
    const val speedDial = "de.charlex.compose:speeddial:${Versions.speedDial}"

    /* https://firebase.google.com/docs/admob/android/quick-start */
    const val adMob = "com.google.android.gms:play-services-ads:${Versions.adMob}"
}