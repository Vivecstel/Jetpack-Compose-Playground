package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

private const val Url = "ui/SpanStyleScreen.kt"

@Composable
fun SpanStyleScreen() {
    DefaultScaffold(
        title = UiNavRoutes.SpanStyle,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                fontSize = 16.sp,
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Red)) {
                        append("Jetpack")
                    }
                    withStyle(SpanStyle(color = Color.Blue)) {
                        append(" compose")
                    }
                    withStyle(SpanStyle(fontSize = 28.sp)) {
                        append(" playground")
                    }
                }
            )
        }
    }
}