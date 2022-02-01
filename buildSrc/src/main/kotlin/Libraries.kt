@file:Suppress("unused")

object Libraries {

    /* https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-reflect */
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"

    /* https://developer.android.com/jetpack/androidx/releases/compose-animation */
    const val composeAnimation = "androidx.compose.animation:animation:${Versions.compose}"
    const val composeAnimationGraphics =
        "androidx.compose.animation:animation-graphics:${Versions.compose}"

    /* https://developer.android.com/jetpack/androidx/releases/compose-compiler */
    const val composeCompiler = "androidx.compose.compiler:compiler:${Versions.compose}"

    /* https://developer.android.com/jetpack/androidx/releases/compose-foundation */
    const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.compose}"

    /* https://developer.android.com/jetpack/androidx/releases/compose-material */
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeMaterialIcons =
        "androidx.compose.material:material-icons-extended:${Versions.compose}"

    /* https://developer.android.com/jetpack/androidx/releases/compose-material3 */
    const val composeMaterial3 = "androidx.compose.material3:material3:${Versions.composeMaterial3}"

    /* https://developer.android.com/jetpack/androidx/releases/compose-runtime */
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val composeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"

    /* https://developer.android.com/jetpack/androidx/releases/compose-ui */
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiUtil = "androidx.compose.ui:ui-util:${Versions.compose}"

    /* https://developer.android.com/jetpack/androidx/releases/ui */
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"

    /* https://developer.android.com/jetpack/compose/layout */
    const val composeConstraint =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraint}"

    /* https://developer.android.com/jetpack/androidx/releases/paging */
    const val composePaging = "androidx.paging:paging-compose:${Versions.composePaging}"

    /* https://developer.android.com/jetpack/compose/navigation */
    const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"

    /* https://developer.android.com/jetpack/androidx/releases/glance */
    const val glance = "androidx.glance:glance-appwidget:${Versions.glance}"

    /* https://developer.android.com/jetpack/androidx/releases/core */
    const val core = "androidx.core:core:${Versions.core}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.core}"

    /* https://developer.android.com/jetpack/androidx/releases/activity */
    const val activity = "androidx.activity:activity:${Versions.activity}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.activity}"

    /* https://developer.android.com/jetpack/androidx/releases/appcompat */
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"

    /* https://developer.android.com/jetpack/androidx/releases/lifecycle */
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata:${Versions.lifecycle}"

    /* https://firebase.google.com/docs/android/learn-more */
    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebase}"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx"
    const val firebaseFirestore = "com.google.firebase:firebase-firestore-ktx"
    const val firebaseMessaging = "com.google.firebase:firebase-messaging-ktx"
    const val firebaseInstallations = "com.google.firebase:firebase-installations-ktx"
    const val firebaseAuth = "com.google.firebase:firebase-auth-ktx"

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
    const val coroutinesPlayServices =
        "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutines}"

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

    /* https://developer.android.com/jetpack/androidx/releases/work */
    const val workManager = "androidx.work:work-runtime:${Versions.workManager}"

    /* https://square.github.io/retrofit/ */
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

    /* https://github.com/square/okhttp */
    const val okhttpBom = "com.squareup.okhttp3:okhttp-bom:${Versions.okhttp}"
    const val okhttp = "com.squareup.okhttp3:okhttp"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor"

    /* https://github.com/JakeWharton/retrofit2-kotlinx-serialization-converter */
    const val kotlinxSerializationConverter =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.kotlinxSerializationConverter}"

    /* https://github.com/Kotlin/kotlinx.serialization */
    const val kotlinxSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}"

    /* https://github.com/chrisbanes/accompanist */
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
    const val accompanistPermissions =
        "com.google.accompanist:accompanist-permissions:${Versions.accompanist}"
    const val accompanistPlaceholderMaterial =
        "com.google.accompanist:accompanist-placeholder-material:${Versions.accompanist}"
    const val accompanistDrawablePainter =
        "com.google.accompanist:accompanist-drawablepainter:${Versions.accompanist}"
    const val accompanistNavigationAnimation =
        "com.google.accompanist:accompanist-navigation-animation:${Versions.accompanist}"
    const val accompanistNavigationMaterial =
        "com.google.accompanist:accompanist-navigation-material:${Versions.accompanist}"
    const val accompanistWebView =
        "com.google.accompanist:accompanist-webview:${Versions.accompanist}"

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
    const val coilCompose = "io.coil-kt:coil-compose:${Versions.coil}"

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
    const val ratingBar = "io.github.a914-gowtham:compose-ratingbar:${Versions.ratingBar}"

    /* https://github.com/ch4rl3x/RevealSwipe */
    const val revealSwipe = "de.charlex.compose:revealswipe:${Versions.revealSwipe}"

    /* https://github.com/ch4rl3x/SpeedDialFloatingActionButton */
    const val speedDial = "de.charlex.compose:speeddial:${Versions.speedDial}"

    /* https://github.com/Gurupreet/FontAwesomeCompose */
    const val fontAwesome = "com.github.Gurupreet:FontAwesomeCompose:${Versions.fontAwesome}"

    /* https://github.com/humawork/compose-charts */
    const val composeCharts = "ma.hu:compose-charts:${Versions.composeCharts}"

    /* https://github.com/CuriousNikhil/neumorphic-compose */
    const val composeNeumorphism =
        "me.nikhilchaudhari:composeNeumorphism:${Versions.composeNeumorphism}"

    /* https://github.com/jeziellago/compose-markdown */
    const val composeMarkdown = "com.github.jeziellago:compose-markdown:${Versions.composeMarkdown}"

    /* https://github.com/simonsickle/ComposedBarcodes */
    const val composeBarcodes = "com.simonsickle:composed-barcodes:${Versions.composeBarcodes}"

    /* https://github.com/halilozercan/compose-richtext */
    const val composeRichtextUi =
        "com.halilibo.compose-richtext:richtext-ui:${Versions.composeRichtext}"
    const val composeRichtextUiMaterial =
        "com.halilibo.compose-richtext:richtext-ui-material:${Versions.composeRichtext}"
    const val composeRichtextPrinting =
        "com.halilibo.compose-richtext:printing:${Versions.composeRichtext}"
    const val composeRichtextSlideshow =
        "com.halilibo.compose-richtext:slideshow:${Versions.composeRichtext}"

    /* https://github.com/loukwn/StageStepBar */
    const val stageStepBar =
        "com.github.loukwn.StageStepBar:stagestepbar-compose:${Versions.stageStepBar}"

    /* https://github.com/Madrapps/plot */
    const val plot = "com.github.madrapps:plot:${Versions.plot}"

    /* https://github.com/jisungbin/ComposeTimeLineView */
    const val composeTimelineView =
        "io.github.jisungbin:timelineview:${Versions.composeTimelineView}"

    /* https://github.com/CuriousNikhil/compose-particle-system */
    const val composeParticleSystem = "me.nikhilchaudhari:quarks:${Versions.composeParticleSystem}"

    /* https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton */
    const val ssJetPackComposeProgressButton =
        "com.github.SimformSolutionsPvtLtd:SSJetPackComposeProgressButton:${Versions.ssJetPackComposeProgressButton}"

    /* https://github.com/wasabeef/compose-gap */
    const val gap = "jp.wasabeef:gap:${Versions.gap}"

    /* https://github.com/warting/permissions-ui */
    const val permissionsUi = "se.warting.permissionsui:permissionsui:${Versions.permissionsUi}"

    /* https://github.com/ch4rl3x/HtmlText */
    const val htmlText = "de.charlex.compose:html-text:${Versions.htmlText}"

    /* https://github.com/chrisbanes/snapper */
    const val snapper = "dev.chrisbanes.snapper:snapper:${Versions.snapper}"

    /* https://github.com/valentinilk/compose-shimmer */
    const val composeShimmer = "com.valentinilk.shimmer:compose-shimmer:${Versions.composeShimmer}"

    /* https://github.com/re-ovo/ZoomableComposeImage */
    const val zoomableComposeImage =
        "com.github.re-ovo:ZoomableComposeImage:${Versions.zoomableComposeImage}"

    /* https://github.com/overpas/compose-treemap-chart */
    const val composeTreeMap =
        "io.github.overpas:treemap-compose-android:${Versions.composeTreeMap}"

    /* https://firebase.google.com/docs/admob/android/quick-start */
    const val adMob = "com.google.android.gms:play-services-ads:${Versions.adMob}"

    /* https://firebase.google.com/docs/auth/android/google-signin */
    const val playServicesAuth =
        "com.google.android.gms:play-services-auth:${Versions.playServicesAuth}"
}