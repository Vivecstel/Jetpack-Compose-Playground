package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.AnimationNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "animation/AnimationModifierScreen.kt"

@Composable
fun AnimationModifierScreen() {
    DefaultScaffold(
        title = AnimationNavRoutes.AnimationModifier,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AnimateContent()
        }
    }
}

@Composable
private fun AnimateContent() {
    val shortText = "Hi"
    val longText = "Very long text\nthat spans across\nmultiple lines"
    var short by remember { mutableStateOf(true) }
    Box(
        modifier = Modifier
            .background(
                Color.Blue,
                RoundedCornerShape(15.dp)
            )
            .clickable { short = !short }
            .padding(20.dp)
            .wrapContentSize()
            .animateContentSize(
                tween(500)
            )
    ) {
        Text(
            if (short) {
                shortText
            } else {
                longText
            },
            style = LocalTextStyle.current.copy(color = Color.White)
        )
    }
}