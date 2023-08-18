package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.popovanton0.heartswitch.HeartSwitch
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "externallibraries/HeartSwitchScreen.kt"

@Composable
fun HeartSwitchScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.HeartSwitch,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeartSwitchExample()
        }
    }
}

@Composable
private fun HeartSwitchExample() {
    var state by remember { mutableStateOf(true) }
    HeartSwitch(
        checked = state,
        onCheckedChange = { state = it },
        width = 64.dp,
        borderWidth = 4.dp,
        movementAnimSpec = spring(stiffness = Spring.StiffnessMediumLow),
        colorsAnimSpec = spring(stiffness = Spring.StiffnessMediumLow),
        thumb = { modifier, color ->
            Box(
                modifier = modifier
                    .shadow(12.dp, CircleShape)
                    .background(color.value, CircleShape)
            )
        },
    )
}