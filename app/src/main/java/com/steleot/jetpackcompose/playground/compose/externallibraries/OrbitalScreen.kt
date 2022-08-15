package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.skydoves.orbital.Orbital
import com.skydoves.orbital.animateMovement
import com.skydoves.orbital.rememberContentWithOrbitalScope
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import com.steleot.jetpackcompose.playground.utils.randomSampleImageUrl

private const val Url = "externallibraries/OrbitalScreen.kt"

@Composable
fun OrbitalScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.Orbital,
        link = Url,
    ) {
        OrbitalExample()
    }
}

private val imageUrl = randomSampleImageUrl()

@Composable
private fun OrbitalExample() {
    val movementSpec = SpringSpec<IntOffset>(
        dampingRatio = Spring.DampingRatioMediumBouncy,
        stiffness = 200f
    )

    var isTransformed by rememberSaveable { mutableStateOf(false) }
    val poster = rememberContentWithOrbitalScope {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = if (isTransformed) {
                Modifier.size(360.dp, 620.dp)
            } else {
                Modifier.size(130.dp, 220.dp)
            }.animateMovement(this, movementSpec),
            contentScale = ContentScale.Fit
        )
    }

    Orbital(
        modifier = Modifier
            .clickable { isTransformed = !isTransformed }
    ) {
        if (isTransformed) {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                poster()
            }
        } else {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom
            ) {
                poster()
            }
        }
    }
}
