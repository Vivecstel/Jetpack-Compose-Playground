package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "externallibraries/LottieScreen.kt"

@Composable
fun LottieScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.Lottie,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LottiePlayOnce()
            LottieRepeatForever()
            LottieRepeatForeverWithAnimateLottieCompositionAsState()
            LottieRepeatForeverWithLottieAnimatable()
        }
    }
}

@Composable
private fun LottiePlayOnce() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.heart_like))
    LottieAnimation(
        composition,
        modifier = Modifier.size(150.dp)
    )
}

@Composable
private fun LottieRepeatForever() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.wave_loading))
    LottieAnimation(
        composition,
        modifier = Modifier.size(150.dp),
        iterations = LottieConstants.IterateForever,
    )
}

@Composable
private fun LottieRepeatForeverWithAnimateLottieCompositionAsState() {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("loading.json"))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
    )
    LottieAnimation(
        composition,
        progress,
        modifier = Modifier.size(150.dp)
    )
}

private const val LOTTIE_URL = "https://assets7.lottiefiles.com/datafiles/bEYvzB8QfV3EM9a/data.json"

@Composable
private fun LottieRepeatForeverWithLottieAnimatable() {
    val anim = rememberLottieAnimatable()
    val composition by rememberLottieComposition(LottieCompositionSpec.Url(LOTTIE_URL))
    LaunchedEffect(composition) {
        anim.animate(
            composition,
            iterations = LottieConstants.IterateForever,
        )
    }
    LottieAnimation(
        anim.composition,
        anim.progress,
        modifier = Modifier.size(150.dp)
    )
}
