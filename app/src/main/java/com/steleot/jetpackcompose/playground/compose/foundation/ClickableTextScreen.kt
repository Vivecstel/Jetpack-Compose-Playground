package com.steleot.jetpackcompose.playground.compose.foundation

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundation/ClickableTextScreen.kt"

@Composable
fun ClickableTextScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.ClickableText,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
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
        text = AnnotatedString("Click Me"),
        onClick = { offset ->
            Toast.makeText(context, "$offset -th character is clicked.", Toast.LENGTH_SHORT).show()
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
                Toast.makeText(context, "Clicked URL : ${annotation.item}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    )
}