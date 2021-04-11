package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.airbnb.lottie.compose.rememberLottieAnimationState
import com.steleot.jetpackcompose.playground.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "external/LottieScreen.kt"

@Composable
fun LottieScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.Coil,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LottieAsset()
            LottieRaw()
        }
    }
}

@Composable
private fun LottieAsset() {
    val animationSpec = remember { LottieAnimationSpec.Asset("loading.json") }
    LottieAnimation(
        animationSpec,
        modifier = Modifier.size(150.dp),
        animationState = rememberLottieAnimationState(autoPlay = true, repeatCount = Int.MAX_VALUE)
    )
}

@Composable
private fun LottieRaw() {
    val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.wave_loading) }
    LottieAnimation(
        animationSpec,
        modifier = Modifier.size(150.dp),
        animationState = rememberLottieAnimationState(autoPlay = true, repeatCount = Int.MAX_VALUE)
    )
}
