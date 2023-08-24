package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import me.nikhilchaudhari.quarks.CreateParticles
import me.nikhilchaudhari.quarks.particle.*

private const val URL = "externallibraries/ComposeParticleSystemScreen.kt"

@Composable
fun ComposeParticleSystemScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeParticleSystem,
        link = URL,
    ) {
        ComposeParticleSystemExample(paddingValues = it)
    }
}

@Composable
private fun ComposeParticleSystemExample(
    paddingValues: PaddingValues,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
    ) {
        CreateParticles(
            modifier = Modifier.fillMaxSize(),
            x = 500f,
            y = 1000f,
            velocity = Velocity(xDirection = 1f, yDirection = 1f),
            force = Force.Gravity(0f),
            acceleration = Acceleration(0f, 0f),
            particleSize = ParticleSize.RandomSizes(25..100),
            particleColor = ParticleColor.RandomColors(
                listOf(
                    Color.Magenta,
                    Color.Yellow,
                    Color.Red,
                    Color.Blue
                )
            ),
            lifeTime = LifeTime(255f, 0.2f),
            emissionType = EmissionType.ExplodeEmission(numberOfParticles = 50),
            durationMillis = 5_000
        )
    }
}