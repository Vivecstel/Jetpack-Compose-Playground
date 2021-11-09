package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

private const val Url = "ui/TextIndentScreen.kt"

@Composable
fun TextIndentScreen() {
    DefaultScaffold(
        title = UiNavRoutes.TextIndent,
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
        text = stringResource(id = R.string.lorem_ipsum),
        style = textStyle
    )
}