package com.steleot.jetpackcompose.playground.compose.reusable

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun BoxScope.CenteredCircularProgressIndicator(
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
}