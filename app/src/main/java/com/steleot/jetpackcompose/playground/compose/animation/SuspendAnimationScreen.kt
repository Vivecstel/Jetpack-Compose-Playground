package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.AnimationNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.*

@Composable
fun SuspendAnimationScreen() {
    DefaultScaffold(
        title = AnimationNavRoutes.SuspendAnimation.capitalize(Locale.getDefault())
    ) {

    }
}