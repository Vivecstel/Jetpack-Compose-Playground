package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale

private const val Url = "ui/TextIndentScreen.kt"

@Composable
fun TextIndentScreen() {
    DefaultScaffold(
        title = UiNavRoutes.TextIndent.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            TextIndentExample()
        }
    }
}

@Composable
private fun TextIndentExample() {
    val textStyle = TextStyle(
        textAlign = TextAlign.Justify,
        lineHeight = 20.sp,
        textIndent = TextIndent(firstLine = 14.sp, restLine = 3.sp)
    )
    Text(
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
                "incididunt ut labore et dolore magna aliqua.\nUt enim ad minim veniam, quis " +
                "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        style = textStyle
    )
}