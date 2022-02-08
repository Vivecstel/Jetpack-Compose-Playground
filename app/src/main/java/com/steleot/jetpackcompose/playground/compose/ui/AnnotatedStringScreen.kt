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
import androidx.compose.ui.res.stringResource
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
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

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
            Text(text = annotatedStringConstructorExample(stringResource(id = R.string.hello_world)))
            Text(text = annotatedStringBuilderExample(stringResource(id = R.string.hello_world)))
            Text(text = annotatedStringBuilderPushExample(stringResource(id = R.string.hello_world)))
            Text(
                text = annotatedStringBuilderPushParagraphStyleExample(
                    stringResource(id = R.string.paragraph_args, stringResource(id = R.string.one)),
                    stringResource(id = R.string.paragraph_args, stringResource(id = R.string.two)),
                )
            )
            Text(
                text = annotatedStringBuilderPushStringAnnotationExample(
                    stringResource(id = R.string.paragraph_args, stringResource(id = R.string.one)),
                    stringResource(id = R.string.paragraph_args, stringResource(id = R.string.two)),
                )
            )
            Text(text = annotatedStringBuilderWithStyleExample(stringResource(id = R.string.hello_world)))
            Text(text = annotatedStringBuilderLambdaExample(stringResource(id = R.string.hello_world)))
            Text(text = annotatedStringAddStringAnnotationExample(stringResource(id = R.string.link_jetpack_compose)))
        }
    }
}

private fun annotatedStringConstructorExample(
    text: String,
): AnnotatedString {
    return AnnotatedString(
        text = text,
        spanStyles = listOf(
            AnnotatedString.Range(SpanStyle(fontStyle = FontStyle.Italic), 0, 5)
        ),
        paragraphStyles = listOf(
            AnnotatedString.Range(ParagraphStyle(textAlign = TextAlign.Center), 0, 6),
            AnnotatedString.Range(ParagraphStyle(textIndent = TextIndent(5.sp)), 6, 11)
        )
    )
}

private fun annotatedStringBuilderExample(
    text: String
): AnnotatedString {
    val textSplit = text.split(' ')
    return with(AnnotatedString.Builder(textSplit[0])) {
        pushStyle(SpanStyle(color = Color.Green))
        append(' ')
        append(textSplit[1])
        pop()
        append("!")
        addStyle(SpanStyle(color = Color.Red), text.length, this.length)
        toAnnotatedString()
    }
}

private fun annotatedStringBuilderPushExample(
    text: String
): AnnotatedString {
    val textSplit = text.split(' ')
    return with(AnnotatedString.Builder()) {
        pushStyle(SpanStyle(color = Color.Green))
        append(textSplit[0])
        pop()
        append(' ')
        append(textSplit[1])
        toAnnotatedString()
    }
}

private fun annotatedStringBuilderPushParagraphStyleExample(
    paragraphOne: String,
    paragraphTwo: String,
): AnnotatedString {
    return with(AnnotatedString.Builder()) {
        pushStyle(ParagraphStyle(lineHeight = 18.sp))
        append("$paragraphOne\n")
        pop()
        append("$paragraphTwo\n")
        toAnnotatedString()
    }
}

private fun annotatedStringBuilderPushStringAnnotationExample(
    paragraphOne: String,
    paragraphTwo: String,
): AnnotatedString {
    return with(AnnotatedString.Builder()) {
        pushStringAnnotation("ParagraphLabel", "paragraph1")
        append("$paragraphOne\n")
        pop()
        append("$paragraphTwo\n")
        toAnnotatedString()
    }
}

private fun annotatedStringBuilderWithStyleExample(
    text: String
): AnnotatedString {
    val textSplit = text.split(' ')
    return with(AnnotatedString.Builder()) {
        withStyle(SpanStyle(color = Color.Green)) {
            append(textSplit[0])
        }
        toAnnotatedString()
    }
}

private fun annotatedStringBuilderLambdaExample(
    text: String
): AnnotatedString {
    val textSplit = text.split(' ')
    return buildAnnotatedString {
        withStyle(SpanStyle(color = Color.Red)) {
            append(textSplit[0])
        }
        append(' ')
        withStyle(SpanStyle(color = Color.Blue)) {
            append(textSplit[1])
        }
    }
}

private fun annotatedStringAddStringAnnotationExample(
    text: String
): AnnotatedString {
    return with(AnnotatedString.Builder()) {
        append(text)
        addStringAnnotation(
            tag = "URL",
            annotation = "https://developer.android.com/jetpack/compose",
            start = 6,
            end = 21
        )
        toAnnotatedString()
    }
}