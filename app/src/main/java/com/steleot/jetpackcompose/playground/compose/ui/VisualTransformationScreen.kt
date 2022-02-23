package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "ui/VisualTransformationScreen.kt"

@Composable
fun VisualTransformationScreen() {
    val text = stringResource(id = R.string.password)
    val password = remember { mutableStateOf(TextFieldValue(text = text)) }
    val creditCard = remember { mutableStateOf(TextFieldValue(text = "1234567890123456")) }
    DefaultScaffold(
        title = UiNavRoutes.VisualTransformation,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                visualTransformation = {
                    passwordFilter(it)
                })
            OutlinedTextField(
                value = creditCard.value,
                onValueChange = { creditCard.value = it },
                visualTransformation = {
                    creditCardFilter(it)
                })
        }
    }
}

private fun passwordFilter(text: AnnotatedString): TransformedText {
    return TransformedText(
        AnnotatedString("*".repeat(text.text.length)),
        OffsetMapping.Identity
    )
}

private fun creditCardFilter(text: AnnotatedString): TransformedText {
    val trimmed = if (text.text.length >= 16) text.text.substring(0..15) else text.text
    var out = ""
    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i % 4 == 3 && i != 15) out += "-"
    }
    val creditCardOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return when {
                offset <= 3 -> offset
                offset <= 7 -> offset + 1
                offset <= 11 -> offset + 2
                offset <= 16 -> offset + 3
                else -> 19
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            return when {
                offset <= 4 -> offset
                offset <= 9 -> offset - 1
                offset <= 14 -> offset - 2
                offset <= 19 -> offset - 3
                else -> 16
            }
        }
    }

    return TransformedText(AnnotatedString(out), creditCardOffsetTranslator)
}