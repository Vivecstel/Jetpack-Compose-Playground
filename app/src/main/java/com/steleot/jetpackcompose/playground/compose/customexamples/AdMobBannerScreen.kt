package com.steleot.jetpackcompose.playground.compose.customexamples

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.graph.CustomExamplesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import timber.log.Timber

private const val Url = "customexamples/AdMobBannerScreen.kt"

@Composable
fun AdMobBannerScreen() {
    DefaultScaffold(
        title = CustomExamplesNavRoutes.AdMobBanner,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AdViewExample(R.string.ad_mob_banner_id)
        }
    }
}

@Composable
fun AdViewExample(
    @StringRes adStringRes: Int
) {
    val adView = rememberAdMobWithLifecycle(adStringRes)
    AndroidView({ adView })
}

@SuppressLint("MissingPermission")
@Composable
private fun rememberAdMobWithLifecycle(
    @StringRes adStringRes: Int
): AdView {
    val context = LocalContext.current
    val adView = remember {
        AdView(context).apply {
            setAdSize(AdSize.BANNER)
            adUnitId = context.getString(adStringRes)
        }
    }
    adView.loadAd(AdRequest.Builder().build())
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(key1 = lifecycle, key2 = adView) {
        val lifecycleObserver = getAdLifecycleObserver(adView)
        lifecycle.addObserver(lifecycleObserver)
        onDispose {
            lifecycle.removeObserver(lifecycleObserver)
        }
    }

    return adView
}

private fun getAdLifecycleObserver(adView: AdView): LifecycleEventObserver =
    LifecycleEventObserver { _, event ->
        when (event) {
            Lifecycle.Event.ON_RESUME -> adView.resume()
            Lifecycle.Event.ON_PAUSE -> adView.pause()
            Lifecycle.Event.ON_DESTROY -> adView.destroy()
            else -> Timber.d("Ignored rest lifecycle events for adview")
        }
    }