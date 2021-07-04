package com.steleot.jetpackcompose.playground.compose.customexamples

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.CustomExamplesNavRoutes

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
    val lifecycleOwner = LocalLifecycleOwner.current
    AndroidView(
        factory = { context ->
            com.google.android.gms.ads.AdView(context).apply {
                adSize = AdSize.BANNER
                adUnitId = context.getString(adStringRes)
            }
        },
        update = { view ->
            view.loadAd(AdRequest.Builder().build())
            lifecycleOwner.lifecycle.addObserver(object :
                DefaultLifecycleObserver {
                override fun onPause(owner: LifecycleOwner) {
                    view.pause()
                }

                override fun onResume(owner: LifecycleOwner) {
                    view.resume()
                }

                override fun onDestroy(owner: LifecycleOwner) {
                    view.destroy()
                }
            })
        }
    )
}