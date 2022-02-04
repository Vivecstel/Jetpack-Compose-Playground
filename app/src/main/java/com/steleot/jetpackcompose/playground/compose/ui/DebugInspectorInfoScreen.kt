package com.steleot.jetpackcompose.playground.compose.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

private const val Url = "ui/DebugInspectorInfoScreen.kt"

@Composable
fun DebugInspectorInfoScreen() {
    DefaultScaffold(
        title = UiNavRoutes.DebugInspectorInfo,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DebugInspectorInfoExample()
        }
    }
}

@Composable
private fun DebugInspectorInfoExample() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .debugColorModifier(Color.Red)
    )
    Box(modifier = Modifier.debugModifier(50.dp, 50.dp, Color.Green))
}

@SuppressLint("UnnecessaryComposedModifier")
private fun Modifier.debugColorModifier(color: Color) = composed(
    inspectorInfo = debugInspectorInfo {
        name = "debugColorModifier"
        value = color
    }) {
    Modifier.background(color)
}

@SuppressLint("UnnecessaryComposedModifier")
private fun Modifier.debugModifier(width: Dp, height: Dp, color: Color) = composed(
    inspectorInfo = debugInspectorInfo {
        name = "debugModifier"
        properties["width"] = width
        properties["height"] = height
        properties["color"] = color
    }) {
    Modifier
        .size(width, height)
        .background(color)
}
