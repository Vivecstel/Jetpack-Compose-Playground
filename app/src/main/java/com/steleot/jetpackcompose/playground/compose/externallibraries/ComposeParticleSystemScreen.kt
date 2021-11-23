package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes
import me.nikhilchaudhari.quarks.CreateParticles
import me.nikhilchaudhari.quarks.particle.Acceleration
import me.nikhilchaudhari.quarks.particle.EmissionType
import me.nikhilchaudhari.quarks.particle.Force
import me.nikhilchaudhari.quarks.particle.LifeTime
import me.nikhilchaudhari.quarks.particle.ParticleColor
import me.nikhilchaudhari.quarks.particle.ParticleSize
import me.nikhilchaudhari.quarks.particle.Velocity

private const val Url = "externallibraries/ComposeParticleSystemScreen.kt"

@Composable
fun ComposeParticleSystemScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeParticleSystem,
        link = Url,
    ) {
        ComposeParticleSystemExample()
    }
}

@Composable
private fun ComposeParticleSystemExample() {
    Box(
        modifier = Modifier
            .fillMaxSize()
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