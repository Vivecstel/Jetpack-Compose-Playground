package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.resources.R
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val URL = "material/TextScreen.kt"

@Composable
fun TextScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.Text,
        link = URL,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultText()
            ColoredText()
            FontSizeText()
            FontStyleText()
            FontWeightText()
            FontFamilyText()
            LetterSpacingText()
            TextDecorationText()
            TextAlignText()
            LineHeightText()
            TextOverflowText()
            StyledText()
        }
    }
}

@Composable
private fun DefaultText() {
    Text(text = stringResource(id = R.string.app_name))
}

@Composable
private fun ColoredText() {
    Text(text = stringResource(id = R.string.app_name), color = Color.Red)
}

@Composable
private fun FontSizeText() {
    Text(text = stringResource(id = R.string.app_name), fontSize = 24.sp)
}

@Composable
private fun FontStyleText() {
    Text(text = stringResource(id = R.string.app_name), fontStyle = FontStyle.Italic)
}

@Composable
private fun FontWeightText() {
    Text(text = stringResource(id = R.string.app_name), fontWeight = FontWeight.Bold)
}

@Composable
private fun FontFamilyText() {
    Text(text = stringResource(id = R.string.app_name), fontFamily = FontFamily.Cursive)
}

@Composable
private fun LetterSpacingText() {
    Text(text = stringResource(id = R.string.app_name), letterSpacing = 5.sp)
}

@Composable
private fun TextDecorationText() {
    Text(text = stringResource(id = R.string.app_name), textDecoration = TextDecoration.LineThrough)
}

@Composable
private fun TextAlignText() {
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.End
    )
}

@Composable
private fun LineHeightText() {
    Text(text = stringResource(id = R.string.app_name), lineHeight = 30.sp)
}

@Composable
private fun TextOverflowText() {
    Text(
        text = stringResource(id = R.string.app_name).repeat(4),
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
private fun StyledText() {
    Text(
        text = stringResource(id = R.string.app_name),
        style = MaterialTheme.typography.h3.copy(
            color = Color.Red,
            shadow = Shadow(Color.Green)
        )
    )
}