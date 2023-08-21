package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.FoundationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import com.steleot.jetpackcompose.playground.utils.shortToast

private const val URL = "foundation/ClickableTextScreen.kt"

@Composable
fun ClickableTextScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.ClickableText,
        link = URL,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ClickableTextExample()
            AnnotatedClickableText()
        }
    }
}

@Composable
private fun ClickableTextExample() {
    val context = LocalContext.current
    ClickableText(
        text = AnnotatedString(stringResource(id = R.string.click_me)),
        onClick = { offset ->
            context.shortToast(context.getString(R.string.clicked_character, offset))
        }
    )
}

@Composable
private fun AnnotatedClickableText() {
    val context = LocalContext.current
    val annotatedText = buildAnnotatedString {
        append("Click ")

        pushStringAnnotation(tag = "URL", annotation = "https://developer.android.com")
        withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold)) {
            append("here")
        }

        pop()
    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = "URL", start = offset,
                end = offset
            ).firstOrNull()?.let { annotation ->
                context.shortToast(context.getString(R.string.clicked_url, annotation.item))
            }
        }
    )
}