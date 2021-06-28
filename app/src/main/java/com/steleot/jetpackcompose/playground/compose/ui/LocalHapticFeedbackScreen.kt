package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "ui/LocalHapticFeedbackScreen.kt"

@Composable
fun LocalHapticFeedbackScreen() {
    DefaultScaffold(
        title = UiNavRoutes.LocalHapticFeedback,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LocalHapticFeedbackExample()
        }
    }
}

@Composable
private fun LocalHapticFeedbackExample() {
    val hapticFeedback = LocalHapticFeedback.current
    Text(
        text = "press me",
        modifier = Modifier
            .clickable {
                hapticFeedback.performHapticFeedback(HapticFeedbackType.TextHandleMove)
            }
            .padding(32.dp)
    )
}