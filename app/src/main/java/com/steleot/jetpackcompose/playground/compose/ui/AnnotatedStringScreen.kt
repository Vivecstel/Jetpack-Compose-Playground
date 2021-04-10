package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.UiNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "ui/AnnotatedStringScreen.kt"

@Composable
fun AnnotatedStringScreen() {
    DefaultScaffold(
        title = UiNavRoutes.AnnotatedString,
        link = Url,
    ) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = annotatedStringConstructorExample())
            Text(text = annotatedStringBuilderExample())
            Text(text = annotatedStringBuilderPushExample())
            Text(text = annotatedStringBuilderPushParagraphStyleExample())
            Text(text = annotatedStringBuilderPushStringAnnotationExample())
            Text(text = annotatedStringBuilderWithStyleExample())
            Text(text = annotatedStringBuilderLambdaExample())
            Text(text = annotatedStringAddStringAnnotationExample())
        }
    }
}

private fun annotatedStringConstructorExample(): AnnotatedString {
    return AnnotatedString(
        text = "Hello World",
        spanStyles = listOf(
            AnnotatedString.Range(SpanStyle(fontStyle = FontStyle.Italic), 0, 5)
        ),
        paragraphStyles = listOf(
            AnnotatedString.Range(ParagraphStyle(textAlign = TextAlign.Center), 0, 6),
            AnnotatedString.Range(ParagraphStyle(textIndent = TextIndent(5.sp)), 6, 11)
        )
    )
}

private fun annotatedStringBuilderExample(): AnnotatedString {
    return with(AnnotatedString.Builder("Hello")) {
        pushStyle(SpanStyle(color = Color.Green))
        append(" World")
        pop()
        append("!")
        addStyle(SpanStyle(color = Color.Red), "Hello World".length, this.length)
        toAnnotatedString()
    }
}

private fun annotatedStringBuilderPushExample(): AnnotatedString {
    return with(AnnotatedString.Builder()) {
        pushStyle(SpanStyle(color = Color.Green))
        append("Hello")
        pop()
        append(" World")
        toAnnotatedString()
    }
}

private fun annotatedStringBuilderPushParagraphStyleExample(): AnnotatedString {
    return with(AnnotatedString.Builder()) {
        pushStyle(ParagraphStyle(lineHeight = 18.sp))
        append("Paragraph One\n")
        pop()
        append("Paragraph Two\n")
        toAnnotatedString()
    }
}

private fun annotatedStringBuilderPushStringAnnotationExample(): AnnotatedString {
    return with(AnnotatedString.Builder()) {
        pushStringAnnotation("ParagrapLabel", "paragraph1")
        append("Paragraph One\n")
        pop()
        append("Paragraph Two\n")
        toAnnotatedString()
    }
}

private fun annotatedStringBuilderWithStyleExample(): AnnotatedString {
    return with(AnnotatedString.Builder()) {
        withStyle(SpanStyle(color = Color.Green)) {
            append("Hello")
        }
        toAnnotatedString()
    }
}

private fun annotatedStringBuilderLambdaExample(): AnnotatedString {
    return buildAnnotatedString {
        withStyle(SpanStyle(color = Color.Red)) {
            append("Hello")
        }
        append(" ")
        withStyle(SpanStyle(color = Color.Blue)) {
            append("World!")
        }
    }
}

private fun annotatedStringAddStringAnnotationExample(): AnnotatedString {
    return with(AnnotatedString.Builder()) {
        append("link: Jetpack Compose")
        addStringAnnotation(
            tag = "URL",
            annotation = "https://developer.android.com/jetpack/compose",
            start = 6,
            end = 21
        )
        toAnnotatedString()
    }
}